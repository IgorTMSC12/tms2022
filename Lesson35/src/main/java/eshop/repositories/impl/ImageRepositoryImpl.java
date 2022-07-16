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
    private static final String GET_ALL_IMAGES_CATEGORIES = "SELECT * FROM eshop_db.images WHERE id_product IS NULL";
    private static final String GET_ALL_IMAGES_BY_ID_CATEGORY = "SELECT * FROM eshop_db.images WHERE id_category=? AND id_product IS NOT NULL";
    private static final String GET_IMAGE_BY_ID_PRODUCT = "SELECT * FROM eshop_db.images WHERE id_product=?";

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
                int idCategory = resultSet.getInt("id_category");
                int idProduct = resultSet.getInt("id_product");
                String imagePath = resultSet.getString("image_path");
                Image image = new Image(idCategory, idProduct, imagePath);
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
                int idCategory = resultSet.getInt("id_category");
                int idProduct = resultSet.getInt("id_product");
                String imagePath = resultSet.getString("image_path");
                Image image = new Image(idCategory, idProduct, imagePath);
                images.add(image);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return images;
    }

    @Override
    public Image getImageByIdProduct(int idProduct) {
        Image image = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_IMAGE_BY_ID_PRODUCT);
            preparedStatement.setInt(1, idProduct);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idCategory = resultSet.getInt("id_category");
                int productId = resultSet.getInt("id_product");
                String imagePath = resultSet.getString("image_path");
                image = new Image(idCategory, productId, imagePath);
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
                    int idCategory = resultSet.getInt("id_category");
                    int idProduct = resultSet.getInt("id_product");
                    String imagePath = resultSet.getString("image_path");
                    Image image = new Image(idCategory, idProduct, imagePath);
                    images.add(image);
                }
            }
            connectionPool.closeConnection(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return images;
    }
}
