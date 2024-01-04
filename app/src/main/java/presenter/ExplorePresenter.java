package presenter;

public class ExplorePresenter extends Presenter {

    /**
     * add walk around option
     */
    public void addWalkAround() {
        addToQueue("Walk around");
    }

    /**
     * add heal option
     */
    public void addHeal() {
        addToQueue("Heal");
    }

    /**
     * add change place option
     */
    public void addChangePlace() {
        addToQueue("Change place");
    }

    /**
     * add view pocket option
     */
    public void addViewPocket() {
        addToQueue("View Pocket");
    }

    /**
     * add log out option
     */
    public void addLogout() {
        addToQueue("Log out");
    }

    /**
     * show nothing happens
     */
    public void printNothingHappens() {
        System.out.println("Nothing happens.");
    }

    /**
     * show log out information
     */
    public void printLogout() {
        System.out.println("You are logged out.");
    }

    /**
     * show heal information
     */
    public void printHealed() {
        System.out.println("All pokemons are healed.");
    }

    /**
     * show meet opponent information
     *
     * @param opponentName the opponent pokemon information
     */
    public void printOpponent(String opponentName) {
        System.out.println("You bumped into " + opponentName + ".");
    }

}