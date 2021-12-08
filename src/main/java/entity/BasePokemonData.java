package entity;

import java.io.Serializable;

public class BasePokemonData implements Serializable {
    protected final PokemonType pokemonType;
    protected int maxHitPoint;
    protected int attackPoint;
    protected int defencePoint;
    protected int speed;

    /**
     * Construct a BasePokemon, giving them the
     * given pokemonType, maxHitPoint, attackPoint, defencePoint and speed.
     *
     * @param pokemonType  enum value of the enum class PokemonType
     * @param maxHitPoint  the basic max HP / the max HP on level 1
     * @param attackPoint  the attack on level 1
     * @param defencePoint the defence on level 1
     * @param speed        the speed on level 1
     *                     <p>
     *                     The relative classes
     * @see PokemonType
     */

    public BasePokemonData(PokemonType pokemonType, int maxHitPoint, int attackPoint, int defencePoint, int speed) {
        this.pokemonType = pokemonType;
        this.maxHitPoint = maxHitPoint;
        this.attackPoint = attackPoint;
        this.defencePoint = defencePoint;
        this.speed = speed;
    }

    public PokemonType getPokemonType() {
        return pokemonType;
    }

    public int getMaxHitPoint() {
        return maxHitPoint;
    }

    public int getAttackPoint() {
        return attackPoint;
    }

    public int getDefencePoint() {
        return defencePoint;
    }

    public int getSpeed() {
        return speed;
    }
}
