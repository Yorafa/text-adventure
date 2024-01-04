package usecase_pocket;

import entity.Pocket;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PocketSorterByNameTest {
    final PocketSorterByName testPSBN = new PocketSorterByName();
    final Pocket testPocket = new Pocket();

    @Test
    public void sortTest() {
        testPocket.add(PokemonForTest.testPokemon1);
        testPocket.add(PokemonForTest.testPokemon3);
        testPocket.add(PokemonForTest.testPokemon4);
        testPocket.add(PokemonForTest.testPokemon2);
        testPSBN.sort(testPocket);
        for (int i = 0; i < testPocket.size() - 1; i++) {
            assertTrue(testPocket.get(i).getLevel() >= (testPocket.get(i + 1).getLevel()));
        }
    }
}
