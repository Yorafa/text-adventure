package usecase;

import entity.*;

import java.util.ArrayList;
import java.util.List;

public class PokemonManager {
    private PokemonBook pokemonBook;
    private Pocket pocket;

    public PokemonManager() {
        this.pokemonBook = new PokemonBook();
        this.pocket = new Pocket();
        initialize();
    }

    public PokemonManager(Pocket pocket) {
        this.pokemonBook = new PokemonBook();
        this.pocket = pocket;
    }

    public void levelChange(Pokemon pokemon, int level) {
        PokemonDataManager pokemonDataManager = new PokemonDataManager();
        pokemon.setLevel(level);
        pokemonDataManager.update(pokemon.getPokemonData(), pokemon.getBasePokemonData(), level);
    }

    public void addExperiencePoint(Pokemon pokemon, int increment) {
        LevelCalculator levelCalculator = new LevelCalculator();
        pokemon.setExperiencePoint(pokemon.getExperiencePoint() + increment);
        int level = levelCalculator.calculate(pokemon.getExperiencePoint());
        if (level != pokemon.getLevel()) {
            levelChange(pokemon, level);
        }
    }

    public Pocket getPocket() {
        return pocket;
    }

    public void setPocket(Pocket pocket) {
        this.pocket = pocket;
    }

    public List<Pokemon> getBattlePokemons() {
        return pocket.getBattlePokemons();
    }

    public Pokemon getDefaultPokemon() {
        return pocket.getDefaultPokemon();
    }

    public void initialize() {
        BasePokemonData basePokemonData = new BasePokemonData(PokemonType.ELECTRICITY, 1000, 1000, 1000, 1000);
        BasePokemon basePokemon = new BasePokemon("Pikachu", basePokemonData);
        PokemonFactory pf = new PokemonFactory();
        Pokemon pikachu = pf.getPokemon(basePokemon, 0, 1000);
        pocket.add(pikachu);
        List<Pokemon> dp = new ArrayList<>();
        dp.add(pikachu);
        pocket.setBattlePokemons(dp);
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
