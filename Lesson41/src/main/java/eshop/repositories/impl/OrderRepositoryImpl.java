package eshop.repositories.impl;

import eshop.entities.Order;
import eshop.entities.Product;
import eshop.repositories.ConnectionPool;
import eshop.repositories.OrderRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private static final String INSERT_NEW_ORDER = "INSERT INTO eshop_db.orders (user_id, order_price, date) value (?,?,?)";
    private static final String INSERT_NEW_ORDER_PRODUCT = "INSERT INTO eshop_db.order_products (order_id, product_id) value (?,?)";
    private static final String GET_ORDERS_BY_ID_USER = "SELECT * FROM eshop_db.orders WHERE user_id=?";
    private static final String GET_PRODUCTS_BY_ID_ORDER = "SELECT * FROM eshop_db.order_products WHERE order_id=?";

    @Override
    public void create(Order entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_ORDER);
            preparedStatement.setInt(1, entity.getUserId());
            preparedStatement.setInt(2, entity.getPrice());
            preparedStatement.setObject(3, entity.getDate());
            preparedStatement.executeUpdate();
            for (int i = 0; i < entity.getProducts().size(); i++) {
                createOrderProduct(getOrderByIdUser(entity.getUserId()).getId(), entity.getProducts().get(i).getId());
            }
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Order> read() {
        return null;
    }

    @Override
    public void update(Order entity) {

    }

    @Override
    public void delete(int id) {

    }

    public void createOrderProduct(int orderId, int productId) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_ORDER_PRODUCT);
            preparedStatement.setInt(1, orderId);
            preparedStatement.setInt(2, productId);
            preparedStatement.executeUpdate();
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public Order getOrderByIdUser(int userId) {
        Order order = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDERS_BY_ID_USER);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int orderId = resultSet.getInt("id");
                int orderPrice = resultSet.getInt("order_price");
                LocalDate date = resultSet.getDate("date").toLocalDate();
                List<Product> products = getProductsByIdOrder(orderId);
                order = Order.builder()
                        .id(orderId)
                        .userId(userId)
                        .price(orderPrice)
                        .date(date)
                        .products(products)
                        .build();
            }
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return order;
    }


    @Override
    public List<Order> getOrdersByIdUser(int userId) {
        List<Order> orders = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDERS_BY_ID_USER);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int orderId = resultSet.getInt("id");
                int orderPrice = resultSet.getInt("order_price");
                LocalDate date = resultSet.getDate("date").toLocalDate();
                List<Product> products = getProductsByIdOrder(orderId);
                Order order = Order.builder()
                        .id(orderId)
                        .userId(userId)
                        .price(orderPrice)
                        .date(date)
                        .products(products)
                        .build();
                orders.add(order);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return orders;
    }

    public List<Product> getProductsByIdOrder(int orderId) {
        List<Product> products = new ArrayList<>();
        ProductRepositoryImpl productRepositoryImp = new ProductRepositoryImpl();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCTS_BY_ID_ORDER);
            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = productRepositoryImp.getProductById(resultSet.getInt("product_id"));
                products.add(product);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return products;
    }
}
