package UI;

import entity.BasePokemon;
import entity.Pokemon;

import javax.swing.*;
import java.awt.*;

public class BrowsePokemonPanel extends JPanel {

    public BrowsePokemonPanel(TextAdventureFrame taf){
        this.setLayout(new GridLayout(3,1,20,20));
        addPokemonBookLine(taf);
        addCheckBattlePokemon(taf);
    }

    public void addPokemonBookLine(TextAdventureFrame taf){
        JPanel pokemonBookPanel = new JPanel();
        JLabel pokemonBookLabel = new JLabel("Pokemon Index");
        JComboBox<Pokemon> pokemonBookField = new JComboBox<>();
        for (BasePokemon basePokemon: taf.getAllBasePokemon()){
            pokemonBookField.addItem(taf.getPokemon(basePokemon));
        }
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> pokemonInfo(taf, (Pokemon) pokemonBookField.getSelectedItem()));
        pokemonBookPanel.add(pokemonBookLabel);
        pokemonBookPanel.add(pokemonBookField);
        pokemonBookPanel.add(searchButton);
        this.add(pokemonBookPanel);
    }

    public void addCheckBattlePokemon(TextAdventureFrame taf){
        JPanel BattlePokemonPanel = new JPanel();
        JLabel BattlePokemonLabel = new JLabel("Battle Pokemon");
        JComboBox<Pokemon> BattlePokemonField = new JComboBox<>();
        for (Pokemon Pokemon: taf.getBattlePokemons()){
            BattlePokemonField.addItem(Pokemon);
        }
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> pokemonInfo(taf, (Pokemon) BattlePokemonField.getSelectedItem()));
        BattlePokemonPanel.add(BattlePokemonLabel);
        BattlePokemonPanel.add(BattlePokemonField);
        BattlePokemonPanel.add(searchButton);
        this.add(BattlePokemonPanel);
    }

    public void pokemonInfo(TextAdventureFrame taf, Pokemon pokemon){
        PokemonDialog pokemonDialog = new PokemonDialog(taf, pokemon);
        pokemonDialog.setTitle(pokemon.getName() + " Basic Information");
        pokemonDialog.setModal(true);
        pokemonDialog.setSize(500,720);
        pokemonDialog.setVisible(true);
        if (pokemonDialog.isAcceptable()){
            taf.remove(this);
        }
    }

}
