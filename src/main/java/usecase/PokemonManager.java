package usecase;

import entity.BasePokemon;
import entity.Pokemon;

import java.util.List;
import java.util.Map;

public class PokemonManager {
    private LevelCalculator lc;
    private PokemonDataManager pdm;

    public PokemonManager(LevelCalculator lc, PokemonDataManager pdm) {
        this.lc = lc;
        this.pdm = pdm;
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
}
