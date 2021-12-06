package Gui;

import GuiController.PokemonController;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {
    private final TextAdventureFrame parent;

    public MapPanel(TextAdventureFrame parent) {
        this.parent = parent;
        this.setLayout(new GridLayout(2, 1, 10, 10));

        JLabel label = new JLabel("Welcome to Text Adventure, " + parent.getUser().getUsername() +
                ". You are currently at " + parent.getCurrentMapName() + "."
                );

        this.add(label);
        setButtonFild();
        parent.pack();
    }
    public JButton healAllButton(){
        JButton healAll = new JButton("Heal All");
        healAll.addActionListener((e) -> {
            PokemonController.healAll(parent.getPocketPokemons());
            String message = "All of Your Pokemons are healed";
            JOptionPane.showMessageDialog(this, message, "Notice", JOptionPane.WARNING_MESSAGE);
        });
        return healAll;
    }

    public JButton walkAroundButton(){
        parent.walkAround();
        JButton search = new JButton("Walk around");
        search.addActionListener((e) -> doSearch());
        return search;
    }

    public void doSearch(){
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

    public JButton mapButton(){
        JButton mapButton = new JButton("Change place");
        mapButton.addActionListener((e) ->
        {
            parent.remove(this);
            parent.setContentPane(new MapChangingPanel(parent));
            parent.pack();
        });
        return mapButton;
    }

    public JButton browsePokemonButton(){
        JButton browsePokemon = new JButton("Browse pokemon");
        browsePokemon.addActionListener((e) -> {
            parent.setContentPane(new BrowsePokemonPanel(parent));
            parent.pack();
        });
        return browsePokemon;
    }

    public JButton logOutButton(){
        JButton logOut = new JButton("Log out");
        logOut.addActionListener((e) -> {
            parent.remove(this);
            parent.setContentPane(new LoginPanel(parent));
            parent.setUser(null);
            parent.pack();
        });
        return logOut;
    }

    public JButton saveButton(){
        JButton save = new JButton("Save");
        save.addActionListener(e -> parent.save());
        return save;
    }

    public JButton loadButton(){
        JButton load = new JButton("Load");
        load.addActionListener(e -> {
            LoadDataDialog loadDataDialog = new LoadDataDialog(parent);
            loadDataDialog.setTitle("All Save Game Data");
            loadDataDialog.setModal(true);
            loadDataDialog.setSize(600,360);
            loadDataDialog.setVisible(true);
        });
        return load;
    }

    public void setButtonFild(){
        // Setup Button Field
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3, 10, 10));
        if (parent.getCurrentMapName().equals("Home")) buttonPanel.add(healAllButton());
        else buttonPanel.add(walkAroundButton());
        buttonPanel.add(mapButton());
        buttonPanel.add(saveButton());
        buttonPanel.add(browsePokemonButton());
        buttonPanel.add(logOutButton());
        buttonPanel.add(loadButton());
        this.add(buttonPanel);
    }
}
