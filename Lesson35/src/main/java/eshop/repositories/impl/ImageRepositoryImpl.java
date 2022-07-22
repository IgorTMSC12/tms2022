package eshop.repositories.impl;

import eshop.entities.Image;
import eshop.entities.Product;
import eshop.repositories.ImageRepository;
import eshop.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImageRepositoryImpl implements ImageRepository {
    private static final String GET_ALL_IMAGES_CATEGORIES = "SELECT * FROM eshop_db.images WHERE product_id IS NULL";
    private static final String GET_ALL_IMAGES_BY_ID_CATEGORY = "SELECT * FROM eshop_db.images WHERE category_id=? AND product_id IS NOT NULL";
    private static final String GET_IMAGE_BY_ID_PRODUCT = "SELECT * FROM eshop_db.images WHERE product_id=?";

    @Override
    public void create(Image entity) {

    }

    @Override
    public List<Image> read() {
        return null;
    }

    @Override
    public Image update(Image entity) {
        return null;
    }

    @Override
    public void delete(int id) {

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
                Image image = new Image(categoryId, productId, imagePath);
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
                Image image = new Image(categoryId, productId, imagePath);
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
                image = new Image(categoryId, productId, imagePath);
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
                    Image image = new Image(categoryId, productId, imagePath);
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
