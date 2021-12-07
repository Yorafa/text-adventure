package usecase_pokemon;

import entity.BasePokemon;
import entity.BasePokemonData;
import entity.Pokemon;
import entity.PokemonType;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokemonFactoryTest {

    @Test
    public void testGetPokemon() {
        BasePokemonData basePokemonData = new BasePokemonData(PokemonType.ELECTRICITY, 100, 200, 300, 400);
        BasePokemon basePokemon = new BasePokemon("Pikachu", basePokemonData);
        PokemonFactory pokemonFactory = new PokemonFactory();

        Pokemon pokemon1 = pokemonFactory.getPokemon(basePokemon, 400, 50);
        assertEquals("Pikachu", pokemon1.getName());
        assertEquals(400, pokemon1.getExperiencePoint());
        assertEquals(50, pokemon1.getHitPoint());

        Pokemon pokemon2 = pokemonFactory.getPokemon(basePokemon, 10);
        assertEquals("Pikachu", pokemon1.getName());
        assertEquals(pokemon2.getMaxHitPoint(), pokemon2.getHitPoint());
        assertEquals(10, pokemon2.getLevel());
    }
}