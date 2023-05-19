package cl.cs.interlogica.services.product;

import cl.cs.interlogica.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto find(Integer id);
    List<ProductDto> findAll();
    ProductDto save(ProductDto product);
    void deleteById(Integer id);
    ProductDto update(ProductDto product);
    List<ProductDto> findActiveProducts();

    ProductDto getById(Integer id);
}
