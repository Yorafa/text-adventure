package GUI_Controller;

import entity.Pokemon;


public class BattleController {
    private Pokemon playerPokemon;

    private Pokemon wildPokemon;

    public BattleController(Pokemon playerPokemon, Pokemon wildPokemon){
        this.playerPokemon = playerPokemon;
        this.wildPokemon = wildPokemon;
    }

    public void setPlayerPokemon(Pokemon playerPokemon) {
        this.playerPokemon = playerPokemon;
    }

    public void setWildPokemon(Pokemon wildPokemon) {
        this.wildPokemon = wildPokemon;
    }

    public Pokemon getWildPokemon() {
        return wildPokemon;
    }

    public Pokemon getPlayerPokemon() {
        return playerPokemon;
    }
}
