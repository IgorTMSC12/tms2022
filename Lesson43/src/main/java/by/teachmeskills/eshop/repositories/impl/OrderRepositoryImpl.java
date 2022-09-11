package by.teachmeskills.eshop.repositories.impl;

import by.teachmeskills.eshop.entities.Order;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.repositories.OrderRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private JdbcTemplate jdbcTemplate;
    private ProductRepositoryImpl productRepository;

    private static final String GET_ALL_ORDERS = "SELECT * FROM eshop_db.orders";
    private static final String CREATE_NEW_ORDER = "INSERT INTO eshop_db.orders (user_id, order_price, date) value (?,?,?)";
    private static final String UPDATE_ORDER = "INSERT INTO eshop_db.orders SET user_id=? order_price=? order_data=? WHERE id=?";
    private static final String DELETE_IMAGES = "DELETE FROM eshop_db.orders WHERE id=?";
    private static final String INSERT_NEW_ORDER_PRODUCT = "INSERT INTO eshop_db.order_products (order_id, product_id) value (?,?)";
    private static final String GET_ORDERS_BY_ID_USER = "SELECT * FROM eshop_db.orders WHERE user_id=?";
    private static final String GET_PRODUCTS_BY_ID_ORDER = "SELECT * FROM eshop_db.order_products WHERE order_id=?";

    public OrderRepositoryImpl(JdbcTemplate jdbcTemplate, ProductRepositoryImpl productRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.productRepository = productRepository;
    }

    @Override
    public void create(Order entity) {
        jdbcTemplate.update(CREATE_NEW_ORDER, entity.getUserId(), entity.getPrice(), entity.getDate());
        List<Order> orders = jdbcTemplate.query(GET_ORDERS_BY_ID_USER, (rs, nowNum) -> Order.builder()
                .id(rs.getInt("id"))
                .userId(rs.getInt("user_id"))
                .price(rs.getInt("order_price"))
                .date(rs.getObject("date", LocalDate.class))
                .build(), entity.getUserId());
        int idOrder = orders.get(orders.size() - 1).getId();
        for (int i = 0; i < entity.getProducts().size(); i++) {
            jdbcTemplate.update(INSERT_NEW_ORDER_PRODUCT, idOrder, entity.getProducts().get(i).getId());
        }
    }

    @Override
    public List<Order> read() {
        return jdbcTemplate.query(GET_ALL_ORDERS, (rs, nowNum) -> Order.builder()
                .id(rs.getInt("id"))
                .userId(rs.getInt("user_id"))
                .price(rs.getInt("order_price"))
                .date(rs.getObject("date", LocalDate.class))
                .products(getProductsByIdOrder(rs.getInt("id")))
                .build());
    }

    @Override
    public void update(Order entity) {
        jdbcTemplate.update(UPDATE_ORDER, entity.getUserId(),
                entity.getPrice(), entity.getDate(), entity.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_IMAGES, id);
    }

    @Override
    public List<Order> getOrdersByIdUser(int userId) {
        return jdbcTemplate.query(GET_ORDERS_BY_ID_USER, (rs, nowNum) -> Order.builder()
                .id(rs.getInt("id"))
                .userId(rs.getInt("user_id"))
                .price(rs.getInt("order_price"))
                .date(rs.getObject("date", LocalDate.class))
                .products(getProductsByIdOrder(rs.getInt("id")))
                .build(), userId);
    }

    public List<Product> getProductsByIdOrder(int orderId) {
        return jdbcTemplate.query(GET_PRODUCTS_BY_ID_ORDER, (rs, nowNum) -> productRepository.getProductById(rs.getInt("product_id")), orderId);
    }
}
