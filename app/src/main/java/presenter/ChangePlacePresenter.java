package presenter;

public class ChangePlacePresenter extends Presenter {

    /**
     * add Cancel option
     */
    public void addCancel() {
        addToQueue("Cancel");
    }

    /**
     * show player the current place is changed
     *
     * @param mapName the new current place
     */
    public void printMapChanged(String mapName) {
        System.out.println("You are at " + mapName + " now.");
    }
}