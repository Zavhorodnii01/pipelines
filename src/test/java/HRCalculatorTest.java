import org.junit.jupiter.api.Test;
import se2526.HRCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HRCalculatorTest {
    @Test
    public void testValidMaxHR(){
        var result = HRCalculator.calculateMaxHR(25);
        assertEquals(195, result);
    }

    @Test
    public void testInvalidMinHR_ageTooHigh() {
        assertThrows(IllegalArgumentException.class,
                ()-> HRCalculator.calculateMaxHR(500));
    }
    @Test
    public void testInvalidMinHR_ageTooLow() {
        assertThrows(IllegalArgumentException.class,
                ()-> HRCalculator.calculateMaxHR(-1));
    }

    @Test
    public void testGetWorkoutZone() {
        assertEquals("Warm-up", HRCalculator.getWorkoutZone(30, 100));
        assertEquals("Fat burn", HRCalculator.getWorkoutZone(30, 120));
        assertEquals("Aerobic", HRCalculator.getWorkoutZone(30, 140));
        assertEquals("Anaerobic", HRCalculator.getWorkoutZone(30, 160));
        assertEquals("Red line", HRCalculator.getWorkoutZone(30, 175));
        assertEquals("Above max HR", HRCalculator.getWorkoutZone(30, 250));
        assertEquals("Below warm-up", HRCalculator.getWorkoutZone(30, 50));
    }

}