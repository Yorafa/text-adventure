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
        if (!battleManager.isFaster()) {
            opponentAction();
        }
    }

    @Override
    protected void execute(String choice) {
        switch (choice) {
            case "1":
                int damage = battleManager.attack();
                System.out.println(battleManager.getP1Name() + " made " + damage + " damage to " +
                        battleManager.getP2Name());
                opponentAction();
                break;
            case "2":
                battleManager.defense();
                System.out.println("Defending.");
                opponentAction();
                break;
            case "3":
                boolean captured = battleManager.capture();
                if (captured) {
                    pokemonManager.add(battleManager.getOpponent());
                    System.out.println("Captured.");
                    battleManager.endBattle();
                } else {
                    System.out.println("Not captured.");
                    opponentAction();
                }
                break;
            case "4":
                System.out.println("chose change pokemon");
                changePokemon();
                opponentAction();
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
        battleManager.changePokemon(changePokemonPanel.getNewPokemon());
    }

}
