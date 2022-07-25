package eshop.repositories.impl;

import eshop.entities.Category;
import eshop.repositories.CategoryRepository;
import eshop.repositories.ConnectionPool;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private static final String GET_ALL_CATEGORIES = "SELECT * FROM eshop_db.categories";
    private static final String CREATE_NEW_CATEGORIES = "INSERT INTO eshop_db.categories (name, rating) VALUES(?,?)";
    private static final String UPDATE_CATEGORIES = "INSERT INTO eshop_db.categories SET name=? rating=? WHERE id=?";
    private static final String DELETE_CATEGORIES = "DELETE FROM eshop_db.categories WHERE id=?";

    @Override
    public List read() {
        List<Category> categories = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CATEGORIES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double rating = resultSet.getDouble("rating");
                Category category = Category.builder().id(id).name(name).rating(rating).build();
                categories.add(category);
            }
            connectionPool.closeConnection(connection);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } catch (Exception exception) {
            throw new RuntimeException();
        }
        return categories;
    }

    @Override
    public void create(Category entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NEW_CATEGORIES);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setDouble(2, entity.getRating());
            preparedStatement.executeUpdate();
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Category entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CATEGORIES);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setDouble(2, entity.getRating());
            preparedStatement.setInt(3, entity.getId());
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
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CATEGORIES);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
