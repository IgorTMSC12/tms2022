package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.PagesPathEnum;
import by.teachmeskills.eshop.entities.Cart;
import by.teachmeskills.eshop.entities.Image;
import by.teachmeskills.eshop.entities.Order;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.repositories.impl.ImageRepositoryImpl;
import by.teachmeskills.eshop.repositories.impl.OrderRepositoryImpl;
import by.teachmeskills.eshop.repositories.impl.ProductRepositoryImpl;
import by.teachmeskills.eshop.services.CartService;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
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
        List<Image> images = new ArrayList<>();
        if (!(cart.getProducts() == null)) {
            for (Product product : cart.getProducts()) {
                Image image = imageRepository.getImageByIdProduct(product.getId());
                if (images.size() == 0) {
                    images.add(image);
                }
                int count = 0;
                for (int i = 0; i < images.size(); i++) {
                    if (!(images.get(i).getProduct().getId() == image.getProduct().getId())) {
                        count++;
                    }
                    if (count == images.size()) {
                        images.add(image);
                    }
                }
            }
        }
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
        modelMap.addAttribute("cart", cart);
        return new ModelAndView(PagesPathEnum.PRODUCT_PAGE.getPath(), modelMap);
    }

    @Override
    public ModelAndView deleteProductToCart(int id, Cart cart) {
        ModelMap modelMap = new ModelMap();
        cart.removeProduct(productRepository.getProductById(id));
        List<Image> images = new ArrayList<>();
        if (!(cart.getProducts() == null)) {
            for (Product product : cart.getProducts()) {
                Image image = imageRepository.getImageByIdProduct(product.getId());
                if (images.size() == 0) {
                    images.add(image);
                }
                int count = 0;
                for (int i = 0; i < images.size(); i++) {
                    if (!(images.get(i).getProduct().getId() == image.getProduct().getId())) {
                        count++;
                    }
                    if (count == images.size()) {
                        images.add(image);
                    }
                }
            }
        }
        modelMap.addAttribute("cart", cart);
        modelMap.addAttribute("images", images);
        return new ModelAndView(PagesPathEnum.CART_PAGE.getPath(), modelMap);
    }

    @Override
    public ModelAndView createOrder(Cart cart, User user) {
        ModelMap modelMap = new ModelMap();
        LocalDate date = LocalDate.now();
        Order order = Order.builder()
                .user(user)
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
