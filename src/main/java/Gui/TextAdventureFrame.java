package Gui;

import GuiController.MapController;
import GuiController.PlayerPokemonController;
import GuiController.SaveLoadController;
import GuiController.UserController;
import GuiUsecase.GuiGameData;
import GuiUsecase.GuiPlayerPokemons;
import GuiUsecase.TextAdventureMap;
import entity.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TextAdventureFrame extends JFrame {
    private final UserController userController;
    private final MapController mapController;
    private PokemonBook pokemonBook;
    private Pokemon wildPokemon;
    private PlayerPokemonController playerPokemonController;
    private SaveLoadController saveLoadController;

    /**
     * Construct a TextAdventureFrame, given them the given userController,
     * mapController and pokemonBook
     *
     * @param userController the controller of user
     * @param mapController the controller of map
     * @param pokemonBook the pokemon index of pokemon
     *
     * The relative classes
     * @see UserController
     * @see MapController
     * @see PokemonBook
     * @see Pokemon
     * @see PlayerPokemonController
     * @see SaveLoadController
     */
    public TextAdventureFrame(UserController userController, MapController mapController, PokemonBook pokemonBook) {
        this.userController = userController;
        this.mapController = mapController;
        this.pokemonBook = pokemonBook;
        this.playerPokemonController = null;
        this.saveLoadController = null;
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

    // setter methods
    public void setUser(User user) {
        userController.setCurrentUser(user);
    }

    public void setCurrentMap(TextAdventureMap textAdventureMap) {
        mapController.setCurrentPlace(textAdventureMap);
    }

    public void setCurrentMap(String mapName) {
        mapController.setCurrentPlace(mapController.find(mapName));
    }

    public void setUp(){
        saveLoadController = new SaveLoadController(getUser());
        GuiGameData gameData = saveLoadController.load();
        playerPokemonController = new PlayerPokemonController(gameData.getPlayerPokemons());
        setCurrentMap(gameData.getCurrentPlace());
    }

   public void setPokemonBook(PokemonBook pokemonBook) {
        this.pokemonBook = pokemonBook;
    }

   // getter methods
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

    public String getUserName() {
        return getUser().getUsername();
    }


    public TextAdventureMap getCurrentMap() {
        return mapController.getCurrentPlace();
    }

    public String getCurrentMapName() {
        return getCurrentMap().getMapName();
    }

    public UserController getUserController() {
        return this.userController;
    }

    public MapController getMapManager() {
        return mapController;
    }

    public List<TextAdventureMap> getMaps(){return mapController.getTextAdventureMaps();}
    // Controller usage methods

    public void setFirstPokemon(Pokemon pokemon){
        this.playerPokemonController.setFirstPokemon(pokemon);
    }

    public List<BasePokemon> getAllBasePokemon(){
        return this.pokemonBook.getPokemonBook();
    }

    public void intoLib(Pokemon pokemon){
        if (pokemon != null){
            if (! playerPokemonController.intoLib(pokemon)){
                    String message = "Invalid action: only 1 pokemon in your pocket";
                    JOptionPane.showMessageDialog(this, message,
                            "Warning", JOptionPane.WARNING_MESSAGE);
                }}}

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

    public User login(String Username,String Password){
        return userController.login(Username, Password);
    }
    public void newStart() {
        this.setCurrentMap("Home");
        this.playerPokemonController = (new PlayerPokemonController(new GuiPlayerPokemons()));
        this.saveLoadController = new SaveLoadController();
    }

    public void addPokemon(Pokemon pokemon){
        if (! playerPokemonController.addPocketPokemon(pokemon)){
            String message = "Since your pocket is full, your pokemon is moved into library";
            JOptionPane.showMessageDialog(this, message,
                    "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void intoPocket(Pokemon pokemon) {
        if (pokemon != null){
        if (! playerPokemonController.moveIntoPocket(pokemon)){
            String message = "Since your pocket is full, your pokemon is moved back library";
            JOptionPane.showMessageDialog(this, message,
                    "Warning", JOptionPane.WARNING_MESSAGE);
        }}
    }

    public void save(){
        saveLoadController.save(getUser(),
                new GuiGameData(this.playerPokemonController.getPlayerPokemons(),
                this.mapController.getCurrentPlace()), getUserController());
    }

    public void load(GuiGameData guiGameData){
        if (guiGameData != null){
        playerPokemonController.setPlayerPokemons(guiGameData.getPlayerPokemons());
        mapController.setCurrentPlace(guiGameData.getCurrentPlace());}
    }

    public List<GuiGameData> getAllSaves(){
        return saveLoadController.getGameDataHistory();
    }
}
