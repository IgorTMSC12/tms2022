package eshop.repositories;

import eshop.entities.Order;

import java.util.List;

public interface OrderRepository extends BaseRepository<Order> {
    Order getOrderByIdUser(int idUser);

    List<Order> getOrdersByIdUser(int idUser);
}
