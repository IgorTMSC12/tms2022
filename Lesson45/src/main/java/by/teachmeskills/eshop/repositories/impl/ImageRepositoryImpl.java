package by.teachmeskills.eshop.repositories.impl;

import by.teachmeskills.eshop.entities.Image;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.repositories.ImageRepository;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ImageRepositoryImpl implements ImageRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Image entity) {
        entityManager.persist(entity);
    }

    public List<Image> read() {
        return entityManager.createQuery("select i from Image i").getResultList();
    }

    public void update(Image entity) {
        entityManager.merge(entity);
    }

    public void delete(int id) {
        Image image = entityManager.find(Image.class, id);
        entityManager.remove(image);
    }

    @Override
    public List<Image> getAllImagesCategories() {
        Query query = (Query) entityManager.createQuery("select i from Image i where i.product.id is null");
        return query.getResultList();
    }

    @Override
    public List<Image> getImagesProductsByCategory(int categoryId) {
        Query query = (Query) entityManager.createQuery("select i from Image i where i.category.id=:categoryId");
        query.setParameter("categoryId", categoryId);
        return query.getResultList();
    }

    @Override
    public Image getImageByIdProduct(int productId) {
        Query query = (Query) entityManager.createQuery("select i from Image i where i.product.id=:productId");
        query.setParameter("productId", productId);
        return (Image) query.getSingleResult();
    }

    @Override
    public List<Image> getImagesByListProducts(List<Product> products) {
        List<Image> images = new ArrayList<>();
        for (Product product : products) {
            Query query = (Query) entityManager.createQuery("select distinct i from Image i where i.product.id=:productId");
            query.setParameter("productId", product.getId());
            Image image = (Image) query.uniqueResult();
            images.add(image);
        }
        return images;
    }
}
