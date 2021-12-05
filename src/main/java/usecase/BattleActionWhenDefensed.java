package usecase;

import entity.Pokemon;

public class BattleActionWhenDefensed implements BattleAction {
    private BattleManager battleManager;
    private Pokemon p1;
    private Pokemon p2;
    private boolean hasCounterattackP1;
    private IBattlePresenter presenter;

    public BattleActionWhenDefensed(BattleManager battleManager) {
        this.battleManager = battleManager;
        this.p1 = battleManager.getP1();
        this.p2 = battleManager.getP2();
        this.hasCounterattackP1 = battleManager.isHasCounterattackP1();
        this.presenter = battleManager.getPresenter();
    }

    @Override
    public void attack() {
        DamageCalculator damageCalculator = new DamageCalculator();
        damageCalculator.setHasCounterattack(hasCounterattackP1);
        damageCalculator.setHasDefense(true);
        int damageByP1 = damageCalculator.calculate(p1.getAttackPoint(), p2.getDefencePoint());
        p2.setHitPoint(p2.getHitPoint() - damageByP1);
        battleManager.setHasCounterattackP1(false);
        battleManager.setHasCounterattackP2(true);
        presenter.printAttack(p1.getName(), p2.getName(), damageByP1);
        presenter.printDefense(p2.getName());
        presenter.printDefenseSucceed(p2.getName());
    }

    @Override
    public void defense() {
        presenter.printDefense(p1.getName());
        presenter.printDefenseFail(p1.getName());
        presenter.printDefense(p2.getName());
        presenter.printDefenseFail(p2.getName());
    }

    @Override
    public void heal() {
        HealCalculator healCalculator = new HealCalculator();
        int healedPoint = healCalculator.calculate(p1.getMaxHitPoint());
        p1.setHitPoint(p1.getHitPoint() + healedPoint);
        presenter.printHeal(p1.getName(), healedPoint);
        presenter.printDefense(p2.getName());
        presenter.printDefenseFail(p2.getName());
    }

    @Override
    public boolean capture() {
        CaptureCalculator captureCalculator = new CaptureCalculator();
        boolean captured = captureCalculator.calculate(p2.getHitPoint(), p2.getMaxHitPoint());
        if (captured) {
            presenter.printCaptured(p2.getName());
        } else {
            presenter.printNotCaptured(p2.getName());
            presenter.printDefense(p2.getName());
            presenter.printDefenseFail(p2.getName());
        }
        return captured;
    }
}