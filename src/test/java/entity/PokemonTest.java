package entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokemonTest {
    Pokemon pokemon;

    @Before
    public void setPokemon() {
        BasePokemonData basePokemonData = new BasePokemonData(PokemonType.ELECTRICITY, 1, 1, 1, 1);
        PokemonData pokemonData = new PokemonData(PokemonType.ELECTRICITY, 1, 1, 1, 1);
        this.pokemon = new Pokemon("test", basePokemonData, 1, 0, 1, pokemonData);
    }

    @Test(timeout = 50)
    public void testSetLevelAndGetLevel() {
        assertEquals(1, pokemon.getLevel());
        pokemon.setLevel(2);
        assertEquals(2, pokemon.getLevel());
    }

    @Test(timeout = 50)
    public void testSetExperiencePointAndGetExperiencePoint() {
        assertEquals(0, pokemon.getExperiencePoint());
        pokemon.setExperiencePoint(1);
        assertEquals(1, pokemon.getExperiencePoint());
    }

    @Test(timeout = 50)
    public void testSetHitPointAndGetHitPoint() {
        assertEquals(1, pokemon.getHitPoint());
        pokemon.setHitPoint(2);
        assertEquals(2, pokemon.getHitPoint());
    }

    @Test(timeout = 50)
    public void testSetPokemonDataAndGetPokemonData() {
        PokemonData pokemonData = new PokemonData(PokemonType.ELECTRICITY, 1, 1, 1, 1);
        assertEquals(pokemonData, pokemon.getPokemonData());
        PokemonData newData = new PokemonData(PokemonType.ELECTRICITY, 2, 2, 2, 2);
        pokemon.setPokemonData(newData);
        assertEquals(newData, pokemon.getPokemonData());
    }

    @Test(timeout = 50)
    public void testEqual() {
        BasePokemonData basePokemonData = new BasePokemonData(PokemonType.ELECTRICITY, 1, 1, 1, 1);
        PokemonData pokemonData = new PokemonData(PokemonType.ELECTRICITY, 1, 1, 1, 1);
        Pokemon testPokemon = new Pokemon("test", basePokemonData, 1, 0, 1, pokemonData);
        assertEquals(this.pokemon, testPokemon);
    }
}
