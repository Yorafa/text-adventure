package UI;

import entity.Pokemon;

import javax.swing.*;
import java.awt.*;

public class BattlePanel extends JPanel {
    public BattlePanel(TextAdventureFrame taf){
        this.setLayout(new GridLayout(2,1,10,10));
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
        JButton defenceButton = new JButton("Defence");
        JButton catchButton = new JButton("Catch");
        JButton escapeButton = new JButton("Escape");

        buttonPanel.add(attackButton);
        buttonPanel.add(defenceButton);
        buttonPanel.add(catchButton);
        buttonPanel.add(escapeButton);
        this.add(buttonPanel);
    }
}
