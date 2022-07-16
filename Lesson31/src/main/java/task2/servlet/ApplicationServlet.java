package task2.servlet;

import task2.exceptions.RequestParamNullException;
import task2.model.*;
import task2.util.HttpRequestParamValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class ApplicationServlet extends HttpServlet {
    private static final String ADMIN_EMAIL = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("signin.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("useremail");
        String password = req.getParameter("password");

        User user = null;
        try {
            HttpRequestParamValidator.validateParamNotNull(email);
            HttpRequestParamValidator.validateParamNotNull(password);
            user = new User(email, password);
        } catch (RequestParamNullException exception) {
            System.out.println(exception.getMessage());
        }


        RequestDispatcher requestDispatcher = req.getRequestDispatcher(checkReceivedUser(user, req));
        requestDispatcher.forward(req, resp);
    }

    private String checkReceivedUser(User user, HttpServletRequest request) {
        User admin = new User(ADMIN_EMAIL, ADMIN_PASSWORD);
        StorageUser.addUsers(admin);
        if (StorageUser.checkUser(request.getParameter("useremail"), request.getParameter("password"))) {
            User user1 = StorageUser.getUser(request.getParameter("useremail"), request.getParameter("password"));
            request.getSession().setAttribute("user", user1);

            List<Category> categories = StorageCategory.createCategory();
            request.setAttribute("categories", categories);

            Cart cart = new Cart();
            HttpSession session = request.getSession();
            session.setAttribute("cart", cart);
            return "home.jsp";
        } else {
            return "signin.jsp";
        }
    }
}
