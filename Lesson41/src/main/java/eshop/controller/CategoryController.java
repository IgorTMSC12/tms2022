package eshop.controller;

import eshop.services.impl.ProductServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private ProductServiceImpl productService;

    public CategoryController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping
    public ModelAndView openCategoryPage(@RequestParam("categoryId") int id, @RequestParam("categoryName") String name) {
        return productService.getCategoryPage(id, name);
    }
}
