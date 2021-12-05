package usecase;

public interface IBattlePresenter {
    void printStatus(String name, int level, int hitPoint, int maxHitPoint);

    void printAttack(String attacker, String attacked, int damage);

    void printDefense(String name);

    void printDefenseSucceed(String name);

    void printDefenseFail(String name);

    void printHeal(String nameP1, int healedPoint);

    void printCaptured(String name);

    void printNotCaptured(String name);

    void printBattleEnded();

    void printDraw();

    void printLose();

    void printWin();

}