package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.dto.CategoryDto;
import by.teachmeskills.eshop.dto.convertes.CategoryConverter;
import by.teachmeskills.eshop.entities.Category;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.repositories.CategoryRepository;
import by.teachmeskills.eshop.repositories.ProductRepository;
import by.teachmeskills.eshop.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    private CategoryConverter categoryConverter;

    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               ProductRepository productRepository, CategoryConverter categoryConverter) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.categoryConverter = categoryConverter;
    }

    public List<Category> read() {
        return categoryRepository.findAll();
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = read();
        return categories.stream().map(categoryConverter::toDto).toList();
    }

    public CategoryDto getCategoryById(int id) {
        Category category = categoryRepository.getCategoryById(id);
        if (Optional.ofNullable(category).isPresent()) {
            List<Product> products = productRepository.getProductsByCategoryId(category.getId());
            category.setProducts(products);
        }
        return categoryConverter.toDto(category);
    }
}
