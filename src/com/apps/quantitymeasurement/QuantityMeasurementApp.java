package com.apps.quantitymeasurement;

/**
 * QuantityMeasurementApp - UC1: Feet Measurement Equality
 *
 * This application checks equality between two measurements in feet.
 * It demonstrates object equality, null safety, and proper comparison of double values.
 */
public class QuantityMeasurementApp {

    /**
     * Inner class representing a measurement in feet.
     * This class is immutable.
     */
    public static class Feet {

        /**
         * Stores the value in feet
         */
        private final double value;

        /**
         * Constructor to initialize feet value
         *
         * @param value measurement in feet
         */
        public Feet(double value) {
            this.value = value;
        }

        /**
         * Overrides equals() to compare two Feet objects
         *
         * Equality Rules:
         * 1. Same reference → true
         * 2. Null → false
         * 3. Different class → false
         * 4. Same value → true
         *
         * @param obj object to compare
         * @return true if equal, else false
         */
        @Override
        public boolean equals(Object obj) {

            // 1. Reference check
            if (this == obj) return true;

            // 2. Null check
            if (obj == null) return false;

            // 3. Type check
            if (this.getClass() != obj.getClass()) return false;

            // 4. Cast to Feet
            Feet other = (Feet) obj;

            // 5. Compare values safely
            return Double.compare(this.value, other.value) == 0;
        }
    }

    /**
     * Main method to demonstrate equality check
     */
    public static void main(String[] args) {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        System.out.println("Comparing 1.0 ft and 1.0 ft:");
        System.out.println("Are equal? " + f1.equals(f2));
    }
}