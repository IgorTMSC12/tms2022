package eshop.repositories.impl;

import eshop.entities.User;
import eshop.repositories.ConnectionPool;
import eshop.repositories.UserRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static final String GET_USER_BY_LOG_AND_PASS = "SELECT * FROM eshop_db.users WHERE email=? AND password=?";
    private static final String INSERT_NEW_USER = "INSERT INTO eshop_db.users (name, lastname, email, password) value (?,?,?,?)";
    private static final String GET_ALL_USERS = "SELECT * FROM eshop_db.users";
    private static final String UPDATE_USERS = "INSERT INTO eshop_db.users SET name=? lastname=? email=? password=? WHERE id=?";
    private static final String DELETE_USERS = "DELETE FROM eshop_db.users WHERE id=?";

    @Override
    public void create(User entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_USER);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setString(4, entity.getPassword());
            preparedStatement.executeUpdate();
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<User> read() {
        List<User> users = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                User user = User.builder()
                        .id(id)
                        .name(name)
                        .lastName(lastname)
                        .email(email)
                        .password(password)
                        .build();
                users.add(user);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return users;
    }

    @Override
    public void update(User entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setString(4, entity.getPassword());
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
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public User getUserByLoginAndPass(String login, String pass) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        User user = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_LOG_AND_PASS);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, pass);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                user = User.builder()
                        .id(id)
                        .name(name)
                        .lastName(lastname)
                        .email(email)
                        .password(password)
                        .build();

            }
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return user;
    }

    public boolean checkUserFromBase(User user) {
        User userFromBase = getUserByLoginAndPass(user.getEmail(), user.getPassword());
        if (userFromBase != null) {
            return true;
        }
        return false;
    }
}
