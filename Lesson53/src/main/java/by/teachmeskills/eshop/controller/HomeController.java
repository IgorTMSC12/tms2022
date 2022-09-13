package by.teachmeskills.eshop.controller;

import by.teachmeskills.eshop.services.impl.CategoryServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @GetMapping("/export")
    public ModelAndView exportToFile(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setCharacterEncoding("UTF8");
        response.addHeader("Content-Disposition", "attachment; filename=categories.csv");
        categoryService.exportToFile(response.getWriter());
        return categoryService.getAllCategories();
    }

    @PostMapping("/import")
    public ModelAndView importFromFile(@RequestParam("file") MultipartFile file) {
        categoryService.importFromFile(file);
        return categoryService.getAllCategories();
    }
}
