package by.teachmeskills.eshop.repositories;

import by.teachmeskills.eshop.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

    List<Product> getProductsByCategoryId(int categoryId);

    Product getProductById(int idProduct);

    @Query("select i from Product i where i.name like :request or i.description like: request")
    Page<Product> findProductsByRequest(String request, Pageable pageable);


}
