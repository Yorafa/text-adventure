package entity;

import java.io.Serializable;
import java.util.Objects;

public class BasePokemon implements Serializable {
    protected String name;
    protected BasePokemonData basePokemonData;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasePokemon that = (BasePokemon) o;
        return getName().equals(that.getName()) && getBasePokemonData().equals(that.getBasePokemonData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBasePokemonData());
    }
}

