package pac;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class GameFrame extends JFrame {
    private JButton upButton, downButton, rightButton, leftButton;
    private Canvas canvas;
    private final Model model;

    public GameFrame(Model model) {
        this.model = model;

        setTitle("Dungeon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Canvas középen
        canvas = new GameCanvas(model.getWorld(), model.getPlayer());
        add(canvas, BorderLayout.CENTER);

        // Irányítógombok alul
        JPanel controlPanel = new JPanel(new GridLayout(2, 3)); // pl. 2x3-as rács

        upButton = new JButton("↑");
        downButton = new JButton("↓");
        leftButton = new JButton("←");
        rightButton = new JButton("→");

        // elrendezés (középen fel/le, oldalt bal/jobb)
        controlPanel.add(new JLabel());      // üres
        controlPanel.add(upButton);
        controlPanel.add(new JLabel());
        controlPanel.add(leftButton);
        controlPanel.add(downButton);
        controlPanel.add(rightButton);

        add(controlPanel, BorderLayout.SOUTH);

        CombatStatusPanel combatPanel = new CombatStatusPanel(model);
        add(combatPanel, BorderLayout.NORTH);

        System.out.println("player x: " + model.getPlayer().getX() + " y : " + model.getPlayer().getY());
        // ActionListenerek – csak mozgást kérnek, logika World-ben
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
        TwoListSkillPanel skillPanel = new TwoListSkillPanel(model);
        add(skillPanel, BorderLayout.EAST);




        pack(); // ha a canvas megfelelő méretet ad
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
