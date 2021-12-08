package addition_part.Gui;

import addition_part.GuiDriver.GuiDriver;
import entity.Pokemon;
import usecase_pokemon.PokemonManager;

import javax.swing.*;
import java.awt.*;

public class InitialPanel extends BasePanel {
    private final PokemonManager pokemonManager;

    public InitialPanel(TextAdventureFrame parent, GuiDriver guiDriver){
        super(parent, guiDriver);
        this.pokemonManager = guiDriver.getPokemonManager();
        initialize();
    }

    private void initialize(){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1, 10, 10));
        mainPanel.add(new JLabel("Welcome to Text Adventure, " +
                "Pick a pokemon to start your adventure"
        ));
        String[] pokemonNames = {"Bulbasaur", "Squirtle", "Charmander"};
        // setUp button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 10, 10));
        for (String pokemonName: pokemonNames){
            buttonPanel.add(createButton(pokemonName));
        }
        mainPanel.add(buttonPanel);
        this.add(mainPanel);
    }

    private JButton createButton(String pokemonName){
        JButton button = new JButton(pokemonName);
        button.addActionListener(e -> showPokemonInfo(pokemonManager.getPokemon(pokemonName,1)));
        return button;
    }

    private void showPokemonInfo(Pokemon pokemon){
        PokemonDialog pokemonDialog = new PokemonDialog(parent, pokemon);
        pokemonDialog.setTitle("Click Yes to Choose Your First Pokemon");
        pokemonDialog.setModal(true);
        pokemonDialog.setSize(500,720);
        pokemonDialog.setVisible(true);
        if (pokemonDialog.isAcceptable()){
            parent.remove(this);
            pokemonManager.add(pokemon);
            parent.explorePanel();
        }
    }
}
