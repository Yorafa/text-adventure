package entity;

import java.io.Serializable;

public class BasePokemon implements Serializable {
    protected String name;
    protected PokemonType type;
    protected int baseHitPoint;
    protected int baseAttackPoint;
    protected int baseDefencePoint;
    protected int baseSpeed;

    public BasePokemon(String name, PokemonType type, int baseHitPoint, int baseAttackPoint, int baseDefencePoint,
                       int baseSpeed) {
        this.name = name;
        this.type = type;
        this.baseHitPoint = baseHitPoint;
        this.baseAttackPoint = baseAttackPoint;
        this.baseDefencePoint = baseDefencePoint;
        this.baseSpeed = baseSpeed;
    }

    public String getName() {
        return name;
    }

    public PokemonType getType() {
        return type;
    }

    public int getBaseHitPoint() {
        return baseHitPoint;
    }

    public int getBaseAttackPoint() {
        return baseAttackPoint;
    }

    public int getBaseDefencePoint() {
        return baseDefencePoint;
    }

    public int getBaseSpeed() {
        return baseSpeed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }

    public void setBaseHitPoint(int baseHitPoint) {
        this.baseHitPoint = baseHitPoint;
    }

    public void setBaseAttackPoint(int baseAttackPoint) {
        this.baseAttackPoint = baseAttackPoint;
    }

    public void setBaseDefencePoint(int baseDefencePoint) {
        this.baseDefencePoint = baseDefencePoint;
    }

    public void setBaseSpeed(int baseSpeed) {
        this.baseSpeed = baseSpeed;
    }

}

