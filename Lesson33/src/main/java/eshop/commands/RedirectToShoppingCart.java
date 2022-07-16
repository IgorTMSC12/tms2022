package eshop.commands;

import eshop.PagesPathEnum;
import eshop.domain.Cart;
import eshop.exceptions.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RedirectToShoppingCart implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        request.setAttribute("cart", cart);

        return PagesPathEnum.CART_PAGE.getPath();
    }
}
