package UISimple;

import java.util.List;
import java.util.Map;

public class PocketPresenter extends Presenter {
    public void addShowDetails() {
        addToQueue("Show details");
    }

    public void addHideDetails() {
        addToQueue("Hide details");
    }

    public void addSortByName() {
        addToQueue("Sort by name");
    }

    public void addSortByLevel() {
        addToQueue("Sort by level");
    }

    public void addSetBattlePokemon() {
        addToQueue("Change battle pokemon");
    }

    public void addBack() {
        addToQueue("Back");
    }

    public void addPocketInfo(List<Map<String, String>> pocketInfo) {
        for (Map<String, String> pokemonInfo : pocketInfo) {
            addPokemonInfo(pokemonInfo);
        }
    }

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

    public void printBattlePokemonChanged(String battlePokemonName) {
        System.out.println("You changed the battle pokemon to " + battlePokemonName + ".");
    }
}