package usecase_data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import entity.Pokemon;
import org.junit.Test;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.junit.Assert.*;

public class GameDataManagerTest {
    GameDataReadWriterForTest testGDRW = new GameDataReadWriterForTest("testuser");
    GameDataManager testGDM = new GameDataManager();

    public void prepForTest() throws IOException {
        if (new File("test_data/testuser.ser").delete()) {
            Path source = new File("test_data/backup/testuser.ser").toPath();
            Path dest = new File("test_data/testuser.ser").toPath();
            Files.copy(source, dest, REPLACE_EXISTING);
        }
        testGDM.setReadWriter(testGDRW);
    }

    @Test
    public void testGetCurrentPlace() throws IOException {
        prepForTest();
        assertEquals("Ocean", testGDM.getCurrentPlace().getMapName());
    }

    @Test
    public void testGetPocket() throws IOException {
        prepForTest();
        String battlePokemon = testGDM.getPocket().getBattlePokemon().getName();
        List<Pokemon> listPokemon = testGDM.getPocket().getPokemons();
        assertTrue(battlePokemon.equals("Pikachu")
                && listPokemon.size() == 1
                && listPokemon.get(0).getName().equals("Pikachu"));
    }
}
