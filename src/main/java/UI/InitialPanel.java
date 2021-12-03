package UI;

import entity.Pokemon;

import javax.swing.*;
import java.awt.*;

public class InitialPanel extends JPanel {
    public InitialPanel(TextAdventureFrame taf){

        taf.setContentPane(this);
        this.setLayout(new GridLayout(2, 1, 10, 10));
        JLabel label = new JLabel("Welcome to Text Adventure, " + taf.getUser().getUsername() +
                ".\n I believe that you have wanted to go out and take risks for a long time.\n" +
                "But hold on. \n" +
                "Going out on an adventure can't be done without a pokemon.\n" +
                "Pick a pokemon to start your adventure"
        );
        label.setSize(this.getWidth()/2,20);
        this.add(label);
        String[] pokemonNames = {"Walter", "Gras", "Elect","Fir"};
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 10, 10));
        for (String pokemonName: pokemonNames){
            buttonPanel.add(createButton(pokemonName, taf));
        }

        this.add(buttonPanel);
        taf.pack();
    }
    public JButton createButton(String pokemonName, TextAdventureFrame taf){
        JButton button = new JButton(pokemonName);
        button.addActionListener(e -> showPokemonInfo(taf, taf.getPokemon(pokemonName)));
        return button;
    }

    public void showPokemonInfo(TextAdventureFrame taf, Pokemon pokemon){
        PokemonDialog pokemonDialog = new PokemonDialog(taf, pokemon);
        pokemonDialog.setTitle("Click Yes to Choose Your First Pokemon");
        pokemonDialog.setModal(true);
        pokemonDialog.setSize(500,720);
        pokemonDialog.setVisible(true);
        if (pokemonDialog.isAcceptable()){
            taf.remove(this);
            taf.setContentPane(new MapPanel(taf));
        }
    }
}
