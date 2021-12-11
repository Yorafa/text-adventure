package usecase_pocket;

import entity.Pocket;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PocketSorterByLevelTest {
    final PocketSorterByLevel testPSBL = new PocketSorterByLevel();
    final Pocket testPocket = new Pocket();

    @Test
    public void sortTest() {
        testPocket.add(PokemonForTest.testPokemon2);
        testPocket.add(PokemonForTest.testPokemon3);
        testPocket.add(PokemonForTest.testPokemon4);
        testPocket.add(PokemonForTest.testPokemon1);
        testPSBL.sort(testPocket);
        for (int i = 0; i < testPocket.size() - 1; i++) {
            assertTrue(testPocket.get(i).getName().compareTo(testPocket.get(i + 1).getName()) <= 0);
        }
    }
}
