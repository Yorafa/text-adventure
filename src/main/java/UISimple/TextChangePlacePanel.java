package UISimple;

import entity.Pmap;
import usecase.MapManager;

import java.util.List;
import java.util.Scanner;

public class TextChangePlacePanel extends TextPanel implements PanelState {
    private Pmap newPlace;
    private List<Pmap> maps;

    public TextChangePlacePanel(Scanner input, GameController gameController, List<Pmap> maps, MapManager mapManager) {
        super(input, gameController);
        this.maps = maps;
        int i = 1;
        for (Pmap map : maps) {
            i++;
        }
    }

    @Override
    protected void printMenu() {

    }

    @Override
    protected void execute(String choice) {
//        try {
//            int choiceIndex = Integer.parseInt(choice) - 1;
//            options.get(choiceIndex);
//            if (choiceIndex != options.size() - 1) {
//                newPlace = maps.get(choiceIndex);
//            }
//        } catch (NumberFormatException | IndexOutOfBoundsException e) {
//            System.out.println("Not valid.");
//            run();
//        }
    }

    public Pmap getNewPlace() {
        return newPlace;
    }
}
