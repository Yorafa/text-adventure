package UISimple;

import usecase.PokemonManager;
import usecase.UserManager;

import java.util.Scanner;

public class PanelRunner {
    private Scanner input;
    private UserManager userManager;

    public PanelRunner(Scanner input, UserManager userManager) {
        this.input = input;
        this.userManager = userManager;
    }

    public void runLoginPanel() {
        TextLoginPanel loginPanel = new TextLoginPanel(input, this, userManager);
        loginPanel.runPanel();
    }

    public void runExplorePanel(PokemonManager pokemonManager) {
        TextExplorePanel explorePanel = new TextExplorePanel(input,this, pokemonManager);
        explorePanel.runPanel();
    }

    public void runBattlePanel(PokemonManager pokemonManager) {
        TextBattlePanel battlePanel = new TextBattlePanel(input, this, pokemonManager);
        battlePanel.runPanel();
    }
}
