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
        int maxHitPoint = leveledPoint(basePokemonData.getMaxHitPoint(), level);
        int attackPoint = leveledPoint(basePokemonData.getAttackPoint(), level);
        int defencePoint = leveledPoint(basePokemonData.getDefencePoint(), level);
        int speed = leveledPoint(basePokemonData.getSpeed(), level);
        return new PokemonData(basePokemonData.getPokemonType(), maxHitPoint, attackPoint, defencePoint, speed);
    }

    public void update(PokemonData pokemonData, BasePokemonData basePokemonData, int level) {
        pokemonData.setMaxHitPoint(leveledPoint(basePokemonData.getMaxHitPoint(), level));
        pokemonData.setAttackPoint(leveledPoint(basePokemonData.getAttackPoint(), level));
        pokemonData.setDefencePoint(leveledPoint(basePokemonData.getDefencePoint(), level));
        pokemonData.setSpeed(leveledPoint(basePokemonData.getSpeed(), level));
    }

    private int leveledPoint(int basePoint, int level) {
        return (int) Math.round(basePoint * (0.1 * (level - 1)) + 1);
    }
}
