package usecase_pokemon;

import com.google.gson.Gson;
import entity.PokemonBook;
import gateway.ConfigReader;
import usecase_data.IJsonReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * the data access object in charge of all base of pokemon
 */
public class PokemonJsonReaderForTest implements IJsonReader<PokemonBook> {

    /**
     * @return the pokemon index of all pokemon
     * @throws IOException file may not exist
     */
    public PokemonBook read() throws IOException {
        String filePath = "test_data/AllPokemonData.json";
        Reader reader = Files.newBufferedReader(Paths.get(filePath));
        Gson gson = new Gson();
        return gson.fromJson(reader, PokemonBook.class);
    }
}