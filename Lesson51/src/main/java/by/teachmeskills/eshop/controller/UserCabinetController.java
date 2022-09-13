package by.teachmeskills.eshop.controller;

import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.services.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @GetMapping("/export")
    public ModelAndView exportToFile(HttpServletResponse response,
                                     @SessionAttribute("user") User user) throws IOException {
        response.setContentType("text/csv");
        response.setCharacterEncoding("UTF8");
        response.addHeader("Content-Disposition", "attachment; filename=userOrders.csv");
        userService.exportToFile(response.getWriter(), user);
        return openUserCabinet(user);
    }
}
