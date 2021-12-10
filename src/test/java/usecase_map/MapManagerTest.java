package usecase_map;

import entity.Pmap;
import org.junit.Test;
import usecase_data.IJsonReader;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MapManagerTest {
    IJsonReader<List<Pmap>> testIJR = new MapJsonReaderForTest();
    MapManager testMM = new MapManager(testIJR);

    @Test
    public void mapCountTest() {
        assertEquals(3, testMM.getMapNames().size());
    }

    @Test
    public void currentPlaceTest() throws IOException {
        testMM.setCurrentPlace(0);
        boolean b1 = testMM.getCurrentPlace().getMapName().equals("Ocean");
        Pmap testPmap = testIJR.read().get(2);
        testMM.setCurrentPlace(testPmap);
        boolean b2 = testMM.getCurrentPlace().getMapName().equals("Forest");
        assertTrue(b1 && b2);
    }

    @Test
    public void getMapNamesTest() {
        assertTrue(testMM.getMapNames().get(0).equals("Ocean")
                && testMM.getMapNames().get(1).equals("Volcano")
                && testMM.getMapNames().get(2).equals("Forest"));
    }

    @Test
    public void pmapRelatedTest() {
        assertTrue(testMM.getPmaps().get(0).getMapName().equals("Ocean")
                && testMM.getPmaps().get(1).getMapName().equals("Volcano")
                && testMM.getPmaps().get(2).getMapName().equals("Forest"));
    }
}
