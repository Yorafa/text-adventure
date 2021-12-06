package entity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PmapTest {
    Pmap pmap;

    @Before
    public void setPmap() {
        pmap = new Pmap();
    }

    @Test(timeout = 50)
    public void testSetMapNameAndGetMapName() {
        this.pmap.setMapName("MAP");
        assertEquals("MAP", pmap.getMapName());
    }

    @Test(timeout = 50)
    public void testSetPokemonsAndGetPokemons() {
        List<List<Pokemon>> pokemonList = new ArrayList<>();
        BasePokemonData basePokemonData = new BasePokemonData(PokemonType.ELECTRICITY, 1, 1, 1, 1);
        PokemonData pokemonData = new PokemonData(PokemonType.ELECTRICITY, 1, 1, 1, 1);
        Pokemon pokemon = new Pokemon("test", basePokemonData, 1, 0, 1, pokemonData);
        List<Pokemon> rarity = new ArrayList<>();
        rarity.add(pokemon);
        pokemonList.add(rarity);
        this.pmap.setPokemons(pokemonList);
        assertEquals(pokemonList, pmap.getPokemons());
    }


    @Test(timeout = 50)
    public void testEqual() {
        Pmap pmapTest = new Pmap();
        assertTrue(pmap.equals(pmapTest));
    }
}
