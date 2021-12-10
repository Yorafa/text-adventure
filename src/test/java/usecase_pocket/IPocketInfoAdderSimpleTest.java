package usecase_pocket;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class IPocketInfoAdderSimpleTest {
    PocketInfoAdderDetail testIPIAS = new PocketInfoAdderDetail();
    Map<String, String> testMap = new HashMap<>();

    @Test
    public void addTest() {
        testIPIAS.add(testMap, PokemonForTest.testPokemon1);
        assertTrue(testMap.get("name").equals("Test Pokemon 1") && testMap.get("level").equals("4"));
    }
}
