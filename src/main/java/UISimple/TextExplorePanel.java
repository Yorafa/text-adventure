package UISimple;

import entity.Pmap;
import entity.Pokemon;
import usecase.MapManager;

import java.util.List;
import java.util.Scanner;

public class TextExplorePanel extends TextPanel {
    private MapManager mapManager;
    private Pokemon pokemon;
    private boolean loggedOut;
    private boolean exploring;

    public TextExplorePanel(Scanner input, MapManager mapManager) {
        super(input);
        options.add("1. Walk around");
        options.add("2. Change place");
        options.add("3. Logout");
        this.mapManager = mapManager;
        this.loggedOut = false;
        this.exploring = true;
    }

    @Override
    protected void execute(String choice) {
        switch (choice) {
            case "1":
                System.out.println("chose walk around");
                pokemon = mapManager.walkAround();
                if (pokemon == null) {
                    runPanel();
                } else {
                    exploring = false;
                }
                break;
            case "2":
                System.out.println("chose change place");
                changePlace();
                runPanel();
                break;
            case "3":
                System.out.println("chose log out");
                loggedOut = true;
                break;
            default:
                System.out.println("Not valid");
                runPanel();
        }
    }

    public void changePlace() {
        List<Pmap> maps = mapManager.getMaps();
        TextChangePlacePanel changePlacePanel = new TextChangePlacePanel(input, maps, mapManager);
        changePlacePanel.runPanel();
        mapManager.setCurrentPlace(changePlacePanel.getNewPlace());
    }

    public boolean isLoggedOut() {
        return loggedOut;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void continueExploring() {
        this.exploring = true;
    }

    public boolean isExploring() {
        return exploring;
    }
}
