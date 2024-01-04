package controller;

import driver.GameDriver;
import presenter.LoginPresenter;
import usecase_user.UserManager;

import java.util.Scanner;

/**
 * This is the panel ask player to login,
 * or register if player do not have an account
 */
public class TextLoginPanel extends TextPanel {
    private final UserManager userManager;
    private final LoginPresenter loginPresenter;

    /**
     * Construct a TextLoginPanel, given them the given input, gameDriver and userManager.
     *
     * @param input       the player input
     * @param gameDriver  the main driver of game
     * @param userManager the manager of user
     *                    <p>
     *                    The relative classes
     * @see GameDriver
     * @see UserManager
     * @see PanelState
     */
    public TextLoginPanel(Scanner input, GameDriver gameDriver, UserManager userManager) {
        super(input, gameDriver);
        this.userManager = userManager;
        this.loginPresenter = new LoginPresenter();
    }

    /**
     * Call presenter to show what action player can do
     */
    @Override
    protected void printMenu() {
        loginPresenter.addLogin();
        loginPresenter.addSignup();
        loginPresenter.addQuit();
        loginPresenter.printAllEnum();
    }

    /**
     * Read player's input and execute the respective action
     *
     * @param choice the string that player input
     */
    @SuppressWarnings("EnhancedSwitchMigration")
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
                gameDriver.endGame();
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
            gameDriver.changeStateExplore(username);
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
                gameDriver.changeStateExplore(username);
            } else {
                loginPresenter.printInvalidPassword();
            }
        }
    }
}