package eshop.commands;

import eshop.PagesPathEnum;
import eshop.entities.Cart;
import eshop.entities.Image;
import eshop.exceptions.CommandException;
import eshop.repositories.impl.ImageRepositoryImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class RedirectToShoppingCart implements BaseCommand {
    ImageRepositoryImpl imageRepository = new ImageRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        List<Image> images = imageRepository.getImagesByListProducts(cart.getProducts());
        request.setAttribute("cart", cart);
        request.setAttribute("images", images);
        return PagesPathEnum.CART_PAGE.getPath();
    }
}
