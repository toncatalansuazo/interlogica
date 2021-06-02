package cl.cs.interlogica.services.ingredient;

import cl.cs.interlogica.entities.Ingredient;
import cl.cs.interlogica.repositories.ingredient.IngredientRepository;

import java.util.List;

public interface IngredientService {

    public Ingredient find(Integer id);

    public List<Ingredient> findAll();

    public Ingredient save(Ingredient product);

    public void delete(Integer id);

    public Ingredient update(Ingredient product);
}
