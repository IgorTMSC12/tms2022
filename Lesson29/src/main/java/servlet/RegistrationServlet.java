package servlet;

import model.StorageUser;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("register.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String userLastName = req.getParameter("userlastname");
        String userEmail = req.getParameter("useremail");
        String userPassword = req.getParameter("userpassword");

        User user = new User(userName, userLastName, userEmail, userPassword);

        StorageUser.addUsers(user);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("signin.jsp");
        requestDispatcher.forward(req, resp);
    }
}
