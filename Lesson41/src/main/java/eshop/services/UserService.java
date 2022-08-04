package eshop.services;

import eshop.entities.User;
import org.springframework.web.servlet.ModelAndView;

public interface UserService extends BaseRepository<User> {

    public ModelAndView authenticate(User user);

    public ModelAndView register(User user);
}
