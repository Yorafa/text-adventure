package UISimple;

import usecase.PokemonManager;
import usecase.UserManager;

import java.io.IOException;
import java.util.Scanner;

public class PokemonWorld {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        UserReadWriter userReadWriter = new UserReadWriter();
        UserManager userManager = new UserManager();
        try {
            userManager = userReadWriter.read();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No userinfo");
        }
        TextLoginPanel loginPanel = new TextLoginPanel(scanner, userManager);

        String username;
        GameDataReadWriter gameDataRW;
        GameController gameController;

        while (true) {
            loginPanel.runPanel();
            try {
                userReadWriter.write(userManager);
            } catch (IOException e) {
                System.out.println("Problem");
            }
            username = loginPanel.getUsername();

            gameDataRW = new GameDataReadWriter(username);
            try {
                gameController = gameDataRW.read();
            } catch (IOException | ClassNotFoundException e) {
                gameController = new GameController(scanner);
            }
            gameController.run();
            try {
                gameDataRW.write(gameController);
            } catch (IOException e) {
                System.out.println("Problem");
            }
        }
    }
}
