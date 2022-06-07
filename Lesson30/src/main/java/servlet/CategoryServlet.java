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
import java.util.List;

@WebServlet("/start")
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("categoryName");
        req.setAttribute("name", name);

        int idCategory = Integer.parseInt(req.getParameter("categoryId"));
        List<Product> products = StorageProducts.getProductByIdCategory(idCategory);
        req.setAttribute("products", products);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("category.jsp");
        requestDispatcher.forward(req, resp);
    }
}
