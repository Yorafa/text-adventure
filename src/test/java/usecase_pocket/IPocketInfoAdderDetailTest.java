package usecase_pocket;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class IPocketInfoAdderDetailTest {
    private final PocketInfoAdderDetail testIPIAD = new PocketInfoAdderDetail();
    private final Map<String, String> testMap = new HashMap<>();

    @Test
    public void testAdd() {
        testIPIAD.add(testMap, PokemonForTest.testPokemon1);
        assertEquals("Test Pokemon 1", testMap.get("name"));
        assertEquals("4", testMap.get("level"));
        assertEquals("4", testMap.get("experiencePoint"));
        assertEquals("1", testMap.get("hitPoint"));
        assertEquals("1", testMap.get("maxHitPoint"));
        assertEquals("1", testMap.get("attackPoint"));
        assertEquals("1", testMap.get("defencePoint"));
        assertEquals("1", testMap.get("speed"));
    }
}
