package eshop.commands;

import eshop.PagesPathEnum;
import eshop.entities.Image;
import eshop.entities.Product;
import eshop.exceptions.CommandException;
import eshop.repositories.impl.ImageRepositoryImpl;
import eshop.repositories.impl.ProductRepositoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SearchRedirectCommand implements BaseCommand {
    private ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
    private ImageRepositoryImpl imageRepository = new ImageRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String search = request.getParameter("search");
        List<Product> products = productRepository.findProductsByRequest(search);
        List<Image> images = imageRepository.getImagesByListProducts(products);
        request.setAttribute("products", products);
        request.setAttribute("images", images);
        return PagesPathEnum.SEARCH_PAGE.getPath();
    }
}
