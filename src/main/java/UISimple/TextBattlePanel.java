package UISimple;

import usecase.BattleManager;
import usecase.PokemonManager;

import java.util.Scanner;

public class TextBattlePanel extends TextPanel implements PanelState {
    private PokemonManager pokemonManager;
    private BattleManager battleManager;
    private BattlePresenter battlePresenter;

    public TextBattlePanel(Scanner input, GameController gameController, PokemonManager pokemonManager, BattleManager battleManager) {
        super(input, gameController);
        this.pokemonManager = pokemonManager;
        this.battleManager = battleManager;
        this.battlePresenter = new BattlePresenter();
    }

    @Override
    public void run() {
        battlePresenter.printOpponent(battleManager.getP2Name());
        if (!battleManager.isFaster()) {
            opponentAction();
            if (battleManager.youLose()) {
                battlePresenter.printLose();
            } else if (battleManager.youWin()) {
                battlePresenter.printWin();
            }
        }
        printMenu();
        execute(input.nextLine());
    }

    @Override
    public void printMenu() {
        battlePresenter.addAttack();
        battlePresenter.addDefense();
        battlePresenter.addCapture();
        battlePresenter.addChangePokemon();
        battlePresenter.addEscape();
        battlePresenter.printAllEnum();
    }

    @Override
    protected void execute(String choice) {
        switch (choice) {
            case "1": // Attack
                int damage = battleManager.attack();
                System.out.println("You made " + damage + " damage to " +
                        battleManager.getP2Name());
                if (battleManager.isBattling()) {
                    opponentAction();
                }
                break;
            case "2": // Defense
                battleManager.defense();
                System.out.println("You are defending.");
                opponentAction();
                break;
            case "3": // Capture
                boolean captured = battleManager.capture();
                if (captured) {
                    pokemonManager.add(battleManager.getOpponent());
                    System.out.println("You captured " + battleManager.getP2Name() + ".");
                    battleManager.endBattle();
                } else {
                    System.out.println("Not captured.");
                    opponentAction();
                }
                break;
            case "4": // Change pokemon
                gameController.changeState(new TextChangePokemonPanel(input, gameController, battleManager));
                break;
            case "5": // Escape
                gameController.changeStateExplore();
                battlePresenter.printEscaped();
                break;
            default:
                battlePresenter.notValid();
        }
    }

    private void opponentAction() {
        String message = battleManager.opponentAction();
        System.out.println(message);
    }
}
