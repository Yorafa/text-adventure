package UISimple;

import usecase.UserManager;

import java.util.Scanner;

public class PokemonWorld {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ReadWriter readWriter = new TestUserReadWriter();
        UserManager userManager = (UserManager) readWriter.read("");
        PanelRunner panelRunner = new PanelRunner(input, userManager);
        panelRunner.runLoginPanel();
    }
}
