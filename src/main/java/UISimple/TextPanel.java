package UISimple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class TextPanel {
    protected Scanner input;
    protected List<String> options;
    protected PanelRunner panelRunner;

    public TextPanel(Scanner input, PanelRunner panelRunner) {
        this.input = input;
        this.options = new ArrayList<>();
        this.panelRunner = panelRunner;
    }

    public void runPanel() {
        printMenu();
        execute(input.nextLine());
    }


    protected void printMenu() {
        for (String option : options) {
            System.out.println(option);
        }
    }

    protected abstract void execute(String choice);

}
