package gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import entities.Entity;
import loader.*;

public class GameCanvas extends Canvas {
    private World map;

    public GameCanvas(World map) {
        // Init
        this.map = map;
        setSize(map.cols * 32, map.rows * 32);
        // Coloring
        for(int r = 0; r < map.rows; r++) {
            for (int c = 0; c < map.cols; c++) {
                Tile t = map.getTiles()[r][c];

            }
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleClick(e.getX(), e.getY());
            }
        });
    }

    @Override
    public void paint(Graphics g) {

        for (int r = 0; r < map.rows; r++){
            for (int c = 0; c < map.cols; c++){
                Tile t = map.getTiles()[r][c];

                Color color = switch (t.getType()) {
                    case 0 -> Color.LIGHT_GRAY;   // floor
                    case 1 -> Color.DARK_GRAY;    // wall
                    case 2 -> Color.RED;          // lava
                    default -> Color.BLACK;
                };

                g.setColor(color);
                g.fillRect(t.x, t.y, t.width, t.height);

                if(t.entityCount() > 0){
                   g.setColor(Color.GREEN);
                   g.drawString("X",t.x,t.y);
                }

                if (t.selected) {
                    g.setColor(Color.YELLOW);
                    g.drawRect(t.x, t.y, t.width, t.height);
                }
            }
        }
    }

    private void handleClick(int mouseX, int mouseY) {
        for(int r=0; r<map.rows; r++){
            for(int c=0; c<map.cols; c++){
                Tile t = map.getTiles()[r][c];

                boolean inside =
                        mouseX >= t.x && mouseX < t.x + t.width &&
                                mouseY >= t.y && mouseY < t.y + t.height;

                if(inside){
                    t.selected = !t.selected;   // CLICK ACTION
                    repaint();                 // redraw screen
                }
            }
        }
    }
}

