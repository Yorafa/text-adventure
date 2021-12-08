package usecase_pokemon;

import entity.BasePokemon;
import entity.Pocket;
import entity.Pokemon;
import entity.PokemonBook;
import usecase_data.IJsonReader;
import usecase_pocket.IPocketInfoAdder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokemonManager {
    private PokemonBook pokemonBook;
    private Pocket pocket;

    /**
     * Construct PokemonManager, given them the given reader read
     *
     * @param reader use to read PokemonManager
     * @see IJsonReader
     * @see PokemonBook
     * @see Pocket
     * @see Pokemon
     */
    public PokemonManager(IJsonReader<PokemonBook> reader) {
        try {
            this.pokemonBook = reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Pokemon getPokemon(String name, int level) {
        BasePokemon basePokemon = pokemonBook.get(name);
        PokemonFactory pokemonFactory = new PokemonFactory();
        return pokemonFactory.getPokemon(basePokemon, level);
    }

    private void levelChange(Pokemon pokemon, int level) {
        PokemonDataManager pokemonDataManager = new PokemonDataManager();
        pokemon.setLevel(level);
        pokemonDataManager.update(pokemon.getPokemonData(), pokemon.getBasePokemonData(), level);
    }

    public void addExperiencePoint(Pokemon pokemon, int increment) {
        LevelCalculator levelCalculator = new LevelCalculator();
        pokemon.setExperiencePoint(pokemon.getExperiencePoint() + increment);
        int level = levelCalculator.calculateLevel(pokemon.getExperiencePoint());
        if (level != pokemon.getLevel()) {
            levelChange(pokemon, level);
        }
    }

    public Pocket getPocket() {
        return pocket;
    }

    public void setPocket(Pocket pocket) {
        if (pocket != null) {
            this.pocket = pocket;
        } else {
            this.pocket = new Pocket();
            Pokemon pokemon = new PokemonFactory().getPokemon(pokemonBook.get(0), 15);
            this.pocket.add(pokemon);
            this.pocket.setBattlePokemon(pokemon);
        }
    }

    public List<Map<String, String>> getPocketInfo(IPocketInfoAdder adder) {
        List<Map<String, String>> pocketInfo = new ArrayList<>();
        for (Pokemon pokemon : pocket) {
            Map<String, String> pokemonInfo = new HashMap<>();
            adder.add(pokemonInfo, pokemon);
            pocketInfo.add(pokemonInfo);
        }
        return pocketInfo;
    }

    public Pokemon getBattlePokemon() {
        return pocket.getBattlePokemon();
    }

    public void setBattlePokemon(int i) {
        pocket.setBattlePokemon(pocket.get(i));
    }

    public String getBattlePokemonName() {
        return pocket.getBattlePokemon().getName();
    }

    public void add(Pokemon pokemon) {
        pocket.add(pokemon);
    }

    public void healAll() {
        List<Pokemon> pokemons = pocket.getPokemons();
        for (Pokemon pokemon : pokemons) {
            pokemon.setHitPoint(pokemon.getMaxHitPoint());
        }
    }
}