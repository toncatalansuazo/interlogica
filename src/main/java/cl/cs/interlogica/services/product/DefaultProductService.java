package cl.cs.interlogica.services.product;

import cl.cs.interlogica.dto.ProductDto;
import cl.cs.interlogica.entities.IngredientEntity;
import cl.cs.interlogica.entities.ProductEntity;
import cl.cs.interlogica.exceptions.ProductNotFoundException;
import cl.cs.interlogica.repositories.product.ProductRepository;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ClockProvider;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultProductService implements ProductService {
    private static final String PRODUCT_NOT_FOUND = "Product not found. id = %s";
    private final ProductRepository productRepository;
    private final ClockProvider clockProvider;

    @Override
    public ProductDto find(Integer id) {
        return productRepository.getOne(id).toDomain();
    }

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
            .map(this::checkExpirationDate)
            .map(ProductEntity::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public ProductDto save(ProductDto product) {
        this.refreshIngredientStock(product.getIngredients());
        return productRepository.save(product.toEntity())
            .toDomain();
    }

    @Override
    public void deleteById(Integer id) {
        ProductEntity product = productRepository.findById(id)
            .orElseThrow(() -> createProductNotFound(id));
        productRepository.delete(product);
    }

    @Override
    public ProductDto update(ProductDto product) {
        ProductEntity prod = productRepository.findById(product.getId())
            .orElseThrow(() -> createProductNotFound(product.getId()));
        // update fields
        return productRepository.save(prod).toDomain();
    }

    @Override
    public List<ProductDto> findActiveProducts() {
        return productRepository.findIsNotExpired().stream()
            .map(ProductEntity::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public ProductDto getById(Integer id) {
        return productRepository.findById(id)
            .orElseThrow(() -> createProductNotFound(id))
            .toDomain();
    }

    private void refreshIngredientStock(Set<IngredientEntity> ingredients) {
        // refresh stock
    }

    private ProductNotFoundException createProductNotFound(Integer id) {
        return new ProductNotFoundException(String.format(PRODUCT_NOT_FOUND, id));
    }

    private ProductEntity checkExpirationDate(ProductEntity product) {
        if (product.isExpired()) {
            return product;
        }
        Instant now = clockProvider.getClock().instant();
        long daysToExpire = product.getExpiredDays(now);
        Double salePrice = null;
        boolean isExpired = daysToExpire < 0;
        if (isExpired) {
            product.setExpired(true);
        } else if (daysToExpire == 1) {
            salePrice = (product.getPrice() * 0.8);
        } else if (daysToExpire == 2) {
            salePrice = (product.getPrice() * 0.2);
        }
        product.setSalePrice(salePrice);
        product.setExpired(isExpired);
        return productRepository.save(product);
    }
}
