package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.dto.CartDto;
import by.teachmeskills.eshop.dto.OrderDto;
import by.teachmeskills.eshop.dto.UserDto;
import by.teachmeskills.eshop.entities.Cart;

public interface CartService {

    public CartDto addProductToCart(int productId, Cart cart);

    public CartDto deleteProductToCart(int id, Cart cart);

    public OrderDto createOrder(Cart cart, UserDto userDto);
}
