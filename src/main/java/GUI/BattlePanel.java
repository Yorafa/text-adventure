package GUI;

import GUI_Controller.BattleController;
import entity.Pokemon;
import usecase.BattleManager;

import javax.swing.*;
import java.awt.*;

public class BattlePanel extends JPanel {
    private BattleController battleController;
    public BattlePanel(TextAdventureFrame taf){
        this.setLayout(new GridLayout(2,1,10,10));
        this.battleController = new BattleController(taf.getPocketPokemons(), taf.getWildPokemon());
        pokemonPanel(taf);
        buttonPanel(taf);
    }

    public JPanel pokemonInfoPanel(Pokemon pokemon, String info){
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(3,1,10,10));
        JLabel infoLabel = new JLabel(info);
        JLabel nameLabel = new JLabel(pokemon.getName());
        JLabel hpLabel = new JLabel(pokemon.getHitPoint() + "/" +pokemon.getMaxHitPoint());
        infoPanel.add(infoLabel);
        infoPanel.add(nameLabel);
        infoPanel.add(hpLabel);
        return infoPanel;
    }

    public void pokemonPanel(TextAdventureFrame taf){
        JPanel pokemonPanel = new JPanel();
        pokemonPanel.setLayout(new GridLayout(1,3,20,20));
        JLabel textLabel = new JLabel("V.S.");
        pokemonPanel.add(pokemonInfoPanel(taf.getFirstPokemon(), "My Pokemon"));
        pokemonPanel.add(textLabel);
        pokemonPanel.add(pokemonInfoPanel(taf.getFirstPokemon(), "Wild Pokemon"));
        this.add(pokemonPanel);
    }

    public void buttonPanel(TextAdventureFrame taf){
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,2,20,20));

        JButton attackButton = new JButton("Attack");
        attackButton.addActionListener(e -> {
            boolean state = battleController.attack();
        });
        JButton defenseButton = new JButton("Defense");
        defenseButton.addActionListener(e -> {
            boolean state = battleController.defend();

        });
        JButton catchButton = new JButton("Catch");
        JButton escapeButton = new JButton("Escape");
        escapeButton.addActionListener(e -> {
            String message = "Successful Escape";
            JOptionPane.showMessageDialog(this, message, "Escaping", JOptionPane.WARNING_MESSAGE);
            taf.remove(this);
            taf.setContentPane(new MapPanel(taf));
            taf.pack();
        });
        buttonPanel.add(attackButton);
        buttonPanel.add(defenseButton);
        buttonPanel.add(catchButton);
        buttonPanel.add(escapeButton);
        this.add(buttonPanel);
    }
}
