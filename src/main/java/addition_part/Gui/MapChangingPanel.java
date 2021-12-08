package addition_part.Gui;

import addition_part.GuiUsecase.TextAdventureMap;

import javax.swing.*;

public class MapChangingPanel extends JPanel {
    private final TextAdventureFrame parent;

    public MapChangingPanel(TextAdventureFrame parent) {
        this.parent = parent;
        this.setBorder(BorderFactory.createEmptyBorder(200, 400, 200, 400));

        showAll();
    }
    public void showMap(String name){
        JButton button = new JButton(name);
        button.addActionListener(e -> {
            parent.setCurrentMap(parent.getMapManager().find(name));
            parent.setContentPane(new MapPanel(parent));
            parent.pack();
        });
        this.add(button);
    }

    public void showAll(){
        for (TextAdventureMap textAdventureMap : parent.getMaps())
            showMap(textAdventureMap.getMapName());

    }
}
