package controller;

import driver.GameDriver;

import java.util.Scanner;

/**
 * This is an abstract class that all showing panel will extend this
 */
public abstract class TextPanel implements PanelState {
    protected final Scanner input;
    protected final GameDriver gameDriver;

    /**
     * Construct a TextPanel, given them the given input and gameDriver
     *
     * @param input      the player input
     * @param gameDriver the main driver of game
     *                   The relative classes
     * @see GameDriver
     * @see PanelState
     */
    public TextPanel(Scanner input, GameDriver gameDriver) {
        this.input = input;
        this.gameDriver = gameDriver;
    }

    /**
     * {@inheritDoc}
     * <p>
     * show all action player can do and
     * call execute to do what player input
     */
    public void run() {
        printMenu();
        execute(input.nextLine());
    }

    /**
     * Call presenter to show what action player can do
     */
    protected abstract void printMenu();

    /**
     * Read player's input and execute the respective action
     *
     * @param choice the string that player input
     */
    protected abstract void execute(String choice);

}