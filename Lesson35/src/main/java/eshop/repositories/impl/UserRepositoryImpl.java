package eshop.repositories.impl;

import eshop.entities.User;
import eshop.repositories.UserRepository;
import eshop.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private static final String GET_USER_BY_LOG_AND_PASS = "SELECT * FROM eshop_db.users WHERE email=? AND password=?";
    private static final String INSERT_NEW_USER = "INSERT INTO eshop_db.users (name, lastname, email, password) value (?,?,?,?)";

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
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public void delete(int id) {

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
