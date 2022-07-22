package eshop.commands;

import eshop.PagesPathEnum;
import eshop.entities.Category;
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
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        List<Product> products = productRepository.getProductsByIdCategory(categoryId);
        Category category = Category.builder().id(categoryId).name(name).products(products).build();
        List<Image> images = imageRepository.getImagesProductsByCategory(categoryId);
        request.setAttribute("category", category);
        request.setAttribute("images", images);
        return PagesPathEnum.CATEGORY_PAGE.getPath();
    }
}
