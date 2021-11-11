package usecase;

public class LevelCalculator {
    public int calculate(int experiencePoint) {
        return (int) Math.round(Math.sqrt(experiencePoint));
    }
}
