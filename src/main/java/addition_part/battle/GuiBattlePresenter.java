package addition_part.battle;

import usecase_battle.IBattlePresenter;

import javax.swing.*;
import java.awt.*;

public class GuiBattlePresenter extends JPanel implements IBattlePresenter {
    private final JLabel textLabel = new JLabel();
    private final JPanel battleInfo = new JPanel();

    public GuiBattlePresenter(){
        battleInfo.setLayout(new GridLayout(1, 2,50,50));
        initialize();
    }

    @Override
    public void printStatus(String name, int level, int hitPoint, int maxHitPoint) {
        if (battleInfo.getComponents().length < 2){
            battleInfoAdd(new BattleStatusPanel(name, level, hitPoint, maxHitPoint));
        }
        else{
            battleInfo.removeAll();
            printStatus(name, level, hitPoint, maxHitPoint);
        }
    }

    @Override
    public void printAttack(String attacker, String attacked, int damage) {
        textLabel.setText(attacker + " attacked " + attacked + ", and made " + damage + " damage.");
    }

    @Override
    public void printDefense(String name) {
        textLabel.setText(name + " is defending. ");
    }

    @Override
    public void printDefenseSucceed(String name) {
        textLabel.setText(name + " successfully defended.");
    }

    @Override
    public void printDefenseFail(String name) {
        textLabel.setText(name + " defended nothing.");
    }

    @Override
    public void printHeal(String nameP1, int healedPoint) {
        textLabel.setText(nameP1 + " healed, and gained " + healedPoint + " hit points.");
    }

    @Override
    public void printCaptured(String name) {
        String message = "Succeed to capture " + name;
        JOptionPane.showMessageDialog(this, message, "Capturing Info", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void printNotCaptured(String name) {
        String message = "Fail to capture " + name;
        JOptionPane.showMessageDialog(this, message, "Capturing Info", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void printBattleEnded() {
        textLabel.setText("This battle is ended");
    }

    @Override
    public void printDraw() {
        String message = "A draw battle!";
        JOptionPane.showMessageDialog(this, message, "Battle Status", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void printLose() {
        String message = "You Lose, your Pokemon need healing !!!";
        JOptionPane.showMessageDialog(this, message, "Battle Status", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void printWin() {
        String message = "You Win!!!";
        JOptionPane.showMessageDialog(this, message, "Battle Status", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void printEscaped() {

    }

    @Override
    public void printGainExperiencePoint(String name, int experiencePointGained) {
        textLabel.setText(name + " gained " + experiencePointGained + " experience points.");
    }

    private void initialize() {
        this.setLayout(new BorderLayout());
        JLabel emptyLabel1 = new JLabel("");
        emptyLabel1.setPreferredSize(new Dimension(0, 50));
        JLabel emptyLabel2 = new JLabel("");
        emptyLabel2.setPreferredSize(new Dimension(0, 0));
        JLabel emptyLabel3 = new JLabel("");
        emptyLabel3.setPreferredSize(new Dimension(150, 0));
        JLabel emptyLabel4 = new JLabel("");
        emptyLabel4.setPreferredSize(new Dimension(100, 0));
        this.add(emptyLabel1, BorderLayout.NORTH);
        this.add(emptyLabel2, BorderLayout.SOUTH);
        this.add(emptyLabel3, BorderLayout.WEST);
        this.add(emptyLabel4, BorderLayout.EAST);
        this.add(setUpMainPanel(), BorderLayout.CENTER);
    }

    private void battleInfoAdd(BattleStatusPanel battleStatusPanel){
        battleInfo.add(battleStatusPanel);
    }
    private JPanel setUpMainPanel(){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2,1,10,10));
        mainPanel.add(battleInfo);
        mainPanel.add(textLabel);
        return mainPanel;
    }

    /**
     *
     * @param name pokemon name
     * @param level pokemon level
     * @param hitPoint pokemon current hp
     * @param maxHitPoint pokemon max hp
     */
    public void setUp(String name, int level, int hitPoint, int maxHitPoint){
        battleInfoAdd(new BattleStatusPanel(name, level, hitPoint, maxHitPoint));
    }
}
