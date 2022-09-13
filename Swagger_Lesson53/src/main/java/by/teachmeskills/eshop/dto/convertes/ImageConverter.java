package by.teachmeskills.eshop.dto.convertes;

import by.teachmeskills.eshop.dto.ImageDto;
import by.teachmeskills.eshop.entities.Image;
import by.teachmeskills.eshop.repositories.CategoryRepository;
import by.teachmeskills.eshop.repositories.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ImageConverter {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public ImageConverter(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }


    public ImageDto toDto(Image image) {
        return Optional.ofNullable(image).map(i -> ImageDto.builder()
                        .id(i.getId())
                        .categoryId(i.getCategory().getId())
                        .productId(i.getProduct().getId())
                        .imagePath(i.getImagePath())
                        .build())
                .orElse(null);
    }

    public Image fromDto(ImageDto imageDto) {
        return Optional.ofNullable(imageDto).map(id -> Image.builder()
                        .id(id.getId())
                        .category(categoryRepository.getCategoryById(id.getCategoryId()))
                        .product(productRepository.getProductById(id.getProductId()))
                        .imagePath(id.getImagePath())
                        .build())
                .orElse(null);
    }
}
