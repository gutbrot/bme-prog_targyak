package gui;

import loader.World;
import loader.XmlMapLoader;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame(World world) {
        add(new GameCanvas(world));
        setSize(world.cols * 32, world.rows * 32);
        setVisible(true);
    }
}
