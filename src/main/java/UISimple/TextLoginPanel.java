package UISimple;

import entity.User;
import usecase.UserManager;

import java.io.IOException;
import java.util.Scanner;

public class TextLoginPanel extends TextPanel implements PanelState {
    private UserManager userManager;
    private LoginPresenter loginPresenter;

    public TextLoginPanel(Scanner input, GameController gameController, UserManager userManager) {
        super(input, gameController);
        this.userManager = userManager;
        this.loginPresenter = new LoginPresenter();
    }

    @Override
    protected void printMenu() {
        loginPresenter.addLogin();
        loginPresenter.addSignup();
        loginPresenter.printAllEnum();
    }

    @Override
    protected void execute(String choice) {
        switch (choice) {
            case "1":
                login();
                break;
            case "2":
                signup();
                break;
            default:
                loginPresenter.notValid();
        }

    }

    private void login() {
        String username, password;
        loginPresenter.askForUsername();
        username = input.nextLine();
        loginPresenter.askForPassword();
        password = input.nextLine();
        boolean loggedIn = userManager.login(username, password);
        if (loggedIn) {
            gameController.changeState(new TextExplorePanel(input, gameController, gameController.getMapManager(),
                    gameController.getPokemonManager()));
        } else {
            loginPresenter.printInvalidUsernameOrPassword();
        }
    }

    private void signup() {
        String username, password;
        loginPresenter.askForUsername();
        username = input.nextLine();
        if (userManager.hasUser(username)) {
            loginPresenter.printUsernameExists();
        } else {
            loginPresenter.askForPassword();
            password = input.nextLine();
            boolean loggedIn = userManager.register(username, password);
            if (loggedIn) {
                gameController.changeState(new TextExplorePanel(input, gameController, gameController.getMapManager(),
                        gameController.getPokemonManager()));
            } else {
                loginPresenter.printInvalidPassword();
            }
        }
    }
}
