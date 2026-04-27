import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for UC7: Addition with Target Unit
 */
public class QuantityMeasurementTest {

    private static final double EPSILON = 0.001;

    @Test
    void testAddition_TargetFeet() {
        QuantityLength result = QuantityLength.add(
                new QuantityLength(1.0, LengthUnit.FEET),
                new QuantityLength(12.0, LengthUnit.INCHES),
                LengthUnit.FEET
        );

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_TargetInches() {
        QuantityLength result = QuantityLength.add(
                new QuantityLength(1.0, LengthUnit.FEET),
                new QuantityLength(12.0, LengthUnit.INCHES),
                LengthUnit.INCHES
        );

        assertEquals(24.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_TargetYards() {
        QuantityLength result = QuantityLength.add(
                new QuantityLength(1.0, LengthUnit.FEET),
                new QuantityLength(12.0, LengthUnit.INCHES),
                LengthUnit.YARDS
        );

        assertEquals(0.667, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_TargetCentimeters() {
        QuantityLength result = QuantityLength.add(
                new QuantityLength(1.0, LengthUnit.INCHES),
                new QuantityLength(1.0, LengthUnit.INCHES),
                LengthUnit.CENTIMETERS
        );

        assertEquals(5.08, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_Commutativity() {
        QuantityLength result1 = QuantityLength.add(
                new QuantityLength(1.0, LengthUnit.FEET),
                new QuantityLength(12.0, LengthUnit.INCHES),
                LengthUnit.YARDS
        );

        QuantityLength result2 = QuantityLength.add(
                new QuantityLength(12.0, LengthUnit.INCHES),
                new QuantityLength(1.0, LengthUnit.FEET),
                LengthUnit.YARDS
        );

        assertEquals(result1.getValue(), result2.getValue(), EPSILON);
    }

    @Test
    void testAddition_WithZero() {
        QuantityLength result = QuantityLength.add(
                new QuantityLength(5.0, LengthUnit.FEET),
                new QuantityLength(0.0, LengthUnit.INCHES),
                LengthUnit.YARDS
        );

        assertEquals(1.667, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_NegativeValues() {
        QuantityLength result = QuantityLength.add(
                new QuantityLength(5.0, LengthUnit.FEET),
                new QuantityLength(-2.0, LengthUnit.FEET),
                LengthUnit.INCHES
        );

        assertEquals(36.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_NullTargetUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.add(
                    new QuantityLength(1.0, LengthUnit.FEET),
                    new QuantityLength(12.0, LengthUnit.INCHES),
                    null
            );
        });
    }

    @Test
    void testAddition_LargeToSmallScale() {
        QuantityLength result = QuantityLength.add(
                new QuantityLength(1000.0, LengthUnit.FEET),
                new QuantityLength(500.0, LengthUnit.FEET),
                LengthUnit.INCHES
        );

        assertEquals(18000.0, result.getValue(), EPSILON);
    }
}