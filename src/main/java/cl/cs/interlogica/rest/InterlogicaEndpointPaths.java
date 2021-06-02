package cl.cs.interlogica.rest;

public interface InterlogicaEndpointPaths {
    String ROOT = "rest/interlogica";
    interface Product {
       String PRODUCTS = InterlogicaEndpointPaths.ROOT + "/products";
    }
    interface Ingredient {
        String INGREDIENTS = InterlogicaEndpointPaths.ROOT + "/ingredients";
    }
}
