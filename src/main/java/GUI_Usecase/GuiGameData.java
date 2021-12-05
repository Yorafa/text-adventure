package entity;

import GUI_Usecase.TextAdventureMap;

import java.io.Serializable;

public class GuiGameData implements Serializable {
    private Pocket pocket;
    private TextAdventureMap currentPlace;

    public GuiGameData(Pocket pocket, TextAdventureMap currentPlace) {
        this.pocket = pocket;
        this.currentPlace = currentPlace;
    }

    public GuiGameData(){
        this.pocket = new Pocket();
        this.currentPlace = null;
    }

    public Pocket getPocket() {
        return pocket;
    }

    public void setPocket(Pocket pocket) {
        this.pocket = pocket;
    }

    public TextAdventureMap getCurrentPlace() {
        return currentPlace;
    }

    public void setCurrentPlace(TextAdventureMap currentPlace) {
        this.currentPlace = currentPlace;
    }
}
