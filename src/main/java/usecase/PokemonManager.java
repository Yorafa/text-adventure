package usecase;

import entity.BasePokemon;
import entity.Pocket;
import entity.Pokemon;
import entity.PokemonBook;

import java.util.List;
import java.util.Map;

public class PokemonManager {
    private PokemonBook pokemonBook;
    private Pocket pocket;
    private LevelCalculator lc;
    private PokemonDataManager pdm;

    public PokemonManager(Pocket pocket) {
        this.pokemonBook = new PokemonBook();
        this.pocket = pocket;
        this.lc = new LevelCalculator();
        this.pdm = new PokemonDataManager();
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
}
