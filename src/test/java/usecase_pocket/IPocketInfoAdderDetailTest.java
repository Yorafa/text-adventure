package usecase_pocket;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class IPocketInfoAdderDetailTest {
    final PocketInfoAdderDetail testIPIAD = new PocketInfoAdderDetail();
    final Map<String, String> testMap = new HashMap<>();

    @Test
    public void addTest() {
        testIPIAD.add(testMap, PokemonForTest.testPokemon1);
        assertTrue(testMap.get("name").equals("Test Pokemon 1")
                && testMap.get("pokemonType").equals("ELECTRICITY")
                && testMap.get("level").equals("4")
                && testMap.get("experiencePoint").equals("4")
                && testMap.get("hitPoint").equals("1")
                && testMap.get("maxHitPoint").equals("1")
                && testMap.get("attackPoint").equals("1")
                && testMap.get("defencePoint").equals("1")
                && testMap.get("speed").equals("1"));
    }
}
