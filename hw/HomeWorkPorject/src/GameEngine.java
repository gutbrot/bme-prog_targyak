import abilities.Ability;
import abilities.DependencyGraph;
import entities.Entity;
import gui.GameCanvas;
import gui.GameFrame;
import gui.MenuFrame;
import loader.World;
import loader.XmlMapLoader;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class GameEngine {
    static int mapWidth = 8;
    static int mapHeight = 8;

    public static void main(String[] args) throws Exception {
//        loader.ClassLoader.World world = new loader.ClassLoader.World(mapWidth, mapHeight);
//        Entity john = new Entity("John", 0, 0);
//        for (int x = 0; x < mapWidth; x++) {
//            for (int y = 0; y < mapHeight; y++) {
//                Entity tile = new Entity("loader.Tile", x, y);
//            }
//        }
        World world = XmlMapLoader.load("res/map.xml");
        GameFrame g = new GameFrame(world);


//      UI test
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                MenuFrame frame = new MenuFrame();
//            }
//        });

    }
}
