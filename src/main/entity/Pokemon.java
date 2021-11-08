package entity;

public class Pokemon extends BasePokemon {
    private int experiencePoint;

    public Pokemon(String name, PokemonType type, int baseAttackPoint, int baseDefencePoint, int baseSpeed,
                   int experiencePoint) {
        super(name, type, baseAttackPoint, baseDefencePoint, baseSpeed);
        this.experiencePoint = experiencePoint;
    }

    public int getLevel(LevelCalculator lc) {
        return lc.calculate(experiencePoint);
    }
}
