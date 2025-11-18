package loader;

import entities.Monster;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class XmlMapLoader {

    public static World load(String path) throws Exception {

        Document doc = DocumentBuilderFactory
                .newInstance().newDocumentBuilder().parse(new File(path));

        Element root = doc.getDocumentElement();

        int rows = Integer.parseInt(root.getAttribute("rows"));
        int cols = Integer.parseInt(root.getAttribute("cols"));

        World world = new World(rows, cols);

        // ----- TILE MÁTRIX BETÖLTÉSE -----
        NodeList xmlRows = root.getElementsByTagName("row");

        for (int r = 0; r < rows; r++) {
            String[] values = xmlRows.item(r).getTextContent().trim().split("\\s+");

            for (int c = 0; c < cols; c++) {
                int type = Integer.parseInt(values[c]);

                world.getTiles()[r][c] = new Tile(
                        type,
                        c * 32,        // X
                        r * 32,        // Y
                        32, 32
                );
            }
        }

        // ----- ENEMY BETÖLTÉS -----
        NodeList enemyNodes = root.getElementsByTagName("enemy");

        for (int i = 0; i < enemyNodes.getLength(); i++) {
            Element e = (Element) enemyNodes.item(i);

            String type = e.getAttribute("type");
            int x = Integer.parseInt(e.getAttribute("x"));
            int y = Integer.parseInt(e.getAttribute("y"));

            Monster enemy = new Monster(type, x, y);

            world.addEntity(enemy);
        }

        System.out.println("Loaded enemies: " + enemyNodes.getLength());
        return world;
    }
}
