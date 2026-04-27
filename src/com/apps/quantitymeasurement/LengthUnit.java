/**
 * Enum representing different length units.
 * Each unit has a conversion factor relative to base unit (FEET).
 */
public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),       // 1 inch = 1/12 feet
    YARDS(3.0),               // 1 yard = 3 feet
    CENTIMETERS(1.0 / 30.48); // 1 cm = 1/30.48 feet

    private final double conversionFactor;

    /**
     * Constructor to assign conversion factor.
     * @param conversionFactor factor relative to FEET
     */
    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    /**
     * Getter for conversion factor
     * @return conversion factor
     */
    public double getConversionFactor() {
        return conversionFactor;
    }
}