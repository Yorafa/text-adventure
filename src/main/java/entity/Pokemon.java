package entity;

import java.io.Serializable;

public class Pokemon extends BasePokemon implements Serializable {
    private int experiencePoint;
    private int currentHitPoint;

    public Pokemon(String name, PokemonType type, int baseHitPoint, int baseAttackPoint, int baseDefencePoint,
                   int baseSpeed, int experiencePoint, int currentHitPoint) {
        super(name, type, baseHitPoint, baseAttackPoint, baseDefencePoint, baseSpeed);
        this.experiencePoint = experiencePoint;
        this.currentHitPoint = currentHitPoint;
    }

    public int getExperiencePoint() {
        return experiencePoint;
    }

    public int getCurrentHitPoint() {
        return currentHitPoint;
    }

    public void setExperiencePoint(int experiencePoint) {
        this.experiencePoint = experiencePoint;
    }

    public void setCurrentHitPoint(int currentHitPoint) {
        this.currentHitPoint = currentHitPoint;
    }

    public int getLevel(LevelCalculator lc) {
        return lc.calculate(experiencePoint);
    }
}