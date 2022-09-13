package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.dto.ProductDto;

import java.util.List;

public interface ProductService {

    public ProductDto getProductPage(int id);

    public List<ProductDto> findAllProductsByRequest(String search);

}
