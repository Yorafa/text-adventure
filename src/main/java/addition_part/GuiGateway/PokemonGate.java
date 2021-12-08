package addition_part.GuiGateway;

import com.google.gson.Gson;
import entity.PokemonBook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PokemonGate {

    /**
     * @param pokemonBook the pokemon index of all pokemon
     */
    public static void writePokemonBook(PokemonBook pokemonBook) {
        Gson gson = new Gson();
        String pokemonBookJson = gson.toJson(pokemonBook);
        try {
            FileWriter mapFile = new FileWriter("GuiData/pokemon/AllPokemonData.json");
            mapFile.write(pokemonBookJson);
            mapFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PokemonBook toPokemonBook() {
        try {
            File pokemonFile = new File("GuiData/pokemon/AllPokemonData.json");
            Scanner scanner = new Scanner(pokemonFile);
            StringBuilder pokemonData = new StringBuilder();
            while (scanner.hasNext()) {
                pokemonData.append(scanner.next().strip());
            }
            String pokemonDataJson = pokemonData.toString();
            Gson gson = new Gson();
            return gson.fromJson(pokemonDataJson, PokemonBook.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
