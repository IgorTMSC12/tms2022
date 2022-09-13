package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.dto.ProductDto;
import by.teachmeskills.eshop.dto.convertes.ProductConverter;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.repositories.ProductRepository;
import by.teachmeskills.eshop.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ProductConverter productConverter;

    public ProductServiceImpl(ProductRepository productRepository, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
    }

    @Override
    public ProductDto getProductPage(int id) {
        Product product = productRepository.getProductById(id);

        return productConverter.toDto(product);
    }

    @Override
    public List<ProductDto> findAllProductsByRequest(String search) {
        List<Product> products = productRepository.findProductsByRequest(search);
        return products.stream().map(productConverter::toDto).toList();
    }
}
