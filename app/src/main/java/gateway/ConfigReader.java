package gateway;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import usecase_data.IJsonReader;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/**
 * the data access object in charge of map
 */
public class ConfigReader implements IJsonReader<Map<String, String>> {

    /**
     * @return a map of configuration
     * @throws IOException file may not exist
     */
    public Map<String, String> read() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get("configuration.json"));
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        return gson.fromJson(reader, type);
    }

    /**
     * @return A path String for game data
     * @throws IOException file may not exist
     */
    public String getGamePath() throws IOException {
        return read().get("GamePath");
    }

    /**
     * @return A path String for user data
     * @throws IOException file may not exist
     */
    public String getUserPath() throws IOException {
        return read().get("UserPath");
    }

    /**
     * @return A path String for map data
     * @throws IOException file may not exist
     */
    public String getMapPath() throws IOException {
        return read().get("MapPath");
    }

    /**
     * @return A path String for pokemon data
     * @throws IOException file may not exist
     */
    public String getPokemonPath() throws IOException {
        return read().get("PokemonPath");
    }
}