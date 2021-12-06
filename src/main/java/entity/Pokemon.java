package entity;

import java.io.Serializable;
import java.util.Objects;

public class Pokemon extends BasePokemon implements Serializable {
    private int level;
    private int experiencePoint;
    private int hitPoint;
    private PokemonData pokemonData;

    /**
     * Construct a Pokemon, given them the given name, basePokemonData, level,
     * experiencePoint, hitPoint and pokemonData
     * @param name the name of pokemon which is the same as its basic version
     * @param basePokemonData the data of this pokemon at level 1
     * @param level the level of this pokemon
     * @param experiencePoint the experience point of this pokemon will be used to update level
     * @param hitPoint the current HP of this pokemon
     * @param pokemonData the current data of this pokemon which update based on basePokemonData
     *
     * The relative classes
     * @see BasePokemon
     * @see BasePokemonData
     * @see PokemonData
     */

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

    /**
     * @inheritDoc override the equal method to avoid conflict of pokemons
     * @param o the object used to compare
     * @return true if the o has exactly the same data of this pokemon
     */
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