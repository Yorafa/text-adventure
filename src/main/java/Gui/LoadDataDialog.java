package Gui;

import GuiUsecase.GuiGameData;

import javax.swing.*;
import java.awt.*;

public class LoadDataDialog extends JDialog {
    private final TextAdventureFrame parent;

    public LoadDataDialog(TextAdventureFrame parent){
        super(parent);
        this.parent = parent;

        JPanel mainPanel = new JPanel();
        this.setContentPane(mainPanel);
        mainPanel.setLayout(new GridLayout(2,1,20,20));
        mainPanel.add(dataInfoPanel());
        mainPanel.add(back());
    }

    public JPanel dataInfoPanel(){
        JPanel dataInfo = new JPanel();
        dataInfo.setLayout(new GridLayout(1,3,10,10));
        JLabel dataLabel = new JLabel("GameData Saving Date");
        JComboBox<GuiGameData> guiGameDataField = new JComboBox<>();
        for (GuiGameData guiGameData: parent.getAllSaves()){
            guiGameDataField.addItem(guiGameData);
        }
        JButton loadButton = new JButton("Load");
        loadButton.addActionListener(e -> parent.load((GuiGameData) guiGameDataField.getSelectedItem()));
        dataInfo.add(dataLabel);
        dataInfo.add(guiGameDataField);
        dataInfo.add(loadButton);
        return dataInfo;
    }

    public JButton back(){
        JButton back = new JButton("Back");
        back.addActionListener(e -> setVisible(false));
        return back;
    }
}
