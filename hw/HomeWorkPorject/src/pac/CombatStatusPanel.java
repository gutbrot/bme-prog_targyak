package pac;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CombatStatusPanel extends JPanel {

    private final Model model;

    private JLabel playerHpLabel;
    private DefaultListModel<String> monsterListModel;
    private JList<String> monsterList;
    private JButton attackButton;

    public CombatStatusPanel(Model model) {
        this.model = model;

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 400));

        // PLAYER HP
        playerHpLabel = new JLabel("Player HP: ", SwingConstants.CENTER);
        add(playerHpLabel, BorderLayout.NORTH);

        // MONSTER LIST
        monsterListModel = new DefaultListModel<>();
        monsterList = new JList<>(monsterListModel);
        add(new JScrollPane(monsterList), BorderLayout.CENTER);

        // ATTACK BUTTON
        attackButton = new JButton("Attack");
        attackButton.setEnabled(false);

        attackButton.addActionListener(e -> attack());

        add(attackButton, BorderLayout.SOUTH);

        refresh();
    }

    public void refresh() {

        Character p = model.getPlayer();
        playerHpLabel.setText("Player HP: " + p.getHp());

        monsterListModel.clear();

        List<Monster> monsters = model.getWorld().getMonstersAt(p.getX(), p.getY());

        if (monsters.isEmpty()) {
            monsterListModel.addElement("No monsters here");
            attackButton.setEnabled(false);
        } else {
            attackButton.setEnabled(true);
            for (Monster m : monsters) {
                monsterListModel.addElement(m.getName() + " - HP: " + m.getHp());
            }
        }

        repaint();
        revalidate();
    }

    private void attack() {

        List<Monster> monsters = model.getWorld().getMonstersAt(
                model.getPlayer().getX(), model.getPlayer().getY()
        );

        if (monsters.isEmpty()) return;

        Character p = model.getPlayer();
        Monster m = monsters.get(0);  // egyszerre egyet támadunk

        // Player attack
        m.setHp(m.getHp() - 5);
        if (m.getHp() <= 0) {
            m.setHp(0);
            model.getWorld().removeEntity(m);
        } else {
            // Monster retaliate
            p.setHp(p.getHp() - 3);
            if (p.getHp() <= 0) {
                p.setHp(0);
                JOptionPane.showMessageDialog(this, "You died!");
                System.exit(0);
            }
        }

        refresh();
    }
}
