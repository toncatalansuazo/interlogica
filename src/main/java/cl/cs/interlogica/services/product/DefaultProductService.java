package cl.cs.interlogica.services.product;

import cl.cs.interlogica.entities.Ingredient;
import cl.cs.interlogica.entities.Product;
import cl.cs.interlogica.repositories.product.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class DefaultProductService implements ProductService {
    private ProductRepository productRepository;
    public DefaultProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product find(Integer id) {
        return productRepository.getOne(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        this.refreshIngredientStock(product.getIngredients());
        return productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent()) {
            // todo wrap in Error object using app  error code
            throw new Error("Product not found");
        }
        productRepository.delete(product.get());
    }

    @Override
    public Product update(Product product) {
        Optional<Product> prod = productRepository.findById(product.getId());
        if (!prod.isPresent()) {
            // todo wrap in Error object using app  error code
            throw new Error("Product not found");
        }
        return productRepository.save(prod.get());
    }

    @Override
    public List<Product> findActiveProducts() {
        return null;
    }

    private void refreshIngredientStock(Set<Ingredient> ingredients) {
        // refresh stock
    }
}
