package entity;

import org.junit.Test;

import static entity.PokemonType.ELECTRICITY;
import static org.junit.Assert.assertEquals;

public class BasePokemonDataTest {
    private final BasePokemonData basePokemonData = new BasePokemonData(ELECTRICITY, 1, 1, 1, 1);

    @Test(timeout = 50)
    public void testGetPokemonType() {
        assertEquals(ELECTRICITY, basePokemonData.getPokemonType());
    }

    @Test(timeout = 50)
    public void testGetMaxHitPoint() {
        assertEquals(1, basePokemonData.getMaxHitPoint());
    }

    @Test(timeout = 50)
    public void testGetAttackPoint() {
        assertEquals(1, basePokemonData.getAttackPoint());
    }

    @Test(timeout = 50)
    public void testGetDefencePoint() {
        assertEquals(1, basePokemonData.getDefencePoint());
    }

    @Test(timeout = 50)
    public void testGetSpeed() {
        assertEquals(1, basePokemonData.getSpeed());
    }

    @Test(timeout = 50)
    public void testEqual() {
        BasePokemonData bpd = new BasePokemonData(ELECTRICITY, 1, 1, 1, 1);
        assertEquals(basePokemonData, bpd);
    }
}
