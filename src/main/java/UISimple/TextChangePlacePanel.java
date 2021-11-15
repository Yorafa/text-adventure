package UISimple;

import java.util.List;
import java.util.Scanner;

public class TextChangePlacePanel extends TextPanel {
    private String newPlace;
    private List<String> mapNames;

    public TextChangePlacePanel(Scanner input, List<String> mapNames) {
        super(input);
        this.mapNames = mapNames;
    }

    @Override
    protected void execute(String choice) {
        try {
            int choiceIndex = Integer.parseInt(choice) - 1;
            options.get(choiceIndex);
            if (choiceIndex != options.size() - 1) {
                newPlace = mapNames.get(choiceIndex);
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            runPanel();
        }

    }

    public void addOption(String option) {
        options.add(option);
    }

    public String getNewPlace() {
        return newPlace;
    }
}
