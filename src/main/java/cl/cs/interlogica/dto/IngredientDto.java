package cl.cs.interlogica.dto;

import cl.cs.interlogica.entities.IngredientEntity;
import java.util.Set;
import lombok.Getter;

@Getter
public class IngredientDto {

  private final Set<IngredientEntity> ingredients;
  private final Integer id;
  private final String name;

  public IngredientDto(Integer id, String name, Set<IngredientEntity> ingredients) {
    this.id = id;
    this.name = name;
    this.ingredients = ingredients;
  }

  public IngredientEntity toEntity() {
    return new IngredientEntity(id, name, ingredients);
  }
}
