package servlet;

import exceptions.RequestParamNullException;
import model.Category;
import model.User;
import util.HttpRequestParamValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class ApplicationServlet extends HttpServlet {
    private static final String ADMIN_LOGIN = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("signin.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("username");
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
        if (user != null
                && request.getParameter("username").equals(ADMIN_LOGIN)
                && request.getParameter("password").equals(ADMIN_PASSWORD)) {
            request.getSession().setAttribute("username", user);

            List<Category> categories = new ArrayList<>();

            Category mobilPhone = new Category(1, "Mobil Phone", "mobile.jpg");
            Category laptops = new Category(2, "Laptops", "laptop.jpg");
            Category jpsNavigators = new Category(3, "GPS Navigators", "jps_nav.jpg");
            Category fridges = new Category(4, "Fridges", "fridge.jpg");
            Category car = new Category(5, "Cars", "car.jpg");
            Category camera = new Category(6, "Camera", "camera.jpg");

            categories.add(mobilPhone);
            categories.add(laptops);
            categories.add(jpsNavigators);
            categories.add(fridges);
            categories.add(car);
            categories.add(camera);

            request.setAttribute("categories", categories);
            HttpSession session = request.getSession();
            session.setAttribute("categories", categories);

            return "home.jsp";
        } else {
            return "signin.jsp";
        }
    }
}
