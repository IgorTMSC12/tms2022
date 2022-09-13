package by.teachmeskills.eshop.controller;

import by.teachmeskills.eshop.entities.Cart;
import by.teachmeskills.eshop.services.impl.CartServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/cart")
public class CartController {
    private CartServiceImpl cartService;

    public CartController(CartServiceImpl cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ModelAndView openCartPage(@SessionAttribute("cart") Cart cart) {
        return cartService.getCartPage(cart);
    }

    @PostMapping("/add")
    public ModelAndView addProductToCart(@RequestParam("productId") int id, @SessionAttribute("cart") Cart cart) {
        return cartService.addProductToCart(id, cart);
    }

    @PostMapping("/delete")
    public ModelAndView deleteProductToCart(@RequestParam("productId") int id, @SessionAttribute("cart") Cart cart) {
        return cartService.deleteProductToCart(id, cart);
    }

    @PostMapping("/create")
    private ModelAndView createOrder(@SessionAttribute("cart") Cart cart) {
        return cartService.createOrder(cart);
    }
}
