package task2.servlet;

import task2.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
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

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/cabinet.jsp");
        requestDispatcher.forward(req, resp);
    }
}
