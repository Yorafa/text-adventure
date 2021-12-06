package entity;

import java.io.Serializable;
import java.util.Objects;

public class Pokemon extends BasePokemon implements Serializable {
    private int level;
    private int experiencePoint;
    private int hitPoint;
    private PokemonData pokemonData;

    public Pokemon(String name, BasePokemonData basePokemonData, int level, int experiencePoint, int hitPoint,
                   PokemonData pokemonData) {
        super(name, basePokemonData);
        this.level = level;
        this.experiencePoint = experiencePoint;
        this.hitPoint = hitPoint;
        this.pokemonData = pokemonData;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperiencePoint() {
        return experiencePoint;
    }

    public void setExperiencePoint(int experiencePoint) {
        this.experiencePoint = experiencePoint;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public PokemonData getPokemonData() {
        return pokemonData;
    }

    public void setPokemonData(PokemonData pokemonData) {
        this.pokemonData = pokemonData;
    }

    @Override
    public int getMaxHitPoint() {
        return pokemonData.getMaxHitPoint();
    }

    @Override
    public int getAttackPoint() {
        return pokemonData.getAttackPoint();
    }

    @Override
    public int getDefencePoint() {
        return pokemonData.getDefencePoint();
    }

    @Override
    public int getSpeed() {
        return pokemonData.getSpeed();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pokemon pokemon = (Pokemon) o;
        return getLevel() == pokemon.getLevel() && getExperiencePoint() == pokemon.getExperiencePoint() && getHitPoint() == pokemon.getHitPoint() && Objects.equals(getPokemonData(), pokemon.getPokemonData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getLevel(), getExperiencePoint(), getHitPoint(), getPokemonData());
    }
}