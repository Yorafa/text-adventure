package usecase_pokemon;


import entity.BasePokemon;
import entity.Pokemon;
import entity.PokemonData;

public class PokemonFactory {
    /**
     * @param basePokemon     the basic info of a pokemon at its level 1
     * @param experiencePoint the given exp that the pokemon will have
     * @param currentHitPoint the given HP that the pokemon will have
     * @return new Pokmeon consist by basePokemon, experiencePoint and experiencePoint
     * @see BasePokemon
     * @see LevelCalculator
     * @see PokemonDataManager
     * @see Pokemon
     * @see PokemonData
     */
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