import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        User user = new User();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login1");
            requestDispatcher.forward(req, resp);
        } else {
            printWriter.println("Login Fail");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
            requestDispatcher.include(req, resp);
        }
    }
}
