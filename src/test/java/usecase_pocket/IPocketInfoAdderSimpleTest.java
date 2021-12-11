package usecase_pocket;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class IPocketInfoAdderSimpleTest {
    private final PocketInfoAdderDetail testIPIAS = new PocketInfoAdderDetail();
    private final Map<String, String> testMap = new HashMap<>();

    @Test
    public void testAdd() {
        testIPIAS.add(testMap, PokemonForTest.testPokemon1);
        assertEquals("Test Pokemon 1", testMap.get("name"));
        assertEquals("4", testMap.get("level"));
    }
}
