package by.teachmeskills.eshop.repositories;

import by.teachmeskills.eshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User getUserByEmailAndPassword(String email, String password);

    User getByEmail(String email);

    Optional<User> findByEmail(String Email);
}
