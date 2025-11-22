import gui.GameFrame;
import gui.MenuFrame;
import loader.Tile;
import loader.World;
import loader.XmlMapLoader;

public class GameEngine {
    static entities.Character player = new entities.Character("",0,0);
    static int mapWidth = 8;
    static int mapHeight = 8;

    public static void main(String[] args) throws Exception {

        MenuFrame menu = new MenuFrame(player);

        World world = XmlMapLoader.load("res/map.xml");
        GameFrame g = new GameFrame(world);
    }
    boolean movePlayer(int dx, int dy){
        return true;
    }

}
