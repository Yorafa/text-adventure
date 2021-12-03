package UISimple;

import entity.Pokemon;
import usecase.BattleManager;
import usecase.PokemonManager;

import java.util.Scanner;

public class TextBattlePanel extends TextPanel implements PanelState {
    private PokemonManager pokemonManager;
    private BattleManager battleManager;

    public TextBattlePanel(Scanner input, GameController gameController, PokemonManager pokemonManager, BattleManager battleManager) {
        super(input, gameController);
        this.pokemonManager = pokemonManager;
        this.battleManager = battleManager;

        System.out.println("You bumped into " + battleManager.getP2Name() + ".");
        if (!battleManager.isFaster()) {
            opponentAction();
            if (battleManager.youLose()) {
                System.out.println("You lose.");
            } else if (battleManager.youWin()) {
                System.out.println("You win.");
            }
        }
    }

    @Override
    protected void execute(String choice) {
        switch (choice) {
            case "1":
                int damage = battleManager.attack();
                System.out.println("You made " + damage + " damage to " +
                        battleManager.getP2Name());
                if (battleManager.isBattling()) {
                    opponentAction();
                }
                break;
            case "2":
                battleManager.defense();
                System.out.println("You are defending.");
                opponentAction();
                break;
            case "3":
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
            case "4":
                changePokemon();
                opponentAction();
                System.out.println("Changed to " + battleManager.getP1Name() + ".");
                break;
            case "5":
                System.out.println("Escaped.");
                battleManager.endBattle();
                break;
            default:
                System.out.println("Not Valid");
        }
        if (battleManager.isBattling()) {
            run();
        } else if (battleManager.youLose()) {
            System.out.println("You lose.");
        } else if (battleManager.youWin()) {
            System.out.println("You win.");
        }
    }

    private void opponentAction() {
        String message = battleManager.opponentAction();
        System.out.println(message);
    }

    private void changePokemon() {
        TextChangePokemonPanel changePokemonPanel = new TextChangePokemonPanel(input, gameController, battleManager.getBattlePokemons(),
                pokemonManager);
        changePokemonPanel.run();
        Pokemon newPokemon = changePokemonPanel.getNewPokemon();
        if (newPokemon != null) {
            battleManager.changePokemon(changePokemonPanel.getNewPokemon());
        }
    }

    public boolean isBattling() {
        return battleManager.isBattling();
    }


    @Override
    public void printMenu() {

    }
}
