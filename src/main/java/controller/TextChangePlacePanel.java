package controller;

import driver.GameDriver;
import presenter.ChangePlacePresenter;
import usecase_map.MapManager;

import java.util.Scanner;

public class TextChangePlacePanel extends TextPanel implements PanelState {
    private final MapManager mapManager;
    private final ChangePlacePresenter changePlacePresenter;

    public TextChangePlacePanel(Scanner input, GameDriver gameDriver, MapManager mapManager) {
        super(input, gameDriver);
        this.mapManager = mapManager;
        this.changePlacePresenter = new ChangePlacePresenter();
    }

    @Override
    protected void printMenu() {
        changePlacePresenter.addToQueue(mapManager.getMapNames());
        changePlacePresenter.addCancel();
        changePlacePresenter.printAllEnum();
    }

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