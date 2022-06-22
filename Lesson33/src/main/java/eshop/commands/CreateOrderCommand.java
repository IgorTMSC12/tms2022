package eshop.commands;

import eshop.PagesPathEnum;
import eshop.domain.*;
import eshop.exceptions.CommandException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CreateOrderCommand implements BaseCommand {

    private static final Logger log = LoggerFactory.getLogger(CreateOrderCommand.class);

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");
        int idUser = user.getIdUser();
        int priceOrder = cart.getProductsPrice();
        List<Product> products = new ArrayList<>();
        for (Product product : cart.getProducts()) {
            products.add(product);
        }
        LocalDate date = LocalDate.now();
        Order order = new Order(idUser, priceOrder, date, products);
        StorageOrder.addOrder(order);
        ArrayList<Order> orders = (ArrayList<Order>) StorageOrder.getOrdersByIdUser(idUser);
        session.setAttribute("orders", orders);
        cart.clear();
        session.setAttribute("cart", cart);
        log.info("Пользователь с id = " + user.getIdUser() + " оформил заказ");
        return PagesPathEnum.CART_PAGE.getPath();
    }
}
