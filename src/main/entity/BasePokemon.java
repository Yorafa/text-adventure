package entity;

public class BasePokemon {
    protected String name;
    protected PokemonType type;
    protected int baseAttackPoint;
    protected int baseDefencePoint;
    protected int baseSpeed;

    public BasePokemon(String name, PokemonType type, int baseAttackPoint, int baseDefencePoint, int baseSpeed) {
        this.name = name;
        this.type = type;
        this.baseAttackPoint = baseAttackPoint;
        this.baseDefencePoint = baseDefencePoint;
        this.baseSpeed = baseSpeed;
    }

    // TODO: getters and setters
}

