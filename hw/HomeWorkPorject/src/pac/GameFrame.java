package pac;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    JButton upButton, downButton, rightButton, leftButton;
    Canvas canvas;
    public GameFrame(Model model) {
        canvas = new GameCanvas(model.getWorld());
        add(canvas);
        setSize(model.getWorld().cols * 32, model.getWorld().rows * 32);
        setVisible(true);
        System.out.println("Game visible");
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
