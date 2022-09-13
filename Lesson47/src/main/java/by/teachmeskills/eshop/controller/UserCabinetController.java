package by.teachmeskills.eshop.controller;

import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.services.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/cabinet")
public class UserCabinetController {
    private UserServiceImpl userService;

    public UserCabinetController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView openUserCabinet(@SessionAttribute("user") User user) {
        return userService.getUserCabinet(user);
    }
}
