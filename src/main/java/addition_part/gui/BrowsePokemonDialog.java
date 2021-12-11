package addition_part.gui;

import addition_part.gui_driver.GuiDriver;
import entity.Pokemon;
import usecase_pokemon.PokemonManager;

import javax.swing.*;
import java.awt.*;

public class BrowsePokemonDialog extends JDialog {
    private final TextAdventureFrame parent;
    private final PokemonManager pokemonManager;
    private final JComboBox<Pokemon> comboBox = new JComboBox<>();

    public BrowsePokemonDialog(TextAdventureFrame parent, GuiDriver guiDriver) {
        this.parent = parent;
        this.pokemonManager = guiDriver.getPokemonManager();
        addBattlePokemon();
    }

    private void addBattlePokemon() {
        JPanel BattlePokemonPanel = new JPanel();
        JLabel BattlePokemonLabel = new JLabel("My Pokemon: ");
        for (Pokemon Pokemon : pokemonManager.getPocket()) {
            comboBox.addItem(Pokemon);
        }
        BattlePokemonPanel.add(BattlePokemonLabel);
        BattlePokemonPanel.add(comboBox);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 10, 10));
        JButton searchButton = new JButton("Show pokemon information");
        searchButton.addActionListener(e -> pokemonInfo(
                (Pokemon) comboBox.getSelectedItem()
        ));
        JButton setFirstButton = new JButton("Set As Starter");
        setFirstButton.addActionListener(e ->
                pokemonManager.getPocket().setFirstPokemon((Pokemon) comboBox.getSelectedItem())
        );
        buttonPanel.add(searchButton);
        buttonPanel.add(setFirstButton);
        BattlePokemonPanel.add(buttonPanel);
        this.add(BattlePokemonPanel);
    }

    private void pokemonInfo(Pokemon pokemon) {
        if (pokemon != null) {
            PokemonDialog pokemonDialog = new PokemonDialog(parent, pokemon);
            pokemonDialog.setTitle(pokemon.getName() + " Information");
            pokemonDialog.setModal(true);
            pokemonDialog.setSize(500, 720);
            pokemonDialog.setVisible(true);
        }
    }
}