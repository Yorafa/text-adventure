package entity;

import java.io.Serializable;

public class BasePokemonData implements Serializable {
    protected PokemonType pokemonType;
    protected int maxHitPoint;
    protected int attackPoint;
    protected int defencePoint;
    protected int speed;

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
