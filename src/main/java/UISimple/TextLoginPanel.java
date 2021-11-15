package UISimple;

import entity.User;
import usecase.PokemonManager;
import usecase.UserManager;

import java.util.Scanner;

public class TextLoginPanel extends TextPanel {
    private UserManager userManager;
    private String username;

    public TextLoginPanel(Scanner input, UserManager userManager) {
        super(input);
        super.options.add("1. Login");
        super.options.add("2. Signup");
        this.userManager = userManager;
    }

    @Override
    protected void execute(String choice) {
        switch (choice) {
            case "1":
                login();
                break;
            case "2":
                signup();
                break;
            default:
                System.out.println("Not valid");
                runPanel();
        }

    }

    public void login() {
        User user = null;
        String username = null, password;
        while (user == null) {
            System.out.print("Username: ");
            username = input.nextLine();
            System.out.print("Password: ");
            password = input.nextLine();
            user = userManager.login(username, password);
            if (user == null) {
                System.out.println("Not valid");
            }
        }
        this.username = username;
    }

    private void signup() {
        User user = null;
        String username = null, password;
        while (user == null) {
            System.out.print("Username: ");
            username = input.nextLine();
            if (userManager.hasUser(username)) {
                System.out.println("Not valid");
            } else {
                System.out.print("Password: ");
                password = input.nextLine();
                user = userManager.register(username, password);
            }
        }
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
