package cl.cs.interlogica.dto;

import cl.cs.interlogica.entities.IngredientEntity;
import cl.cs.interlogica.entities.ProductEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Setter
@Getter
public class ProductDto {
  private Integer id;

  @NotNull
  private String name;

  @NotNull
  @Type(type= "text")
  private String img;

  @NotNull
  private Double price;


  @NotNull
  @JsonProperty("created_at")
  private Instant createdAt;

  @NotNull
  @JsonProperty("expiration_date")
  private Instant expirationDate;

  @NotNull
  private Integer stock;

  @NotNull
  private boolean expired;

  @JsonProperty("sale_price")
  private Double salePrice;

  private Set<IngredientEntity> ingredients;

  public ProductDto(Integer id, String name, String img, Double price, Instant createdAt, Integer stock, boolean expired, Double salePrice, Instant expirationDate, Set<IngredientEntity> ingredients) {
    this.id = id;
    this.name = name;
    this.img = img;
    this.price = price;
    this.createdAt = createdAt;
    this.stock = stock;
    this.expired = expired;
    this.salePrice = salePrice;
    this.expirationDate = expirationDate;
    this.ingredients = ingredients;
  }

  public ProductEntity toEntity() {
    return new ProductEntity(name, img, price, expired, createdAt, expirationDate, stock, salePrice, ingredients);
  }
}
