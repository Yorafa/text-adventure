package controller;

import driver.GameDriver;

import java.util.Scanner;

public abstract class TextPanel implements PanelState {
    protected Scanner input;
    protected GameDriver gameDriver;

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
