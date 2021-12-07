package usecase_pokemon;

import org.junit.Test;

import static org.junit.Assert.*;

public class LevelCalculatorTest {

    @Test
    public void testCalculateLevel() {
        assertEquals(100, new LevelCalculator().calculateLevel(10000));
    }

    @Test
    public void testCalculateExperiencePoint() {
        assertEquals(10000, new LevelCalculator().calculateExperiencePoint(100));
    }
}