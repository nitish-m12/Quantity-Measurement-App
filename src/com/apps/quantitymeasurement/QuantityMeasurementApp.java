package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // Generic method
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }
    // UC6 addition implemented
    public static void demonstrateFeetEquality() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);

        System.out.println("Feet equal: " + l1.equals(l2));
    }

    public static void demonstrateInchesEquality() {
        Length l1 = new Length(10.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(10.0, Length.LengthUnit.INCHES);

        System.out.println("Inches equal: " + l1.equals(l2));
    }

    public static void demonstrateFeetInchesComparison() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        System.out.println("Feet vs Inches equal: " + l1.equals(l2));
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
=======
/**
 * Main class to demonstrate conversion and equality
 */

/**
 * Demonstrates conversion using raw values
 */
public static void demonstrateLengthConversion(double value,
                                               LengthUnit from,
                                               LengthUnit to) {

    double result = QuantityLength.convert(value, from, to);
    IO.println(value + " " + from + " = " + result + " " + to);
}

/**
 * Overloaded method (method overloading)
 */
public static void demonstrateLengthConversion(QuantityLength length,
                                               LengthUnit to) {

    QuantityLength converted = length.convertTo(to);
    IO.println(length + " = " + converted);
}

/**
 * Demonstrates equality check
 */
public static void demonstrateLengthEquality(QuantityLength l1,
                                             QuantityLength l2) {

    IO.println("Are equal? " + l1.equals(l2));
}

/**
 * Main method (for quick testing)
 */
void main() {

    demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES);
    demonstrateLengthConversion(3.0, LengthUnit.YARDS, LengthUnit.FEET);

    QuantityLength l1 = new QuantityLength(12, LengthUnit.INCHES);
    QuantityLength l2 = new QuantityLength(1, LengthUnit.FEET);

    demonstrateLengthEquality(l1, l2);
}