package eshop.commands;

import eshop.PagesPathEnum;
import eshop.entities.Cart;
import eshop.entities.Image;
import eshop.entities.Product;
import eshop.entities.User;
import eshop.exceptions.CommandException;
import eshop.repositories.impl.ImageRepositoryImpl;
import eshop.repositories.impl.ProductRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class DeleteProductToCartCommand implements BaseCommand {

    private static final Logger log = LoggerFactory.getLogger(DeleteProductToCartCommand.class);
    private ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
    private ImageRepositoryImpl imageRepository = new ImageRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        int id = Integer.parseInt(request.getParameter("productId"));
        Product product = productRepository.getProductById(id);
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");
        cart.removeProduct(product);
        session.setAttribute("cart", cart);
        List<Image> images = imageRepository.getImagesByListProducts(cart.getProducts());
        request.setAttribute("images", images);
        request.setAttribute("cart", cart);
        log.info("Пользователь с id = " + user.getId() + " удалил продукт с id = " + product.getId() +
                " с корзины");
        return PagesPathEnum.CART_PAGE.getPath();
    }
}
