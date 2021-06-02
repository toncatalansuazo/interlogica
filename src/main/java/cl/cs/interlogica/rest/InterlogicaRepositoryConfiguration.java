package cl.cs.interlogica.rest;

import cl.cs.interlogica.repositories.product.ProductRepository;
import cl.cs.interlogica.services.product.DefaultProductService;
import cl.cs.interlogica.services.product.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//@Configuration
//public class InterlogicaRepositoryConfiguration {
//
//    @Bean
//    @Primary
//    public ProductService initDefaultHelloController(ProductRepository productRepository) {
//        return new DefaultProductService(productRepository);
//    }
//}
