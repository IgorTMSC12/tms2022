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

public class DeleteProductToCartCommand implements BaseCommand {

    private static final Logger log = LoggerFactory.getLogger(DeleteProductToCartCommand.class);

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        int id = Integer.parseInt(request.getParameter("productId"));
        Product product = StorageProducts.getProductById(id);
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.removeProduct(product);
        session.setAttribute("cart", cart);
        User user = (User) session.getAttribute("user");
        log.info("Пользователь с id = " + user.getIdUser() + " удалил продукт с id = " + product.getId() +
                " с корзины");
        return PagesPathEnum.CART_PAGE.getPath();
    }
}
