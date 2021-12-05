package GUI;

import GUI_Controller.*;
import gateway.*;
import usecase.*;
import entity.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TextAdventureFrame extends JFrame {
    private UserController userController;
    private MapController mapController;
    private BattleManager battleManager;
    private PokemonBook pokemonBook;
    private Pokemon wildPokemon;
    private Pocket pocket;


    public TextAdventureFrame(UserController userController, MapController mapController, PokemonBook pokemonBook) {
        this.userController = userController;
        this.mapController = mapController;
        this.pokemonBook = pokemonBook;
        this.pocket = null;
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

    public void setUser(User user) {
        userController.setCurrentUser(user);
    }

    public void setMap(Pmap pmap) {
        mapController.setCurrentPlace(pmap);
    }

    public void setMap(String mapName) {
        mapController.setCurrentPlace(mapController.find(mapName));
    }

    public void setPocket(Pocket pocket) {
        this.pocket = pocket;
    }

    public void setUp(){
        GameData gameData = GameDataGate.readGameData(this.getUser());
        this.setMap(gameData.getCurrentPlace());
        this.setPocket(gameData.getPocket());
    }

    public void setUserManager(UserController userController) {
        this.userController = userController;
    }

    public void setMapManager(MapController mapController) {
        this.mapController = mapController;
    }

    public void setPokemonBook(PokemonBook pokemonBook) {
        this.pokemonBook = pokemonBook;
    }

    public Pokemon getFirstPokemon(){
        return this.pocket.getDefaultPokemon();
    }

    public Pokemon getWildPokemon() {
        return wildPokemon;
    }

    public PokemonBook getPokemonBook() {
        return pokemonBook;
    }

    public List<Pokemon> getBattlePokemons(){
        return this.pocket.getBattlePokemons();
    }

    public List<Pokemon> getPockePokemons(){
        return  this.pocket.getPokemons();
    }

    public User getUser() {
        return userController.getCurrentUser();
    }

    public Pmap getMap() {
        return mapController.getCurrentPlace();
    }

    public Pocket getPocket() {
        return pocket;
    }

    public UserController getUserManager() {
        return this.userController;
    }

    public MapController getMapManager() {
        return mapController;
    }

    public GameData getGameData(){
        return new GameData(this.pocket, this.mapController.getCurrentPlace());
    }

    public void setFirstPokemon(Pokemon pokemon){
        this.pocket.setFirstPokemon(pokemon);
    }

    public List<BasePokemon> getAllBasePokemon(){
        return this.pokemonBook.getPokemonBook();
    }

    public void intoLib(Pokemon pokemon){
        if (this.pocket.getBattlePokemons().size() > 1){
        this.pocket.intoLib(pokemon);}
        else{
            String message = "Invalid action: only 1 pokemon in your Battle pocket";
            JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);
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
        this.setPocket(new Pocket());
    }

    public void addPokemon(Pokemon pokemon){
        if (this.pocket.getBattlePokemons().size() >=6){
            this.pocket.addPokemon(pokemon);
        }
        else{
            this.pocket.addBattlePokemon(pokemon);
        }
    }

    public void intoPocket(Pokemon pokemon) {
        if (this.pocket.getBattlePokemons().size() >= 6){
            String message = "Invalid action: your Battle pocket is full";
            JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
            this.pocket.addBattlePokemon(pokemon);
        }
    }
}
