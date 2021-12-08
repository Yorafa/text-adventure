package usecase_battle;

public class DamageCalculator {
    private boolean hasCounterattack;
    private boolean hasDefense;

    /**
     * Construct DamageCalculator, given false two attributes
     */
    public DamageCalculator() {
        hasCounterattack = false;
        hasDefense = false;
    }

    /**
     * calculate the damage by attack point and defence point
     *
     * @param attackPoint the attack point of attacker pokemon
     * @param defencePoint the defence point of defender pokemon
     * @return the final damage that attacker cause
     */
    public int calculate(int attackPoint, int defencePoint) {
        double damage = 0.9 * attackPoint / defencePoint * 100 + 0.1 * attackPoint;
        if (hasCounterattack) {
            damage *= 2;
        }
        if (hasDefense) {
            damage /= 2;
        }
        return (int) Math.round(damage);
    }

    /**
     * the setter method of hasCounterattack
     * @param hasCounterattack if the attacker has counter-attack
     */
    public void setHasCounterattack(boolean hasCounterattack) {
        this.hasCounterattack = hasCounterattack;
    }

    /**
     * the setter method of hasDefense
     * @param hasDefense if the defender do defense
     */
    public void setHasDefense(boolean hasDefense) {
        this.hasDefense = hasDefense;
    }
}