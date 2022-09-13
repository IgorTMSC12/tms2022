package by.teachmeskills.eshop.repositories;

import by.teachmeskills.eshop.entities.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getProductsByIdCategory(int idCategory);

    Product getProductById(int idProduct);

    List<Product> findProductsByRequest(String request, int number);
}
