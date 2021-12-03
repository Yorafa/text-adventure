package UI;

import entity.BasePokemonData;
import entity.Pokemon;
import entity.PokemonData;
import entity.PokemonType;

import javax.swing.*;
import java.awt.*;

public class PokemonDialog extends JDialog {
    private boolean acceptable = false;
    public PokemonDialog(Window owner, Pokemon pokemon){
        super(owner);
        JPanel mainPanel = new JPanel();
        this.setContentPane(mainPanel);
        this.setLayout(new GridLayout(10,1,10,10));

        PokemonData pokemonData = pokemon.getPokemonData();
        pokemonInfoLabel("Pokemon Name: " + pokemon.getName(), mainPanel);
        pokemonInfoLabel("Level: " + pokemon.getLevel(), mainPanel);
        pokemonInfoLabel("Experience Point: " + pokemon.getExperiencePoint(), mainPanel);
        pokemonInfoLabel("HP: " + pokemon.getHitPoint() + "/"+pokemonData.getMaxHitPoint(), mainPanel);
        pokemonInfoLabel("Attack: " + pokemonData.getAttackPoint(), mainPanel);
        pokemonInfoLabel("Defend: " + pokemonData.getDefencePoint(), mainPanel);
        pokemonInfoLabel("Speed: " + pokemonData.getSpeed(), mainPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2,10,10));
        JButton accept = new JButton("Yes");
        JButton reject = new JButton("No");
        accept.addActionListener(e ->
        {acceptable = true;
        setVisible(false);});
        reject.addActionListener(e -> setVisible(false));

        this.add(accept);
        this.add(reject);
    }
    public void pokemonInfoLabel(String info, JPanel panel){
        JLabel label = new JLabel(info);
        panel.add(label);
    }

    public boolean isAcceptable() {
        return acceptable;
    }
}
