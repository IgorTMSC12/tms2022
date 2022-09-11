package by.teachmeskills.eshop.repositories;

import by.teachmeskills.eshop.entities.Product;

import java.util.List;

public interface ProductRepository extends BaseRepository<Product> {
    List<Product> getProductsByIdCategory(int idCategory);

    Product getProductById(int idProduct);

    List<Product> findProductsByRequest(String request);
}