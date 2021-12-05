package GUI;

import GUI_Controller.*;
import GUI_Usecase.*;
import Gui_gateway.*;
import entity.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TextAdventureFrame extends JFrame {
    private UserController userController;
    private MapController mapController;
    private PokemonBook pokemonBook;
    private Pokemon wildPokemon;
    private PlayerPokemonController playerPokemonController;


    public TextAdventureFrame(UserController userController, MapController mapController, PokemonBook pokemonBook) {
        this.userController = userController;
        this.mapController = mapController;
        this.pokemonBook = pokemonBook;
        this.playerPokemonController = null;
        this.wildPokemon = null;
        // Setup frame
        this.setTitle("Text Adventure");
        this.setSize(new Dimension(1280,720));
        this.setPreferredSize(new Dimension(1280,720));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoginPanel loginPanel = new LoginPanel(this);
        this.setContentPane(loginPanel);
        this.pack();
        this.setVisible(true);
    }

    // setter function
    public void setUser(User user) {
        userController.setCurrentUser(user);
    }

    public void setMap(TextAdventureMap textAdventureMap) {
        mapController.setCurrentPlace(textAdventureMap);
    }

    public void setMap(String mapName) {
        mapController.setCurrentPlace(mapController.find(mapName));
    }

    public void setUp(){
        GuiGameData guiGameData = GameDataGate.readGameData(this.getUser());
        this.setMap(guiGameData.getCurrentPlace());

    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    public void setMapController(MapController mapController) {
        this.mapController = mapController;
    }

    public void setPokemonBook(PokemonBook pokemonBook) {
        this.pokemonBook = pokemonBook;
    }

    public void setPlayerPokemonController(PlayerPokemonController playerPokemonController) {
        this.playerPokemonController = playerPokemonController;
    }

    // getter functions
    public Pokemon getFirstPokemon(){
        return this.playerPokemonController.getFirstPokemon();
    }

    public Pokemon getWildPokemon() {
        return wildPokemon;
    }

    public PokemonBook getPokemonBook() {
        return pokemonBook;
    }

    public List<Pokemon> getPocketPokemons(){
        return this.playerPokemonController.getPocketPokemons();
    }

    public List<Pokemon> getLibraryPokemons(){
        return  this.playerPokemonController.getLibraryPokemons();
    }

    public User getUser() {
        return userController.getCurrentUser();
    }

    public TextAdventureMap getMap() {
        return mapController.getCurrentPlace();
    }

    public UserController getUserManager() {
        return this.userController;
    }

    public MapController getMapManager() {
        return mapController;
    }

    public GuiGameData getGameData(){
        return new GuiGameData(this.playerPokemonController.getPlayerPokemons(), this.mapController.getCurrentPlace());
    }

    // Controller usage function
    public PlayerPokemonController getPlayerPokemonController() {
        return playerPokemonController;
    }

    public void setFirstPokemon(Pokemon pokemon){
        this.playerPokemonController.setFirstPokemon(pokemon);
    }

    public List<BasePokemon> getAllBasePokemon(){
        return this.pokemonBook.getPokemonBook();
    }

    public void intoLib(Pokemon pokemon){
        if (! playerPokemonController.intoLib(pokemon)){
                String message = "Invalid action: only 1 pokemon in your pocket";
                JOptionPane.showMessageDialog(this, message,
                        "Warning", JOptionPane.WARNING_MESSAGE);
            }
    }

    public void fight(){}

    public void walkAround() {
        this.wildPokemon = this.mapController.walkAround(pokemonBook);
    }

    public Pokemon getPokemon(String pokemonName){
        BasePokemon basePokemon = this.pokemonBook.getPokemon(pokemonName);
        PokemonData pokemonData = new PokemonData(basePokemon.getPokemonType(),
                basePokemon.getMaxHitPoint(),
                basePokemon.getAttackPoint(),
                basePokemon.getDefencePoint(),
                basePokemon.getSpeed());
        return new Pokemon(basePokemon.getName(),basePokemon.getBasePokemonData(),
                1,0, basePokemon.getMaxHitPoint(), pokemonData);
    }

    public Pokemon getPokemon(BasePokemon basePokemon){
        PokemonData pokemonData = new PokemonData(basePokemon.getPokemonType(),
                basePokemon.getMaxHitPoint(),
                basePokemon.getAttackPoint(),
                basePokemon.getDefencePoint(),
                basePokemon.getSpeed());
        return new Pokemon(basePokemon.getName(),basePokemon.getBasePokemonData(),
                1,0, basePokemon.getMaxHitPoint(), pokemonData);
    }

    public void newStart() {
        this.setMap("Home");
        this.setPlayerPokemonController(new PlayerPokemonController(new GuiPlayerPokemons()));
    }

    public void addPokemon(Pokemon pokemon){
        if (playerPokemonController.addPocketPokemon(pokemon)){
            String message = "Since your pocket is full, your pokemon is moved into library";
            JOptionPane.showMessageDialog(this, message,
                    "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void intoPocket(Pokemon pokemon) {
        if (! playerPokemonController.moveIntoPocket(pokemon)){
            String message = "Since your pocket is full, your pokemon is moved back library";
            JOptionPane.showMessageDialog(this, message,
                    "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
}
