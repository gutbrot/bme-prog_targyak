package pac;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class TwoListSkillPanel extends JPanel {

    private JComboBox<Ability> unlockedBox;
    private JComboBox<Ability> unlockableBox;

    private JButton useButton;
    private JButton unlockButton;

    private final Model model;

    public TwoListSkillPanel(Model model) {
        this.model = model;

        setLayout(new GridLayout(1, 2));  // két egymás melletti panel

        add(createUnlockedPanel());
        add(createUnlockablePanel());

        refresh();
    }

    private JPanel createUnlockedPanel() {

        JPanel p = new JPanel(new BorderLayout());
        p.add(new JLabel("Unlocked Abilities:"), BorderLayout.NORTH);

        unlockedBox = new JComboBox<>();
        p.add(unlockedBox, BorderLayout.CENTER);

        useButton = new JButton("Use");
        useButton.addActionListener(e -> {
            Ability a = (Ability) unlockedBox.getSelectedItem();
            if (a != null) {
                System.out.println("Using ability: " + a.getName());
            }
        });

        p.add(useButton, BorderLayout.SOUTH);

        return p;
    }

    private JPanel createUnlockablePanel() {

        JPanel p = new JPanel(new BorderLayout());
        p.add(new JLabel("Unlockable Abilities:"), BorderLayout.NORTH);

        unlockableBox = new JComboBox<>();
        p.add(unlockableBox, BorderLayout.CENTER);

        unlockButton = new JButton("Unlock");
        unlockButton.addActionListener(e -> {

            Ability a = (Ability) unlockableBox.getSelectedItem();
            Character player = model.getPlayer();

            if (a == null) return;

            // ability feloldása a playerhez
            player.unlockAbility(a);

            // FELOLDOTT ability cost-ját nullázzuk
            a.setCost(0);

            System.out.println("Unlocked: " + a.getName());

            refresh();
        });

        p.add(unlockButton, BorderLayout.SOUTH);

        return p;
    }


    public void refresh() {

        Character player = model.getPlayer();

        Set<Ability> unlocked = player.getUnlockedAbilities();
        Set<Ability> unlockable = model.getGraph().getUnlockable(unlocked);

        // Bal panel: unlocked abilities
        unlockedBox.removeAllItems();
        for (Ability a : unlocked) {
            unlockedBox.addItem(a);
        }

        // Jobb panel: unlockable abilities
        unlockableBox.removeAllItems();
        for (Ability a : unlockable) {
            unlockableBox.addItem(a);
        }

        updateButtonState();
        revalidate();
        repaint();
    }

    private void updateButtonState() {

        Character player = model.getPlayer();
        Ability selectedUnlockable = (Ability) unlockableBox.getSelectedItem();

        // Use button
        useButton.setEnabled(unlockedBox.getItemCount() > 0);

        // Unlock button
        if (selectedUnlockable == null) {
            unlockButton.setEnabled(false);
            return;
        }

        boolean enoughXp = player.getXp() >= selectedUnlockable.getCost();

        unlockButton.setEnabled(enoughXp);
    }
}
