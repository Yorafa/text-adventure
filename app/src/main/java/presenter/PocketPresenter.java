package presenter;

import java.util.List;
import java.util.Map;

public class PocketPresenter extends Presenter {
    /**
     * add show details option
     */
    public void addShowDetails() {
        addToQueue("Show details");
    }

    /**
     * add hide details option
     */
    public void addHideDetails() {
        addToQueue("Hide details");
    }

    /**
     * add sort by name option
     */
    public void addSortByName() {
        addToQueue("Sort by name");
    }

    /**
     * add sort by level
     */
    public void addSortByLevel() {
        addToQueue("Sort by level");
    }

    /**
     * add change battle pokemon option
     */
    public void addSetBattlePokemon() {
        addToQueue("Change battle pokemon");
    }

    /**
     * add back option
     */
    public void addBack() {
        addToQueue("Back");
    }

    /**
     * call addPokemonInfo to add pokemon information
     *
     * @param pocketInfo all pocket pokemon information
     */
    public void addPocketInfo(List<Map<String, String>> pocketInfo) {
        for (Map<String, String> pokemonInfo : pocketInfo) {
            addPokemonInfo(pokemonInfo);
        }
    }

    /**
     * show pokemon specific information
     *
     * @param pokemonInfo specific pokemon information
     */
    private void addPokemonInfo(Map<String, String> pokemonInfo) {
        String name = pokemonInfo.get("name");
        String pokemonType = pokemonInfo.get("pokemonType");
        String level = pokemonInfo.get("level");
        String experiencePoint = pokemonInfo.get("experiencePoint");
        String hitPoint = pokemonInfo.get("hitPoint");
        String maxHitPoint = pokemonInfo.get("maxHitPoint");
        String attackPoint = pokemonInfo.get("attackPoint");
        String defencePoint = pokemonInfo.get("defencePoint");
        String speed = pokemonInfo.get("speed");

        String toAdd = "";
        toAdd += name;
        if (level != null) {
            toAdd = String.format("%-20s%-20s", toAdd, "Level: " + level);
        }
        if (experiencePoint != null) {
            toAdd = String.format("%-20s%-20s", toAdd, "EXP: " + experiencePoint);
        }
        if (pokemonType != null) {
            toAdd = String.format("%-20s%-20s", toAdd, "Type: " + pokemonType.toLowerCase());
        }
        if (hitPoint != null) {
            toAdd = String.format("%-20s%-20s", toAdd, "HP: " + hitPoint + "/" + maxHitPoint);
        }
        if (attackPoint != null) {
            toAdd = String.format("%-20s%-20s", toAdd, "ATK: " + attackPoint);
        }
        if (defencePoint != null) {
            toAdd = String.format("%-20s%-20s", toAdd, "DEF: " + defencePoint);
        }
        if (speed != null) {
            toAdd = String.format("%-20s%-20s", toAdd, "Speed: " + speed);
        }
        addToQueue(toAdd);
    }

    /**
     * show battle pokemon changed
     *
     * @param battlePokemonName the switched battle pokemon name
     */
    public void printBattlePokemonChanged(String battlePokemonName) {
        System.out.println("You changed the battle pokemon to " + battlePokemonName + ".");
    }
}