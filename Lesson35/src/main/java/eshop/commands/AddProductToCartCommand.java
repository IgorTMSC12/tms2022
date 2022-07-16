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


public class AddProductToCartCommand implements BaseCommand {

    private static final Logger log = LoggerFactory.getLogger(AddProductToCartCommand.class);
    private ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
    private ImageRepositoryImpl imageRepository = new ImageRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        int id = Integer.parseInt(request.getParameter("productId"));
        Product product = productRepository.getProductById(id);
        Image image = imageRepository.getImageByIdProduct(id);
        cart.addProduct(product);
        session.setAttribute("cart", cart);
        request.setAttribute("product", product);
        request.setAttribute("image", image);
        User user = (User) session.getAttribute("user");
        log.info("Пользователь с id = " + user.getId() +
                ", добавил продукт с id = " + product.getId() + " в корзину");
        return PagesPathEnum.PRODUCT_PAGE.getPath();
    }
}
