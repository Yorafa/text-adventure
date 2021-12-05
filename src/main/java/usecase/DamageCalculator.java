package usecase;

public class DamageCalculator {
    private boolean hasCounterattack;
    private boolean hasDefense;

    public DamageCalculator() {
        hasCounterattack = false;
        hasDefense = false;
    }

    public int calculate(int attackPoint, int defencePoint) {
        double damage = (double) attackPoint / defencePoint * 100;
        if (hasCounterattack) {
            damage *= 2;
        }
        if (hasDefense) {
            damage /= 2;
        }
        return (int) Math.round(damage);
    }

    public void setHasCounterattack(boolean hasCounterattack) {
        this.hasCounterattack = hasCounterattack;
    }

    public void setHasDefense(boolean hasDefense) {
        this.hasDefense = hasDefense;
    }
}