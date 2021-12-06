package presenter;

public class ChangePlacePresenter extends Presenter {
    public void addCancel() {
        addToQueue("Cancel");
    }

    public void printMapChanged(String mapName) {
        System.out.println("You are at " + mapName + " now.");
    }
}