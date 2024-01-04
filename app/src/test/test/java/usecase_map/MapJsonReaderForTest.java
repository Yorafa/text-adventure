package usecase_map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.Pmap;
import usecase_data.IJsonReader;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * the data access object in charge of map
 */
public class MapJsonReaderForTest implements IJsonReader<List<Pmap>> {
    /**
     * @return a list of map
     * @throws IOException file may not exist
     */
    public List<Pmap> read() throws IOException {
        String filePath = "test_data/AllMapData.json";
        Reader reader = Files.newBufferedReader(Paths.get(filePath));
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Pmap>>() {
        }.getType();
        return gson.fromJson(reader, type);
    }
}