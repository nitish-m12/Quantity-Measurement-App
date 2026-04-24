package com.apps.quantitymeasurement;

public class Length {

    // Instance variables
    private double value;
    private LengthUnit unit;

    // Enum for units (base = inches)
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // Constructor
    public Length(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    // Convert to base unit (inches)
    private double toBaseUnit() {
        return this.value * this.unit.getConversionFactor();
    }

    // Compare method
    public boolean compare(Length other) {
        if (other == null) return false;
        return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
    }

    // equals override (VERY IMPORTANT)
    @Override
    public boolean equals(Object o) {

        // same reference
        if (this == o) return true;

        // null or different class
        if (o == null || getClass() != o.getClass()) return false;

        Length that = (Length) o;

        return this.compare(that);
    }
}