package entity;

import java.io.Serializable;

public class BasePokemon implements Serializable {
    protected String name;
    protected BasePokemonData basePokemonData;

    /**
     * Construct a BasePokemon, giving them the
     * given name and basePokemonData.
     *
     * @param name BasePokemon's name
     * @param basePokemonData  BasePokemon's data
     *
     * The relative classes
     * @see BasePokemonData
     */

    public BasePokemon(String name, BasePokemonData basePokemonData) {
        this.name = name;
        this.basePokemonData = basePokemonData;
    }

    public String getName() {
        return name;
    }

    public BasePokemonData getBasePokemonData() {
        return basePokemonData;
    }

    public PokemonType getPokemonType() {
        return basePokemonData.getPokemonType();
    }

    public int getMaxHitPoint() {
        return basePokemonData.getMaxHitPoint();
    }

    public int getAttackPoint() {
        return basePokemonData.getAttackPoint();
    }

    public int getDefencePoint() {
        return basePokemonData.getDefencePoint();
    }

    public int getSpeed() {
        return basePokemonData.getSpeed();
    }
}

