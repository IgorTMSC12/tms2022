package eshop.commands;

import eshop.PagesPathEnum;
import eshop.domain.Cart;
import eshop.domain.Product;
import eshop.domain.StorageProducts;
import eshop.domain.User;
import eshop.exceptions.CommandException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class AddProductToCartCommand implements BaseCommand {

    private static final Logger log = LoggerFactory.getLogger(AddProductToCartCommand.class);

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        int id = Integer.parseInt(request.getParameter("productId"));
        Product product = StorageProducts.getProductById(id);
        cart.addProduct(product);
        session.setAttribute("cart", cart);
        request.setAttribute("product", product);
        User user = (User) session.getAttribute("user");
        log.info("Пользователь с id = " + user.getIdUser() +
                ", добавил продукт с id = " + product.getId() + " в корзину");
        return PagesPathEnum.PRODUCT_PAGE.getPath();
    }
}
