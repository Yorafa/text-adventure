package Gui_gateway;


import GUI_Usecase.TextAdventureMap;
import com.google.gson.*;
import GUI_Controller.MapController;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapGate {
    public static void writeMapController(MapController mapController){
        Gson gson = new Gson();
        String mapManagerJson = gson.toJson(mapController);
        try {
            FileWriter mapFile = new FileWriter("gamedata/GuiData/map/mapdata.json");
            mapFile.write(mapManagerJson);
            mapFile.close();}
        catch (IOException e) {
            e.printStackTrace();}

    }
    public static MapController readMapController(){
        try {
            File mapFile = new File("gamedata/GuiData/map/mapdata.json");
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

