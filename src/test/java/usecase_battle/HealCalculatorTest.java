package usecase_battle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HealCalculatorTest {
    private final HealCalculator healCalculator = new HealCalculator();

    @Test(timeout = 50)
    public void testCalculate() {
        assertEquals(0, healCalculator.calculate(1));
        assertEquals(10, healCalculator.calculate(50));

    }
}
