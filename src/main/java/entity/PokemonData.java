package entity;

import java.io.Serializable;

/**
 * updatable data of pokemon
 */
public class PokemonData extends BasePokemonData implements Serializable {

    /**
     * Construct a PokemonData, given them the given pokemonType, maxHitPoint,
     * attackPoint, defencePoint and speed.
     *
     * @param pokemonType the enum pokemonType, the type of pokemon
     * @param maxHitPoint the updatable max HP of a pokemon
     * @param attackPoint the updatable attack point of a pokemon
     * @param defencePoint the updatable defence point of a pokemon
     * @param speed the updatable speed of a pokemon
     *
     * The relative classes
     * @see PokemonType
     */
    public PokemonData(PokemonType pokemonType, int maxHitPoint, int attackPoint, int defencePoint, int speed) {
        super(pokemonType, maxHitPoint, attackPoint, defencePoint, speed);
    }

    /**
     * the setter method of maxHitPoint
     * @param maxHitPoint new maxHitPoint of pokemon
     */
    public void setMaxHitPoint(int maxHitPoint) {
        this.maxHitPoint = maxHitPoint;
    }

    /**
     * the setter method of attackPoint
     * @param attackPoint new attackPoint of pokemon
     */
    public void setAttackPoint(int attackPoint) {
        this.attackPoint = attackPoint;
    }

    /**
     * the setter method of defencePoint
     * @param defencePoint new defencePoint of pokemon
     */
    public void setDefencePoint(int defencePoint) {
        this.defencePoint = defencePoint;
    }

    /**
     * the setter method of speed
     * @param speed new speed of pokemon
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
