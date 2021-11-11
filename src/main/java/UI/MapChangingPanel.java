package UI;

import entity.Pmap;

import javax.swing.*;
import java.awt.*;

public class MapChangingPanel extends JPanel {
    public MapChangingPanel(TextAdventureFrame taf) {
        taf.setContentPane(this);

        for (Pmap pmap : taf.getMapManager().getMaps()) {
            showMap(pmap.getMapName(), taf);
        }
    }
    public void showMap(String name, TextAdventureFrame taf){
        JButton button = new JButton(name);
        button.addActionListener(e -> {
            taf.setMap(taf.getMapManager().find(name));
            taf.setContentPane(new MapPanel(taf));
        });
        this.add(button);
    }
}
