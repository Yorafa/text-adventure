package presenter;

import usecase_battle.IBattlePresenter;

public class BattlePresenter extends Presenter implements IBattlePresenter {

    /**
     * add attack option
     */
    public void addAttack() {
        addToQueue("Attack");
    }

    /**
     * add defense option
     */
    public void addDefense() {
        addToQueue("Defense");
    }

    /**
     * add heal option
     */
    public void addHeal() {
        addToQueue("Heal");
    }

    /**
     * add capture option
     */
    public void addCapture() {
        addToQueue("Capture");
    }

    /**
     * add escape option
     */
    public void addEscape() {
        addToQueue("Escape");
    }

    /**
     * show pokemon status
     *
     * @param name        the name of pokemon
     * @param level       the level of pokemon
     * @param hitPoint    the current hit point of pokemon
     * @param maxHitPoint the max hit point of pokemon
     */
    @Override
    public void printStatus(String name, int level, int hitPoint, int maxHitPoint) {
        System.out.printf("%-20s%-20s%-20s%n", name, "Level: " + level, "Hit Point: " + hitPoint + "/" + maxHitPoint);
    }

    /**
     * show the damage caused info
     *
     * @param attacker the attacker pokemon
     * @param attacked the pokemon be attacked
     * @param damage   the damage from attacker
     */
    @Override
    public void printAttack(String attacker, String attacked, int damage) {
        System.out.println(attacker + " attacked " + attacked + ", and made " + damage + " damage.");
    }

    /**
     * show pokemon defending
     *
     * @param name the pokemon choose to defend
     */
    @Override
    public void printDefense(String name) {
        System.out.print(name + " is defending. ");
    }

    /**
     * show pokemon defend successfully
     *
     * @param name the pokemon execute defend
     */
    @Override
    public void printDefenseSucceed(String name) {
        System.out.println(name + " successfully defended.");
    }

    /**
     * show pokemon defend failure
     *
     * @param name the pokemon execute defend
     */
    @Override
    public void printDefenseFail(String name) {
        System.out.println(name + " defended nothing.");
    }

    /**
     * show pokemon get healed and exact hp get from heal
     *
     * @param name        the pokemon execute defend
     * @param healedPoint the hp get from heal
     */
    @Override
    public void printHeal(String name, int healedPoint) {
        System.out.println(name + " healed, and gained " + healedPoint + " hit points.");
    }

    /**
     * show successful information about capturing pokemon
     *
     * @param name the pokemon that player try to capture
     */
    @Override
    public void printCaptured(String name) {
        System.out.println("You captured " + name + ".");
    }

    /**
     * show failure information about capturing pokemon
     *
     * @param name the pokemon that player try to capture
     */
    @Override
    public void printNotCaptured(String name) {
        System.out.println("You did not capture " + name + ".");
    }

    /**
     * show battle ending sentence
     */
    @Override
    public void printBattleEnded() {
        System.out.println("The battle is ended.");
    }

    /**
     * show draw battle sentence
     */
    @Override
    public void printDraw() {
        System.out.println("This is a draw.");
    }

    /**
     * show player lose
     */
    @Override
    public void printLose() {
        System.out.println("You lose.");
    }

    /**
     * show player win
     */
    @Override
    public void printWin() {
        System.out.println("You win.");
    }

    /**
     * notice player that successful escaped
     */
    public void printEscaped() {
        System.out.println("You escaped.");
    }

    /**
     * notice how much exp that the pokemon get
     *
     * @param name                  the name of pokemon
     * @param experiencePointGained the exp that got
     */
    public void printGainExperiencePoint(String name, int experiencePointGained) {
        System.out.println(name + " gained " + experiencePointGained + " experience points.");
    }

}