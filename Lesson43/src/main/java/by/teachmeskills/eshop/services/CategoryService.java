package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.entities.Category;
import org.springframework.web.servlet.ModelAndView;

public interface CategoryService extends BaseRepository<Category> {

    public ModelAndView getAllCategories();
}