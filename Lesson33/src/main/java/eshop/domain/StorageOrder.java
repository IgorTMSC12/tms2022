package eshop.domain;

import java.util.ArrayList;
import java.util.List;

public class StorageOrder {
    private static List<Order> orders = new ArrayList<>();

    public static void addOrder(Order order) {
        orders.add(order);
    }

    public static List<Order> getOrdersByIdUser(int idUser) {
        List<Order> ordersByIdUser = new ArrayList<>();
        for (Order order : orders) {
            if (order.getIdUser() == idUser) {
                ordersByIdUser.add(order);
            }
        }
        return ordersByIdUser;
    }
}
