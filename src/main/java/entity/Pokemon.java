package entity;

import java.io.Serializable;

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
}