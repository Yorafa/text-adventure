package entity;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static entity.PokemonType.ELECTRICITY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PokemonBookTest {
    private final PokemonBook pokemonBook = new PokemonBook();

    @Test(timeout = 50)
    public void testGetPokemonBook() {
        List<BasePokemon> testList = new ArrayList<>();
        assertEquals(testList, this.pokemonBook.getPokemonBook());
    }

    @Test(timeout = 50)
    public void testAddPokemonAndRemovePokemon() {
        BasePokemonData bpd = new BasePokemonData(ELECTRICITY, 1, 1, 1, 1);
        BasePokemon basePokemon = new BasePokemon("test", bpd);
        pokemonBook.addPokemon(basePokemon);
        assertTrue(pokemonBook.getPokemonBook().contains(basePokemon));
        pokemonBook.removePokemon(0);
        assertEquals(new ArrayList<>(), pokemonBook.getPokemonBook());
    }
}
