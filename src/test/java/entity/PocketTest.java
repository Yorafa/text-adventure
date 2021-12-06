package entity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PocketTest {
    Pocket pocket;

    @Before
    public void setPocket() {
        pocket = new Pocket();
    }

    @Test(timeout = 50)
    public void testSetAndGetBattlePokemonsAndGetDefaultPokemon() {
        // Test empty
        List<Pokemon> pokemonList = new ArrayList<>();
        pocket.setBattlePokemon(pokemonList);
        assertEquals(pocket.getBattlePokemon(), pokemonList);
        // Test one element
        BasePokemonData basePokemonData = new BasePokemonData(PokemonType.ELECTRICITY, 1, 1, 1, 1);
        PokemonData pokemonData = new PokemonData(PokemonType.ELECTRICITY, 1, 1, 1, 1);
        Pokemon pokemon = new Pokemon("test", basePokemonData, 1, 0, 1, pokemonData);
        pokemonList.add(pokemon);
        pocket.setBattlePokemon(pokemonList);
        assertEquals(pocket.getBattlePokemon(), pokemonList);
        assertEquals(pocket.getDefaultPokemon(), pokemon);
    }

    @Test(timeout = 50)
    public void testAddAndGetPokemons() {
        // Test initial setup
        assertEquals(pocket.getPokemons(), new ArrayList<>());
        // Test Add and Get
        BasePokemonData basePokemonData = new BasePokemonData(PokemonType.ELECTRICITY, 1, 1, 1, 1);
        PokemonData pokemonData = new PokemonData(PokemonType.ELECTRICITY, 1, 1, 1, 1);
        Pokemon pokemon = new Pokemon("test", basePokemonData, 1, 0, 1, pokemonData);
        pocket.add(pokemon);
        assertEquals(pocket.getPokemons().get(0), pokemon);
    }

    @Test(timeout = 50)
    public void testEqual() {
        Pocket newPocket = new Pocket();
        assertTrue(pocket.equals(newPocket));
    }
}
