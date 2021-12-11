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

    /**
     * @param name  the name of pokemon
     * @param level the level of pokemon
     * @return a new pokemon
     */
    public Pokemon getPokemon(String name, int level) {
        BasePokemon basePokemon = pokemonBook.get(name);
        PokemonFactory pokemonFactory = new PokemonFactory();
        return pokemonFactory.getPokemon(basePokemon, level);
    }

    /**
     * @param pokemon pokemon
     * @param level   new level
     */
    private void levelChange(Pokemon pokemon, int level) {
        PokemonDataManager pokemonDataManager = new PokemonDataManager();
        pokemon.setLevel(level);
        pokemonDataManager.update(pokemon.getPokemonData(), pokemon.getBasePokemonData(), level);
    }

    /**
     * @param pokemon   pokemon
     * @param increment exp will be added
     */
    public void addExperiencePoint(Pokemon pokemon, int increment) {
        LevelCalculator levelCalculator = new LevelCalculator();
        pokemon.setExperiencePoint(pokemon.getExperiencePoint() + increment);
        int level = levelCalculator.calculateLevel(pokemon.getExperiencePoint());
        if (level != pokemon.getLevel()) {
            levelChange(pokemon, level);
        }
    }

    /**
     * the getter method of pocket
     *
     * @return the container of pokemons of player
     */
    public Pocket getPocket() {
        return pocket;
    }

    /**
     * the setter method of pocket
     *
     * @param pocket the container of pokemons of player
     */
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

    /**
     * @param adder the information adder
     * @return list of pokemons information
     */
    public List<Map<String, String>> getPocketInfo(IPocketInfoAdder adder) {
        List<Map<String, String>> pocketInfo = new ArrayList<>();
        for (Pokemon pokemon : pocket) {
            Map<String, String> pokemonInfo = new HashMap<>();
            adder.add(pokemonInfo, pokemon);
            pocketInfo.add(pokemonInfo);
        }
        return pocketInfo;
    }

    /**
     * @return the pokemon that used to battle
     */
    public Pokemon getBattlePokemon() {
        return pocket.getBattlePokemon();
    }

    /**
     * @param i the index of pokemon in pocket
     */
    public void setBattlePokemon(int i) {
        pocket.setBattlePokemon(pocket.get(i));
    }

    /**
     * @return the name of pokemon that will battle
     */
    public String getBattlePokemonName() {
        return pocket.getBattlePokemon().getName();
    }

    /**
     * @param pokemon new pokemon
     */
    public void add(Pokemon pokemon) {
        pocket.add(pokemon);
    }

    /**
     * heal all pokemon in pocket
     */
    public void healAll() {
        List<Pokemon> pokemons = pocket.getPokemons();
        for (Pokemon pokemon : pokemons) {
            pokemon.setHitPoint(pokemon.getMaxHitPoint());
        }
    }

    /**
     *
     * @return true if the battle pokemon can fight
     */
    public boolean canFight(){
        return this.getBattlePokemon().getHitPoint() > 0;
    }
}