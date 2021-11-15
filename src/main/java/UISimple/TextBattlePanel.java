package UISimple;

import entity.Pokemon;
import usecase.BattleManager;
import usecase.PokemonManager;

import java.util.Scanner;

public class TextBattlePanel extends TextPanel {
    private PokemonManager pokemonManager;
    private BattleManager battleManager;

    public TextBattlePanel(Scanner input, PokemonManager pokemonManager, Pokemon opponent) {
        super(input);
        options.add("1. Attack");
        options.add("2. Defense");
        options.add("3. Capture");
        options.add("4. Change pokemon");
        options.add("5. Escape");
        this.pokemonManager = pokemonManager;
        this.battleManager = new BattleManager(pokemonManager.getBattlePokemons(), opponent);

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
            runPanel();
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
        TextChangePokemonPanel changePokemonPanel = new TextChangePokemonPanel(input, battleManager.getBattlePokemons(),
                pokemonManager);
        changePokemonPanel.runPanel();
        Pokemon newPokemon = changePokemonPanel.getNewPokemon();
        if (newPokemon != null) {
            battleManager.changePokemon(changePokemonPanel.getNewPokemon());
        }
    }

    public boolean isBattling() {
        return battleManager.isBattling();
    }

}
