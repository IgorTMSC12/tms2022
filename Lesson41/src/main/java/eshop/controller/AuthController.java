package eshop.controller;

import eshop.PagesPathEnum;
import eshop.entities.Cart;
import eshop.entities.User;
import eshop.services.impl.UserServiceImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@SessionAttributes({"user", "cart"})
@RequestMapping("/login")
public class AuthController {
    private UserServiceImpl userService;

    public AuthController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView openLoginPage() {
        return new ModelAndView(PagesPathEnum.SIGN_IN_PAGE.getPath());
    }

    @PostMapping
    public ModelAndView login(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            populateError("email", modelAndView, bindingResult);
            populateError("password", modelAndView, bindingResult);
            modelAndView.setViewName(PagesPathEnum.SIGN_IN_PAGE.getPath());
            return modelAndView;
        }
        return userService.authenticate(user);
    }

    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @ModelAttribute("cart")
    public Cart shoppingCart() {
        return new Cart();
    }

    private void populateError(String field, ModelAndView modelAndView, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors(field)) {
            modelAndView.addObject(field + "Error", Objects.requireNonNull(bindingResult
                    .getFieldError(field)).getDefaultMessage());
        }
    }
}
