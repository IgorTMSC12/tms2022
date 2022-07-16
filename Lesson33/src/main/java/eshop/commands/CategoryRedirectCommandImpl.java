package eshop.commands;

import eshop.PagesPathEnum;
import eshop.domain.Product;
import eshop.domain.StorageProducts;
import eshop.exceptions.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CategoryRedirectCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String name = request.getParameter("categoryName");
        request.setAttribute("name", name);

        int idCategory = Integer.parseInt(request.getParameter("categoryId"));
        List<Product> products = StorageProducts.getProductByIdCategory(idCategory);
        request.setAttribute("products", products);

        return PagesPathEnum.CATEGORY_PAGE.getPath();
    }
}
