package cl.cs.interlogica.services.product;

import cl.cs.interlogica.entities.Product;

import java.util.List;

public interface ProductService {
    Product find(Integer id);
    List<Product> findAll();
    Product save(Product product);
    void delete(Integer id);
    Product update(Product product);
    List<Product> findActiveProducts();
}
