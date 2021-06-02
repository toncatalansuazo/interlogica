package cl.cs.interlogica.repositories.ingredient;

import cl.cs.interlogica.entities.Ingredient;
import cl.cs.interlogica.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}
