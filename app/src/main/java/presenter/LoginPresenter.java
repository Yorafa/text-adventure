package presenter;

public class LoginPresenter extends Presenter {

    /**
     * add login option
     */
    public void addLogin() {
        addToQueue("Login");
    }

    /**
     * add signup option
     */
    public void addSignup() {
        addToQueue("Signup");
    }

    /**
     * add quit option
     */
    public void addQuit() {
        addToQueue("Quit");
    }

    /**
     * show username
     */
    public void askForUsername() {
        System.out.print("Username: ");
    }

    /**
     * show password
     */
    public void askForPassword() {
        System.out.print("Password: ");
    }

    /**
     * show invalid input
     */
    public void printInvalidUsernameOrPassword() {
        System.out.println("The username or password you entered is not valid.");
    }

    /**
     * show invalid register password input
     */
    public void printInvalidPassword() {
        System.out.println("The password you entered is not valid.");
    }

    /**
     * show invalid register username input
     */
    public void printUsernameExists() {
        System.out.println("The username you entered already exists.");
    }
}