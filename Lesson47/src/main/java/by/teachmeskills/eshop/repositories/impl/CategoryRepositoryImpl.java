package by.teachmeskills.eshop.repositories.impl;

import by.teachmeskills.eshop.entities.Category;
import by.teachmeskills.eshop.repositories.CategoryRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Category> read() {
        return entityManager.createQuery("select c from Category c").getResultList();
    }

    public void create(Category entity) {
        entityManager.persist(entity);
    }

    public void update(Category entity) {
        entityManager.merge(entity);
    }

    public void delete(int id) {
        Category category = entityManager.find(Category.class, id);
        entityManager.remove(category);
    }
}
