package eshop.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@SuperBuilder
public class Cart {

    private List<Product> products = new ArrayList<>();
    private int productsPrice;
    private int productsCount;

    public void addProduct(Product product) {
        products.add(product);
        productsCount++;
        productsPrice = productsPrice + product.getPrice();
    }

    public void removeProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == (product.getId())) {
                products.remove(i);
                productsCount--;
                productsPrice = productsPrice - product.getPrice();
            }
        }
    }

    public void clear() {
        products.clear();
        productsCount = 0;
        productsPrice = 0;
    }
}
