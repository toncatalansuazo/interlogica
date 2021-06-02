package cl.cs.interlogica.services.ingredient;

import cl.cs.interlogica.entities.Ingredient;
import cl.cs.interlogica.repositories.ingredient.IngredientRepository;
import java.util.List;
import java.util.Optional;

public class DefaultIngredientService implements IngredientService {
    private IngredientRepository ingredientRepository;

    public DefaultIngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient find(Integer id) {
        return ingredientRepository.getOne(id);
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient save(Ingredient product) {
        return ingredientRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        Optional<Ingredient> product = ingredientRepository.findById(id);
        if (!product.isPresent()) {
            // todo wrap in Error object using app  error code
            throw new Error("Ingredient not found");
        }
        ingredientRepository.delete(product.get());
    }

    @Override
    public Ingredient update(Ingredient product) {
        Optional<Ingredient> prod = ingredientRepository.findById(product.getId());
        if (!prod.isPresent()) {
            // todo wrap in Error object using app  error code
            throw new Error("Ingredient not found");
        }
        return ingredientRepository.save(prod.get());
    }
}
