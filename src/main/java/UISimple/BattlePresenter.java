package UISimple;

public class BattlePresenter extends Presenter {

    public void addAttack() {
        addToQueue("Attack");
    }

    public void addDefense() {
        addToQueue("Defense");
    }

    public void addCapture() {
        addToQueue("Capture");
    }

    public void addChangePokemon() {
        addToQueue("Change pokemon");
    }

    public void addEscape() {
        addToQueue("Escape");
    }

    public void printEscaped() {
        System.out.println("You escaped.");
    }

    public void printOpponent(String opponentName) {
        System.out.println("You bumped into " + opponentName + ".");
    }

    public void printLose() {
        System.out.println("You lose.");
    }

    public void printWin() {
        System.out.println("You Win.");
    }
}
