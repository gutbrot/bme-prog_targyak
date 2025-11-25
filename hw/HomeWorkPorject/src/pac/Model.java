package pac;

public class Model {
    public World map;
    public DependencyGraph graph;
    public Character player;
    public Model(World map, DependencyGraph graph){
        this.map= map;
        this.graph = graph;
    }
}
