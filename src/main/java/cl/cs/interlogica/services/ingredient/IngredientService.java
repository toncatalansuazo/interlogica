package cl.cs.interlogica.services.ingredient;

import cl.cs.interlogica.dto.IngredientDto;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface IngredientService {

    public Optional<IngredientDto> find(Integer id);

    public List<IngredientDto> findAll(Pageable pageable);

    public IngredientDto save(IngredientDto product);

    public void delete(Integer id);

    public IngredientDto update(IngredientDto ingredient);
}
