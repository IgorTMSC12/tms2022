package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.dto.SearchParamsDto;
import by.teachmeskills.eshop.entities.Product;
import org.springframework.web.servlet.ModelAndView;

public interface ProductService extends BaseRepository<Product> {
    public ModelAndView getCategoryPage(int id);

    public ModelAndView getProductPage(int id);

    public ModelAndView findAllProductsByRequest(SearchParamsDto searchParamsDto, int pageNumber, int pageSize);
}
