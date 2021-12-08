package usecase_pokemon;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeveledDataCalculatorTest {

    @Test
    public void testCalculate() {
        LeveledDataCalculator leveledDataCalculator = new LeveledDataCalculator();
        assertEquals(100, leveledDataCalculator.calculate(10, 100));
        assertEquals(15, leveledDataCalculator.calculate(15, 1));
    }
}