package by.teachmeskills.eshop.controller;

import by.teachmeskills.eshop.services.impl.CategoryServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/home")
public class HomeController {
    private CategoryServiceImpl categoryService;

    public HomeController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ModelAndView getHomePage() {
        return categoryService.getAllCategories();
    }
}
