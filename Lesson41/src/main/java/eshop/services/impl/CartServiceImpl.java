package eshop.services.impl;

import eshop.PagesPathEnum;
import eshop.entities.*;
import eshop.repositories.impl.ImageRepositoryImpl;
import eshop.repositories.impl.OrderRepositoryImpl;
import eshop.repositories.impl.ProductRepositoryImpl;
import eshop.services.CartService;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private ImageRepositoryImpl imageRepository;
    private ProductRepositoryImpl productRepository;
    private OrderRepositoryImpl orderRepository;

    public CartServiceImpl(ImageRepositoryImpl imageRepository, ProductRepositoryImpl productRepository,
                           OrderRepositoryImpl orderRepository) {
        this.imageRepository = imageRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public ModelAndView getCartPage(Cart cart) {
        ModelMap modelMap = new ModelMap();
        List<Image> images = imageRepository.getImagesByListProducts(cart.getProducts());
        modelMap.addAttribute("cart", cart);
        modelMap.addAttribute("images", images);
        return new ModelAndView(PagesPathEnum.CART_PAGE.getPath(), modelMap);
    }

    @Override
    public ModelAndView addProductToCart(int productId, Cart cart) {
        ModelMap modelMap = new ModelMap();
        Product product = productRepository.getProductById(productId);
        Image image = imageRepository.getImageByIdProduct(productId);
        cart.addProduct(product);
        modelMap.addAttribute("product", product);
        modelMap.addAttribute("image", image);
        return new ModelAndView(PagesPathEnum.PRODUCT_PAGE.getPath(), modelMap);
    }

    @Override
    public ModelAndView deleteProductToCart(int id, Cart cart) {
        ModelMap modelMap = new ModelMap();
        Product product = productRepository.getProductById(id);
        cart.removeProduct(product);
        List<Image> images = imageRepository.getImagesByListProducts(cart.getProducts());
        modelMap.addAttribute("cart", cart);
        modelMap.addAttribute("images", images);
        return new ModelAndView(PagesPathEnum.CART_PAGE.getPath(), modelMap);
    }

    @Override
    public ModelAndView createOrder(Cart cart, User user) {
        ModelMap modelMap = new ModelMap();
        LocalDate date = LocalDate.now();
        Order order = Order.builder()
                .userId(user.getId())
                .orderPrice(cart.getProductsPrice())
                .orderData(date)
                .products(cart.getProducts())
                .build();
        orderRepository.create(order);
        cart.clear();
        modelMap.addAttribute("cart", cart);
        return new ModelAndView(PagesPathEnum.CART_PAGE.getPath(), modelMap);
    }
}
