package usecase_pokemon;

import junit.framework.TestCase;

public class LevelCalculatorTest extends TestCase {
    private final LevelCalculator levelCalculator = new LevelCalculator();

    public void testCalculateLevel() {
        assertEquals(100, levelCalculator.calculateLevel(10000));
    }

    public void testCalculateExperiencePoint() {
        assertEquals(10000, levelCalculator.calculateExperiencePoint(100));
    }
}