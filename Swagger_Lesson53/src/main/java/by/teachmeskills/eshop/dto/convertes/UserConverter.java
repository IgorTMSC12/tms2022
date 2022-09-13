package by.teachmeskills.eshop.dto.convertes;

import by.teachmeskills.eshop.dto.UserDto;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.repositories.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserConverter {
    private final OrderConverter orderConverter;
    private final OrderRepository orderRepository;
    private final RoleConverter roleConverter;

    public UserConverter(OrderConverter orderConverter, OrderRepository orderRepository, RoleConverter roleConverter) {
        this.orderConverter = orderConverter;
        this.orderRepository = orderRepository;
        this.roleConverter = roleConverter;
    }

    public UserDto toDto(User user) {
        return Optional.ofNullable(user).map(u -> UserDto.builder()
                        .id(u.getId())
                        .name(u.getName())
                        .lastName(u.getLastName())
                        .email(u.getEmail())
                        .password(u.getPassword())
                        .roleName(u.getRole().getName())
                        .orders(Optional.ofNullable(u.getOrders()).map(orders -> orders.stream()
                                .map(orderConverter::toDto).toList()).orElse(List.of()))
                        .build())
                .orElse(null);
    }

    public User fromDto(UserDto userDto) {
        return Optional.ofNullable(userDto).map(u -> User.builder()
                        .name(u.getName())
                        .lastName(u.getLastName())
                        .email(u.getEmail())
                        .password(u.getPassword())
                        .role(roleConverter.fromDto(u.getRoleName()))
                        .orders(orderRepository.getOrdersByUserId(u.getId()))
                        .build())
                .orElse(null);
    }
}