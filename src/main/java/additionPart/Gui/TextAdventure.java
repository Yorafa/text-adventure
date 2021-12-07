package additionPart.Gui;

import additionPart.GuiController.MapController;
import additionPart.GuiController.UserController;
import additionPart.GuiGateway.MapGate;
import additionPart.GuiGateway.PokemonGate;
import additionPart.GuiGateway.UserGate;
import entity.*;

import javax.swing.*;

public class TextAdventure {

    public static void main(String[] args) {
        UserController userController = UserGate.readUM();
        MapController mapController = MapGate.readMapController();
        PokemonBook pokemonBook = PokemonGate.toPokemonBook();
        JFrame frame = new TextAdventureFrame(userController, mapController, pokemonBook);
    }
}
