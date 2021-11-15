package usecase;

public class DamageCalculator {
    int calculate(int attackPoint, int defencePoint) {
        double damage = (double) attackPoint / defencePoint * 100;
        return (int) Math.round(damage);
    }
}
