package UISimple;

public class LoginPresenter extends Presenter {
    public void addLogin() {
        addToQueue("Login");
    }

    public void addSignup() {
        addToQueue("Signup");
    }

    public void askForUsername() {
        System.out.println("Username: ");
    }

    public void askForPassword() {
        System.out.println("Password: ");
    }

    public void printInvalidUsernameOrPassword() {
        System.out.println("The username or password you entered is not valid.");
    }

    public void printInvalidPassword() {
        System.out.println("The password you entered is not valid.");
    }

    public void printUsernameExists() {
        System.out.println("The username you entered already exists.");
    }
}
