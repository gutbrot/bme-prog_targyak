package pac;

import java.util.*;

public class DependencyGraph {

    // Map each ability to the list of abilities that depend on it
    private final Map<Ability, Set<Ability>> adjList = new HashMap<>();

    // Add a new ability node to the graph
    public void addAbility(Ability a) {
        adjList.putIfAbsent(a, new HashSet<>());
    }

    // Add a dependency: parent -> child
    public void addDependency(Ability parent, Ability child) {
        addAbility(parent);
        addAbility(child);
        adjList.get(parent).add(child);
    }

    // Return list of abilities that depend on given ability
    public Set<Ability> getChildren(Ability a) {
        return adjList.getOrDefault(a, Collections.emptySet());
    }

    // Return all prerequisite abilities of a given ability
    public Set<Ability> getParents(Ability a) {
        Set<Ability> parents = new HashSet<>();
        for (var entry : adjList.entrySet()) {
            if (entry.getValue().contains(a)) {
                parents.add(entry.getKey());
            }
        }
        return parents;
    }

    // Check if ability is unlockable (all prerequisites are unlocked)
    public boolean canUnlock(Ability a, Set<Ability> unlocked) {
        for (Ability prerequisite : getParents(a)) {
            if (!unlocked.contains(prerequisite)) {
                return false;
            }
        }
        return true;
    }

    // Get all abilities that are currently unlockable
    public Set<Ability> getUnlockable(Set<Ability> unlocked) {
        Set<Ability> unlockable = new HashSet<>();
        for (Ability a : adjList.keySet()) {
            if (!unlocked.contains(a) && canUnlock(a, unlocked)) {
                unlockable.add(a);
            }
        }
        return unlockable;
    }

    // For drawing or visualization: topologically sort the abilities
    public List<Ability> topologicalOrder() {
        Set<Ability> visited = new HashSet<>();
        List<Ability> result = new ArrayList<>();
        for (Ability a : adjList.keySet()) {
            dfs(a, visited, result);
        }
        Collections.reverse(result);
        return result;
    }

    private void dfs(Ability node, Set<Ability> visited, List<Ability> result) {
        if (!visited.contains(node)) {
            visited.add(node);
            for (Ability child : getChildren(node)) {
                dfs(child, visited, result);
            }
            result.add(node);
        }
    }
}
