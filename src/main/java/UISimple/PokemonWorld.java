package UISimple;

import entity.GameData;
import entity.User;
import usecase.UserManager;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class PokemonWorld {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        GameController gameController = new GameController();
        gameController.run();
    }
}
