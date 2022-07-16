package eshop.commands;

import eshop.PagesPathEnum;
import eshop.entities.Cart;
import eshop.entities.Order;
import eshop.entities.Product;
import eshop.entities.User;
import eshop.exceptions.CommandException;
import eshop.repositories.impl.OrderRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CreateOrderCommand implements BaseCommand {

    private static final Logger log = LoggerFactory.getLogger(CreateOrderCommand.class);
    private OrderRepositoryImpl orderRepository = new OrderRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");
        List<Product> products = new ArrayList<>();
        for (Product product : cart.getProducts()) {
            products.add(product);
        }
        LocalDate date = LocalDate.now();
        Order order = new Order(user.getId(), cart.getProductsPrice(), date, products);
        orderRepository.create(order);
        cart.clear();
        session.setAttribute("cart", cart);
        log.info("Пользователь с id = " + user.getId() + " оформил заказ");
        return PagesPathEnum.CART_PAGE.getPath();
    }
}
