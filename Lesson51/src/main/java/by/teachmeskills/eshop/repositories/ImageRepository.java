package by.teachmeskills.eshop.repositories;

import by.teachmeskills.eshop.entities.Image;
import by.teachmeskills.eshop.entities.Product;

import java.util.List;

public interface ImageRepository {

    List<Image> getAllImagesCategories();

    List<Image> getImagesProductsByCategory(int categoryId);

    Image getImageByIdProduct(int idProduct);

    List<Image> getImagesByListProducts(List<Product> products);
}
