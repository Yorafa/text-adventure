package presenter;

import usecase_battle.IBattlePresenter;

public class BattlePresenter extends Presenter implements IBattlePresenter {

    public void addAttack() {
        addToQueue("Attack");
    }

    public void addDefense() {
        addToQueue("Defense");
    }

    public void addHeal() {
        addToQueue("Heal");
    }

    public void addCapture() {
        addToQueue("Capture");
    }

    public void addEscape() {
        addToQueue("Escape");
    }

    public void printEscaped() {
        System.out.println("You escaped.");
    }

    public void printGainExperiencePoint(String name, int experiencePointGained) {
        System.out.println(name + " gained " + experiencePointGained + " experience points.");
    }

    @Override
    public void printStatus(String name, int level, int hitPoint, int maxHitPoint) {
        System.out.printf("%-20s%-20s%-20s%n", name, "Level: " + level, "Hit Point: " + hitPoint + "/" + maxHitPoint);
    }

    @Override
    public void printAttack(String attacker, String attacked, int damage) {
        System.out.println(attacker + " attacked " + attacked + ", and made " + damage + " damage.");
    }

    @Override
    public void printDefense(String name) {
        System.out.print(name + " is defending. ");
    }

    @Override
    public void printDefenseSucceed(String name) {
        System.out.println(name + " successfully defended.");
    }

    @Override
    public void printDefenseFail(String name) {
        System.out.println(name + " defended nothing.");
    }

    @Override
    public void printHeal(String name, int healedPoint) {
        System.out.println(name + " healed, and gained " + healedPoint + " hit points.");
    }

    @Override
    public void printCaptured(String name) {
        System.out.println("You captured " + name + ".");
    }

    @Override
    public void printNotCaptured(String name) {
        System.out.println("You did not capture " + name + ".");
    }

    @Override
    public void printBattleEnded() {
        System.out.println("The battle is ended.");
    }

    @Override
    public void printDraw() {
        System.out.println("This is a draw.");
    }

    @Override
    public void printLose() {
        System.out.println("You lose.");
    }

    @Override
    public void printWin() {
        System.out.println("You win.");
    }
}