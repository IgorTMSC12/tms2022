package eshop.controller;

import eshop.PagesPathEnum;
import eshop.entities.User;
import eshop.services.impl.UserServiceImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
            populateError("name", modelAndView, bindingResult);
            populateError("lastName", modelAndView, bindingResult);
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
