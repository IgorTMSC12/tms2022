package by.teachmeskills.eshop.controller;

import by.teachmeskills.eshop.services.impl.ProductServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/search")
public class SearchController {
    private ProductServiceImpl productService;

    public SearchController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping
    public ModelAndView getSearchPage(@RequestParam("search") String search) {
        return productService.findAllProductsByRequest(search);
    }
}