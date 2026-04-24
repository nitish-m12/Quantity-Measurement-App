package com.apps.quantitymeasurement;

/**
 * QuantityMeasurementApp – UC2: Feet and Inches Measurement Equality
 *
 * This class extends UC1 by supporting equality comparison for both
 * Feet and Inches measurements separately.
 *
 * NOTE:
 * - Feet and Inches are NOT compared with each other.
 * - Each unit is handled independently.
 *
 * Concepts Covered:
 * - Object Equality
 * - Floating-point comparison
 * - Null safety
 * - Type checking
 * - Encapsulation
 */
public class QuantityMeasurementApp {

    /**
     * Inner class to represent Feet measurement
     */
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            // Same reference
            if (this == obj) return true;

            // Null or different class
            if (obj == null || this.getClass() != obj.getClass()) return false;

            Feet other = (Feet) obj;

            // Compare values
            return Double.compare(this.value, other.value) == 0;
        }
    }

    /**
     * Inner class to represent Inches measurement
     */
    public static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            // Same reference
            if (this == obj) return true;

            // Null or different class
            if (obj == null || this.getClass() != obj.getClass()) return false;

            Inches other = (Inches) obj;

            // Compare values
            return Double.compare(this.value, other.value) == 0;
        }
    }

    /**
     * Demonstrates Feet equality comparison
     */
    public static void demonstrateFeetEquality() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        System.out.println("Feet Comparison: " + f1.equals(f2));
    }

    /**
     * Demonstrates Inches equality comparison
     */
    public static void demonstrateInchesEquality() {
        Inches i1 = new Inches(1.0);
        Inches i2 = new Inches(1.0);

        System.out.println("Inches Comparison: " + i1.equals(i2));
    }

    /**
     * Main method
     * Calls both Feet and Inches equality checks
     */
    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
    }
}