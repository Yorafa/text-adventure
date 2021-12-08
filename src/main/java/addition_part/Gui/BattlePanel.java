package addition_part.Gui;

import addition_part.GuiController.BattleController;
import addition_part.GuiController.PokemonController;
import entity.Pokemon;

import javax.swing.*;
import java.awt.*;

public class BattlePanel extends JPanel {
    private final BattleController battleController;
    private final Pokemon wildPokemon;

    public BattlePanel(TextAdventureFrame taf){
        this.setLayout(new GridLayout(2,1,10,10));
        this.battleController = new BattleController(taf.getPocketPokemons(), taf.getWildPokemon());
        wildPokemon = battleController.getWildPokemon();

        // PokemonInfo Panel
        JPanel pokemonPanel = new JPanel();
        pokemonPanel.setLayout(new GridLayout(1,3,20,20));
        JLabel textLabel = new JLabel("V.S.");
        // Player Pokemon Information
        JPanel playerPokemonInfoPanel = new JPanel();
        playerPokemonInfoPanel.setLayout(new GridLayout(4,1,10,10));
        JLabel playerInfoLabel = new JLabel("My Pokemon");
        JLabel playerPokemonNameLabel = new JLabel(battleController.getPlayerPokemon().getName());
        JLabel playerPokemonHpLabel = new JLabel(battleController.getPlayerPokemon().getHitPoint() +
                "/" +battleController.getPlayerPokemon().getMaxHitPoint());
        JLabel playerPokemonLevelLabel = new JLabel("level: " + battleController.getPlayerPokemon().getLevel());
        playerPokemonInfoPanel.add(playerInfoLabel);
        playerPokemonInfoPanel.add(playerPokemonNameLabel);
        playerPokemonInfoPanel.add(playerPokemonHpLabel);
        playerPokemonInfoPanel.add(playerPokemonLevelLabel);
        pokemonPanel.add(playerPokemonInfoPanel);
        pokemonPanel.add(textLabel);

        JPanel wildPokemonInfoPanel = new JPanel();
        wildPokemonInfoPanel.setLayout(new GridLayout(4,1,10,10));
        JLabel infoLabel = new JLabel("Wild Pokemon");
        JLabel nameLabel = new JLabel(wildPokemon.getName());
        JLabel hpLabel = new JLabel(wildPokemon.getHitPoint() +
                "/" +wildPokemon.getMaxHitPoint());
        JLabel lvlLabel = new JLabel("level: " + wildPokemon.getLevel());
        wildPokemonInfoPanel.add(infoLabel);
        wildPokemonInfoPanel.add(nameLabel);
        wildPokemonInfoPanel.add(hpLabel);
        wildPokemonInfoPanel.add(lvlLabel);
        pokemonPanel.add(wildPokemonInfoPanel);

        this.add(pokemonPanel);
        buttonPanel(taf, playerPokemonNameLabel, playerPokemonHpLabel, hpLabel);
    }

    public void buttonPanel(TextAdventureFrame taf, JLabel playerPokemonNameLabel, JLabel playerPokemonHpLabel,
                            JLabel wildPokemonLabel){
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,2,20,20));

        JButton attackButton = new JButton("Attack");
        attackButton.addActionListener(e -> checkState(taf, battleController.attack(),
                playerPokemonNameLabel,playerPokemonHpLabel, wildPokemonLabel));
        JButton defenseButton = new JButton("Defense");
        defenseButton.addActionListener(e -> checkState(taf, battleController.defend(),
                playerPokemonNameLabel, playerPokemonHpLabel, wildPokemonLabel));
        JButton catchButton = new JButton("Catch");
        catchButton.addActionListener(e -> catching(taf,
                playerPokemonNameLabel, playerPokemonHpLabel,
                 wildPokemonLabel));
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

    public void checkState(TextAdventureFrame taf, boolean battleState,
                           JLabel playerPokemonNameLabel, JLabel playerPokemonHpLabel,
                           JLabel wildPokemonLabel){
        playerPokemonNameLabel.setText(battleController.getPlayerPokemon().getName());
        playerPokemonHpLabel.setText(battleController.getPlayerPokemon().getHitPoint() +
                "/" +battleController.getPlayerPokemon().getMaxHitPoint());
        wildPokemonLabel.setText(wildPokemon.getHitPoint() + "/" + wildPokemon.getMaxHitPoint());
        if (!battleState && battleController.isPlayerPokemonState()){
            String message = "You Win";
            JOptionPane.showMessageDialog(this, message, "Congratulation", JOptionPane.WARNING_MESSAGE);
            PokemonController.getExp(taf.getPocketPokemons(), wildPokemon);
            taf.remove(this);
            taf.setContentPane(new MapPanel(taf));
            taf.pack();
        }else if (!battleState && !battleController.isPlayerPokemonState()){
            String message = "You Lose, Please Back to Home to Heal Your Pokemon";
            JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);
            taf.remove(this);
            taf.setContentPane(new MapPanel(taf));
            taf.pack();
        }
    }

    public void catching(TextAdventureFrame taf,
                         JLabel playerPokemonNameLabel, JLabel playerPokemonHpLabel,
                         JLabel wildPokemonLabel){
        playerPokemonNameLabel.setText(battleController.getPlayerPokemon().getName());
        playerPokemonHpLabel.setText(battleController.getPlayerPokemon().getHitPoint() +
                "/" +battleController.getPlayerPokemon().getMaxHitPoint());
        wildPokemonLabel.setText(wildPokemon.getHitPoint() + "/" + wildPokemon.getMaxHitPoint());
        if (battleController.catching()){
            taf.addPokemon(taf.getWildPokemon());
            String message = "Successful Catching";
            JOptionPane.showMessageDialog(this, message, "Congratulation", JOptionPane.WARNING_MESSAGE);
            taf.remove(this);
            taf.setContentPane(new MapPanel(taf));
            taf.pack();
        } else{
            String message = "Catching Failure";
            JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);
            checkState(taf, battleController.isBattling(), playerPokemonNameLabel,playerPokemonHpLabel,wildPokemonLabel);
        }
    }
}
