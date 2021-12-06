package Gui;

import GuiController.*;
import entity.*;
import gateway.*;

import javax.swing.*;

public class TextAdventure {

    public static void main(String[] args) {
        UserController userController = UserGate.readUM();
        MapController mapController = MapGate.readMapController();
        PokemonBook pokemonBook = PokemonGate.toPokemonBook();
        JFrame frame = new TextAdventureFrame(userController, mapController, pokemonBook);
    }
}
