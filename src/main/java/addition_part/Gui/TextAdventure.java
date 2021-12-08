package addition_part.Gui;

import addition_part.GuiController.MapController;
import addition_part.GuiController.UserController;
import addition_part.GuiGateway.MapGate;
import addition_part.GuiGateway.PokemonGate;
import addition_part.GuiGateway.UserGate;
import entity.PokemonBook;

import javax.swing.*;

public class TextAdventure {

    public static void main(String[] args) {
        UserController userController = UserGate.readUM();
        MapController mapController = MapGate.readMapController();
        PokemonBook pokemonBook = PokemonGate.toPokemonBook();
        JFrame frame = new TextAdventureFrame(userController, mapController, pokemonBook);
    }
}
