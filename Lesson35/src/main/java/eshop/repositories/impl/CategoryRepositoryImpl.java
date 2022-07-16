package eshop.repositories.impl;

import eshop.entities.BaseEntity;
import eshop.entities.Category;
import eshop.repositories.CategoryRepository;
import eshop.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {
    private static final String GET_ALL_CATEGORIES = "SELECT * FROM eshop_db.categories";

    @Override
    public void create(BaseEntity entity) {

    }

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
                Category category = new Category(id, name, rating);
                categories.add(category);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return categories;
    }

    @Override
    public BaseEntity update(BaseEntity entity) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
