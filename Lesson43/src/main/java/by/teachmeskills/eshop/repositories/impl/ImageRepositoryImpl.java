package by.teachmeskills.eshop.repositories.impl;

import by.teachmeskills.eshop.entities.Image;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.repositories.ImageRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImageRepositoryImpl implements ImageRepository {
    private JdbcTemplate jdbcTemplate;

    private static final String GET_ALL_IMAGES = "SELECT * FROM eshop_db.images";
    private static final String GET_ALL_IMAGES_CATEGORIES = "SELECT * FROM eshop_db.images WHERE product_id IS NULL";
    private static final String GET_ALL_IMAGES_BY_ID_CATEGORY = "SELECT * FROM eshop_db.images WHERE category_id=? AND product_id IS NOT NULL";
    private static final String GET_IMAGE_BY_ID_PRODUCT = "SELECT * FROM eshop_db.images WHERE product_id=?";
    private static final String CREATE_NEW_IMAGE = "INSERT INTO eshop_db.images (category_id, product_id, image_path) VALUES(?,?,?)";
    private static final String UPDATE_IMAGES = "INSERT INTO eshop_db.images SET category_id=? product_id=? image_path=? WHERE id=?";
    private static final String DELETE_IMAGES = "DELETE FROM eshop_db.images WHERE id=?";

    public ImageRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Image entity) {
        jdbcTemplate.update(CREATE_NEW_IMAGE, entity.getCategoryId(), entity.getProductId(), entity.getImagePath());
    }

    @Override
    public List<Image> read() {
        return jdbcTemplate.query(GET_ALL_IMAGES, (rs, nowNum) -> Image.builder()
                .id(rs.getInt("id"))
                .categoryId(rs.getInt("category_id"))
                .productId(rs.getInt("product_id"))
                .imagePath(rs.getString("image_path")).build());
    }

    @Override
    public void update(Image entity) {
        jdbcTemplate.update(UPDATE_IMAGES, entity.getCategoryId(),
                entity.getProductId(), entity.getImagePath(), entity.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_IMAGES, id);
    }

    @Override
    public List<Image> getAllImagesCategories() {
        return jdbcTemplate.query(GET_ALL_IMAGES_CATEGORIES, (rs, nowNum) -> Image.builder()
                .id(rs.getInt("id"))
                .categoryId(rs.getInt("category_id"))
                .productId(rs.getInt("product_id"))
                .imagePath(rs.getString("image_path")).build());
    }

    @Override
    public List<Image> getImagesProductsByCategory(int categoryId) {
        return jdbcTemplate.query(GET_ALL_IMAGES_BY_ID_CATEGORY, (rs, nowNum) -> Image.builder()
                .id(rs.getInt("id"))
                .categoryId(rs.getInt("category_id"))
                .productId(rs.getInt("product_id"))
                .imagePath(rs.getString("image_path")).build(), categoryId);
    }

    @Override
    public Image getImageByIdProduct(int productId) {
        return jdbcTemplate.queryForObject(GET_IMAGE_BY_ID_PRODUCT, (rs, nowNum) -> Image.builder()
                .id(rs.getInt("id"))
                .categoryId(rs.getInt("category_id"))
                .productId(rs.getInt("product_id"))
                .imagePath(rs.getString("image_path")).build(), productId);
    }

    @Override
    public List<Image> getImagesByListProducts(List<Product> products) {
        return jdbcTemplate.query(GET_IMAGE_BY_ID_PRODUCT, (rs, nowNum) -> Image.builder()
                .id(rs.getInt("id"))
                .categoryId(rs.getInt("category_id"))
                .productId(rs.getInt("product_id"))
                .imagePath(rs.getString("image_path")).build(), products);
    }
}
