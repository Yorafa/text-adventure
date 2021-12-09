package entity;

import java.io.Serializable;

/**
 * The template information of a pokemon
 */
public class BasePokemon implements Serializable {
    protected String name;
    protected BasePokemonData basePokemonData;

    /**
     * Construct a BasePokemon, giving them the
     * given name and basePokemonData.
     *
     * @param name            BasePokemon's name
     * @param basePokemonData BasePokemon's data
     *
     * The relative classes
     * @see BasePokemonData
     */

    public BasePokemon(String name, BasePokemonData basePokemonData) {
        this.name = name;
        this.basePokemonData = basePokemonData;
    }

    /**
     * the getter method of name
     *
     * @return pokemon's name
     */
    public String getName() {
        return name;
    }

    /**
     * the getter method of basePokemonData
     *
     * @return the base pokemon data of this pokemon
     */
    public BasePokemonData getBasePokemonData() {
        return basePokemonData;
    }

    /**
     * the getter method of type from basePokemonData
     *
     * @return the type of this pokemon
     */
    public PokemonType getPokemonType() {
        return basePokemonData.getPokemonType();
    }

    /**
     * the getter method of MaxHitPoint from basePokemonData
     *
     * @return the MaxHitPoint of this pokemon
     */
    public int getMaxHitPoint() {
        return basePokemonData.getMaxHitPoint();
    }

    /**
     * the getter method of AttackPoint from basePokemonData
     *
     * @return the AttackPoint of this pokemon
     */
    public int getAttackPoint() {
        return basePokemonData.getAttackPoint();
    }

    /**
     * the getter method of DefencePoint from basePokemonData
     *
     * @return the DefencePoint of this pokemon
     */
    public int getDefencePoint() {
        return basePokemonData.getDefencePoint();
    }

    /**
     * the getter method of Speed from basePokemonData
     *
     * @return the Speed of this pokemon
     */
    public int getSpeed() {
        return basePokemonData.getSpeed();
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
        else {
            BasePokemon basepokemon = (BasePokemon) o;
            return this.getMaxHitPoint() == basepokemon.getMaxHitPoint()
                    && this.getAttackPoint() == basepokemon.getAttackPoint()
                    && this.getDefencePoint() == basepokemon.getDefencePoint()
                    && this.getSpeed() == basepokemon.getSpeed();
        }
    }
}

