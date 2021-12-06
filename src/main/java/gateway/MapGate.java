package gateway;


import com.google.gson.*;
import GuiController.MapController;


import java.io.*;
import java.util.Scanner;

public class MapGate {
    /**
     * @param mapController the controller of map
     */
    public static void writeMapController(MapController mapController){
        Gson gson = new Gson();
        String mapManagerJson = gson.toJson(mapController);
        try {
            FileWriter mapFile = new FileWriter("GuiData/map/mapdata.json");
            mapFile.write(mapManagerJson);
            mapFile.close();}
        catch (IOException e) {
            e.printStackTrace();}

    }
    public static MapController readMapController(){
        try {
            File mapFile = new File("GuiData/map/mapdata.json");
            Scanner scanner = new Scanner(mapFile);
            StringBuilder mapString = new StringBuilder();
            while (scanner.hasNext()){
                mapString.append(scanner.next().strip());
            }
            String mapManagerJson = mapString.toString();
            Gson gson = new Gson();
            return gson.fromJson(mapManagerJson, MapController.class);}
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

