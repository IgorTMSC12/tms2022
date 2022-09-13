package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.config.JwtProvider;
import by.teachmeskills.eshop.dto.AuthResponse;
import by.teachmeskills.eshop.dto.UserDto;
import by.teachmeskills.eshop.dto.convertes.CategoryConverter;
import by.teachmeskills.eshop.dto.convertes.UserConverter;
import by.teachmeskills.eshop.entities.Role;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.exceptions.AuthorizationException;
import by.teachmeskills.eshop.repositories.CategoryRepository;
import by.teachmeskills.eshop.repositories.OrderRepository;
import by.teachmeskills.eshop.repositories.RoleRepository;
import by.teachmeskills.eshop.repositories.UserRepository;
import by.teachmeskills.eshop.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;
    private OrderRepository orderRepository;
    private final UserConverter userConverter;
    private final CategoryConverter categoryConverter;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private JwtProvider jwtProvider;

    public UserServiceImpl(UserRepository userRepository, CategoryRepository categoryRepository,
                           OrderRepository orderRepository, RoleRepository roleRepository,
                           UserConverter userConverter, CategoryConverter categoryConverter,
                           PasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.orderRepository = orderRepository;
        this.userConverter = userConverter;
        this.categoryConverter = categoryConverter;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public UserDto create(UserDto userDto) {
        User user = userConverter.fromDto(userDto);
        if (!(checkUserFromBase(user))) {
            Role role = roleRepository.getRoleByName("ROLE_USER");
            user.setRole(role);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return userConverter.toDto(user);
        } else {
            return null;
        }
    }

    @Override
    public AuthResponse authenticate(UserDto userDto) throws AuthorizationException {
        User user = userRepository.getUserByEmailAndPassword(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()));
        String accessToken = jwtProvider.generateToken(userDto.getEmail());
        return new AuthResponse(accessToken);
    }

    public UserDto getUserCabinet(UserDto userDto) {
        User user = userRepository.getUserByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
        return userConverter.toDto(user);
    }

    public boolean checkUserFromBase(User user) {
        List<User> users = userRepository.findAll();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(user.getEmail()) && users.get(i).getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
