package controller;

import driver.GameDriver;
import presenter.ChangePlacePresenter;
import usecase_map.MapManager;

import java.util.Scanner;

/**
 * This is the panel will show all the place that player can go,
 * and let player choose where to go
 */
public class TextChangePlacePanel extends TextPanel {
    private final MapManager mapManager;
    private final ChangePlacePresenter changePlacePresenter;

    /**
     * Construct a TextChangePlacePanel, given them the given input, gameDriver
     * and mapManager
     *
     * @param input      the player input
     * @param gameDriver the main driver of game
     * @param mapManager the manager of map
     *                   <p>
     *                   The relative classes
     * @see GameDriver
     * @see MapManager
     * @see PanelState
     */
    public TextChangePlacePanel(Scanner input, GameDriver gameDriver, MapManager mapManager) {
        super(input, gameDriver);
        this.mapManager = mapManager;
        this.changePlacePresenter = new ChangePlacePresenter();
    }

    /**
     * Call presenter to show what action player can do
     */
    @Override
    protected void printMenu() {
        changePlacePresenter.addToQueue(mapManager.getMapNames());
        changePlacePresenter.addCancel();
        changePlacePresenter.printAllEnum();
    }

    /**
     * Read player's input and execute the respective action
     *
     * @param choice the string that player input
     */
    @Override
    protected void execute(String choice) {
        try {
            int numChoice = Integer.parseInt(choice) - 1;
            if (numChoice >= 0 && numChoice < mapManager.getMapNames().size()) {
                mapManager.setCurrentPlace(numChoice);
                changePlacePresenter.printMapChanged(mapManager.getMapNames().get(numChoice));
                gameDriver.changeStateExplore();
            } else if (numChoice == mapManager.getMapNames().size()) { // Cancel
                gameDriver.changeStateExplore();
            } else {
                changePlacePresenter.notValid();
            }
        } catch (NumberFormatException e) {
            changePlacePresenter.notValid();
        }
    }
}