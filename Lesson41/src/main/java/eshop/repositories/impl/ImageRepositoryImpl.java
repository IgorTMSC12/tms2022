package eshop.repositories.impl;

import eshop.entities.Image;
import eshop.entities.Product;
import eshop.repositories.ConnectionPool;
import eshop.repositories.ImageRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ImageRepositoryImpl implements ImageRepository {
    private static final String GET_ALL_IMAGES = "SELECT * FROM eshop_db.images";
    private static final String GET_ALL_IMAGES_CATEGORIES = "SELECT * FROM eshop_db.images WHERE product_id IS NULL";
    private static final String GET_ALL_IMAGES_BY_ID_CATEGORY = "SELECT * FROM eshop_db.images WHERE category_id=? AND product_id IS NOT NULL";
    private static final String GET_IMAGE_BY_ID_PRODUCT = "SELECT * FROM eshop_db.images WHERE product_id=?";
    private static final String CREATE_NEW_IMAGE = "INSERT INTO eshop_db.images (category_id, product_id, image_path) VALUES(?,?,?)";
    private static final String UPDATE_IMAGES = "INSERT INTO eshop_db.images SET category_id=? product_id=? image_path=? WHERE id=?";
    private static final String DELETE_IMAGES = "DELETE FROM eshop_db.images WHERE id=?";

    @Override
    public void create(Image entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NEW_IMAGE);
            preparedStatement.setInt(1, entity.getCategoryId());
            preparedStatement.setInt(2, entity.getProductId());
            preparedStatement.setString(3, entity.getImagePath());
            preparedStatement.executeUpdate();
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Image> read() {
        List<Image> images = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_IMAGES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int categoryId = resultSet.getInt("category_id");
                int productId = resultSet.getInt("product_id");
                String imagePath = resultSet.getString("image_path");
                Image image = Image.builder()
                        .id(id)
                        .categoryId(categoryId)
                        .productId(productId)
                        .imagePath(imagePath)
                        .build();
                images.add(image);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return images;
    }

    @Override
    public void update(Image entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_IMAGES);
            preparedStatement.setInt(1, entity.getCategoryId());
            preparedStatement.setInt(2, entity.getProductId());
            preparedStatement.setString(3, entity.getImagePath());
            preparedStatement.setInt(4, entity.getId());
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
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_IMAGES);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Image> getAllImagesCategories() {
        List<Image> categoryImage = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_IMAGES_CATEGORIES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int categoryId = resultSet.getInt("category_id");
                int productId = resultSet.getInt("product_id");
                String imagePath = resultSet.getString("image_path");
                Image image = Image.builder()
                        .categoryId(categoryId)
                        .productId(productId)
                        .imagePath(imagePath)
                        .build();
                categoryImage.add(image);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return categoryImage;
    }

    @Override
    public List<Image> getImagesProductsByCategory(int categoryId) {
        List<Image> images = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_IMAGES_BY_ID_CATEGORY);
            preparedStatement.setInt(1, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String imagePath = resultSet.getString("image_path");
                Image image = Image.builder()
                        .categoryId(categoryId)
                        .productId(productId)
                        .imagePath(imagePath)
                        .build();
                images.add(image);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return images;
    }

    @Override
    public Image getImageByIdProduct(int productId) {
        Image image = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_IMAGE_BY_ID_PRODUCT);
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int categoryId = resultSet.getInt("category_id");
                String imagePath = resultSet.getString("image_path");
                image = Image.builder()
                        .categoryId(categoryId)
                        .productId(productId)
                        .imagePath(imagePath)
                        .build();
            }
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return image;
    }

    @Override
    public List<Image> getImagesByListProducts(List<Product> products) {
        List<Image> images = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            for (Product product : products) {
                PreparedStatement preparedStatement = connection.prepareStatement(GET_IMAGE_BY_ID_PRODUCT);
                preparedStatement.setInt(1, product.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int categoryId = resultSet.getInt("category_id");
                    int productId = resultSet.getInt("product_id");
                    String imagePath = resultSet.getString("image_path");
                    Image image = Image.builder()
                            .categoryId(categoryId)
                            .productId(productId)
                            .imagePath(imagePath)
                            .build();
                    if (images.size() == 0) {
                        images.add(image);
                    }
                    int count = 0;
                    for (int i = 0; i < images.size(); i++) {
                        if (!(images.get(i).getProductId() == image.getProductId())) {
                            count++;
                        }
                        if (count == images.size()) {
                            images.add(image);
                        }
                    }
                }
            }
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return images;
    }
}
