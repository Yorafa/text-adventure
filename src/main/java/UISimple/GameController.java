package UISimple;

import entity.GameData;
import entity.Pmap;
import entity.Pocket;
import usecase.GameDataManager;
import usecase.MapManager;
import usecase.PokemonManager;
import usecase.UserManager;

import java.util.Scanner;

public class GameController {
    private Scanner input = new Scanner(System.in);
    private UserManager userManager;
    private PokemonManager pokemonManager;
    private MapManager mapManager;
    private PanelState state;
    private boolean gaming;

    public GameController() {
        this.userManager = new UserManager();
        this.pokemonManager = new PokemonManager();
        this.mapManager = new MapManager();
        this.state = new TextLoginPanel(input, this ,userManager);
        this.gaming = true;
    }

    public void run() {
        while (gaming) {
            state.run();
        }
    }

    private void changeState(PanelState state) {
        this.state = state;
    }

    public void endGame() {
        this.gaming = false;
    }
}
