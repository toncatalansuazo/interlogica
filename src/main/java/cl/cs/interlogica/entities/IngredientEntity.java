package cl.cs.interlogica.entities;

import cl.cs.interlogica.dto.IngredientDto;
import cl.cs.interlogica.rest.InterlogicaEndpointPaths.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ingredients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @NotNull
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade ={ CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinTable(
            name = "product_ingredient",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns= @JoinColumn(name = "product_id")
    )
    private Set<IngredientEntity> ingredients = new HashSet<>();

    public IngredientDto toDomain() {
        return new IngredientDto(id, name, ingredients);
    }
}
