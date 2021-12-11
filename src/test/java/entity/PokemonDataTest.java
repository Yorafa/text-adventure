package entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PokemonDataTest {
    PokemonData pokemonData;

    @Before
    public void setUp(){
        pokemonData = new PokemonData(PokemonType.ELECTRICITY, 1, 1, 1, 1);
    }

    @Test(timeout = 50)
    public void testSetMaxHitPoint(){
        pokemonData.setMaxHitPoint(2);
        assertEquals(2, pokemonData.getMaxHitPoint());
    }

    @Test(timeout = 50)
    public void testSetAttackPoint(){
        pokemonData.setAttackPoint(2);
        assertEquals(2, pokemonData.getAttackPoint());
    }

    @Test(timeout = 50)
    public void testSetDefencePoint(){
        pokemonData.setDefencePoint(2);
        assertEquals(2, pokemonData.getDefencePoint());
    }

    @Test(timeout = 50)
    public void testSetSpeed(){
        pokemonData.setSpeed(2);
        assertEquals(2, pokemonData.getSpeed());
    }
}
