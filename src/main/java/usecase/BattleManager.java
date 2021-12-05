package usecase;

import entity.Pokemon;

import java.util.Random;

public class BattleManager {
    private Pokemon p1;
    private Pokemon p2;
    private boolean hasCounterattackP1;
    private boolean hasCounterattackP2;
    private IBattlePresenter presenter;
    private BattleAction battleAction;

    public BattleManager(Pokemon p1, Pokemon p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.hasCounterattackP1 = false;
        this.hasCounterattackP2 = false;
    }

    public void setPresenter(IBattlePresenter presenter) {
        this.presenter = presenter;
    }

    public void printStatus() {
        presenter.printStatus(p1.getName(), p1.getLevel(), p1.getHitPoint(), p1.getMaxHitPoint());
        presenter.printStatus(p2.getName(), p2.getLevel(), p2.getHitPoint(), p2.getMaxHitPoint());
    }

    public void attack() {
        opponentAction();
        battleAction.attack();
        boundHitPoint();
    }

    public void defense() {
        opponentAction();
        battleAction.defense();
        boundHitPoint();
    }

    public void heal() {
        opponentAction();
        battleAction.heal();
        boundHitPoint();
    }

    public boolean capture() {
        opponentAction();
        boolean captured = battleAction.capture();
        boundHitPoint();
        return captured;
    }

    public void opponentAction() {
        Random r = new Random();
        int i = r.nextInt(100);
        if (i < 50) {
            setBattleAction(new BattleActionWhenAttacked(this));
        } else {
            setBattleAction(new BattleActionWhenDefensed(this));
        }
    }

    private void boundHitPoint() {
        boundHitPoint(p1);
        boundHitPoint(p2);
    }

    private void boundHitPoint(Pokemon pokemon) {
        pokemon.setHitPoint(Math.max(pokemon.getHitPoint(), 0));
        pokemon.setHitPoint(Math.min(pokemon.getHitPoint(), pokemon.getMaxHitPoint()));
    }

    public boolean isBattling() {
        return !(p2 == null || p1.getHitPoint() == 0 || p2.getHitPoint() == 0);
    }

    public void endBattle() {
        p2 = null;
    }

    public void printBattleResult() {
        presenter.printBattleEnded();
        if (p2 != null) {
            if (p1.getHitPoint() == 0 && p2.getHitPoint() == 0) {
                presenter.printDraw();
            } else if (p1.getHitPoint() == 0) {
                presenter.printLose();
            } else if (p2.getHitPoint() == 0) {
                presenter.printWin();
            }
        }
    }

    public String getP1Name() {
        return p1.getName();
    }

    public String getP2Name() {
        return p2.getName();
    }

    public Pokemon getP1() {
        return p1;
    }

    public void setP1(Pokemon p1) {
        this.p1 = p1;
    }

    public Pokemon getP2() {
        return p2;
    }

    public void setP2(Pokemon p2) {
        this.p2 = p2;
    }

    public boolean isHasCounterattackP1() {
        return hasCounterattackP1;
    }

    public void setHasCounterattackP1(boolean hasCounterattackP1) {
        this.hasCounterattackP1 = hasCounterattackP1;
    }

    public boolean isHasCounterattackP2() {
        return hasCounterattackP2;
    }

    public void setHasCounterattackP2(boolean hasCounterattackP2) {
        this.hasCounterattackP2 = hasCounterattackP2;
    }

    public IBattlePresenter getPresenter() {
        return presenter;
    }

    public void setBattleAction(BattleAction battleAction) {
        this.battleAction = battleAction;
    }
}
