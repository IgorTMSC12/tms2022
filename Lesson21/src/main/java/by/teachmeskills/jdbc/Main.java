package by.teachmeskills.jdbc;

import by.teachmeskills.jdbc.model.Product;
import by.teachmeskills.jdbc.utils.CRUDUtils;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Lg", "TV", 100, 7, true);
        Product product2 = new Product("Xiaomi", "Phone", 60, 14, false);
        Product product3 = new Product("Huawei", "Phone", 210, 41, true);
        Product product4 = new Product("Samsung", "Washer", 300, 3, true);
        Product product5 = new Product("Lg", "Smart Watch", 60, 14, true);

        CRUDUtils.saveProduct(product1);
        CRUDUtils.saveProduct(product2);
        CRUDUtils.saveProduct(product3);
        CRUDUtils.saveProduct(product4);
        CRUDUtils.saveProduct(product5);

        System.out.println(CRUDUtils.getAllProduct());

        CRUDUtils.updateProduct(17, 800);

        System.out.println(CRUDUtils.getAllProduct());

        CRUDUtils.deleteProduct(21);


    }
}
