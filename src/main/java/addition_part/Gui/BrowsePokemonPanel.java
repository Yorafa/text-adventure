package addition_part.Gui;

import entity.BasePokemon;
import entity.Pokemon;

import javax.swing.*;
import java.awt.*;

public class BrowsePokemonPanel extends JPanel {
    private final TextAdventureFrame parent;

    public BrowsePokemonPanel(TextAdventureFrame parent){
        this.setLayout(new GridLayout(4,1,20,20));
        this.parent = parent;
        addPokemonBookLine();
        addBattlePokemon();
        addLibraryLine();
        JButton returnButton = new JButton("Back");
        returnButton.addActionListener(e -> {parent.setContentPane(new MapPanel(parent));
        parent.pack();});
        this.add(returnButton);
    }

    public void addPokemonBookLine(){
        JPanel pokemonBookPanel = new JPanel();
        JLabel pokemonBookLabel = new JLabel("Pokemon Index");
        JComboBox<Pokemon> pokemonBookField = new JComboBox<>();
        for (BasePokemon basePokemon: parent.getAllBasePokemon()){
            pokemonBookField.addItem(parent.getPokemon(basePokemon));
        }
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> pokemonInfo(
                (Pokemon) pokemonBookField.getSelectedItem(),
                " Basic Information"));
        pokemonBookPanel.add(pokemonBookLabel);
        pokemonBookPanel.add(pokemonBookField);
        pokemonBookPanel.add(searchButton);
        this.add(pokemonBookPanel);
    }

    public void addLibraryLine(){
        JPanel pocketLibPanel = new JPanel();
        JLabel pocketLibLabel = new JLabel("My Pokemon Library");
        JComboBox<Pokemon> pokemonLib = new JComboBox<>();
        for (Pokemon pokemon: parent.getLibraryPokemons()){
            pokemonLib.addItem(pokemon);
        }
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,1,10,10));
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> pokemonInfo(
                (Pokemon) pokemonLib.getSelectedItem(),
                " Information"));
        JButton intoPocketButton = new JButton("Put Into Pocket");
        intoPocketButton.addActionListener(e ->{
                parent.intoPocket((Pokemon) pokemonLib.getSelectedItem());
                parent.remove(this);
                parent.setContentPane(new BrowsePokemonPanel(parent));
                parent.pack();
        });
        buttonPanel.add(searchButton);
        buttonPanel.add(intoPocketButton);

        pocketLibPanel.add(pocketLibLabel);
        pocketLibPanel.add(pokemonLib);
        pocketLibPanel.add(buttonPanel);
        this.add(pocketLibPanel);
    }

    public void addBattlePokemon(){
        JPanel BattlePokemonPanel = new JPanel();
        JLabel BattlePokemonLabel = new JLabel("Battle Pokemon Pocket");
        JComboBox<Pokemon> BattlePokemonField = new JComboBox<>();
        for (Pokemon Pokemon: parent.getPocketPokemons()){
            BattlePokemonField.addItem(Pokemon);
        }
        BattlePokemonPanel.add(BattlePokemonLabel);
        BattlePokemonPanel.add(BattlePokemonField);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3,1,10,10));
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> pokemonInfo(
                (Pokemon) BattlePokemonField.getSelectedItem(),
                " Information"));
        JButton setFirstButton = new JButton("Set As Starter");
        setFirstButton.addActionListener(e ->{
                parent.setFirstPokemon((Pokemon) BattlePokemonField.getSelectedItem());
                parent.remove(this);
                parent.setContentPane(new BrowsePokemonPanel(parent));
                parent.pack();
        });
        JButton intoLibButton = new JButton("Put Into Library");
        intoLibButton.addActionListener(e ->{
                parent.intoLib((Pokemon) BattlePokemonField.getSelectedItem());
                parent.remove(this);
                parent.setContentPane(new BrowsePokemonPanel(parent));
                parent.pack();
        });
        buttonPanel.add(searchButton);
        buttonPanel.add(setFirstButton);
        buttonPanel.add(intoLibButton);
        BattlePokemonPanel.add(buttonPanel);
        this.add(BattlePokemonPanel);
    }

    public void pokemonInfo(Pokemon pokemon, String title){
        if (pokemon != null){
        PokemonDialog pokemonDialog = new PokemonDialog(parent, pokemon);
        pokemonDialog.setTitle(pokemon.getName() + title);
        pokemonDialog.setModal(true);
        pokemonDialog.setSize(500,720);
        pokemonDialog.setVisible(true);
        if (pokemonDialog.isAcceptable()){
            parent.remove(this);
        }}
    }
}
