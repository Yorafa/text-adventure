package usecase;

import entity.*;

import java.io.IOException;
import java.util.List;

public class PokemonManager {
    private PokemonBook pokemonBook;
    private Pocket pocket;

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

    public void levelChange(Pokemon pokemon, int level) {
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

    public Pokemon getBattlePokemon() {
        return pocket.getBattlePokemon();
    }

    public void add(Pokemon pokemon) {
        pocket.add(pokemon);
    }

    public String getName(Pokemon pokemon) {
        return pokemon.getName();
    }

    public void healAll() {
        List<Pokemon> pokemons = pocket.getPokemons();
        for (Pokemon pokemon : pokemons) {
            pokemon.setHitPoint(pokemon.getMaxHitPoint());
        }
    }
}
