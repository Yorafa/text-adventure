package UISimple;

import java.util.Scanner;

public abstract class TextPanel implements PanelState {
    protected Scanner input;
    protected GameController gameController;

    public TextPanel(Scanner input, GameController gameController) {
        this.input = input;
        this.gameController = gameController;
    }

    public void run() {
        printMenu();
        execute(input.nextLine());
    }

    protected abstract void printMenu();

    protected abstract void execute(String choice);

}