/**
 * Value Object class representing a length quantity.
 * Immutable class (value + unit cannot change).
 */
public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    /**
     * Constructor
     * @param value numeric value
     * @param unit length unit
     */
    public QuantityLength(double value, LengthUnit unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    /**
     * Convert this object to another unit
     * @param targetUnit unit to convert to
     * @return new QuantityLength object
     */
    public QuantityLength convertTo(LengthUnit targetUnit) {
        double convertedValue = convert(this.value, this.unit, targetUnit);
        return new QuantityLength(convertedValue, targetUnit);
    }

    /**
     * Static API method for conversion
     */
    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        // Convert to base unit (feet)
        double valueInFeet = value * source.getConversionFactor();

        // Convert to target unit
        return valueInFeet / target.getConversionFactor();
    }

    /**
     * Private helper to convert to base unit
     */
    private double toBaseUnit() {
        return value * unit.getConversionFactor();
    }

    /**
     * Override equals method (value-based equality)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof QuantityLength)) return false;

        QuantityLength other = (QuantityLength) obj;

        double epsilon = 1e-6;
        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < epsilon;
    }

    /**
     * Override toString method
     */
    @Override
    public String toString() {
        return value + " " + unit;
    }
}