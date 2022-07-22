package eshop.entities;

import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@SuperBuilder
public class Order extends BaseEntity {

    private int userId;
    private int orderPrice;
    private LocalDate orderData;
    private List<Product> products;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public LocalDate getOrderData() {
        return orderData;
    }

    public void setOrderData(LocalDate orderData) {
        this.orderData = orderData;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
