package pac;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private JButton upButton, downButton, rightButton, leftButton;
    private Canvas canvas;
    private final Model model;

    public GameFrame(Model model) {
        this.model = model;

        setTitle("Dungeon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        canvas = new GameCanvas(model.getWorld(), model.getPlayer());
        add(canvas, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel(new GridLayout(2, 3));

        upButton = new JButton("↑");
        downButton = new JButton("↓");
        leftButton = new JButton("←");
        rightButton = new JButton("→");

        controlPanel.add(new JLabel());
        controlPanel.add(upButton);
        controlPanel.add(new JLabel());
        controlPanel.add(leftButton);
        controlPanel.add(downButton);
        controlPanel.add(rightButton);

        add(controlPanel, BorderLayout.SOUTH);

        CombatStatusPanel combatPanel = new CombatStatusPanel(model);
        add(combatPanel, BorderLayout.NORTH);

        System.out.println("player x: " + model.getPlayer().getX() + " y : " + model.getPlayer().getY());
        upButton.addActionListener(e -> {
            if (model.getWorld().movePlayer(model.getPlayer(),0, -1)) {
                canvas.repaint();
                combatPanel.refresh();
                System.out.println("Move up");
            }
            System.out.println("player x: " + model.getPlayer().getX() + " y : " + model.getPlayer().getY());
        });

        downButton.addActionListener(e -> {
            if (model.getWorld().movePlayer(model.getPlayer(),0, 1)) {
                canvas.repaint();
                combatPanel.refresh();
                System.out.println("Move down");
            }
            System.out.println("player x: " + model.getPlayer().getX() + " y : " + model.getPlayer().getY());
        });

        leftButton.addActionListener(e -> {
            if (model.getWorld().movePlayer(model.getPlayer(),-1, 0)) {
                canvas.repaint();
                combatPanel.refresh();
                System.out.println("Move left");
            }
            System.out.println("player x: " + model.getPlayer().getX() + " y : " + model.getPlayer().getY());
        });

        rightButton.addActionListener(e -> {
            if (model.getWorld().movePlayer(model.getPlayer(),1, 0)) {
                canvas.repaint();
                combatPanel.refresh();
                System.out.println("Move right");
            }
            System.out.println("player x: " + model.getPlayer().getX() + " y : " + model.getPlayer().getY());
        });
        SkillPanel skillPanel = new SkillPanel(model);
        add(skillPanel, BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}