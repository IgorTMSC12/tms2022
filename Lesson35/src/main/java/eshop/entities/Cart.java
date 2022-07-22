package eshop.entities;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> products;
    private int productsPrice;
    private int productsCount;

    public Cart() {
        this.products = new ArrayList<>();
        productsPrice = 0;
        productsCount = 0;
    }

    public int getProductsPrice() {
        return productsPrice;
    }

    public int getProductsCount() {
        return productsCount;
    }

    public List<Product> getProducts() {
        return products;
    }

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
