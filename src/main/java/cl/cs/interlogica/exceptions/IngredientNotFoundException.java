package cl.cs.interlogica.exceptions;

public class IngredientNotFoundException extends RuntimeException {

  public IngredientNotFoundException(String message) {
    super(message);
  }
}
