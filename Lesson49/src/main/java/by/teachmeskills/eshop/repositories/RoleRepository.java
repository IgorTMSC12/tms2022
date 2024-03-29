package by.teachmeskills.eshop.repositories;

import by.teachmeskills.eshop.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role getRoleByName(String name);
}
