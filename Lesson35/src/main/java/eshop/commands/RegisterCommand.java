package eshop.commands;

import eshop.PagesPathEnum;
import eshop.entities.User;
import eshop.exceptions.CommandException;
import eshop.repositories.impl.UserRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements BaseCommand {

    private static final Logger log = LoggerFactory.getLogger(RegisterCommand.class);
    private UserRepositoryImpl userRepository = new UserRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String userName = request.getParameter("username");
        String userLastName = request.getParameter("userlastname");
        String userEmail = request.getParameter("useremail");
        String userPassword = request.getParameter("userpassword");
        String repeatPassword = request.getParameter("repeatpassword");
        if (userPassword.equals(repeatPassword)) {
            User user = User.builder()
                    .name(userName)
                    .lastName(userLastName)
                    .email(userEmail)
                    .password(userPassword)
                    .build();
            if (!userRepository.checkUserFromBase(user)) {
                userRepository.create(user);
            }
            log.info("Пользователь с id = " + user.getId() + " зарегистрировался");
            return PagesPathEnum.SIGN_IN_PAGE.getPath();
        }

        return PagesPathEnum.REGISTER_PAGE.getPath();
    }
}
