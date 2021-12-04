package UISimple;

import usecase.MapManager;

import java.util.Scanner;

public class TextChangePlacePanel extends TextPanel implements PanelState {
    private MapManager mapManager;
    private ChangePlacePresenter changePlacePresenter;

    public TextChangePlacePanel(Scanner input, GameController gameController, MapManager mapManager) {
        super(input, gameController);
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
            } else if (numChoice == mapManager.getMapNames().size()) {
                gameController.changeState(new TextExplorePanel(input, gameController, mapManager,
                        gameController.getPokemonManager()));
            } else {
                changePlacePresenter.notValid();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            changePlacePresenter.notValid();
        }
    }
}
