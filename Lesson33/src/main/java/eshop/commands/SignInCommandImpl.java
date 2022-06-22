package eshop.commands;

import eshop.PagesPathEnum;
import eshop.domain.*;
import eshop.exceptions.CommandException;
import eshop.exceptions.RequestParamNullException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static eshop.util.HttpRequestParamValidator.validateParamNotNull;

public class SignInCommandImpl implements BaseCommand {

    private static final Logger log = LoggerFactory.getLogger(SignInCommandImpl.class);

    private static final String ADMIN_EMAIL = "admin";
    private static final String ADMIN_PASSWORD = "admin";

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

        User user = new User(ADMIN_EMAIL, ADMIN_PASSWORD);
        StorageUser.addUsers(user);

        return checkReceivedUser(request);
    }

    private String checkReceivedUser(HttpServletRequest request) {
        if (StorageUser.checkUser(request.getParameter("useremail"), request.getParameter("password"))) {
            User user = StorageUser.getUser(request.getParameter("useremail"), request.getParameter("password"));
            request.getSession().setAttribute("user", user);

            List<Category> categories = StorageCategory.createCategory();
            request.setAttribute("categories", categories);

            Cart cart = new Cart();
            HttpSession session = request.getSession();
            session.setAttribute("cart", cart);
            log.info("Пользователь с id = " + user.getIdUser() + " вошёл в систему");
            return PagesPathEnum.HOME_PAGE.getPath();
        } else {
            return PagesPathEnum.SIGN_IN_PAGE.getPath();
        }
    }
}
