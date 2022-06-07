package servlet;

import model.Cart;
import model.Product;
import model.StorageProducts;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        req.setAttribute("cart", cart);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("cart.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("productId"));
        Product product = StorageProducts.getProductById(id);
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.removeProduct(product);
        session.setAttribute("cart", cart);
        doGet(req, resp);
    }
}
