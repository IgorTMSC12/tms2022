package by.teachmeskills.eshop.controller;

import by.teachmeskills.eshop.PagesPathEnum;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.services.impl.UserServiceImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    private UserServiceImpl userService;

    public RegistrationController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView openRegistrationPage() {
        return new ModelAndView(PagesPathEnum.REGISTER_PAGE.getPath());
    }

    @PostMapping
    public ModelAndView registerNewUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            populateError("email", modelAndView, bindingResult);
            populateError("password", modelAndView, bindingResult);
            modelAndView.setViewName(PagesPathEnum.REGISTER_PAGE.getPath());
            return modelAndView;
        }
        return userService.register(user);
    }

    private void populateError(String field, ModelAndView modelAndView, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors(field)) {
            modelAndView.addObject(field + "Error", Objects.requireNonNull(bindingResult
                    .getFieldError(field)).getDefaultMessage());
        }
    }
}
