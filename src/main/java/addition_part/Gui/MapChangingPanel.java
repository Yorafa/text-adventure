package addition_part.Gui;

import entity.Pmap;
import usecase_map.MapManager;

import javax.swing.*;
import java.awt.*;

public class MapChangingPanel extends JPanel {
    private final MapManager mapManager;
    private final JComboBox<Pmap> comboBox = new JComboBox<>();

    public MapChangingPanel(MapManager mapManager) {
        this.mapManager = mapManager;
        initialize();
    }

    private void initialize(){
        this.setLayout(new GridLayout(1,3,10,10));
        this.add(nameLabel());
        this.add(comboBox);
        this.add(switchButton());
    }

    private JButton switchButton(){
        JButton switchButton = new JButton("Switch to");
        switchButton.addActionListener(e -> setCurrentPlace((Pmap) comboBox.getSelectedItem()));
        return switchButton;
    }

    private JLabel nameLabel(){
        return new JLabel("Select map you want to go");
    }

    private void addItem(){
        for (Pmap map: mapManager.getPmaps()) comboBox.addItem(map);
    }

    private void setCurrentPlace(Pmap pmap){
        mapManager.setCurrentPlace(pmap);
    }
}
