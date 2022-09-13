package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.PagesPathEnum;
import by.teachmeskills.eshop.entities.Category;
import by.teachmeskills.eshop.entities.Image;
import by.teachmeskills.eshop.entities.Order;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.exceptions.AuthorizationException;
import by.teachmeskills.eshop.repositories.impl.CategoryRepositoryImpl;
import by.teachmeskills.eshop.repositories.impl.ImageRepositoryImpl;
import by.teachmeskills.eshop.repositories.impl.OrderRepositoryImpl;
import by.teachmeskills.eshop.repositories.impl.UserRepositoryImpl;
import by.teachmeskills.eshop.services.UserService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepositoryImpl userRepository;
    private CategoryRepositoryImpl categoryRepository;
    private ImageRepositoryImpl imageRepository;
    private OrderRepositoryImpl orderRepository;

    public UserServiceImpl(UserRepositoryImpl userRepository, CategoryRepositoryImpl categoryRepository,
                           ImageRepositoryImpl imageRepository, OrderRepositoryImpl orderRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.imageRepository = imageRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void create(User entity) {
        userRepository.create(entity);
    }

    @Override
    public List read() {
        return userRepository.read();
    }

    @Override
    public void update(User entity) {
        userRepository.update(entity);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public ModelAndView authenticate(User user) throws AuthorizationException {
        ModelAndView modelAndView = new ModelAndView();
        if (Optional.ofNullable(user.getEmail()).isPresent()
                && Optional.ofNullable(user.getPassword()).isPresent()) {
            if (userRepository.checkUserFromBase(new User(user.getEmail(), user.getPassword()))) {
                user = userRepository.getUserByLoginAndPass(user.getEmail(), user.getPassword());
                ModelMap modelMap = new ModelMap();
                List<Category> categories = categoryRepository.read();
                List<Image> imagesCategories = imageRepository.getAllImagesCategories();
                modelMap.addAttribute("categories", categories);
                modelMap.addAttribute("imagesCategories", imagesCategories);
                modelMap.addAttribute("user", user);
                modelAndView.setViewName(PagesPathEnum.HOME_PAGE.getPath());
                modelAndView.addAllObjects(modelMap);
            } else {
                throw new AuthorizationException("User is not authorized! Please, try again");
            }
        }
        return modelAndView;
    }

    @Override
    public ModelAndView register(User user) {
        ModelAndView modelAndView = new ModelAndView();
        if (Optional.ofNullable(user.getName()).isPresent() && Optional.ofNullable(user.getLastName()).isPresent() &&
                Optional.ofNullable(user.getEmail()).isPresent() && Optional.ofNullable(user.getPassword()).isPresent()) {
            User newUser = User.builder()
                    .name(user.getName())
                    .lastName(user.getLastName())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .build();
            if (!(userRepository.checkUserFromBase(newUser))) {
                userRepository.create(newUser);
                modelAndView.setViewName(PagesPathEnum.SIGN_IN_PAGE.getPath());
            } else {
                modelAndView.setViewName(PagesPathEnum.REGISTER_PAGE.getPath());
            }
        } else {
            modelAndView.setViewName(PagesPathEnum.REGISTER_PAGE.getPath());
        }
        return modelAndView;
    }

    public ModelAndView getUserCabinet(User user) {
        ModelMap modelMap = new ModelMap();

        // ArrayList<Order> orders = (ArrayList<Order>) orderRepository.read();
        ArrayList<Order> orders = (ArrayList<Order>) orderRepository.getOrdersByIdUser(user.getId());
        List<Image> images = new ArrayList<>();
        for (Order order : orders) {
            for (Product product : order.getProducts()) {
                Image image = imageRepository.getImageByIdProduct(product.getId());
                if (images.size() == 0) {
                    images.add(image);
                }
                int count = 0;
                for (int i = 0; i < images.size(); i++) {
                    if (!(images.get(i).getProduct().getId() == image.getProduct().getId())) {
                        count++;
                    }
                    if (count == images.size()) {
                        images.add(image);
                    }
                }
            }
        }
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("orders", orders);
        modelMap.addAttribute("images", images);
        return new ModelAndView(PagesPathEnum.USER_CABINET_PAGE.getPath(), modelMap);
    }

    public void exportToFile(Writer writer, User user) {
        try {
            List<Order> orders = orderRepository.getOrdersByIdUser(user.getId());
            StatefulBeanToCsv statefulBeanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
            statefulBeanToCsv.write(orders);
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            e.getStackTrace();
        }
    }
}
