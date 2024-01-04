package addition_part.gui;

import entity.Pokemon;
import entity.PokemonData;

import javax.swing.*;
import java.awt.*;

public class PokemonDialog extends JDialog {
    private final Pokemon pokemon;
    private boolean acceptable = false;

    public PokemonDialog(TextAdventureFrame owner, Pokemon pokemon) {
        super(owner);
        this.pokemon = pokemon;

        JPanel mainPanel = new JPanel();
        this.setContentPane(mainPanel);
        mainPanel.setLayout(new GridLayout(12, 1, 20, 20));
        addPokemonInfo(mainPanel);
        addYesNoButton(mainPanel);
    }

    private void pokemonInfoLabel(String info, JPanel panel) {
        JLabel label = new JLabel(info);
        panel.add(label);
    }

    private void addPokemonInfo(JPanel mainPanel) {
        PokemonData pokemonData = pokemon.getPokemonData();
        pokemonInfoLabel("Pokemon Name: " + pokemon.getName(), mainPanel);
        pokemonInfoLabel("Level: " + pokemon.getLevel(), mainPanel);
        pokemonInfoLabel("Experience Point: " + pokemon.getExperiencePoint(), mainPanel);
        pokemonInfoLabel("HP: " + pokemon.getHitPoint() + "/" + pokemonData.getMaxHitPoint(), mainPanel);
        pokemonInfoLabel("Attack: " + pokemonData.getAttackPoint(), mainPanel);
        pokemonInfoLabel("Defend: " + pokemonData.getDefencePoint(), mainPanel);
        pokemonInfoLabel("Speed: " + pokemonData.getSpeed(), mainPanel);
    }

    private void addYesNoButton(JPanel mainPanel) {
        JButton accept = new JButton("Yes");
        JButton reject = new JButton("No");
        accept.addActionListener(e ->
        {
            acceptable = true;
            setVisible(false);
        });
        reject.addActionListener(e -> setVisible(false));
        mainPanel.add(accept);
        mainPanel.add(reject);
    }

    public boolean isAcceptable() {
        return acceptable;
    }
}
