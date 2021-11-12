package UISimple;

import usecase.PokemonManager;

import java.util.Scanner;

public class TextBattlePanel extends TextPanel {
    private PokemonManager pokemonManager;

    public TextBattlePanel(Scanner input, PanelRunner panelRunner, PokemonManager pokemonManager) {
        super(input, panelRunner);
        options.add("1. Attack");
        options.add("2. Defense");
        options.add("3. Capture");
        options.add("4. Change pokemon");
        options.add("5. Escape");
        this.pokemonManager = pokemonManager;
    }

    @Override
    protected void execute(String choice) {
        switch (choice) {
            case "1":
                System.out.println("chose attack");
                panelRunner.runBattlePanel(pokemonManager);
                break;
            case "2":
                System.out.println("chose defense");
                panelRunner.runBattlePanel(pokemonManager);
                break;
            case "3":
                System.out.println("chose capture");
                panelRunner.runBattlePanel(pokemonManager);
                break;
            case "4":
                System.out.println("chose change pokemon");
                panelRunner.runBattlePanel(pokemonManager);
                break;
            case "5":
                System.out.println("chose escape");
                panelRunner.runExplorePanel(pokemonManager);
                break;
            default:
                System.out.println("Not Valid");
                panelRunner.runBattlePanel(pokemonManager);
        }
    }
}
