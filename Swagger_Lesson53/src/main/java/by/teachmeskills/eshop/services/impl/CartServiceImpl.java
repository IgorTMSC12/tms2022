package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.dto.CartDto;
import by.teachmeskills.eshop.dto.OrderDto;
import by.teachmeskills.eshop.dto.UserDto;
import by.teachmeskills.eshop.dto.convertes.CartConverter;
import by.teachmeskills.eshop.dto.convertes.OrderConverter;
import by.teachmeskills.eshop.dto.convertes.UserConverter;
import by.teachmeskills.eshop.entities.Cart;
import by.teachmeskills.eshop.entities.Order;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.repositories.OrderRepository;
import by.teachmeskills.eshop.repositories.ProductRepository;
import by.teachmeskills.eshop.repositories.UserRepository;
import by.teachmeskills.eshop.services.CartService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CartServiceImpl implements CartService {
    private ProductRepository productRepository;
    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private CartConverter cartConverter;
    private UserConverter userConverter;
    private OrderConverter orderConverter;

    public CartServiceImpl(ProductRepository productRepository, UserRepository userRepository,
                           OrderRepository orderRepository, CartConverter cartConverter,
                           UserConverter userConverter, OrderConverter orderConverter) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.cartConverter = cartConverter;
        this.userConverter = userConverter;
        this.orderConverter = orderConverter;
        this.userRepository = userRepository;
    }


    @Override
    public CartDto addProductToCart(int productId, Cart cart) {
        Product product = productRepository.getProductById(productId);
        cart.addProduct(product);
        return cartConverter.toDto(cart);
    }


    @Override
    public CartDto deleteProductToCart(int productId, Cart cart) {
        Product product = productRepository.getProductById(productId);
        cart.removeProduct(product);
        return cartConverter.toDto(cart);
    }

    @Override
    public OrderDto createOrder(Cart cart, UserDto userDto) {
        User user = userRepository.getUserByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
        LocalDate date = LocalDate.now();
        Order order = Order.builder()
                .user(user)
                .orderPrice(cart.getProductsPrice())
                .orderData(date)
                .products(cart.getProducts())
                .build();
        orderRepository.save(order);
        cart.clear();
        return orderConverter.toDto(order);
    }
}
