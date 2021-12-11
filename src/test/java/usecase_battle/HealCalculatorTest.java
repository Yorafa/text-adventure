package usecase_battle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HealCalculatorTest {
    HealCalculator healCalculator;

    @Before
    public void setHealCalculator() {
        healCalculator = new HealCalculator();
    }

    @Test(timeout = 50)
    public void testCalculate() {
        assertEquals(0, healCalculator.calculate(1));
        assertEquals(10, healCalculator.calculate(50));

    }
}
