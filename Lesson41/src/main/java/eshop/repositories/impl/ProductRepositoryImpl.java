package eshop.repositories.impl;

import eshop.entities.Product;
import eshop.repositories.ConnectionPool;
import eshop.repositories.ProductRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static final String GET_PRODUCTS_BY_ID_CATEGORY = "SELECT * FROM eshop_db.products WHERE category_id=?";
    private static final String GET_PRODUCT_BY_ID = "SELECT * FROM eshop_db.products WHERE id=?";
    private static final String FIND_PRODUCTS_BY_REQUEST = "SELECT * FROM eshop_db.products WHERE name LIKE ? OR description LIKE ?";
    private static final String CREATE_NEW_PRODUCT = "INSERT INTO eshop_db.products (category_id, name, descriptions, price) VALUES(?,?,?,?)";
    private static final String GET_ALL_PRODUCTS = "SELECT * FROM eshop_db.products";
    private static final String UPDATE_PRODUCTS = "INSERT INTO eshop_db.products SET category_id=? name=? description=? price=? WHERE id=?";
    private static final String DELETE_PRODUCTS = "DELETE FROM eshop_db.products WHERE id=?";

    @Override
    public void create(Product entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NEW_PRODUCT);
            preparedStatement.setInt(1, entity.getCategoryId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setString(3, entity.getDescription());
            preparedStatement.setInt(4, entity.getPrice());
            preparedStatement.executeUpdate();
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Product> read() {
        List<Product> products = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int categoryId = resultSet.getInt("category_id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("descriptions");
                int price = resultSet.getInt("price");
                Product product = Product.builder()
                        .id(id)
                        .categoryId(categoryId)
                        .name(name)
                        .description(description)
                        .price(price)
                        .build();
                products.add(product);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return products;
    }

    @Override
    public void update(Product entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCTS);
            preparedStatement.setInt(1, entity.getCategoryId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setString(3, entity.getDescription());
            preparedStatement.setInt(4, entity.getPrice());
            preparedStatement.setInt(5, entity.getId());
            preparedStatement.executeUpdate();
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCTS);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Product> getProductsByIdCategory(int categoryid) {
        List<Product> products = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCTS_BY_ID_CATEGORY);
            preparedStatement.setInt(1, categoryid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int categoryId = resultSet.getInt("category_id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int price = resultSet.getInt("price");
                Product product = Product.builder()
                        .id(id)
                        .categoryId(categoryId)
                        .name(name)
                        .description(description)
                        .price(price)
                        .build();
                products.add(product);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getProductById(int productId) {
        Product product = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_BY_ID);
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int categoryId = resultSet.getInt("category_id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int price = resultSet.getInt("price");
                product = Product.builder()
                        .id(id)
                        .categoryId(categoryId)
                        .name(name)
                        .description(description)
                        .price(price)
                        .build();
            }
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findProductsByRequest(String request) {
        List<Product> products = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_PRODUCTS_BY_REQUEST);
            preparedStatement.setString(1, "%" + request + "%");
            preparedStatement.setString(2, "%" + request + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int categoryId = resultSet.getInt("category_id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int price = resultSet.getInt("price");
                Product product = Product.builder()
                        .id(id)
                        .categoryId(categoryId)
                        .name(name)
                        .description(description)
                        .price(price)
                        .build();
                products.add(product);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return products;
    }
}
