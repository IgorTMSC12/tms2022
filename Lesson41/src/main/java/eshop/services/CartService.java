package eshop.services;

import eshop.entities.Cart;
import eshop.entities.User;
import org.springframework.web.servlet.ModelAndView;

public interface CartService {

    public ModelAndView getCartPage(Cart cart);

    public ModelAndView addProductToCart(int productId, Cart cart);

    public ModelAndView deleteProductToCart(int id, Cart cart);

    public ModelAndView createOrder(Cart cart, User user);
}
