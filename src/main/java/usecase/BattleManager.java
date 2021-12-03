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
    private boolean hasCounterattackP1;
    private boolean hasCounterattackP2;
    private boolean battling;

    public BattleManager(List<Pokemon> battlePokemons, Pokemon p2) {
        this.battlePokemons = battlePokemons;
        this.p1 = battlePokemons.get(0);
        this.p2 = p2;
        this.hasDefenseP1 = false;
        this.hasDefenseP2 = false;
        this.hasCounterattackP1 = false;
        this.hasCounterattackP2 = false;
        this.battling = (p2 != null);
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
        if (hasDefenseP2) {
            hasCounterattackP2 = true;
        }
        int damage = attack(p1, hasCounterattackP1, p2, hasDefenseP2);
        hasCounterattackP1 = false;
        return damage;
    }

    public void defense() {
        this.hasDefenseP1 = true;
    }

    private int attack(Pokemon attacker, boolean hasCounterattack, Pokemon attackee, boolean hasDefense) {
        DamageCalculator damageCalculator = new DamageCalculator();
        int attackPoint = attacker.getAttackPoint();
        if (hasCounterattack) {
            attackPoint *= 2;
        }
        int defencePoint = attackee.getDefencePoint();
        if (hasDefense) {
            defencePoint *= 2;
        }
        int damage = damageCalculator.calculate(attackPoint, defencePoint);
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
        } else if (speedP1 > speedP2) {
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
            if (hasDefenseP1) {
                hasCounterattackP1 = true;
            }
            int damage = attack(p2, hasCounterattackP2, p1, hasDefenseP1);
            hasCounterattackP2 = false;
            message = getP2Name() + " attacked. " + getP2Name() + " made " + damage + " damage to you.";
        } else {
            hasDefenseP2 = true;
            message = getP2Name() + " defended.";
        }
        return message;
    }

    public Pokemon getOpponent() {
        return this.p2;
    }

    public boolean isBattling() {
        if (p2.getHitPoint() == 0) {
            battling = false;
        }
        boolean notAllDead = false;
        for (Pokemon pokemon : battlePokemons) {
            if (pokemon.getHitPoint() != 0) {
                notAllDead = true;
            }
        }
        battling = battling && notAllDead;
        return battling;
    }

    public void endBattle() {
        this.battling = false;
    }

    public boolean youLose() {
        boolean notAllDead = false;
        for (Pokemon pokemon : battlePokemons) {
            if (pokemon.getHitPoint() != 0) {
                notAllDead = true;
            }
        }
        return !isBattling() && !notAllDead;
    }

    public boolean youWin() {
        return !isBattling() && p2.getHitPoint() == 0;
    }
}
