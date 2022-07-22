package eshop.repositories;

import eshop.entities.Image;
import eshop.entities.Product;

import java.util.List;

public interface ImageRepository extends BaseRepository<Image> {
    List<Image> getAllImagesCategories();

    List<Image> getImagesProductsByCategory(int categoryId);

    Image getImageByIdProduct(int idProduct);

    List<Image> getImagesByListProducts(List<Product> products);
}
