package cl.cs.interlogica.repositories.ingredient;

import cl.cs.interlogica.entities.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<IngredientEntity, Integer> {
}
