package pac;

public class Model {
    public World map;
    public DependencyGraph graph;
    public Model(World m, DependencyGraph dg){
        map= m;
        graph = dg;
    }
}
