package entity;

import java.io.Serializable;

public class PokemonData extends BasePokemonData implements Serializable {

    public PokemonData(PokemonType pokemonType, int maxHitPoint, int attackPoint, int defencePoint, int speed) {
        super(pokemonType, maxHitPoint, attackPoint, defencePoint, speed);
    }

    public void setMaxHitPoint(int maxHitPoint) {
        this.maxHitPoint = maxHitPoint;
    }

    public void setAttackPoint(int attackPoint) {
        this.attackPoint = attackPoint;
    }

    public void setDefencePoint(int defencePoint) {
        this.defencePoint = defencePoint;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
