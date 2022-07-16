package eshop.commands;

import eshop.PagesPathEnum;
import eshop.domain.StorageUser;
import eshop.domain.User;
import eshop.exceptions.CommandException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements BaseCommand {

    private static final Logger log = LoggerFactory.getLogger(RegisterCommand.class);

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String userName = request.getParameter("username");
        String userLastName = request.getParameter("userlastname");
        String userEmail = request.getParameter("useremail");
        String userPassword = request.getParameter("userpassword");
        String repeatPassword = request.getParameter("repeatpassword");

        if (userPassword.equals(repeatPassword)) {
            User user = new User(userName, userLastName, userEmail, userPassword);
            StorageUser.addUsers(user);
            log.info("Пользователь с id = " + user.getIdUser() + " зарегистрировался");
            return PagesPathEnum.SIGN_IN_PAGE.getPath();
        }

        return PagesPathEnum.REGISTER_PAGE.getPath();
    }
}
