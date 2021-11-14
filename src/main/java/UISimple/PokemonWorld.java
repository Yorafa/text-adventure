package UISimple;

import entity.GameData;
import entity.User;
import usecase.PokemonManager;
import usecase.UserManager;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class PokemonWorld {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        UserReadWriter userReadWriter = new UserReadWriter();
        UserManager userManager = new UserManager();
        try {
            List<User> users = userReadWriter.read();
            userManager.setUsers(users);
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
                userReadWriter.write(userManager.getUsers());
            } catch (IOException e) {
                System.out.println("Problem");
            }
            username = loginPanel.getUsername();

            gameDataRW = new GameDataReadWriter(username);
            try {
                GameData gameData = gameDataRW.read();
                gameController = new GameController(scanner, gameData);
            } catch (IOException | ClassNotFoundException e) {
                gameController = new GameController(scanner);
            }
            gameController.run();
            try {
                gameDataRW.write(gameController.getGameData());
            } catch (IOException e) {
                System.out.println("Problem");
            }
        }
    }
}
