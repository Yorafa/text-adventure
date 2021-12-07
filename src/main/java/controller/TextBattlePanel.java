package controller;

import driver.GameDriver;
import presenter.BattlePresenter;
import usecase_battle.BattleManager;
import usecase_pokemon.ExperiencePointCalculator;
import usecase_pokemon.PokemonManager;

import java.util.Scanner;

/**
 * This is the battle panel when player meet wild pokemon
 */
public class TextBattlePanel extends TextPanel{
    private final PokemonManager pokemonManager;
    private final BattleManager battleManager;
    private final BattlePresenter battlePresenter;

    /**
     * Construct a TextBattlePanel, given them the given input, gameDriver,
     * pokemonManager and battleManger
     * @param input the player input
     * @param gameDriver the main driver of game
     * @param pokemonManager the manager of pokemon
     * @param battleManager the battle manager of pokemon
     *
     * The relative class
     * @see GameDriver
     * @see PokemonManager
     * @see BattleManager
     * @see PanelState
     * @see TextPanel
     */
    public TextBattlePanel(Scanner input, GameDriver gameDriver,
                           PokemonManager pokemonManager, BattleManager battleManager) {
        super(input, gameDriver);
        this.pokemonManager = pokemonManager;
        this.battleManager = battleManager;
        this.battlePresenter = new BattlePresenter();
        this.battleManager.setPresenter(battlePresenter);
    }

    /**
     * {@inheritDoc}
     *
     * Judge whether the battle is going on, and call the battlePresenter to present action
     * if true, call execute
     * else, exit the battle, settlement experience and switch state
     */
    @Override
    public void run() {
        if (battleManager.isBattling()) {
            battleManager.printStatus();
            super.run();
        } else {
            battleManager.printBattleResult();
            ExperiencePointCalculator experiencePointCalculator = new ExperiencePointCalculator();
            int experiencePointGained = experiencePointCalculator.calculate(battleManager.getP2());
            pokemonManager.addExperiencePoint(battleManager.getP1(), experiencePointGained);
            battlePresenter.printGainExperiencePoint(battleManager.getP1Name(), experiencePointGained);
            gameDriver.changeStateExplore();
        }
    }

    /**
     * Call presenter to show what action player can do
     */
    @Override
    public void printMenu() {
        battlePresenter.addAttack();
        battlePresenter.addDefense();
        battlePresenter.addHeal();
        battlePresenter.addCapture();
        battlePresenter.addEscape();
        battlePresenter.printAllEnum();
    }

    /**
     * Read player's input and execute the respective action
     *
     * @param choice the string that player input
     */
    @Override
    protected void execute(String choice) {
        switch (choice) {
            case "1": // Attack
                battleManager.attack();
                break;
            case "2": // Defense
                battleManager.defense();
                break;
            case "3": // Heal
                battleManager.heal();
                break;
            case "4": // Capture
                if (battleManager.capture()) {
                    pokemonManager.add(battleManager.getP2());
                    battleManager.endBattle();
                }
                break;
            case "5": // Escape
                gameDriver.changeStateExplore();
                battlePresenter.printEscaped();
                break;
            default:
                battlePresenter.notValid();
        }
    }
}