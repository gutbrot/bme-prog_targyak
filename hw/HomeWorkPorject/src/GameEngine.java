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
    }
}
