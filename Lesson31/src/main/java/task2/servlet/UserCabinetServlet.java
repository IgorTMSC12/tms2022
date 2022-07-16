package task2.servlet;

import task2.model.Order;
import task2.model.StorageOrder;
import task2.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/cabinet")
public class UserCabinetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        req.setAttribute("user", user);
        ArrayList<Order> orders = (ArrayList<Order>) StorageOrder.getOrdersByIdUser(user.getIdUser());

        req.setAttribute("orders", orders);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("cabinet.jsp");
        requestDispatcher.forward(req, resp);
    }

}
