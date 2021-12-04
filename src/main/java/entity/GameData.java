package entity;

import java.io.Serializable;

public class GameData implements Serializable {
    private Pocket pocket;
    private Pmap currentPlace;

    public Pocket getPocket() {
        return pocket;
    }

    public void setPocket(Pocket pocket) {
        this.pocket = pocket;
    }

    public Pmap getCurrentPlace() {
        return currentPlace;
    }

    public void setCurrentPlace(Pmap currentPlace) {
        this.currentPlace = currentPlace;
    }
}
