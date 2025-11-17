import abilities.Ability;
import abilities.DependencyGraph;
import entities.Entity;

import java.util.HashSet;
import java.util.Set;

public class GameEngine {
    static int mapWidth = 8;
    static int mapHeight = 8;

    public static void main(String[] args) {
        World world = new World(mapWidth, mapHeight);
        Entity john = new Entity("John", 0, 0);
        for (int x = 0; x < mapWidth; x++) {
            for (int y = 0; y < mapHeight; y++) {
                Entity tile = new Entity("Tile", x, y);
            }
        }
        Ability slash = new Ability("1", "Slash", "Basic melee attack", 0);
        Ability parry = new Ability("2", "Parry", "Defensive stance", 50);
        Ability whirlwind = new Ability("3", "Whirlwind", "Attack all enemies", 100);

        DependencyGraph graph = new DependencyGraph();
        graph.addDependency(slash, parry);
        graph.addDependency(parry, whirlwind);

        Set<Ability> unlocked = new HashSet<>();
        unlocked.add(slash); // Kezdetben csak Slash elérhető

        System.out.println("Unlockable: ");
        graph.getUnlockable(unlocked).forEach(a -> System.out.println(a.getName()));
    }
}
