package servlet;

import exceptions.RequestParamNullException;
import model.Category;
import model.StorageCategory;
import model.StorageUser;
import model.User;
import util.HttpRequestParamValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        List<User> users = StorageUser.getUsers();
        User admin = new User(ADMIN_EMAIL, ADMIN_PASSWORD);
        users.add(admin);
        if (StorageUser.checkUser(request.getParameter("useremail"), request.getParameter("password"))) {
            request.getSession().setAttribute("username", user);

            List<Category> categories = StorageCategory.getCategories();
            request.setAttribute("categories", categories);
            return "home.jsp";
        } else {
            return "signin.jsp";
        }
    }
}
