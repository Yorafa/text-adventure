package entity;

import java.io.Serializable;

public class PokemonData extends BasePokemonData implements Serializable {

    /**
     * Construct a PokemonData, given them the given pokemonType, maxHitPoint,
     * attackPoint, defencePoint and speed.
     *
     * @param pokemonType  the enum pokemonType, the type of pokemon
     * @param maxHitPoint  the updatable max HP of a pokemon
     * @param attackPoint  the updatable attack point of a pokemon
     * @param defencePoint the updatable defence point of a pokemon
     * @param speed        the updatable speed of a pokemon
     *                     <p>
     *                     The relative classes
     * @see PokemonType
     */

    public PokemonData(PokemonType pokemonType, int maxHitPoint, int attackPoint, int defencePoint, int speed) {
        super(pokemonType, maxHitPoint, attackPoint, defencePoint, speed);
    }

    public void setMaxHitPoint(int maxHitPoint) {
        this.maxHitPoint = maxHitPoint;
    }

    public void setAttackPoint(int attackPoint) {
        this.attackPoint = attackPoint;
    }

    public void setDefencePoint(int defencePoint) {
        this.defencePoint = defencePoint;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
