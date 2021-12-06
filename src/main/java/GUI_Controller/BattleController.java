package GUI_Controller;

import entity.Pokemon;

import java.util.List;
import java.util.Random;


public class BattleController {
    private List<Pokemon> playerPokemons;
    private Pokemon playerPokemon;
    private Pokemon wildPokemon;
    private int playerPokemonIndex = 0;
    private boolean playerCounter;
    private boolean wildCounter;
    private boolean playerDefense;
    private boolean wildDefense;
    private boolean isBattling;
    private boolean playerPokemonState;


    public BattleController(List<Pokemon> playerPokemons, Pokemon wildPokemon){
        this.playerPokemons = playerPokemons;
        this.playerPokemon = playerPokemons.get(playerPokemonIndex) ;
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

    public void setPlayerPokemons(List<Pokemon> playerPokemons) {
        this.playerPokemons = playerPokemons;
    }

    public void setBattling(boolean battling) {
        isBattling = battling;
    }

    public void setPlayerPokemonIndex(int playerPokemonIndex) {
        this.playerPokemonIndex = playerPokemonIndex;
    }

    public void setPlayerPokemonState(boolean playerPokemonState) {
        this.playerPokemonState = playerPokemonState;
    }

    // getter methods

    public int getPlayerPokemonIndex() {
        return playerPokemonIndex;
    }

    public List<Pokemon> getPlayerPokemons() {
        return playerPokemons;
    }

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
            checkState();
            if (!isBattling()) return isBattling;
            if (AIbattle.isAttack()){PokemonController.reduceHp(playerPokemon, AiAttack());
                checkState();
                if (!isBattling()) return isBattling;}
            else wildDefense = true;
        }
        if (AIbattle.isAttack()){ PokemonController.reduceHp(playerPokemon, AiAttack());
            checkState();
            if (!isBattling()) return isBattling;}
        else wildDefense = true;
        PokemonController.reduceHp(wildPokemon, playerAttack());
        checkState();
        return isBattling;
    }

    public boolean defend(){
        if (faster().equals(playerPokemon)){
            playerDefense = true;
            if (AIbattle.isAttack()){PokemonController.reduceHp(playerPokemon, AiAttack());
                checkState();
                if (!isBattling()) return isBattling;}
            else wildDefense = true;
        }else{
        if (AIbattle.isAttack()){ PokemonController.reduceHp(playerPokemon, AiAttack());
            checkState();
            if (!isBattling()) return isBattling;}
        else wildDefense = true;
        playerDefense = true;}
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
                damage = playerPokemon.getAttackPoint() * 2;
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
            if (damage <= 0) return 1;
            return damage;
        }
    }

    public int AiAttack(){
        int damage;
        if (wildCounter){
            if (playerDefense){
                damage = wildPokemon.getAttackPoint() * 2 - playerPokemon.getDefencePoint();
                playerDefense = false;
            }
            else{
                damage = wildPokemon.getAttackPoint() * 2;
            }
            if (damage <= 0) return 1;
            return damage;
        }
        else if (playerDefense){
            damage = wildPokemon.getAttackPoint() - playerPokemon.getDefencePoint();
            playerDefense = false;
            if (damage <= 0) return 1;
            return damage;
        }
        else{
            damage = wildPokemon.getAttackPoint();
            if (damage <= 0) return 1;
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
        if (wildPokemon.getHitPoint() <= 0){
            isBattling = false;}
        if (playerPokemon.getHitPoint() <= 0 && playerPokemonIndex +1 != playerPokemons.size()) {
            do {
                playerPokemonIndex++;
                playerPokemon = playerPokemons.get(playerPokemonIndex);
            }while (playerPokemon.getHitPoint() <=0 && playerPokemonIndex +1 != playerPokemons.size());
        }
        else if (playerPokemon.getHitPoint() <= 0 && playerPokemonIndex +1 == playerPokemons.size()){
            playerPokemonState = false;
            isBattling = false;
        }
    }
    public boolean catching(){
        if (capture()){return true;}
        else{if (AIbattle.isAttack()){PokemonController.reduceHp(playerPokemon, AiAttack());}
            else {wildDefense = true;}
            checkState();
            return false;}
    }

    public boolean capture() {
        Random r = new Random();
        return r.nextDouble() > 0.8 * wildPokemon.getHitPoint() / wildPokemon.getMaxHitPoint() + 0.1;
    }
}
