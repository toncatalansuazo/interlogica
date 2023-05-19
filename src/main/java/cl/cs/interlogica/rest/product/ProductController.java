package cl.cs.interlogica.rest.product;

import cl.cs.interlogica.dto.ProductDto;
import cl.cs.interlogica.entities.ProductEntity;
import cl.cs.interlogica.rest.InterlogicaEndpointPaths;
import cl.cs.interlogica.services.product.ProductService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController(InterlogicaEndpointPaths.Product.PRODUCTS)
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping
    private ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> prods =  productService.findAll();
        return ResponseEntity.ok(prods);
    }

    @GetMapping("/{id}")
    private ResponseEntity<ProductDto> getProducts(Integer id) {
        ProductDto prod = productService.getById(id);
        return ResponseEntity.ok(prod);
    }

    @PutMapping
    private ResponseEntity<ProductDto> updateProduct(@Valid @RequestBody ProductDto product) {
        ProductDto prod = productService.update(product);
        return ResponseEntity.ok(prod);
    }

    @PostMapping
    private ResponseEntity<ProductDto> saveProduct(@Valid @RequestBody ProductDto product) {
        ProductDto prod = productService.save(product);
        return ResponseEntity.ok(prod);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
