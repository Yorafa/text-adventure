package addition_part.battle;

import addition_part.gui.TextAdventureFrame;
import addition_part.gui_driver.GuiDriver;
import entity.Pokemon;
import usecase_battle.BattleManager;
import usecase_pokemon.ExperiencePointCalculator;
import usecase_pokemon.PokemonManager;

import javax.swing.*;
import java.awt.*;

public class BattlePanel extends JPanel {
    private final TextAdventureFrame parent;
    private final BattleManager battleManager;
    private final PokemonManager pokemonManager;
    private final GuiBattlePresenter battlePresenter;
    private final Pokemon playerPokemon;
    private final Pokemon wildPokemon;

    public BattlePanel(TextAdventureFrame parent, GuiDriver guiDriver) {
        this.parent = parent;
        this.pokemonManager = guiDriver.getPokemonManager();
        this.setLayout(new GridLayout(2, 1, 10, 10));
        this.playerPokemon = pokemonManager.getBattlePokemon();
        this.wildPokemon = guiDriver.getWildPokemon();
        this.battleManager = new BattleManager(playerPokemon, wildPokemon);
        this.battlePresenter = new GuiBattlePresenter();
        this.battleManager.setPresenter(battlePresenter);
        initialize();
    }

    private void initialize() {
        this.add(battlePresenter);
        battlePresenter.setUp(getPokemonName(playerPokemon), getPokemonLevel(playerPokemon),
                getPokemonHp(playerPokemon), getPokemonMaxHp(playerPokemon));
        battlePresenter.setUp(getPokemonName(wildPokemon), getPokemonLevel(wildPokemon),
                getPokemonHp(wildPokemon), getPokemonMaxHp(wildPokemon));
        setUpButtonPanel();
    }

    private void setUpButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2, 20, 20));
        buttonPanel.add(attackButton());
        buttonPanel.add(defenseButton());
        buttonPanel.add(healButton());
        buttonPanel.add(catchButton());
        buttonPanel.add(escapeButton());
        this.add(buttonPanel);
    }

    private JButton attackButton() {
        JButton attackButton = new JButton("Attack");
        attackButton.addActionListener(e -> {
            battleManager.attack();
            checkState();
        });
        return attackButton;
    }

    private JButton defenseButton() {
        JButton defenseButton = new JButton("Defense");
        defenseButton.addActionListener(e -> {
            battleManager.defense();
            checkState();
        });
        return defenseButton;
    }

    private JButton catchButton() {
        JButton catchButton = new JButton("Catch");
        catchButton.addActionListener(e -> {
            if (battleManager.capture()) {
                pokemonManager.add(battleManager.getP2());
                battleManager.endBattle();
            }
            checkState();
        });
        return catchButton;
    }

    private JButton escapeButton() {
        JButton escapeButton = new JButton("Escape");
        escapeButton.addActionListener(e -> {
            parent.explorePanel();
            battlePresenter.printEscaped();
        });
        return escapeButton;
    }

    private JButton healButton() {
        JButton healButton = new JButton("Heal");
        healButton.addActionListener(e -> {
            battleManager.heal();
            checkState();
        });
        return healButton;
    }

    private void checkState() {
        if (battleManager.isBattling()) {
            battleManager.printStatus();
        } else {
            battleManager.printBattleResult();
            ExperiencePointCalculator experiencePointCalculator = new ExperiencePointCalculator();
            int experiencePointGained = experiencePointCalculator.calculate(battleManager.getP2());
            pokemonManager.addExperiencePoint(battleManager.getP1(), experiencePointGained);
            battlePresenter.printGainExperiencePoint(battleManager.getP1Name(), experiencePointGained);
            parent.explorePanel();
        }
    }

    private String getPokemonName(Pokemon pokemon) {
        return pokemon.getName();
    }

    private int getPokemonHp(Pokemon pokemon) {
        return pokemon.getHitPoint();
    }

    private int getPokemonMaxHp(Pokemon pokemon) {
        return pokemon.getMaxHitPoint();
    }

    private int getPokemonLevel(Pokemon pokemon) {
        return pokemon.getLevel();
    }
}
