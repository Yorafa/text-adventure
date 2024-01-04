package entity;

import java.io.Serializable;

/**
 * This class used store data of game
 *
 * @see Pocket
 * @see Pmap
 */
public class GameData implements Serializable {
    private Pocket pocket;
    private Pmap currentPlace;

    /**
     * the getter method of pocket
     *
     * @return player's pocket
     */
    public Pocket getPocket() {
        return pocket;
    }

    /**
     * the setter method of pocket
     *
     * @param pocket player's pocket
     */
    public void setPocket(Pocket pocket) {
        this.pocket = pocket;
    }

    /**
     * the getter method of currentPlace
     *
     * @return current place that player stay
     */
    public Pmap getCurrentPlace() {
        return currentPlace;
    }

    /**
     * the setter method of currentPlace
     *
     * @param currentPlace current place that player stay
     */
    public void setCurrentPlace(Pmap currentPlace) {
        this.currentPlace = currentPlace;
    }
}