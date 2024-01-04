package usecase_pocket;

import entity.Pokemon;

import java.util.Map;

public interface IPocketInfoAdder {
    void add(Map<String, String> pokemonInfo, Pokemon pokemon);
}
