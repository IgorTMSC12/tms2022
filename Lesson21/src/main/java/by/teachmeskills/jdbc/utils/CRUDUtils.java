package by.teachmeskills.jdbc.utils;

import by.teachmeskills.jdbc.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {

    private static String GET_ALL_PRODUCT_QUERY = "SELECT * FROM product";
    private static String INSERT_PRODUCT_QUERY = "INSERT INTO product(name, info, price, count, availability) " +
            "VALUES(?, ?, ?, ?, ?);";
    private static String UPDATE_PRODUCT_QUERY = "UPDATE product SET price = ? WHERE id = ?;";
    private static String DELETE_PRODUCT_QUERY = "DELETE FROM product WHERE id = ?";

    public static List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCT_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String info = resultSet.getString("info");
                int price = resultSet.getInt("price");
                int count = resultSet.getInt("count");
                boolean availability = resultSet.getBoolean("availability");
                products.add(new Product(name, info, price, count, availability));
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

        return products;
    }

    public static List<Product> saveProduct(Product product) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_QUERY);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getInfo());
            preparedStatement.setInt(3, product.getPrice());
            preparedStatement.setInt(4, product.getCount());
            preparedStatement.setBoolean(5, product.isAvailability());
            preparedStatement.executeUpdate();
            products = getAllProduct();
        } catch (SQLException exception) {
            System.out.println("Exception");
        }
        return products;
    }

    public static List<Product> updateProduct(int productId, double price) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_QUERY);
            preparedStatement.setDouble(1, price);
            preparedStatement.setInt(2, productId);
            preparedStatement.executeUpdate();
            products = getAllProduct();
        } catch (SQLException exception) {
            System.out.println("Exception");
        }
        return products;
    }

    public static List<Product> deleteProduct(int productId) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_QUERY);
            preparedStatement.setInt(1, productId);
            preparedStatement.executeUpdate();
            products = getAllProduct();
        } catch (SQLException exception) {
            System.out.println("Exception");
        }
        return products;
    }
}
