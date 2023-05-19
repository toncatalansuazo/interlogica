package cl.cs.interlogica.repositories.product;

import cl.cs.interlogica.dto.ProductDto;
import cl.cs.interlogica.entities.ProductEntity;
import java.time.Instant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

  List<ProductEntity> findByCreatedAtGreaterThan(Instant date);

  List<ProductEntity> findIsNotExpired();
}
