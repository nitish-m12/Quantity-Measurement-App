/**
 * LengthUnit enum is now a standalone class.
 * It is responsible ONLY for unit conversions.
 * Base unit = FEET
 */
public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(1.0 / 30.48);

    private final double conversionFactor;

    /**
     * Constructor to assign conversion factor
     * @param conversionFactor factor relative to base unit (feet)
     */
    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    /**
     * Convert given value to base unit (feet)
     */
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    /**
     * Convert base unit (feet) to this unit
     */
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }

    /**
     * Getter for testing purposes
     */
    public double getConversionFactor() {
        return conversionFactor;
    }
}