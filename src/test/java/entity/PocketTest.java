package entity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PocketTest {
    private Pocket pocket;
    private Pokemon testPokemon;

    @Before
    public void setUp() {
        pocket = new Pocket();
        BasePokemonData basePokemonData = new BasePokemonData(PokemonType.ELECTRICITY, 1, 1, 1, 1);
        PokemonData pokemonData = new PokemonData(PokemonType.ELECTRICITY, 1, 1, 1, 1);
        testPokemon = new Pokemon("test", basePokemonData, 1, 0, 1, pokemonData);
    }

    @Test(timeout = 50)
    public void testGetBattlePokemon() {
        assertNull(pocket.getBattlePokemon());
    }

    @Test(timeout = 50)
    public void testSetBattlePokemon() {
        pocket.setBattlePokemon(testPokemon);
        assertEquals(testPokemon, pocket.getBattlePokemon());
    }

    @Test(timeout = 50)
    public void testGetPokemons() {
        assertEquals(new ArrayList<>(), pocket.getPokemons());
    }

    @Test(timeout = 50)
    public void testAdd() {
        pocket.add(testPokemon);
        assertNotEquals(new ArrayList<>(), pocket.getPokemons());
    }

    @Test(timeout = 50)
    public void testGet() {
        pocket.add(testPokemon);
        assertEquals(testPokemon, pocket.get(0));
    }

    @Test(timeout = 50)
    public void testSize() {
        assertEquals(0, pocket.size());
        pocket.add(testPokemon);
        assertEquals(1, pocket.size());
    }
}
