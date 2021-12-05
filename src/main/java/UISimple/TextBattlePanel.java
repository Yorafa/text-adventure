package UISimple;

import usecase.BattleManager;
import usecase.ExperiencePointCalculator;
import usecase.PokemonManager;

import java.util.Scanner;

public class TextBattlePanel extends TextPanel implements PanelState {
    private PokemonManager pokemonManager;
    private BattleManager battleManager;
    private BattlePresenter battlePresenter;

    public TextBattlePanel(Scanner input, GameController gameController, PokemonManager pokemonManager, BattleManager battleManager) {
        super(input, gameController);
        this.pokemonManager = pokemonManager;
        this.battleManager = battleManager;
        this.battlePresenter = new BattlePresenter();
        this.battleManager.setPresenter(battlePresenter);
    }

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
            gameController.changeStateExplore();
        }
    }

    @Override
    public void printMenu() {
        battlePresenter.addAttack();
        battlePresenter.addDefense();
        battlePresenter.addHeal();
        battlePresenter.addCapture();
        battlePresenter.addEscape();
        battlePresenter.printAllEnum();
    }

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
                gameController.changeStateExplore();
                battlePresenter.printEscaped();
                break;
            default:
                battlePresenter.notValid();
        }
    }
}