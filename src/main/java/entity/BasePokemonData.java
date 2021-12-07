package entity;

import java.io.Serializable;

/**
 * The template data at level 1
 */
public class BasePokemonData implements Serializable {
    protected PokemonType pokemonType;
    protected int maxHitPoint;
    protected int attackPoint;
    protected int defencePoint;
    protected int speed;

    /**
     * Construct a BasePokemon, giving them the
     * given pokemonType, maxHitPoint, attackPoint, defencePoint and speed.
     *
     * @param pokemonType enum value of the enum class PokemonType
     * @param maxHitPoint  the basic max HP / the max HP at level 1
     * @param attackPoint  the attack at level 1
     * @param defencePoint  the defence at level 1
     * @param speed  the speed at level 1
     *
     * The relative classes
     * @see PokemonType
     */
    public BasePokemonData(PokemonType pokemonType, int maxHitPoint, int attackPoint, int defencePoint, int speed) {
        this.pokemonType = pokemonType;
        this.maxHitPoint = maxHitPoint;
        this.attackPoint = attackPoint;
        this.defencePoint = defencePoint;
        this.speed = speed;
    }

    /**
     * the getter method of pokemonType
     *
     * @return the type of pokemon
     */
    public PokemonType getPokemonType() {
        return pokemonType;
    }

    /**
     * the getter method of maxHitPoint
     *
     * @return the maxHitPoint of pokemon
     */
    public int getMaxHitPoint() {
        return maxHitPoint;
    }

    /**
     * the getter method of attackPoint
     *
     * @return the attackPoint of pokemon
     */
    public int getAttackPoint() {
        return attackPoint;
    }

    /**
     * the getter method of defencePoint
     *
     * @return the defencePoint of pokemon
     */
    public int getDefencePoint() {
        return defencePoint;
    }

    /**
     * the getter method of speed
     *
     * @return the speed of pokemon
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param o the object that use compare
     * @return true if the object share exact the same as this
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        BasePokemonData pd = (BasePokemonData) o;
        return pd.getMaxHitPoint() == this.maxHitPoint
                && pd.getAttackPoint() == this.attackPoint
                && pd.getDefencePoint() == this.defencePoint
                && pd.getSpeed() == this.speed;
    }
}
