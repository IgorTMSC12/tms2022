package by.teachmeskills.eshop.repositories.impl;

import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.repositories.UserRepository;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(User entity) {
        entityManager.persist(entity);
    }

    public List<User> read() {
        return entityManager.createQuery("select u from User u").getResultList();
    }

    public void update(User entity) {
        entityManager.merge(entity);
    }

    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User getUserByLoginAndPass(String email, String password) {
        Query query = (Query) entityManager.createQuery("select i from User i where i.email=:email and i.password=:password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        return (User) query.getSingleResult();
    }

    public boolean checkUserFromBase(User user) {
        List<User> users = read();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(user.getEmail())) {
                return true;
            }
        }
        return false;
    }
}
