package usecase;

import entity.*;

public class PokemonFactory {
    public Pokemon getPokemon(BasePokemon basePokemon, int experiencePoint, int currentHitPoint) {
        LevelCalculator lc = new LevelCalculator();
        PokemonDataManager pdm = new PokemonDataManager();

        int level = lc.calculateLevel(experiencePoint);
        PokemonData pokemonData = pdm.create(basePokemon.getBasePokemonData(), level);
        return new Pokemon(basePokemon.getName(), basePokemon.getBasePokemonData(), level, experiencePoint,
                currentHitPoint, pokemonData);
    }

    public Pokemon getPokemon(BasePokemon basePokemon, int level) {
        LevelCalculator lc = new LevelCalculator();
        int experiencePoint = lc.calculateExperiencePoint(level);
        Pokemon pokemon = getPokemon(basePokemon, experiencePoint, 0);
        pokemon.setHitPoint(pokemon.getMaxHitPoint());
        return pokemon;
    }
}