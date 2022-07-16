package eshop.domain;

import java.time.LocalDate;
import java.util.List;

public class Order {

    private static int idCounter = 1;
    private int idOrder;
    private int idUser;
    private int priceOrder;
    private LocalDate dataOrder;
    private List<Product> products;

    public Order(int idUser, int priceOrder, LocalDate dataOrder, List<Product> products) {
        this.idOrder = idCounter++;
        this.idUser = idUser;
        this.priceOrder = priceOrder;
        this.dataOrder = dataOrder;
        this.products = products;
    }

    public int getIdCounter() {
        return idCounter;
    }

    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getPriceOrder() {
        return priceOrder;
    }

    public void setPriceOrder(int priceOrder) {
        this.priceOrder = priceOrder;
    }

    public LocalDate getDataOrder() {
        return dataOrder;
    }

    public void setDataOrder(LocalDate dataOrder) {
        this.dataOrder = dataOrder;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
