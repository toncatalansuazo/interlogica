package cl.cs.interlogica.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product_ingredient")
@Getter
@Setter
@NoArgsConstructor
public class ProductIngredient {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name="ingredient_id")
    private Product ingredient;

    @NotNull
    private Unit unit;

    @NotNull
    private float quantity;
}
