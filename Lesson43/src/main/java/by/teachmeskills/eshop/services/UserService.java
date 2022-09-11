package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.exceptions.AuthorizationException;
import org.springframework.web.servlet.ModelAndView;

public interface UserService extends BaseRepository<User> {

    public ModelAndView authenticate(User user) throws AuthorizationException;

    public ModelAndView register(User user);
}