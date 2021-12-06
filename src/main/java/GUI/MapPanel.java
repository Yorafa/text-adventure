package GUI;

import GUI_Controller.PokemonController;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {

    public MapPanel(TextAdventureFrame taf) {

        this.setLayout(new GridLayout(2, 1, 10, 10));

        JLabel label = new JLabel("Welcome to Text Adventure, " + taf.getUser().getUsername() +
                ". You are currently at " + taf.getCurrentMapName() + "."
                );

        this.add(label);
        // Setup Button Field
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 10, 10));
        if (taf.getCurrentMapName().equals("Home")){
            JButton healAll = new JButton("Heal All");
            healAll.addActionListener((e) -> {
                PokemonController.healAll(taf.getPocketPokemons());
                String message = "All of Your Pokemons are healed";
                JOptionPane.showMessageDialog(this, message, "Notice", JOptionPane.WARNING_MESSAGE);
                });
            buttonPanel.add(healAll);}
        else{
        JButton search = new JButton("Walk around");
        search.addActionListener((e) -> {
            taf.walkAround();
            if (taf.getWildPokemon() == null){
                String message = "Oof, nothing here, may next time will find somethings";
                JOptionPane.showMessageDialog(this, message, "Search", JOptionPane.WARNING_MESSAGE);
            }
            else{
                taf.remove(this);
                if (PokemonController.canFight(taf.getPocketPokemons())){
                taf.setContentPane(new BattlePanel(taf));
                taf.pack();}
                else {
                    String message = "Oof, Your first pokemon in your pocket can not fight now";
                    JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
            buttonPanel.add(search);}

        JButton mapButton = new JButton("Change place");
        mapButton.addActionListener((e) ->
        {
            taf.remove(this);
            taf.setContentPane(new MapChangingPanel(taf));
            taf.pack();
        });

        JButton browsePokemon = new JButton("Browse pokemon");
        browsePokemon.addActionListener((e) -> {
            taf.setContentPane(new BrowsePokemonPanel(taf));
            taf.pack();
        });

        JButton logOut = new JButton("Log out");
        logOut.addActionListener((e) -> {
            taf.remove(this);
            taf.setContentPane(new LoginPanel(taf));
            taf.setUser(null);
            taf.pack();
        });
        buttonPanel.add(mapButton);
        buttonPanel.add(browsePokemon);
        buttonPanel.add(logOut);

        this.add(buttonPanel);
        taf.pack();
    }
}
