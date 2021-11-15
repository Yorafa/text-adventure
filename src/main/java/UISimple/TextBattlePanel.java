package UISimple;

import entity.Pokemon;
import usecase.PokemonManager;

import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class TextBattlePanel extends TextPanel {
    private PokemonManager pokemonManager;
    private List<Pokemon> myPokemons;
    private Pokemon myPokemon;
    private Pokemon opponent;
    private boolean inChange = false;

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
        if (!inChange) {
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
        } else {
            myPokemon = myPokemons.get(Integer.valueOf(choice) - 1);
        }
    }

    private void opponentAction() {
        Random rand = new Random();
        double num = rand.nextDouble();
        double cons = 0.95 / 2;
        // if num > 0.95, the opponent pokemon will escape, otherwise, random action as of now.
        if (num < cons) {
            pokemonManager.attack(opponent, myPokemon);
        } else if (num < 2 * cons) {
            opponent.setHitPoint((int) Math.round(opponent.getHitPoint() * 1.1));
        }
    }

    private void changePokemon() {
        int temp = 0;
        inChange = true;
        for (Pokemon p : myPokemons) {
            System.out.println((temp + 1) + " " + p.getName());
        }
    }
}
