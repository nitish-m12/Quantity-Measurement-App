/**
 * Enum representing weight units and their conversion logic.
 * Base unit: Kilogram
 */
public enum WeightUnit {

    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double factor;

    /**
     * Constructor to assign conversion factor relative to kilogram
     */
    WeightUnit(double factor) {
        this.factor = factor;
    }

    /**
     * Returns conversion factor
     */
    public double getConversionFactor() {
        return factor;
    }

    /**
     * Convert given value to base unit (kilogram)
     */
    public double toBase(double value) {
        return value * factor;
    }

    /**
     * Convert from base unit (kilogram) to this unit
     */
    public double fromBase(double baseValue) {
        return baseValue / factor;
    }
}