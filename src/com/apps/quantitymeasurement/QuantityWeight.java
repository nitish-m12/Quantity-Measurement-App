/**
 * Represents a weight quantity with value and unit.
 * Supports equality, conversion, and addition.
 */
public class QuantityWeight {

    private final double value;
    private final WeightUnit unit;
    private static final double EPSILON = 1e-6;

    /**
     * Constructor with validation
     */
    public QuantityWeight(double value, WeightUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        this.value = value;
        this.unit = unit;
    }

    /**
     * Convert to another unit
     */
    public QuantityWeight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double baseValue = unit.toBase(value);
        double converted = targetUnit.fromBase(baseValue);

        return new QuantityWeight(converted, targetUnit);
    }

    /**
     * Add two weights (result in first unit)
     */
    public QuantityWeight add(QuantityWeight other) {
        return add(other, this.unit);
    }

    /**
     * Add with explicit target unit
     */
    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {
        double sumBase = this.unit.toBase(this.value) +
                other.unit.toBase(other.value);

        double result = targetUnit.fromBase(sumBase);

        return new QuantityWeight(result, targetUnit);
    }

    /**
     * Equality check using base unit (kg)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityWeight other = (QuantityWeight) obj;

        double thisBase = this.unit.toBase(this.value);
        double otherBase = other.unit.toBase(other.value);

        return Math.abs(thisBase - otherBase) < EPSILON;
    }

    /**
     * HashCode based on base value
     */
    @Override
    public int hashCode() {
        double base = unit.toBase(value);
        return Double.hashCode(base);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}