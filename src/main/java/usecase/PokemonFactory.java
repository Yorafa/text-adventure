package usecase;

import entity.*;

public class PokemonFactory {
    public Pokemon getPokemon(BasePokemon basePokemon, int experiencePoint, int currentHitPoint) {
        LevelCalculator lc = new LevelCalculator();
        PokemonDataManager pdm = new PokemonDataManager();

        int level = lc.calculate(experiencePoint);
        PokemonData pokemonData = pdm.create(basePokemon.getBasePokemonData(), level);
        return new Pokemon(basePokemon.getName(), basePokemon.getBasePokemonData(), level, experiencePoint,
                currentHitPoint, pokemonData);
    }
}
