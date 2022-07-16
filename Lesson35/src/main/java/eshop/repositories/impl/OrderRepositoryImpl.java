package eshop.repositories.impl;

import eshop.entities.Order;
import eshop.entities.Product;
import eshop.repositories.OrderRepository;
import eshop.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private static final String INSERT_NEW_ORDER = "INSERT INTO eshop_db.orders (id_user, price_order, date) value (?,?,?)";
    private static final String INSERT_NEW_ORDER_PRODUCT = "INSERT INTO eshop_db.order_products (id_order, id_product) value (?,?)";
    private static final String GET_ORDERS_BY_ID_USER = "SELECT * FROM eshop_db.orders WHERE id_user=?";
    private static final String GET_PRODUCTS_BY_ID_ORDER = "SELECT * FROM eshop_db.order_products WHERE id_order=?";

    @Override
    public void create(Order entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_ORDER);
            preparedStatement.setInt(1, entity.getIdUser());
            preparedStatement.setInt(2, entity.getPriceOrder());
            preparedStatement.setObject(3, entity.getDataOrder());
            preparedStatement.executeUpdate();
            for (int i = 0; i < entity.getProducts().size(); i++) {
                createOrderProduct(getOrderByIdUser(entity.getIdUser()).getId(), entity.getProducts().get(i).getId());
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
    public Order update(Order entity) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    public void createOrderProduct(int idOrder, int idProduct) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_ORDER_PRODUCT);
            preparedStatement.setInt(1, idOrder);
            preparedStatement.setInt(2, idProduct);
            preparedStatement.executeUpdate();
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public Order getOrderByIdUser(int idUser) {
        Order order = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDERS_BY_ID_USER);
            preparedStatement.setInt(1, idUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idOrder = resultSet.getInt("id");
                int priceOrder = resultSet.getInt("price_order");
                LocalDate date = resultSet.getDate("date").toLocalDate();
                List<Product> products = getProductsByIdOrder(idOrder);
                order = new Order(idOrder, idUser, priceOrder, date, products);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return order;
    }


    @Override
    public List<Order> getOrdersByIdUser(int idUser) {
        List<Order> orders = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDERS_BY_ID_USER);
            preparedStatement.setInt(1, idUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idOrder = resultSet.getInt("id");
                int priceOrder = resultSet.getInt("price_order");
                LocalDate date = resultSet.getDate("date").toLocalDate();
                List<Product> products = getProductsByIdOrder(idOrder);
                Order order = new Order(idOrder, idUser, priceOrder, date, products);
                orders.add(order);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return orders;
    }

    public List<Product> getProductsByIdOrder(int idOrder) {
        List<Product> products = new ArrayList<>();
        ProductRepositoryImpl productRepositoryImp = new ProductRepositoryImpl();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCTS_BY_ID_ORDER);
            preparedStatement.setInt(1, idOrder);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = productRepositoryImp.getProductById(resultSet.getInt("id_product"));
                products.add(product);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return products;
    }
}
