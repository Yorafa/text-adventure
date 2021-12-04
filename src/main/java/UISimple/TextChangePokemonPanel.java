package UISimple;

import usecase.BattleManager;

import java.util.Scanner;

public class TextChangePokemonPanel extends TextPanel implements PanelState {
    private BattleManager battleManager;
    private ChangePokemonPresenter changePokemonPresenter;

    public TextChangePokemonPanel(Scanner input, GameController gameController, BattleManager battleManager) {
        super(input, gameController);
        this.battleManager = battleManager;
        this.changePokemonPresenter = new ChangePokemonPresenter();
    }

    @Override
    protected void printMenu() {
        changePokemonPresenter.addToQueue(battleManager.getBattlePokemonNames());
        changePokemonPresenter.addCancel();
        changePokemonPresenter.printAllEnum();
    }

    @Override
    protected void execute(String choice) {
        try {
            int numChoice = Integer.parseInt(choice) - 1;
            if (numChoice >= 0 && numChoice < battleManager.getBattlePokemonNames().size()) {
                battleManager.setP1(numChoice);
                gameController.changeStateBattle(battleManager);
            } else if (numChoice == battleManager.getBattlePokemonNames().size()) {
                gameController.changeStateBattle(battleManager);
            } else {
                changePokemonPresenter.notValid();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            changePokemonPresenter.notValid();
        }
    }
}
