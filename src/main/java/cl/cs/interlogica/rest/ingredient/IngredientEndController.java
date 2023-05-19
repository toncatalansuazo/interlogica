package cl.cs.interlogica.rest.ingredient;

import cl.cs.interlogica.dto.IngredientDto;
import cl.cs.interlogica.entities.IngredientEntity;
import cl.cs.interlogica.rest.InterlogicaEndpointPaths;
import cl.cs.interlogica.services.ingredient.IngredientService;
import java.awt.print.Pageable;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(InterlogicaEndpointPaths.Ingredient.INGREDIENTS)
@RequiredArgsConstructor
public class IngredientEndController {
    private final IngredientService ingredientService;

    @GetMapping
    private List<IngredientDto> getIngredients(Pageable pageable) {
        return ingredientService.findAll(pageable);
    }

    @PutMapping
    private IngredientDto updateIngredient(@Valid @RequestBody IngredientDto ingredient) {
        return ingredientService.update(ingredient);
    }

    @PostMapping
    private IngredientDto saveIngredient(@Valid @RequestBody IngredientDto ingredient) {
        return ingredientService.save(ingredient);
    }

    @DeleteMapping
    private void deleteIngredient(Integer id) {
        ingredientService.delete(id);
    }
}
