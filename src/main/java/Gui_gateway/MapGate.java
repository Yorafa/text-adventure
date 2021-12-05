package Gui_gateway;


import com.google.gson.*;
import GUI_Controller.MapController;


import java.io.*;
import java.util.Scanner;

public class MapGate {
    public static void writeMM(MapController mapController){
        Gson gson = new Gson();
        String mapManagerJson = gson.toJson(mapController);
        try {
            FileWriter mapFile = new FileWriter("gamedata/map/mapdata.json");
            mapFile.write(mapManagerJson);
            mapFile.close();}
        catch (IOException e) {
            e.printStackTrace();}

    }
    public static MapController readMM(){
        try {
            File mapFile = new File("gamedata/map/mapdata.json");
            Scanner scanner = new Scanner(mapFile);
            StringBuilder mapString = new StringBuilder();
            while (scanner.hasNext()){
                mapString.append(scanner.next().strip());
            }
            String mapManagerJson = mapString.toString();
            Gson gson = new Gson();
            return gson.fromJson(mapManagerJson, MapController.class);}
        catch (IOException e) {
            e.printStackTrace();}
        return null;
    }
}

