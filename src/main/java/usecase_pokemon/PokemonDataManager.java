package usecase_pokemon;

import entity.BasePokemonData;
import entity.PokemonData;

public class PokemonDataManager {
    /**
     *
     * @param basePokemonData the basic data of a pokemon at level 1
     * @param level the level of a pokemon
     * @return data of pokemon update by level through basic data
     *
     * @see PokemonData
     */
    public PokemonData create(BasePokemonData basePokemonData, int level) {
        LeveledDataCalculator leveledDataCalculator = new LeveledDataCalculator();
        int maxHitPoint = leveledDataCalculator.calculate(basePokemonData.getMaxHitPoint(), level);
        int attackPoint = leveledDataCalculator.calculate(basePokemonData.getAttackPoint(), level);
        int defencePoint = leveledDataCalculator.calculate(basePokemonData.getDefencePoint(), level);
        int speed = leveledDataCalculator.calculate(basePokemonData.getSpeed(), level);
        return new PokemonData(basePokemonData.getPokemonType(), maxHitPoint, attackPoint, defencePoint, speed);
    }

    /**
     * update the pokemonData by level and basePokemonData
     * @param pokemonData the current data of pokemon
     * @param basePokemonData the base data of pokemon
     * @param level the current level of pokemon
     */
    public void update(PokemonData pokemonData, BasePokemonData basePokemonData, int level) {
        LeveledDataCalculator leveledDataCalculator = new LeveledDataCalculator();
        pokemonData.setMaxHitPoint(leveledDataCalculator.calculate(basePokemonData.getMaxHitPoint(), level));
        pokemonData.setAttackPoint(leveledDataCalculator.calculate(basePokemonData.getAttackPoint(), level));
        pokemonData.setDefencePoint(leveledDataCalculator.calculate(basePokemonData.getDefencePoint(), level));
        pokemonData.setSpeed(leveledDataCalculator.calculate(basePokemonData.getSpeed(), level));
    }
}
