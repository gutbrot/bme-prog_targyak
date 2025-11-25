package pac;

public class GameEngine {
    static Character player = new Character("",0,0);

    public static void main(String[] args) throws Exception {

        MenuFrame menu = new MenuFrame(player);

        Model model = XmlMapLoader.loadAll("res/map.xml");

        GameFrame g = new GameFrame(model.map);
    }

}
