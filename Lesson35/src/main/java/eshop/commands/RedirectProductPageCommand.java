package eshop.commands;

import eshop.PagesPathEnum;
import eshop.entities.Image;
import eshop.entities.Product;
import eshop.exceptions.CommandException;
import eshop.repositories.impl.ImageRepositoryImpl;
import eshop.repositories.impl.ProductRepositoryImpl;

import javax.servlet.http.HttpServletRequest;

public class RedirectProductPageCommand implements BaseCommand {
    private ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
    private ImageRepositoryImpl imageRepository = new ImageRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        int id = Integer.parseInt(request.getParameter("productId"));
        Product product = productRepository.getProductById(id);
        Image image = imageRepository.getImageByIdProduct(id);
        request.setAttribute("product", product);
        request.setAttribute("image", image);
        return PagesPathEnum.PRODUCT_PAGE.getPath();
    }
}
