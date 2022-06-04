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
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        List<Product> products = cart.getProducts();
        req.setAttribute("products", products);

        int countProducts = cart.getCountProducts();
        int priceProducts = cart.getPriceProducts();

        req.setAttribute("countProducts", countProducts);
        req.setAttribute("priceProducts", priceProducts);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("cart.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("productName");
        Product product = StorageProducts.getProduct(name);
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.removeProduct(product);
        session.setAttribute("cart", cart);
        doGet(req, resp);
    }
}
