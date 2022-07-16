package eshop.commands;

import eshop.PagesPathEnum;
import eshop.entities.Image;
import eshop.entities.Product;
import eshop.exceptions.CommandException;
import eshop.repositories.impl.ImageRepositoryImpl;
import eshop.repositories.impl.ProductRepositoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CategoryRedirectCommandImpl implements BaseCommand {
    private ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
    private ImageRepositoryImpl imageRepository = new ImageRepositoryImpl();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String name = request.getParameter("categoryName");
        int idCategory = Integer.parseInt(request.getParameter("categoryId"));
        List<Product> products = productRepository.getProductsByIdCategory(idCategory);
        List<Image> images = imageRepository.getImagesProductsByCategory(idCategory);
        request.setAttribute("products", products);
        request.setAttribute("images", images);
        request.setAttribute("name", name);
        return PagesPathEnum.CATEGORY_PAGE.getPath();
    }
}
