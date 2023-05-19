package cl.cs.interlogica.services.ingredient;

import cl.cs.interlogica.dto.IngredientDto;
import cl.cs.interlogica.entities.IngredientEntity;
import cl.cs.interlogica.entities.ProductEntity;
import cl.cs.interlogica.exceptions.IngredientNotFoundException;
import cl.cs.interlogica.repositories.ingredient.IngredientRepository;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultIngredientService implements IngredientService {
    private final IngredientRepository ingredientRepository;

    @Override
    public Optional<IngredientDto> find(Integer id) {
        return ingredientRepository.findById(id).map(IngredientEntity::toDomain);
    }

    @Override
    public List<IngredientDto> findAll(Pageable pageable) {
        return ingredientRepository.findAll().stream()
            .map(IngredientEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public IngredientDto save(IngredientDto ingredientDto) {
        return ingredientRepository.save(ingredientDto.toEntity())
            .toDomain();
    }

    @Override
    public void delete(Integer id) {
        IngredientEntity product = ingredientRepository.findById(id)
            .orElseThrow(() -> new IngredientNotFoundException("Ingredient not found"));
        ingredientRepository.delete(product);
    }

    @Override
    public IngredientDto update(IngredientDto ingredient) {
        IngredientEntity prod = ingredientRepository.findById(ingredient.getId())
            .orElseThrow(() -> new IngredientNotFoundException("Ingredient not found"));
        return ingredientRepository.save(prod).toDomain();
    }
}
