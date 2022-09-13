package by.teachmeskills.eshop.dto.convertes;

import by.teachmeskills.eshop.dto.ProductDto;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.repositories.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductConverter {

    private final CategoryRepository categoryRepository;

    public ProductConverter(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .categoryId(product.getCategory().getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public Product fromDto(ProductDto productDto) {
        return Optional.ofNullable(productDto).map(pd -> Product.builder()
                        .id(pd.getId())
                        .category(categoryRepository.getCategoryById(pd.getCategoryId()))
                        .name(pd.getName())
                        .description(pd.getDescription())
                        .price(pd.getPrice())
                        .build()).
                orElse(null);
    }

}
