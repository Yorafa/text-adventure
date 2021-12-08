package usecase_battle;

import entity.Pokemon;

import java.util.Random;

public class BattleManager {
    private final Pokemon p1;
    private final Pokemon p2;
    private boolean hasCounterattackP1;
    private boolean hasCounterattackP2;
    private IBattlePresenter presenter;
    private BattleAction battleAction;
    private boolean battling;

    /**
     * Construct BattleManage, given them the given two pokemon p1, p2
     *
     * @param p1 Pokemon 1
     * @param p2 Pokemon 2
     *
     * The relative classes
     * @see IBattlePresenter
     * @see BattleAction
     */
    public BattleManager(Pokemon p1, Pokemon p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.hasCounterattackP1 = false;
        this.hasCounterattackP2 = false;
        this.battling = true;
    }

    /**
     * show two pokemon information in shell
     */
    public void printStatus() {
        presenter.printStatus(p1.getName(), p1.getLevel(), p1.getHitPoint(), p1.getMaxHitPoint());
        presenter.printStatus(p2.getName(), p2.getLevel(), p2.getHitPoint(), p2.getMaxHitPoint());
    }

    /**
     * do the attack action and update the relative information
     */
    public void attack() {
        opponentAction();
        battleAction.attack();
        boundHitPoint();
    }

    /**
     * do the defense action and update the relative information
     */
    public void defense() {
        opponentAction();
        battleAction.defense();
        boundHitPoint();
    }

    /**
     * do the heal action and update the relative information
     */
    public void heal() {
        opponentAction();
        battleAction.heal();
        boundHitPoint();
    }

    /**
     * do the attack action and update the relative information
     * @return true if and only if successful capture
     */
    public boolean capture() {
        opponentAction();
        boolean captured = battleAction.capture();
        boundHitPoint();
        return captured;
    }

    /**
     * the ai control of wild pokemon
     */
    private void opponentAction() {
        Random r = new Random();
        int i = r.nextInt(100);
        if (i < 70) {
            setBattleAction(new BattleActionWhenAttacked(this));
        } else {
            setBattleAction(new BattleActionWhenDefensed(this));
        }
    }

    /**
     * update two pokemon hit point
     */
    private void boundHitPoint() {
        boundHitPoint(p1);
        boundHitPoint(p2);
    }

    /**
     * update two pokemon hit point
     * @param pokemon pokemon should be updated
     */
    private void boundHitPoint(Pokemon pokemon) {
        pokemon.setHitPoint(Math.max(pokemon.getHitPoint(), 0));
        pokemon.setHitPoint(Math.min(pokemon.getHitPoint(), pokemon.getMaxHitPoint()));
    }

    /**
     * check if still battling
     * @return true if and only if one of pokemons has no hp
     */
    public boolean isBattling() {
        return battling && !(p2 == null || p1.getHitPoint() == 0 || p2.getHitPoint() == 0);
    }

    /**
     * change the battle state to false
     */
    public void endBattle() {
        battling = false;
    }

    /**
     * call presenter to show the result of this battle
     */
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

    /**
     * the getter method for pokemon 1 name
     * @return pokemon 1 name
     */
    public String getP1Name() {
        return p1.getName();
    }

    /**
     * the getter method for pokemon 2 name
     * @return pokemon 2's name
     */
    public String getP2Name() {
        return p2.getName();
    }

    /**
     * the getter method of p1
     * @return Pokemon 1
     */
    public Pokemon getP1() {
        return p1;
    }

    /**
     * the getter method of p2
     * @return Pokemon 2
     */
    public Pokemon getP2() {
        return p2;
    }

    /**
     * the getter method of hasCounterattackP1
     * @return if pokemon 1 counter-attack
     */
    public boolean hasCounterattackP1() {
        return hasCounterattackP1;
    }

    /**
     * the setter method of hasCounterattackP1
     * @param hasCounterattackP1 if pokemon 1 counter-attack
     */
    public void setHasCounterattackP1(boolean hasCounterattackP1) {
        this.hasCounterattackP1 = hasCounterattackP1;
    }

    /**
     * the getter method of hasCounterattackP2
     * @return if pokemon 2 has counter-attack
     */
    public boolean hasCounterattackP2() {
        return hasCounterattackP2;
    }

    /**
     * the setter method of hasCounterattackP2
     * @param hasCounterattackP2  if pokemon 2 counter-attack
     */
    public void setHasCounterattackP2(boolean hasCounterattackP2) {
        this.hasCounterattackP2 = hasCounterattackP2;
    }

    /**
     * the getter method of presenter
     * @return the current presenter
     */
    public IBattlePresenter getPresenter() {
        return presenter;
    }

    /**
     * the setter method of presenter
     * @param presenter the respective presenter of panel to show information on shell
     */
    public void setPresenter(IBattlePresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * the setter method of battleAction
     * @param battleAction the battle action that player choose
     */
    private void setBattleAction(BattleAction battleAction) {
        this.battleAction = battleAction;
    }
}