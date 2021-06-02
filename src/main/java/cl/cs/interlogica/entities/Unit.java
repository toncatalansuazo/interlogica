package cl.cs.interlogica.entities;

public enum Unit {
    GRAMS("GRAMS"),
    KILOGRAMS("KILOGRAMS"),
    LITERS("LITERS");

    Unit(final String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return unit;
    }

    private final String unit;
}
