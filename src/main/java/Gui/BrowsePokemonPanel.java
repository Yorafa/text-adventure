package Gui;

import entity.BasePokemon;
import entity.Pokemon;

import javax.swing.*;
import java.awt.*;

public class BrowsePokemonPanel extends JPanel {

    public BrowsePokemonPanel(TextAdventureFrame taf){
        this.setLayout(new GridLayout(4,1,20,20));
        addPokemonBookLine(taf);
        addBattlePokemon(taf);
        addLibraryLine(taf);
        JButton returnButton = new JButton("Back");
        returnButton.addActionListener(e -> {taf.setContentPane(new MapPanel(taf));
        taf.pack();});
        this.add(returnButton);
    }

    public void addPokemonBookLine(TextAdventureFrame taf){
        JPanel pokemonBookPanel = new JPanel();
        JLabel pokemonBookLabel = new JLabel("Pokemon Index");
        JComboBox<Pokemon> pokemonBookField = new JComboBox<>();
        for (BasePokemon basePokemon: taf.getAllBasePokemon()){
            pokemonBookField.addItem(taf.getPokemon(basePokemon));
        }
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> pokemonInfo(taf,
                (Pokemon) pokemonBookField.getSelectedItem(),
                " Basic Information"));
        pokemonBookPanel.add(pokemonBookLabel);
        pokemonBookPanel.add(pokemonBookField);
        pokemonBookPanel.add(searchButton);
        this.add(pokemonBookPanel);
    }

    public void addLibraryLine(TextAdventureFrame taf){
        JPanel pocketLibPanel = new JPanel();
        JLabel pocketLibLabel = new JLabel("My Pokemon Library");
        JComboBox<Pokemon> pokemonLib = new JComboBox<>();
        for (Pokemon pokemon: taf.getLibraryPokemons()){
            pokemonLib.addItem(pokemon);
        }
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,1,10,10));
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> pokemonInfo(taf,
                (Pokemon) pokemonLib.getSelectedItem(),
                " Information"));
        JButton intoPocketButton = new JButton("Put Into Pocket");
        intoPocketButton.addActionListener(e ->{
                taf.intoPocket((Pokemon) pokemonLib.getSelectedItem());
                taf.remove(this);
                taf.setContentPane(new BrowsePokemonPanel(taf));
                taf.pack();
        });
        buttonPanel.add(searchButton);
        buttonPanel.add(intoPocketButton);

        pocketLibPanel.add(pocketLibLabel);
        pocketLibPanel.add(pokemonLib);
        pocketLibPanel.add(buttonPanel);
        this.add(pocketLibPanel);
    }

    public void addBattlePokemon(TextAdventureFrame taf){
        JPanel BattlePokemonPanel = new JPanel();
        JLabel BattlePokemonLabel = new JLabel("Battle Pokemon Pocket");
        JComboBox<Pokemon> BattlePokemonField = new JComboBox<>();
        for (Pokemon Pokemon: taf.getPocketPokemons()){
            BattlePokemonField.addItem(Pokemon);
        }
        BattlePokemonPanel.add(BattlePokemonLabel);
        BattlePokemonPanel.add(BattlePokemonField);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3,1,10,10));
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> pokemonInfo(taf,
                (Pokemon) BattlePokemonField.getSelectedItem(),
                " Information"));
        JButton setFirstButton = new JButton("Set As Starter");
        setFirstButton.addActionListener(e ->{
                taf.setFirstPokemon((Pokemon) BattlePokemonField.getSelectedItem());
                taf.remove(this);
                taf.setContentPane(new BrowsePokemonPanel(taf));
                taf.pack();
        });
        JButton intoLibButton = new JButton("Put Into Library");
        intoLibButton.addActionListener(e ->{
                taf.intoLib((Pokemon) BattlePokemonField.getSelectedItem());
                taf.remove(this);
                taf.setContentPane(new BrowsePokemonPanel(taf));
                taf.pack();
        });
        buttonPanel.add(searchButton);
        buttonPanel.add(setFirstButton);
        buttonPanel.add(intoLibButton);
        BattlePokemonPanel.add(buttonPanel);
        this.add(BattlePokemonPanel);
    }

    public void pokemonInfo(TextAdventureFrame taf, Pokemon pokemon, String title){
        PokemonDialog pokemonDialog = new PokemonDialog(taf, pokemon);
        pokemonDialog.setTitle(pokemon.getName() + title);
        pokemonDialog.setModal(true);
        pokemonDialog.setSize(500,720);
        pokemonDialog.setVisible(true);
        if (pokemonDialog.isAcceptable()){
            taf.remove(this);
        }
    }

}
