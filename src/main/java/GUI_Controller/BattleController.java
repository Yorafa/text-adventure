package GUI_Controller;

import entity.Pokemon;

import java.util.List;


public class BattleController {
    private Pokemon playerPokemon;
    private Pokemon wildPokemon;
    private boolean playerCounter;
    private boolean wildCounter;
    private boolean playerDefense;
    private boolean wildDefense;
    private boolean isBattling;
    private boolean playerPokemonState;


    public BattleController(List<Pokemon> playerPokemons, Pokemon wildPokemon){

        this.playerPokemon = playerPokemons.get(0) ;
        this.wildPokemon = wildPokemon;
        wildDefense = false;
        playerDefense = false;
        wildCounter = CounterState.IsCounter(wildPokemon, playerPokemon);
        playerCounter = CounterState.IsCounter(playerPokemon, wildPokemon);
        isBattling = true;
        playerPokemonState = true;
    }

    // setter methods
    public void setPlayerPokemon(Pokemon playerPokemon) {
        this.playerPokemon = playerPokemon;
    }

    public void setWildPokemon(Pokemon wildPokemon) {
        this.wildPokemon = wildPokemon;
    }

    public void setPlayerDefense(boolean playerDefense) {
        this.playerDefense = playerDefense;
    }

    public void setPlayerCounter(boolean playerCounter) {
        this.playerCounter = playerCounter;
    }

    public void setWildCounter(boolean wildCounter) {
        this.wildCounter = wildCounter;
    }

    public void setWildDefense(boolean wildDefense) {
        this.wildDefense = wildDefense;
    }

    // getter methods

    public boolean isPlayerPokemonState() {
        return playerPokemonState;
    }

    public boolean isBattling() {
        return isBattling;
    }

    public boolean isPlayerCounter() {
        return playerCounter;
    }

    public boolean isPlayerDefense() {
        return playerDefense;
    }

    public boolean isWildCounter() {
        return wildCounter;
    }

    public boolean isWildDefense() {
        return wildDefense;
    }

    public Pokemon getWildPokemon() {
        return wildPokemon;
    }

    public Pokemon getPlayerPokemon() {
        return playerPokemon;
    }

    // other methods
    public boolean attack(){
        if (faster().equals(playerPokemon)){
            PokemonController.reduceHp(wildPokemon, playerAttack());
            if (AIbattle.isAttack())PokemonController.reduceHp(playerPokemon, AiAttack());
            else wildDefense = true;
        }
        if (AIbattle.isAttack()) PokemonController.reduceHp(playerPokemon, AiAttack());
        else wildDefense = true;
        PokemonController.reduceHp(wildPokemon, playerAttack());
        checkState();
        return isBattling;
    }

    public boolean defend(){
        if (faster().equals(playerPokemon)){
            playerDefense = true;
            if (AIbattle.isAttack())PokemonController.reduceHp(playerPokemon, AiAttack());
            else wildDefense = true;
        }
        if (AIbattle.isAttack()) PokemonController.reduceHp(playerPokemon, AiAttack());
        else wildDefense = true;
        playerDefense = true;
        checkState();
        return isBattling;
    }

    private int playerAttack() {
        int damage;
        if (playerCounter){
            if (wildDefense){
                damage = playerPokemon.getAttackPoint() * 2 - wildPokemon.getDefencePoint();
                wildDefense = false;
            }
            else{
                damage = wildPokemon.getAttackPoint() * 2;
            }
            if (damage <= 0) return 1;
            return damage;
        }
        else if (wildDefense){
            damage = playerPokemon.getAttackPoint() - wildPokemon.getDefencePoint();
            wildDefense = false;
            if (damage <= 0) return 1;
            return damage;
        }
        else{
            damage = playerPokemon.getAttackPoint();
            return damage;
        }
    }

    public int AiAttack(){
        int damage;
        if (wildCounter){
            if (playerDefense){
                damage = wildPokemon.getAttackPoint() * 2 - playerPokemon.getDefencePoint();
            }
            else{
                damage = wildPokemon.getAttackPoint() * 2;
            }
            if (damage <= 0) return 1;
            return damage;
        }
        else if (playerDefense){
            damage = wildPokemon.getAttackPoint() - playerPokemon.getDefencePoint();
            if (damage <= 0) return 1;
            return damage;
        }
        else{
            damage = wildPokemon.getAttackPoint();
            return damage;
        }
    }

    public Pokemon faster(){
        if (playerPokemon.getSpeed() >= wildPokemon.getSpeed()){
            return playerPokemon;
        }
        return wildPokemon;
    }

    public void checkState(){
        if (playerPokemon.getHitPoint() <= 0 || wildPokemon.getHitPoint() <= 0){
            isBattling = false;
            if (playerPokemon.getHitPoint() <= 0) playerPokemonState = false;
        }
    }
}
