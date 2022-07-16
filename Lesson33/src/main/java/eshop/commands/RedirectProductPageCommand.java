package eshop.commands;

import eshop.PagesPathEnum;
import eshop.domain.Product;
import eshop.domain.StorageProducts;
import eshop.exceptions.CommandException;

import javax.servlet.http.HttpServletRequest;

public class RedirectProductPageCommand implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        int id = Integer.parseInt(request.getParameter("productId"));
        Product product = StorageProducts.getProductById(id);
        request.setAttribute("product", product);

        return PagesPathEnum.PRODUCT_PAGE.getPath();
    }
}
