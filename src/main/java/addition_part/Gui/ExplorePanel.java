package addition_part.Gui;

import addition_part.GuiController.PokemonController;
import addition_part.GuiController.SaveLoadController;
import addition_part.GuiDriver.GuiDriver;
import usecase_map.MapManager;
import usecase_pokemon.PokemonManager;

import javax.swing.*;
import java.awt.*;

public class ExplorePanel extends BasePanel {
    private final PokemonManager pokemonManager;
    private final MapManager mapManager;
    private final SaveLoadController saveLoadController;

    public ExplorePanel(TextAdventureFrame parent, GuiDriver guiDriver) {
        super(parent, guiDriver);
        pokemonManager = guiDriver.getPokemonManager();
        mapManager = guiDriver.getMapManager();
        saveLoadController = guiDriver.getSaveLoadController();
        initialize();
    }

    private void initialize(){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1, 10, 10));
        mainPanel.add(new JLabel("You are currently at " + mapManager.getCurrentPlace().getMapName() + "."));
        mainPanel.add(new MapChangingPanel(mapManager));
        mainPanel.add(new SaveLoadPanel(guiDriver));
        mainPanel.add(buttonPanel());
        this.add(mainPanel);
    }
    private JButton healAllButton(){
        JButton healAll = new JButton("Heal All");
        healAll.addActionListener((e) -> {
            pokemonManager.healAll();
            String message = "All of your Pokemon are healed";
            JOptionPane.showMessageDialog(this, message, "Notice", JOptionPane.WARNING_MESSAGE);
        });
        return healAll;
    }

    private JButton walkAroundButton(){
        guiDriver.setWildPokemon(mapManager.walkAround(pokemonManager));
        JButton search = new JButton("Walk around");
        search.addActionListener((e) -> doSearch());
        return search;
    }

    private void doSearch(){
        if (guiDriver.getWildPokemon() == null){
            String message = "Oof, nothing here, may next time will find somethings";
            JOptionPane.showMessageDialog(this, message, "Search", JOptionPane.WARNING_MESSAGE);
        }
        else{
            if (PokemonController.canFight(pokemonManager.getPocket().getPokemons())){
                parent.remove(this);
                parent.battlePanel();}
            else {
                String message = "Oof, Your first pokemon in your pocket can not fight now";
                JOptionPane.showMessageDialog(this, message,
                        "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private JButton logOutButton(){
        JButton logOut = new JButton("Log out");
        logOut.addActionListener((e) -> {
            parent.remove(this);
            saveLoadController.saveGameData(pokemonManager.getPocket(), mapManager.getCurrentPlace());
            parent.loginPanel();
        });
        return logOut;
    }


    private JPanel buttonPanel(){
        // Setup Button Field
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 30, 30));
        buttonPanel.add(walkAroundButton());
        buttonPanel.add(healAllButton());
        buttonPanel.add(browsePokemonButton());
        buttonPanel.add(logOutButton());
        return buttonPanel;
    }

    private JButton browsePokemonButton() {
        JButton browseButton = new JButton("Browse My Pokemon");
        browseButton.addActionListener((e) -> {
            parent.remove(this);
            parent.browsePokemonPanel();
        });
        return browseButton;
    }
}
