package by.teachmeskills.eshop.repositories.impl;

import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.repositories.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private JdbcTemplate jdbcTemplate;

    private static final String GET_USER_BY_LOG_AND_PASS = "SELECT * FROM eshop_db.users WHERE email=? AND password=?";
    private static final String INSERT_NEW_USER = "INSERT INTO eshop_db.users (name, lastname, email, password) value (?,?,?,?)";
    private static final String GET_ALL_USERS = "SELECT * FROM eshop_db.users";
    private static final String UPDATE_USERS = "INSERT INTO eshop_db.users SET name=? lastname=? email=? password=? WHERE id=?";
    private static final String DELETE_USERS = "DELETE FROM eshop_db.users WHERE id=?";

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(User entity) {
        jdbcTemplate.update(INSERT_NEW_USER, entity.getName(), entity.getLastName(),
                entity.getEmail(), entity.getPassword());
    }

    @Override
    public List<User> read() {
        return jdbcTemplate.query(GET_ALL_USERS, (rs, nowNum) -> User.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .lastName(rs.getString("lastname"))
                .email(rs.getString("email"))
                .password(rs.getString("password")).build());
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update(UPDATE_USERS, entity.getName(), entity.getLastName(),
                entity.getEmail(), entity.getPassword(), entity.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_USERS, id);
    }

    @Override
    public User getUserByLoginAndPass(String email, String password) {
        return jdbcTemplate.queryForObject(GET_USER_BY_LOG_AND_PASS, (rs, nowNum) -> User.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .lastName(rs.getString("lastname"))
                .email(rs.getString("email"))
                .password(rs.getString("password"))
                .build(), email, password);
    }

    public boolean checkUserFromBase(User user) {
        List<User> users = read();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(user.getEmail())) {
                return true;
            }
        }
        return false;
    }
}
