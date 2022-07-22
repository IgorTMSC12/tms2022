package eshop.commands;

import eshop.PagesPathEnum;
import eshop.entities.Cart;
import eshop.entities.Category;
import eshop.entities.Image;
import eshop.entities.User;
import eshop.exceptions.CommandException;
import eshop.exceptions.RequestParamNullException;
import eshop.repositories.impl.CategoryRepositoryImpl;
import eshop.repositories.impl.ImageRepositoryImpl;
import eshop.repositories.impl.UserRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static eshop.util.HttpRequestParamValidator.validateParamNotNull;

public class SignInCommandImpl implements BaseCommand {

    private static final Logger log = LoggerFactory.getLogger(SignInCommandImpl.class);
    private UserRepositoryImpl userRepository = new UserRepositoryImpl();
    private CategoryRepositoryImpl categoryRepository = new CategoryRepositoryImpl();
    private ImageRepositoryImpl imageRepository = new ImageRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String email = request.getParameter("useremail");
        String password = request.getParameter("password");
        try {
            validateParamNotNull(email);
            validateParamNotNull(password);
        } catch (RequestParamNullException e) {
            e.printStackTrace();
        }
        User user = User.builder().email(email).password(password).build();
        return checkReceivedUser(user, request);
    }

    private String checkReceivedUser(User user, HttpServletRequest request) {
        if (userRepository.checkUserFromBase(user)) {
            user = userRepository.getUserByLoginAndPass(request.getParameter("useremail"), request.getParameter("password"));
            request.getSession().setAttribute("user", user);
            List<Category> categories = categoryRepository.read();
            request.setAttribute("categories", categories);
            List<Image> imageCategories = imageRepository.getAllImagesCategories();
            request.setAttribute("imageCategories", imageCategories);
            Cart cart = new Cart();
            HttpSession session = request.getSession();
            session.setAttribute("cart", cart);
            log.info("Пользователь с id = " + user.getId() + " вошёл в систему");
            return PagesPathEnum.HOME_PAGE.getPath();
        } else {
            return PagesPathEnum.SIGN_IN_PAGE.getPath();
        }
    }
}
