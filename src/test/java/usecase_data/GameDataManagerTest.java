package usecase_data;

import entity.Pokemon;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameDataManagerTest {
    private final GameDataReadWriterForTest testGDRW = new GameDataReadWriterForTest();
    private final GameDataManager testGDM = new GameDataManager();

    @Before
    public void setUp() throws IOException {
        if (new File("test_data/game/testuser.ser").delete()) {
            Path source = new File("test_data/backup/testuser.ser").toPath();
            Path dest = new File("test_data/game/testuser.ser").toPath();
            Files.copy(source, dest, REPLACE_EXISTING);
        }
        testGDM.setReadWriter(testGDRW);
    }

    @Test
    public void testGetCurrentPlace() {
        assertEquals("Ocean", testGDM.getCurrentPlace().getMapName());
    }

    @Test
    public void testGetPocket() {
        String battlePokemon = testGDM.getPocket().getBattlePokemon().getName();
        List<Pokemon> listPokemon = testGDM.getPocket().getPokemons();
        assertTrue(battlePokemon.equals("Pikachu")
                && listPokemon.size() == 1
                && listPokemon.get(0).getName().equals("Pikachu"));
    }
}
