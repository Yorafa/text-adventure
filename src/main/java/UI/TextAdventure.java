package UI;

import entity.*;
import usecase.*;
import gateway.*;

import javax.swing.*;
import java.awt.*;

public class TextAdventure {

    public static void main(String[] args) {
        UserManager userManager = UserGate.readUM();
        MapManager mapManager = MapGate.readMM();
        PokemonBook pokemonBook = PokemonGate.toPokemonBook();
        GameData gameData = new GameData(new Pocket(), null);
        mapManager.setCurrentPlace(gameData.getCurrentPlace());
        JFrame frame = new TextAdventureFrame(userManager, mapManager, pokemonBook, gameData.getPocket());
    }
}
