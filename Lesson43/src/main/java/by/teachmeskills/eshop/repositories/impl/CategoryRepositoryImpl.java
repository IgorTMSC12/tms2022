package by.teachmeskills.eshop.repositories.impl;

import by.teachmeskills.eshop.entities.Category;
import by.teachmeskills.eshop.repositories.CategoryRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    private JdbcTemplate jdbcTemplate;

    private static final String GET_ALL_CATEGORIES = "SELECT * FROM eshop_db.categories";
    private static final String CREATE_NEW_CATEGORIES = "INSERT INTO eshop_db.categories (name, rating) VALUES(?,?)";
    private static final String UPDATE_CATEGORIES = "INSERT INTO eshop_db.categories SET name=? rating=? WHERE id=?";
    private static final String DELETE_CATEGORIES = "DELETE FROM eshop_db.categories WHERE id=?";

    public CategoryRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Category> read() {
        return jdbcTemplate.query(GET_ALL_CATEGORIES, (rs, rowNum) -> Category.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .rating(rs.getDouble("rating"))
                .build());
    }

    @Override
    public void create(Category entity) {
        jdbcTemplate.update(CREATE_NEW_CATEGORIES, entity.getName(), entity.getRating());
    }

    @Override
    public void update(Category entity) {
        jdbcTemplate.update(UPDATE_CATEGORIES, entity.getName(), entity.getRating(), entity.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_CATEGORIES, id);
    }
}
