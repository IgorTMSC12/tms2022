package by.teachmeskills.eshop.repositories.impl;

import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.repositories.ProductRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private JdbcTemplate jdbcTemplate;

    private static final String GET_PRODUCTS_BY_ID_CATEGORY = "SELECT * FROM eshop_db.products WHERE category_id=?";
    private static final String GET_PRODUCT_BY_ID = "SELECT * FROM eshop_db.products WHERE id=?";
    private static final String FIND_PRODUCTS_BY_REQUEST = "SELECT * FROM eshop_db.products WHERE name LIKE ? OR description LIKE ?";
    private static final String CREATE_NEW_PRODUCT = "INSERT INTO eshop_db.products (category_id, name, descriptions, price) VALUES(?,?,?,?)";
    private static final String GET_ALL_PRODUCTS = "SELECT * FROM eshop_db.products";
    private static final String UPDATE_PRODUCTS = "INSERT INTO eshop_db.products SET category_id=? name=? description=? price=? WHERE id=?";
    private static final String DELETE_PRODUCTS = "DELETE FROM eshop_db.products WHERE id=?";

    public ProductRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Product entity) {
        jdbcTemplate.update(CREATE_NEW_PRODUCT, entity.getCategoryId(), entity.getName(),
                entity.getDescription(), entity.getPrice());
    }

    @Override
    public List<Product> read() {
        return jdbcTemplate.query(GET_ALL_PRODUCTS, (rs, nowNum) -> Product.builder()
                .id(rs.getInt("id"))
                .categoryId(rs.getInt("category_id"))
                .name(rs.getString("name"))
                .description(rs.getString("descriptions"))
                .price(rs.getInt("price")).build());
    }

    @Override
    public void update(Product entity) {
        jdbcTemplate.update(UPDATE_PRODUCTS, entity.getCategoryId(),
                entity.getName(), entity.getDescription(), entity.getPrice(), entity.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_PRODUCTS, id);
    }

    @Override
    public List<Product> getProductsByIdCategory(int categoryId) {
        return jdbcTemplate.query(GET_PRODUCTS_BY_ID_CATEGORY, (rs, nowNum) -> Product.builder()
                .id(rs.getInt("id"))
                .categoryId(rs.getInt("category_id"))
                .name(rs.getString("name"))
                .description(rs.getString("description"))
                .price(rs.getInt("price")).build(), categoryId);
    }

    @Override
    public Product getProductById(int productId) {
        return jdbcTemplate.queryForObject(GET_PRODUCT_BY_ID, (rs, nowNum) -> Product.builder()
                .id(rs.getInt("id"))
                .categoryId(rs.getInt("category_id"))
                .name(rs.getString("name"))
                .description(rs.getString("description"))
                .price(rs.getInt("price")).build(), productId);
    }

    @Override
    public List<Product> findProductsByRequest(String request) {
        request = "%" + request + "%";
        return jdbcTemplate.query(FIND_PRODUCTS_BY_REQUEST, (rs, nowNum) -> Product.builder()
                .id(rs.getInt("id"))
                .categoryId(rs.getInt("category_id"))
                .name(rs.getString("name"))
                .description(rs.getString("description"))
                .price(rs.getInt("price")).build(), request, request);
    }
}
