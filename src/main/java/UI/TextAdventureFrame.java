package UI;

import usecase.*;
import entity.*;

import javax.swing.*;
import java.awt.*;

public class TextAdventureFrame extends JFrame {
    private UserManager userManager;
    private MapManager mapManager;
    private BattleManager battleManager;
    private PokemonBook pokemonBook;
    private Pokemon wildPokemon;
    private Pocket pocket;


    public TextAdventureFrame(UserManager userManager, MapManager mapManager, PokemonBook pokemonBook, Pocket pocket) {
        this.userManager = userManager;
        this.mapManager = mapManager;
        this.pokemonBook = pokemonBook;
        this.pocket = pocket;
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
        userManager.setCurrentUser(user);
    }

    public void setMap(Pmap pmap) {
        mapManager.setCurrentPlace(pmap);
    }

    public void setMap(String mapName) {
        mapManager.setCurrentPlace(mapManager.find(mapName));
    }

    public User getUser() {
        return userManager.getCurrentUser();
    }

    public Pmap getMap() {
        return mapManager.getCurrentPlace();
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public void setMapManager(MapManager mapManager) {
        this.mapManager = mapManager;
    }

    public void setPokemonBook(PokemonBook pokemonBook) {
        this.pokemonBook = pokemonBook;
    }

    public UserManager getUserManager() {
        return this.userManager;
    }

    public MapManager getMapManager() {
        return mapManager;
    }

    public void fight(){}

    public void walkAround() {
        this.wildPokemon = this.mapManager.walkAround(pokemonBook);
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
}
