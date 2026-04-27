/**
 * Enum representing supported length units.
 * Each unit stores a conversion factor relative to base unit (FEET).
 */
public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(1.0 / 30.48);

    private final double toFeetFactor;

    LengthUnit(double toFeetFactor) {
        this.toFeetFactor = toFeetFactor;
    }

    /**
     * Converts a value from this unit to feet (base unit)
     */
    public double toFeet(double value) {
        return value * toFeetFactor;
    }

    /**
     * Converts a value from feet (base unit) to this unit
     */
    public double fromFeet(double feetValue) {
        return feetValue / toFeetFactor;
    }
}