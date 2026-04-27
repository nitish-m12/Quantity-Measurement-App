package com.apps.quantitymeasurement;

/**
 * QuantityMeasurementApp (UC4 - Extended Unit Support)
 *
 * This class demonstrates comparison of length measurements
 * across multiple units: FEET, INCHES, YARDS, and CENTIMETERS.
 *
 * All comparisons are done using the Length class, which converts
 * values into a base unit (inches) before comparison.
 *
 * This demonstrates scalability: adding new units requires only enum changes.
 */
public class QuantityMeasurementApp {

    /**
     * Compares two Length objects for equality
     *
     * @param length1 First length object
     * @param length2 Second length object
     * @return true if equal, false otherwise
     */
    static boolean compareLengths(Length length1, Length length2) {
        return length1.equals(length2);
    }

    /**
     * Helper method to create Length objects and compare them
     *
     * @param value1 First value
     * @param unit1  First unit
     * @param value2 Second value
     * @param unit2  Second unit
     * @return result of comparison
     */
    static boolean demonstrateLengthComparison(
            double value1, Length.LengthUnit unit1,
            double value2, Length.LengthUnit unit2) {

        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);

        boolean result = l1.equals(l2);

        System.out.println("Comparing: " + value1 + " " + unit1 +
                " and " + value2 + " " + unit2 +
                " => " + result);

        return result;
    }

    /**
     * Main method to demonstrate UC4 functionality
     */
    public static void main(String[] args) {

        // Feet and Inches
        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET,
                12.0, Length.LengthUnit.INCHES);

        // Yards and Inches
        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,
                36.0, Length.LengthUnit.INCHES);

        // Centimeters and Inches
        demonstrateLengthComparison(100.0, Length.LengthUnit.CENTIMETERS,
                39.3701, Length.LengthUnit.INCHES);

        // Feet and Yards
        demonstrateLengthComparison(3.0, Length.LengthUnit.FEET,
                1.0, Length.LengthUnit.YARDS);

        // Centimeters and Feet
        demonstrateLengthComparison(30.48, Length.LengthUnit.CENTIMETERS,
                1.0, Length.LengthUnit.FEET);
    }
}