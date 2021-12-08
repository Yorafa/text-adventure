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
        mainPanel.setLayout(new GridLayout(2, 1, 10, 10));
        mainPanel.add(new JLabel("You are currently at " + mapManager.getCurrentPlace().getMapName() + "."));
        mainPanel.add(buttonPanel());
        this.add(this);
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
        mapManager.walkAround(pokemonManager);
        JButton search = new JButton("Walk around");
        search.addActionListener((e) -> doSearch());
        return search;
    }

    private void doSearch(){
        if (parent.getWildPokemon() == null){
            String message = "Oof, nothing here, may next time will find somethings";
            JOptionPane.showMessageDialog(this, message, "Search", JOptionPane.WARNING_MESSAGE);
        }
        else{
            if (PokemonController.canFight(parent.getPocketPokemons())){
                parent.remove(this);
                parent.setContentPane(new BattlePanel(parent));
                parent.pack();}
            else {
                String message = "Oof, Your first pokemon in your pocket can not fight now";
                JOptionPane.showMessageDialog(this, message,
                        "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private JButton mapButton(){
        JButton mapButton = new JButton("Change place");
        mapButton.addActionListener((e) ->
        {
            parent.remove(this);
            parent.setContentPane(new MapChangingPanel(parent));
            parent.pack();
        });
        return mapButton;
    }

    private JButton browsePokemonButton(){
        JButton browsePokemon = new JButton("Browse pokemon");
        browsePokemon.addActionListener((e) -> {
            parent.setContentPane(new BrowsePokemonPanel(parent));
            parent.pack();
        });
        return browsePokemon;
    }

    private JButton logOutButton(){
        JButton logOut = new JButton("Log out");
        logOut.addActionListener((e) -> {
            parent.remove(this);
            parent.loginPanel();
            parent.setUser(null);
            parent.pack();
        });
        return logOut;
    }


    private JPanel buttonPanel(){
        // Setup Button Field
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3, 10, 10));
        buttonPanel.add(walkAroundButton());
        buttonPanel.add(mapButton());
        buttonPanel.add(saveButton());
        buttonPanel.add(browsePokemonButton());
        buttonPanel.add(logOutButton());
        buttonPanel.add(loadButton());
        return  buttonPanel;
    }
}
