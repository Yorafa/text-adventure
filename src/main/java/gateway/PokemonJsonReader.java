package gateway;

import com.google.gson.Gson;
import entity.PokemonBook;
import usecase_data.IJsonReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PokemonJsonReader implements IJsonReader<PokemonBook> {
    public PokemonBook read() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get("game_data/AllPokemonData.json"));
        Gson gson = new Gson();
        return gson.fromJson(reader, PokemonBook.class);
    }
}
