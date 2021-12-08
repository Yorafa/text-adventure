package addition_part.Gui;

import entity.Pmap;
import usecase_map.MapManager;

import javax.swing.*;
import java.awt.*;

public class MapChangingPanel extends JPanel {
    private final MapManager mapManager;
    public MapChangingPanel(MapManager mapManager) {
        this.mapManager = mapManager;
        initialize();
    }

    private void initialize(){
        this.setLayout(new GridLayout(1,3,10,10));
        this.add(nameLabel());
        JComboBox<Pmap> comboBox = comboBox();
        this.add(comboBox);
        this.add(switchButton(comboBox));
    }

    private JButton switchButton(JComboBox<Pmap> comboBox){
        JButton switchButton = new JButton("Switch to");
        switchButton.addActionListener(e -> setCurrentPlace((Pmap) comboBox.getSelectedItem()));
        return switchButton;
    }

    private JLabel nameLabel(){
        return new JLabel("Select map you want to go");
    }

    private JComboBox<Pmap> comboBox(){
        JComboBox<Pmap> comboBox = new JComboBox<>();
        for (Pmap map: mapManager.getPmaps()) comboBox.addItem(map);
        return comboBox;
    }

    private void setCurrentPlace(Pmap pmap){
        mapManager.setCurrentPlace(pmap);
    }
}
