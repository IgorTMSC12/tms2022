package servlet;

import model.Product;
import model.StorageProducts;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("productName");
        Product product = StorageProducts.getProduct(name);
        req.setAttribute("product", product);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("product.jsp");
        requestDispatcher.forward(req, resp);
    }
}
