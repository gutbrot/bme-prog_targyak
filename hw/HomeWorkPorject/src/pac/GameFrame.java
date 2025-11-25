package pac;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    JButton upButton, downButton, rightButton, leftButton;
    Canvas canvas;
    public GameFrame(World world) {
        canvas = new GameCanvas(world);
        add(canvas);
        setSize(world.cols * 32, world.rows * 32);
        setVisible(true);

        upButton.addActionListener(e -> {

        });
        downButton.addActionListener(e -> {

        });
        leftButton.addActionListener(e -> {

        });
        rightButton.addActionListener(e -> {

        });
    }
}
