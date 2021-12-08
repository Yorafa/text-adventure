package addition_part.Gui;

import addition_part.GuiDriver.GuiDriver;
import addition_part.battle.BattlePanel;

import javax.swing.*;
import java.awt.*;

public class TextAdventureFrame extends JFrame {
    private final GuiDriver guiDriver;
    private JPanel panel;

    /**
     * Construct a TextAdventureFrame, given them the given guiDriver
     *
     * @param guiDriver the main driver of game
     */
    public TextAdventureFrame(GuiDriver guiDriver) {
        this.guiDriver = guiDriver;
        // Setup frame
        initialize();
    }

    public void loginPanel(){
        this.panel = new LoginPanel(this, guiDriver);
        this.setContentPane();
        this.pack();
    }

    public void initialPanel(){
        this.panel = new InitialPanel(this, guiDriver);
        this.setContentPane();
        this.pack();
    }

    public void browsePokemonPanel(){
        BrowsePokemonDialog dialog = new BrowsePokemonDialog(this, guiDriver);
        dialog.setTitle("Check the Pokemon Book/Change the battle pokemon");
        dialog.setModal(true);
        dialog.setSize(500,150);
        dialog.setVisible(true);
    }

    public void explorePanel(){
        this.panel = new ExplorePanel(this, guiDriver);
        this.setContentPane();
        this.pack();
    }

    public void battlePanel(){
        this.panel = new BattlePanel(this, guiDriver);
        this.setContentPane();
        this.pack();
    }

    private void setContentPane() {
        this.setContentPane(panel);
    }

    private void initialize() {
        this.setTitle("Text Adventure");
        this.setSize(new Dimension(1280, 720));
        this.setPreferredSize(new Dimension(1280, 720));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginPanel();
        this.setContentPane();
        this.pack();
        this.setVisible(true);
    }
}