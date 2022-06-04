package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> products;
    private int priceProducts;
    private int countProducts;

    public Cart() {
        this.products = new ArrayList<>();
        priceProducts = 0;
        countProducts = 0;
    }

    public int getPriceProducts() {
        return priceProducts;
    }

    public int getCountProducts() {
        return countProducts;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
        countProducts++;
        priceProducts = priceProducts + product.getPrice();
    }

    public void removeProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(product.getName())) {
                products.remove(i);
                countProducts--;
                priceProducts = priceProducts - product.getPrice();
            }
        }
    }

    public void clear() {
        products.clear();
        countProducts = 0;
        priceProducts = 0;
    }
}
