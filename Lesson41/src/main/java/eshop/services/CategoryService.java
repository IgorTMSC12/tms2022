package eshop.services;

import eshop.entities.Category;
import org.springframework.web.servlet.ModelAndView;

public interface CategoryService extends BaseRepository<Category> {

    public ModelAndView getAllCategories();
}
