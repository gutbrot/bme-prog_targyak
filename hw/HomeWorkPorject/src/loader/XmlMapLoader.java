package loader;

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

        NodeList xmlRows = doc.getElementsByTagName("row");

        for (int r = 0; r < rows; r++) {
            String[] values = xmlRows.item(r).getTextContent().trim().split("\\s+");

            for (int c = 0; c < cols; c++) {
                int type = Integer.parseInt(values[c]);

                world.tiles[r][c] = new Tile(
                        type,
                        c * 32,        // X
                        r * 32,        // Y
                        32, 32
                );
            }
        }
        return world;
    }
}
