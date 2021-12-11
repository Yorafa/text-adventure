package addition_part.gui_driver;

import addition_part.gui.TextAdventureFrame;

public class TextAdventure {

    public static void main(String[] args) {
        TextAdventureFrame frame = new TextAdventureFrame(new GuiDriver());
        frame.initialize();
    }
}
