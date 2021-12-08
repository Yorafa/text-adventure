package addition_part.GuiGateway;


import addition_part.GuiController.MapController;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MapGate {
    public static MapController readMapController() {
        try {
            File mapFile = new File("GuiData/map/mapdata.json");
            Scanner scanner = new Scanner(mapFile);
            StringBuilder mapString = new StringBuilder();
            while (scanner.hasNext()) {
                mapString.append(scanner.next().strip());
            }
            String mapManagerJson = mapString.toString();
            Gson gson = new Gson();
            return gson.fromJson(mapManagerJson, MapController.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

