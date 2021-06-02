package cl.cs.interlogica.repositories.product;

import cl.cs.interlogica.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT * FROM products p WHERE p.created_at >= DATE_ADD(CURDATE(), INTERVAL -3 DAY)")
    List<Product> findAllActiveProducts();
}
