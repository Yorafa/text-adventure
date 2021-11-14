package UISimple;

import entity.Pokemon;
import usecase.PokemonManager;

import java.util.List;
import java.util.Scanner;

public class TextBattlePanel extends TextPanel {
    private PokemonManager pokemonManager;
    private List<Pokemon> myPokemons;
    private Pokemon myPokemon;
    private Pokemon opponent;

    public TextBattlePanel(Scanner input, PokemonManager pokemonManager, Pokemon opponent) {
        super(input);
        options.add("1. Attack");
        options.add("2. Defense");
        options.add("3. Capture");
        options.add("4. Change pokemon");
        options.add("5. Escape");
        this.pokemonManager = pokemonManager;
        this.myPokemons = pokemonManager.getDefaultPokemon();
        this.myPokemon = myPokemons.get(0);
        this.opponent = opponent;
    }

    @Override
    protected void execute(String choice) {
        switch (choice) {
            case "1":
                System.out.println("chose attack");
                pokemonManager.attack(myPokemon, opponent);
                opponentAction();
                runPanel();
                break;
            case "2":
                System.out.println("chose defense");
                opponentAction();
                runPanel();
                break;
            case "3":
                System.out.println("chose capture");
                boolean captured = pokemonManager.capture(opponent);
                if (!captured) {
                    opponentAction();
                    runPanel();
                }
                break;
            case "4":
                System.out.println("chose change pokemon");
                changePokemon();
                runPanel();
                break;
            case "5":
                System.out.println("chose escape");
                break;
            default:
                System.out.println("Not Valid");
                runPanel();
        }
    }

    private void opponentAction() {
        // TODO
    }

    private void changePokemon() {
        // TODO
    }
}
