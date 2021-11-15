package usecase;

import entity.Pokemon;

import java.util.List;
import java.util.Random;

public class BattleManager {
    private List<Pokemon> battlePokemons;
    private Pokemon p1;
    private Pokemon p2;
    private boolean hasDefenseP1;
    private boolean hasDefenseP2;
    private boolean battling;

    public BattleManager(List<Pokemon> battlePokemons, Pokemon p2) {
        this.battlePokemons = battlePokemons;
        this.p1 = battlePokemons.get(0);
        this.p2 = p2;
        this.hasDefenseP1 = false;
        this.hasDefenseP2 = false;
        this.battling = true;
    }

    public String getP1Name() {
        return p1.getName();
    }

    public String getP2Name() {
        return p2.getName();
    }

    public List<Pokemon> getBattlePokemons() {
        return battlePokemons;
    }

    public int attack() {
        this.hasDefenseP1 = false;
        return attack(p1, p2, hasDefenseP2);
    }

    public void defense() {
        this.hasDefenseP1 = true;
    }

    private int attack(Pokemon attacker, Pokemon attackee, boolean haveDefense) {
        DamageCalculator damageCalculator = new DamageCalculator();
        int damage = damageCalculator.calculate(attacker, attackee, haveDefense);
        attackee.setHitPoint(Math.max(attackee.getHitPoint() - damage, 0));
        return damage;
    }

    public boolean capture() {
        this.hasDefenseP1 = false;
        Random r = new Random();
        double d = r.nextDouble();
        double percentHitPoint = (double) p2.getHitPoint() / p2.getMaxHitPoint();
        double threshold = 1 - 0.8 * percentHitPoint;
        return d < threshold;
    }

    public void changePokemon(Pokemon pokemon) {
        this.hasDefenseP1 = false;
        this.p1 = pokemon;
    }

    public boolean isFaster() {
        int speedP1 = p1.getSpeed();
        int speedP2 = p2.getSpeed();
        if (speedP1 < speedP2) {
            return false;
        } else if (speedP1 < speedP2) {
            return true;
        } else {
            Random r = new Random();
            return r.nextBoolean();
        }
    }

    public String opponentAction() {
        this.hasDefenseP2 = false;
        String message;
        Random r = new Random();
        int i = r.nextInt(100);
        if (i < 70) {
            int damage = attack(p2, p1, hasDefenseP1);
            message = getP2Name() + " made " + damage + " damage to " + getP1Name() + ".";
        } else {
            hasDefenseP2 = true;
            message = getP2Name() + "defended.";
        }
        return message;
    }

    public Pokemon getOpponent() {
        return this.p2;
    }

    public boolean isBattling() {
        endBattle();
        if (p2.getHitPoint() != 0) {
            battling = true;
        }
        for (Pokemon pokemon : battlePokemons) {
            if (pokemon.getHitPoint() != 0) {
                battling = true;
            }
        }
        return battling;
    }

    public void endBattle() {
        this.battling = false;
    }
}
