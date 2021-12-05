package presenter;

public class ExplorePresenter extends Presenter {
    public void addWalkAround() {
        addToQueue("Walk around");
    }

    public void addHeal() {
        addToQueue("Heal");
    }

    public void addChangePlace() {
        addToQueue("Change place");
    }

    public void addViewPocket() {
        addToQueue("View Pocket");
    }

    public void addLogout() {
        addToQueue("Log out");
    }

    public void printNothingHappens() {
        System.out.println("Nothing happens.");
    }

    public void printLogout() {
        System.out.println("You are logged out.");
    }

    public void printHealed() {
        System.out.println("All pokemons are healed.");
    }

    public void printOpponent(String opponentName) {
        System.out.println("You bumped into " + opponentName + ".");
    }

}
