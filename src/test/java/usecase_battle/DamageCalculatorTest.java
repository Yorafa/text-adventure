package usecase_battle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DamageCalculatorTest {
    DamageCalculator damageCalculator;

    @Before
    public void setDamageCalculator() {
        damageCalculator = new DamageCalculator();
    }

    @Test(timeout = 50)
    public void testCalculate() {
        assertEquals(90, damageCalculator.calculate(1, 1));
    }

    @Test(timeout = 50)
    public void testSetHasCounterattack() {
        damageCalculator.setHasCounterattack(true);
        assertEquals(180, damageCalculator.calculate(1, 1));
    }

    @Test(timeout = 50)
    public void testSetHasDefense() {
        damageCalculator.setHasDefense(true);
        assertEquals(45, damageCalculator.calculate(1, 1));
    }
}
