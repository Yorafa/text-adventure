package UISimple;

import usecase.GameDataManager;
import usecase.UserManager;

import java.util.Scanner;

public class TextLoginPanel extends TextPanel implements PanelState {
    private UserManager userManager;
    private GameDataManager gameDataManager;
    private LoginPresenter loginPresenter;

    public TextLoginPanel(Scanner input, GameController gameController, UserManager userManager, GameDataManager gameDataManager) {
        super(input, gameController);
        this.userManager = userManager;
        this.gameDataManager = gameDataManager;
        this.loginPresenter = new LoginPresenter();
    }

    @Override
    protected void printMenu() {
        loginPresenter.addLogin();
        loginPresenter.addSignup();
        loginPresenter.addQuit();
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
            case "3":
                gameController.endGame();
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
            gameController.changeStateExplore(username);
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
                gameController.changeStateExplore(username);
            } else {
                loginPresenter.printInvalidPassword();
            }
        }
    }
}
