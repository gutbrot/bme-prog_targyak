package pac;

import java.util.Objects;

public class Ability {
    private final int id;
    private final String name;
    private final String description;
    private final int cost; // XP or points required

    public Ability(int id, String name, String description, int cost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getCost() { return cost; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ability)) return false;
        Ability ability = (Ability) o;
        return Objects.equals(id, ability.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public String toString() {
        return name;                 // vagy pl. name + " (cost: " + cost + ")"
    }
}
