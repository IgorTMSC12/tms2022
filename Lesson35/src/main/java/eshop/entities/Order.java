package eshop.entities;

import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@SuperBuilder
public class Order extends BaseEntity {

    private int idUser;
    private int priceOrder;
    private LocalDate dataOrder;
    private List<Product> products;

    public Order(int idOrder, int idUser, int priceOrder, LocalDate dataOrder, List<Product> products) {
        super(idOrder);
        this.idUser = idUser;
        this.priceOrder = priceOrder;
        this.dataOrder = dataOrder;
        this.products = products;
    }

    public Order(int idUser, int priceOrder, LocalDate dataOrder, List<Product> products) {
        this.idUser = idUser;
        this.priceOrder = priceOrder;
        this.dataOrder = dataOrder;
        this.products = products;
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
