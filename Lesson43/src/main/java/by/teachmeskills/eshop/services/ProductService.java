package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.entities.Product;
import org.springframework.web.servlet.ModelAndView;

public interface ProductService extends BaseRepository<Product> {
    public ModelAndView getCategoryPage(int id, String name);

    public ModelAndView getProductPage(int id);

    public ModelAndView findAllProductsByRequest(String search);
}