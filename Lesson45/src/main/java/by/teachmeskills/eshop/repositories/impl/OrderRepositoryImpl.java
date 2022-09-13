package by.teachmeskills.eshop.repositories.impl;

import by.teachmeskills.eshop.entities.Order;
import by.teachmeskills.eshop.repositories.OrderRepository;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;
    private ProductRepositoryImpl productRepository;

    public void create(Order entity) {
        entityManager.persist(entity);
    }

    public List<Order> read() {
        return entityManager.createQuery("select o from Order o").getResultList();
    }

    public void update(Order entity) {
        entityManager.merge(entity);
    }

    public void delete(int id) {
        Order order = entityManager.find(Order.class, id);
        entityManager.remove(order);
    }

    @Override
    public List<Order> getOrdersByIdUser(int userId) {
        Query query = (Query) entityManager.createQuery("select i from Order i where i.user.id=:userId order by i.id desc");
        query.setParameter("userId", userId);
        return query.getResultList();
    }
}
