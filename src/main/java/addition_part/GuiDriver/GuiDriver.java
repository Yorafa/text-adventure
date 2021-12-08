package addition_part.GuiDriver;

import addition_part.GuiController.SaveLoadController;
import entity.Pokemon;
import entity.PokemonBook;
import gateway.MapJsonReader;
import gateway.PokemonJsonReader;
import gateway.UserReadWriter;
import usecase_map.MapManager;
import usecase_pokemon.PokemonManager;
import usecase_user.UserManager;

public class GuiDriver {
    private final UserManager userManager;
    private final MapManager mapManager;
    private final PokemonManager pokemonManager;
    private final SaveLoadController saveLoadController;
    private Pokemon wildPokemon = null;

    /**
     * Construct a TextAdventureFrame, given them the given userController,
     * mapController and pokemonBook
     *
     * The relative classes
     * @see UserManager
     * @see MapManager
     * @see PokemonBook
     * @see Pokemon
     * @see SaveLoadController
     */
    public GuiDriver(){
        this.userManager = new UserManager(new UserReadWriter());
        this.mapManager = new MapManager(new MapJsonReader());
        this.pokemonManager = new PokemonManager(new PokemonJsonReader());
        this.saveLoadController = new SaveLoadController();
    }

    public Pokemon getWildPokemon() {
        return wildPokemon;
    }

    public void setWildPokemon(Pokemon wildPokemon) {
        this.wildPokemon = wildPokemon;
    }

    public MapManager getMapManager() {
        return mapManager;
    }

    public PokemonManager getPokemonManager() {
        return pokemonManager;
    }

    public SaveLoadController getSaveLoadController() {
        return saveLoadController;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUp(String username){
        saveLoadController.setReadWriter(username);
        mapManager.setCurrentPlace(saveLoadController.getCurrentPlace());
        pokemonManager.setPocket(saveLoadController.getPocket());
    }
}
