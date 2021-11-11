package gateway;


import com.google.gson.*;
import usecase.MapManager;


import java.io.*;
import java.util.Scanner;

public class MapGate {
    public static void writeMM(MapManager mapManager){
        Gson gson = new Gson();
        String mapManagerJson = gson.toJson(mapManager);
        try {
            FileWriter mapFile = new FileWriter("gamedata/mapdata.json");
            mapFile.write(mapManagerJson);
            mapFile.close();}
        catch (IOException e) {
            e.printStackTrace();}

    }
    public static MapManager readMM(){
        try {
            File mapFile = new File("gamedata/mapdata.json");
            Scanner scanner = new Scanner(mapFile);
            StringBuilder mapString = new StringBuilder();
            while (scanner.hasNext()){
                mapString.append(scanner.next().strip());
            }
            String mapManagerJson = mapString.toString();
            Gson gson = new Gson();
            return gson.fromJson(mapManagerJson, MapManager.class);}
        catch (IOException e) {
            e.printStackTrace();}
        return null;
    }
}
