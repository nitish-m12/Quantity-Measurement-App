/**
 * Represents a length quantity with value and unit.
 * Immutable class.
 */
public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    /**
     * Constructor with validation
     */
    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value or unit");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    /**
     * UC7: Adds two quantities and returns result in target unit
     *
     * Steps:
     * 1. Validate inputs
     * 2. Convert both to base unit (feet)
     * 3. Add
     * 4. Convert to target unit
     * 5. Return new object
     */
    public static QuantityLength add(QuantityLength q1, QuantityLength q2, LengthUnit targetUnit) {

        if (q1 == null || q2 == null || targetUnit == null) {
            throw new IllegalArgumentException("Null input not allowed");
        }

        if (!Double.isFinite(q1.value) || !Double.isFinite(q2.value)) {
            throw new IllegalArgumentException("Invalid numeric values");
        }

        // Convert to base unit (feet)
        double feet1 = q1.unit.toFeet(q1.value);
        double feet2 = q2.unit.toFeet(q2.value);

        // Add
        double sumFeet = feet1 + feet2;

        // Convert to target unit
        double result = targetUnit.fromFeet(sumFeet);

        return new QuantityLength(result, targetUnit);
    }
}