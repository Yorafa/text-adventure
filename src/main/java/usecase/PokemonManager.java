package usecase;

import entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PokemonManager {
    private PokemonBook pokemonBook;
    private Pocket pocket;
    private LevelCalculator lc;
    private PokemonDataManager pdm;

    public PokemonManager() {
        this.pokemonBook = new PokemonBook();
        this.pocket = new Pocket();
        this.lc = new LevelCalculator();
        this.pdm = new PokemonDataManager();
        initialize();
    }

    public void levelChange(Pokemon pokemon, int level) {
        pokemon.setLevel(level);
        pdm.update(pokemon.getPokemonData(), pokemon.getBasePokemonData(), level);
    }

    public void addExperiencePoint(Pokemon pokemon, int increment) {
        pokemon.setExperiencePoint(pokemon.getExperiencePoint() + increment);
        int level = lc.calculate(pokemon.getExperiencePoint());
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

    public List<Pokemon> getDefaultPokemon() {
        return pocket.getDefaultPokemons();
    }

    public void attack(Pokemon p1, Pokemon p2) {
        // TODO: complete this
    }

    public boolean capture(Pokemon opponent) {
        // TODO: complete this
        return true;
    }

    public void initialize() {
        BasePokemonData basePokemonData = new BasePokemonData(PokemonType.ELECTRICITY, 10, 10, 10, 10);
        BasePokemon basePokemon = new BasePokemon("Pikachu", basePokemonData);
        PokemonFactory pf = new PokemonFactory();
        Pokemon pikachu = pf.getPokemon(basePokemon, 1000, 10);
        pocket.add(pikachu);
        List<Pokemon> dp = new ArrayList<>();
        dp.add(pikachu);
        pocket.setDefaultPokemons(dp);
    }
}
