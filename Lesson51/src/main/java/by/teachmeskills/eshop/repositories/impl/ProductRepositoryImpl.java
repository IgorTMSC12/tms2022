package by.teachmeskills.eshop.repositories.impl;

import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.repositories.ProductRepository;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Product entity) {
        entityManager.persist(entity);
    }

    public List<Product> read() {
        return entityManager.createQuery("select i from Image i").getResultList();
    }

    public void update(Product entity) {
        entityManager.merge(entity);
    }

    public void delete(int id) {
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);
    }

    @Override
    public List<Product> getProductsByIdCategory(int categoryId) {
        Query query = (Query) entityManager.createQuery("select i from Product i where i.category.id=:categoryId");
        query.setParameter("categoryId", categoryId);
        return query.getResultList();
    }

    @Override
    public Product getProductById(int productId) {
        return entityManager.find(Product.class, productId);
    }

    @Override
    public List<Product> findProductsByRequest(String request, int page) {
        request = "%" + request + "%";
        Query query = (Query) entityManager.createQuery("select i from Product i where i.name like :request or i.description like: request");
        query.setParameter("request", request);
        int pageSize = 1;
        int firstResult;
        if (page > 1) {
            firstResult = (page - 1) * pageSize;
        } else {
            firstResult = 0;
        }
        query.setFirstResult(firstResult);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    public int countAllProductsByRequest(String request) {
        int pageSize = 1;
        request = "%" + request + "%";
        Query query = (Query) entityManager.createQuery("select i from Product i where i.name like :request or i.description like: request");
        query.setParameter("request", request);
        int resultQuery = query.list().size();
        if (resultQuery % pageSize != 0) {
            return resultQuery / pageSize + 1;
        }
        return resultQuery / pageSize;
    }
}
