package cl.cs.interlogica.entities;

import cl.cs.interlogica.dto.ProductDto;
import java.time.Duration;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    @Type(type= "text")
    private String img;

    @NotNull
    private Double price;

    private boolean expired;

    @CreatedDate
    @Column(name = "created_at")
    private Instant createdAt;

    @CreatedDate
    @Column(name = "expirationDate")
    private Instant expirationDate;

    @NotNull
    private Integer stock;

    private Double salePrice;

    @ManyToMany(fetch = FetchType.LAZY, cascade ={ CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinTable(
            name = "product_ingredient",
            joinColumns= @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<IngredientEntity> ingredients = new HashSet<>();

    public ProductEntity(String name, String img, Double price, boolean expired, Instant createdAt,
        Instant expirationDate, Integer stock, Double salePrice,
        Set<IngredientEntity> ingredients) {
        this.name = name;
        this.img = img;
        this.price = price;
        this.expired = expired;
        this.createdAt = createdAt;
        this.expirationDate = expirationDate;
        this.stock = stock;
        this.salePrice = salePrice;
        this.ingredients = ingredients;
    }

    public ProductDto toDomain() {
        return new ProductDto(id, name, img, price, createdAt, stock, expired, salePrice, expirationDate, ingredients);
    }

    private boolean isExpired(Instant date) {
        return getExpiredDays(date) < 2;
    }

    public long getExpiredDays(Instant date) {
        return Duration.between(date, expirationDate).toDays();
    }
}
