package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * The main entity that describe Pokemon
 */
public class Pokemon extends BasePokemon implements Serializable {
    private int level;
    private int experiencePoint;
    private int hitPoint;
    private PokemonData pokemonData;

    /**
     * Construct a Pokemon, given them the given name, basePokemonData, level,
     * experiencePoint, hitPoint and pokemonData
     *
     * @param name            the name of pokemon which is the same as its basic version
     * @param basePokemonData the data of this pokemon at level 1
     * @param level           the level of this pokemon
     * @param experiencePoint the experience point of this pokemon will be used to update level
     * @param hitPoint        the current HP of this pokemon
     * @param pokemonData     the current data of this pokemon which update based on basePokemonData
     *                        <p>
     *                        The relative classes
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

    /**
     * the getter method of level
     *
     * @return the level of pokemon
     */
    public int getLevel() {
        return level;
    }

    /**
     * the setter method of level
     *
     * @param level the level of pokemon
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * the getter method of experiencePoint
     *
     * @return the experiencePoint of pokemon
     */
    public int getExperiencePoint() {
        return experiencePoint;
    }

    /**
     * the setter method of experiencePoint
     *
     * @param experiencePoint the new experiencePoint for pokemon
     */
    public void setExperiencePoint(int experiencePoint) {
        this.experiencePoint = experiencePoint;
    }

    /**
     * the getter method of hitPoint
     *
     * @return current hit point of pokemon
     */
    public int getHitPoint() {
        return hitPoint;
    }

    /**
     * the setter method of hitPoint
     *
     * @param hitPoint updated hit point of pokemon
     */
    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    /**
     * the getter method of pokemonData
     *
     * @return current pokemon data
     */
    public PokemonData getPokemonData() {
        return pokemonData;
    }

    /**
     * the setter method of pokemonData
     *
     * @param pokemonData the updated pokemon data
     */
    public void setPokemonData(PokemonData pokemonData) {
        this.pokemonData = pokemonData;
    }

    /**
     * the getter method of MaxHitPoint
     *
     * @return the max hit point of pokemon from its pokemonData
     */
    @Override
    public int getMaxHitPoint() {
        return pokemonData.getMaxHitPoint();
    }

    /**
     * the getter method of AttackPoint
     *
     * @return the attack point of pokemon from its pokemonData
     */
    @Override
    public int getAttackPoint() {
        return pokemonData.getAttackPoint();
    }

    /**
     * the getter method of DefencePoint
     *
     * @return the defence point of pokemon from its pokemonData
     */
    @Override
    public int getDefencePoint() {
        return pokemonData.getDefencePoint();
    }

    /**
     * the getter method of Speed
     *
     * @return the speed of pokemon from its pokemonData
     */
    @Override
    public int getSpeed() {
        return pokemonData.getSpeed();
    }

    /**
     * the toString method
     *
     * @return pokemon name as its presenter
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * the hashcode method
     *
     * @return hashCode of this Pokemon
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getLevel(), getExperiencePoint(), getHitPoint(), getPokemonData());
    }
}