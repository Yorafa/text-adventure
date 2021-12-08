package controller;

import driver.GameDriver;

import java.util.Scanner;

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

    public void run() {
        printMenu();
        execute(input.nextLine());
    }

    protected abstract void printMenu();

    protected abstract void execute(String choice);
}