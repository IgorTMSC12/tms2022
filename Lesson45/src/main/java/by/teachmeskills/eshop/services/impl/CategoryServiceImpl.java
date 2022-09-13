package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.PagesPathEnum;
import by.teachmeskills.eshop.entities.Category;
import by.teachmeskills.eshop.entities.Image;
import by.teachmeskills.eshop.repositories.impl.CategoryRepositoryImpl;
import by.teachmeskills.eshop.repositories.impl.ImageRepositoryImpl;
import by.teachmeskills.eshop.services.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepositoryImpl categoryRepository;
    private ImageRepositoryImpl imageRepository;

    public CategoryServiceImpl(CategoryRepositoryImpl categoryRepository, ImageRepositoryImpl imageRepository) {
        this.categoryRepository = categoryRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public void create(Category entity) {
        categoryRepository.create(entity);
    }

    @Override
    public List read() {
        return categoryRepository.read();
    }

    @Override
    public void update(Category entity) {
        categoryRepository.update(entity);
    }

    @Override
    public void delete(int id) {
        categoryRepository.delete(id);
    }

    @Override
    public ModelAndView getAllCategories() {
        ModelMap modelMap = new ModelMap();
        List<Category> categories = read();
        List<Image> images = imageRepository.getAllImagesCategories();
        modelMap.addAttribute("categories", categories);
        modelMap.addAttribute("images", images);
        return new ModelAndView(PagesPathEnum.HOME_PAGE.getPath(), modelMap);
    }
}
