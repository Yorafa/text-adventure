package usecase_map;

import entity.Pmap;
import entity.Pokemon;
import org.junit.Test;
import usecase_data.IJsonReader;
import usecase_pokemon.PokemonJsonReaderForTest;
import usecase_pokemon.PokemonManager;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MapManagerTest {
    private final IJsonReader<List<Pmap>> testIJR = new MapJsonReaderForTest();
    private final MapManager testMM = new MapManager(testIJR);

    @Test
    public void testGetMapNames() {
        List<String> mapNames = testMM.getMapNames();
        assertTrue(mapNames.contains("Ocean"));
        assertTrue(mapNames.contains("Volcano"));
        assertTrue(mapNames.contains("Forest"));
    }

    @Test
    public void testGetPmaps() {
        List<String> mapNames = testMM.getMapNames();
        List<Pmap> pmaps = testMM.getPmaps();
        for (Pmap pmap : pmaps) {
            assertTrue(mapNames.contains(pmap.getMapName()));
        }
    }

    @Test
    public void testGetAndSetCurrentPlace() throws IOException {
        testMM.setCurrentPlace(0);
        assertEquals("Ocean", testMM.getCurrentPlace().getMapName());
        Pmap testPmap = testIJR.read().get(2);
        testMM.setCurrentPlace(testPmap);
        assertEquals("Forest", testMM.getCurrentPlace().getMapName());
    }

    @Test
    public void testWalkAround() {
        testMM.setCurrentPlace(0);
        Pokemon pokemon = testMM.walkAround(new PokemonManager(new PokemonJsonReaderForTest()));
        assertTrue(pokemon == null || pokemon.getName().equals("Squirtle") || pokemon.getName().equals("Psyduck"));
    }
}
