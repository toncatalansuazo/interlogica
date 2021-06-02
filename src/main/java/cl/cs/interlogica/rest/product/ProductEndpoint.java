package cl.cs.interlogica.rest.product;

import cl.cs.interlogica.entities.Product;
import cl.cs.interlogica.rest.InterlogicaEndpointPaths;
import cl.cs.interlogica.services.product.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductEndpoint {
    private ProductService productService;

    public ProductEndpoint(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET, value = InterlogicaEndpointPaths.Product.PRODUCTS)
    private List<Product> getProducts() {
        return this.productService.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT, value = InterlogicaEndpointPaths.Product.PRODUCTS)
    private Product updateProduct(@RequestParam(required= true) Product product) {
        return this.productService.update(product);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = InterlogicaEndpointPaths.Product.PRODUCTS)
    private void deleteProduct(Integer id) {
        this.productService.delete(id);
    }
}
