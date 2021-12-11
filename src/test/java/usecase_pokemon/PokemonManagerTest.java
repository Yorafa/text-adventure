package usecase_pokemon;

import entity.Pocket;
import entity.Pokemon;
import org.junit.Test;
import usecase_pocket.IPocketInfoAdder;
import usecase_pocket.PocketInfoAdderSimple;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PokemonManagerTest {
    PokemonJsonReaderForTest testPJRFT = new PokemonJsonReaderForTest();
    PokemonManager testPM = new PokemonManager(testPJRFT);

    @Test
    public void getPokemon() {
        Pokemon pokemon = testPM.getPokemon("Pikachu", 1);
        assertTrue(pokemon.getName().equals("Pikachu") && pokemon.getLevel() == 1);
    }

    @Test
    public void addExperiencePoint() {
        Pokemon pokemon = testPM.getPokemon("Pikachu", 1);
        int current = pokemon.getExperiencePoint();
        testPM.addExperiencePoint(pokemon, 10);
        assertEquals(10, pokemon.getExperiencePoint() - current);
    }

    @Test
    public void setPocketAndGetPocket() {
        Pocket testPocket = new Pocket();
        testPocket.add(testPM.getPokemon("Pikachu", 1));
        testPM.setPocket(testPocket);
        assertEquals("Pikachu", testPM.getPocket().getPokemons().get(0).getName());
    }

    @Test
    public void getPocketInfo() {
        // for simple only, due to similarity
        Pocket testPocket = new Pocket();
        testPocket.add(testPM.getPokemon("Pikachu", 1));
        testPM.setPocket(testPocket);
        IPocketInfoAdder adder = new PocketInfoAdderSimple();
        assertEquals("Pikachu",testPM.getPocketInfo(adder).get(0).get("name"));

    }

    @Test
    public void setBattlePokemonAndGetBattlePokemon() {
        Pocket testPocket = new Pocket();
        testPocket.add(testPM.getPokemon("Pikachu", 1));
        testPocket.add(testPM.getPokemon("Squirtle", 2));
        testPM.setPocket(testPocket);
        testPM.setBattlePokemon(1);
        assertEquals("Squirtle", testPM.getBattlePokemon().getName());
    }

    @Test
    public void add() {
        Pocket testPocket = new Pocket();
        testPocket.add(testPM.getPokemon("Pikachu", 1));
        testPM.setPocket(testPocket);
        testPM.add(testPM.getPokemon("Squirtle", 2));
        assertEquals(2, testPM.getPocket().size());
    }

    @Test
    public void healAll() {
        Pocket testPocket = new Pocket();
        Pokemon pokemon = testPM.getPokemon("Pikachu", 1);
        pokemon.setHitPoint(pokemon.getHitPoint() - 1);
        int current = pokemon.getHitPoint();
        testPocket.add(pokemon);
        testPM.setPocket(testPocket);
        testPM.healAll();
        assertEquals(1, testPM.getPocket().get(0).getHitPoint() - current);
    }
}