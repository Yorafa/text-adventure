package UI;

import entity.Pokemon;
import usecase.BattleManager;

import javax.swing.*;
import java.awt.*;

public class BattlePanel extends JPanel {
    private BattleManager battleManager;
    public BattlePanel(TextAdventureFrame taf){
        this.setLayout(new GridLayout(2,1,10,10));
        pokemonPanel(taf);
        buttonPanel(taf);
        this.battleManager = new BattleManager(taf.getBattlePokemons(), taf.getWildPokemon());
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
            this.battleManager.attack();
        });
        JButton defenseButton = new JButton("Defense");
        defenseButton.addActionListener(e -> {
            this.battleManager.defense();
        });
        JButton catchButton = new JButton("Catch");
        JButton escapeButton = new JButton("Escape");
        JButton switchButton = new JButton("Switch Pokemon");
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
