package entity;

import org.junit.Before;
import org.junit.Test;

import static entity.PokemonType.ELECTRICITY;
import static org.junit.Assert.assertEquals;

public class BasePokemonTest {
    private BasePokemon basePokemon;

    @Before
    public void setUp() {
        BasePokemonData bpd = new BasePokemonData(ELECTRICITY, 1, 1, 1, 1);
        basePokemon = new BasePokemon("test", bpd);
    }

    @Test(timeout = 50)
    public void testGetName() {
        assertEquals("test", basePokemon.getName());
    }

    @Test(timeout = 50)
    public void testGetBasePokemonData() {
        BasePokemonData bpd = new BasePokemonData(ELECTRICITY, 1, 1, 1, 1);
        assertEquals(bpd, basePokemon.getBasePokemonData());
    }

    @Test(timeout = 50)
    public void testGetPokemonType() {
        assertEquals(ELECTRICITY, basePokemon.getPokemonType());
    }

    @Test(timeout = 50)
    public void testGetMaxHitPoint() {
        assertEquals(1, basePokemon.getMaxHitPoint());
    }

    @Test(timeout = 50)
    public void testGetAttackPoint() {
        assertEquals(1, basePokemon.getAttackPoint());
    }

    @Test(timeout = 50)
    public void testGetDefencePoint() {
        assertEquals(1, basePokemon.getDefencePoint());
    }

    @Test(timeout = 50)
    public void testGetSpeed() {
        assertEquals(1, basePokemon.getSpeed());
    }

    @Test(timeout = 50)
    public void testEqual() {
        BasePokemonData bpd = new BasePokemonData(ELECTRICITY, 1, 1, 1, 1);
        BasePokemon bp = new BasePokemon("test", bpd);
        assertEquals(basePokemon, bp);
    }
}
