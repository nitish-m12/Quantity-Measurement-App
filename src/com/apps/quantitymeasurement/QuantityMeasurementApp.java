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