package eshop.repositories.impl;

import eshop.entities.Product;
import eshop.repositories.ProductRepository;
import eshop.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private static final String GET_PRODUCTS_BY_ID_CATEGORY = "SELECT * FROM eshop_db.products WHERE id_category=?";
    private static final String GET_PRODUCT_BY_ID = "SELECT * FROM eshop_db.products WHERE id=?";
    private static final String FIND_PRODUCTS_BY_REQUEST = "SELECT * FROM eshop_db.products WHERE name LIKE ? OR description LIKE ?";

    @Override
    public void create(Product entity) {

    }

    @Override
    public List<Product> read() {
        return null;
    }

    @Override
    public Product update(Product entity) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Product> getProductsByIdCategory(int idCategory) {
        List<Product> products = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCTS_BY_ID_CATEGORY);
            preparedStatement.setInt(1, idCategory);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int CategoryId = resultSet.getInt("id_category");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int price = resultSet.getInt("price");
                Product product = new Product(id, CategoryId, name, description, price);
                products.add(product);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getProductById(int idProduct) {
        Product product = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_BY_ID);
            preparedStatement.setInt(1, idProduct);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idCategory = resultSet.getInt("id_category");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int price = resultSet.getInt("price");
                product = new Product(id, idCategory, name, description, price);
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
        //String searc = "%" + request + "%";
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_PRODUCTS_BY_REQUEST);
            preparedStatement.setString(1, "%" + request + "%");
            preparedStatement.setString(2, "%" + request + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int id_category = resultSet.getInt("id_category");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int price = resultSet.getInt("price");
                Product product = new Product(id, id_category, name, description, price);
                products.add(product);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return products;
    }
}
