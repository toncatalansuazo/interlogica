package cl.cs.interlogica.rest;

import cl.cs.interlogica.repositories.ingredient.IngredientRepository;
import cl.cs.interlogica.repositories.product.ProductRepository;
import cl.cs.interlogica.services.ingredient.DefaultIngredientService;
import cl.cs.interlogica.services.ingredient.IngredientService;
import cl.cs.interlogica.services.product.DefaultProductService;
import cl.cs.interlogica.services.product.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class InterlogicaServiceConfiguration {

    @Bean
    @Primary
    public ProductService initDefaultProductService(ProductRepository productRepository) {
        return new DefaultProductService(productRepository);
    }

    @Bean
    @Primary
    public IngredientService initDefaultHelloController(IngredientRepository ingredientRepository) {
        return new DefaultIngredientService(ingredientRepository);
    }
}
