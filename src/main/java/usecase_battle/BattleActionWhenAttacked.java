package usecase_battle;

import entity.Pokemon;

public class BattleActionWhenAttacked implements BattleAction {
    private final BattleManager battleManager;
    private final Pokemon p1;
    private final Pokemon p2;
    private final boolean hasCounterattackP1;
    private final boolean hasCounterattackP2;
    private final IBattlePresenter presenter;

    /**
     * Construct BattleActionWhenAttacked, given them the given battleManager
     * @param battleManager the manager of battle
     *
     * @see BattleManager
     * @see Pokemon
     * @see BattleAction
     * @see IBattlePresenter
     */
    public BattleActionWhenAttacked(BattleManager battleManager) {
        this.battleManager = battleManager;
        this.p1 = battleManager.getP1();
        this.p2 = battleManager.getP2();
        this.hasCounterattackP1 = battleManager.hasCounterattackP1();
        this.hasCounterattackP2 = battleManager.hasCounterattackP2();
        this.presenter = battleManager.getPresenter();
    }

    /**
     * execute the attack action, call class DamageCalculator to calculate damage,
     * call presenter to show the attack action
     */
    @Override
    public void attack() {
        DamageCalculator damageCalculator = new DamageCalculator();
        damageCalculator.setHasCounterattack(hasCounterattackP1);
        int damageByP1 = damageCalculator.calculate(p1.getAttackPoint(), p2.getDefencePoint());
        damageCalculator.setHasCounterattack(hasCounterattackP2);
        int damageByP2 = damageCalculator.calculate(p2.getAttackPoint(), p1.getDefencePoint());
        p1.setHitPoint(p1.getHitPoint() - damageByP2);
        p2.setHitPoint(p2.getHitPoint() - damageByP1);
        battleManager.setHasCounterattackP1(false);
        battleManager.setHasCounterattackP2(false);
        presenter.printAttack(p1.getName(), p2.getName(), damageByP1);
        presenter.printAttack(p2.getName(), p1.getName(), damageByP2);
    }

    /**
     * execute the defense action, call class DamageCalculator to calculate damage,
     * call presenter to show the defense action
     */
    @Override
    public void defense() {
        DamageCalculator damageCalculator = new DamageCalculator();
        damageCalculator.setHasCounterattack(hasCounterattackP2);
        damageCalculator.setHasDefense(true);
        int damageByP2 = damageCalculator.calculate(p2.getAttackPoint(), p1.getDefencePoint());
        p1.setHitPoint(p1.getHitPoint() - damageByP2);
        battleManager.setHasCounterattackP1(true);
        battleManager.setHasCounterattackP2(false);
        presenter.printDefense(p1.getName());
        presenter.printDefenseSucceed(p1.getName());
        presenter.printAttack(p2.getName(), p1.getName(), damageByP2);
    }

    /**
     * execute the heal action, call class DamageCalculator to calculate damage,
     * call HealCalculator to calculate value of healing
     * call presenter to show the heal action
     */
    @Override
    public void heal() {
        DamageCalculator damageCalculator = new DamageCalculator();
        HealCalculator healCalculator = new HealCalculator();
        damageCalculator.setHasCounterattack(hasCounterattackP2);
        int damageByP2 = damageCalculator.calculate(p2.getAttackPoint(), p1.getDefencePoint());
        int healedPoint = healCalculator.calculate(p1.getMaxHitPoint());
        p1.setHitPoint(p1.getHitPoint() - damageByP2 + healedPoint);
        battleManager.setHasCounterattackP2(false);
        presenter.printHeal(p1.getName(), healedPoint);
        presenter.printAttack(p2.getName(), p1.getName(), damageByP2);
    }

    /**
     * execute the capture action, call class CaptureCalculator to calculate if captured,
     * call presenter to show the capture action
     * @return true if successfully capture, false fail in capturing
     */
    @Override
    public boolean capture() {
        CaptureCalculator captureCalculator = new CaptureCalculator();
        boolean captured = captureCalculator.calculate(p2.getHitPoint(), p2.getMaxHitPoint());
        if (captured) {
            presenter.printCaptured(p2.getName());
        } else {
            DamageCalculator damageCalculator = new DamageCalculator();
            damageCalculator.setHasCounterattack(hasCounterattackP2);
            int damageByP2 = damageCalculator.calculate(p2.getAttackPoint(), p1.getDefencePoint());
            p1.setHitPoint(p1.getHitPoint() - damageByP2);
            presenter.printNotCaptured(p2.getName());
            presenter.printAttack(p2.getName(), p1.getName(), damageByP2);
        }
        battleManager.setHasCounterattackP2(false);
        return captured;
    }
}