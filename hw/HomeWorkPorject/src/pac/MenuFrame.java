package pac;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

import static pac.XmlMapLoader.loadAll;

public class MenuFrame extends JFrame {

    private final JComboBox<String> box;
    private final JTextField nameField = new JTextField(20);
    private final JButton startButton = new JButton("Play!");

    private final Character player;
    private final GameEngine.ModelHolder holder;
    private final CountDownLatch latch;

    public MenuFrame(Character player, GameEngine.ModelHolder holder, CountDownLatch latch) {
        this.player = player;
        this.holder = holder;
        this.latch = latch;

        String[] casts = {"Warrior", "Mage", "Monk"};
        box = new JComboBox<>(casts);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dungeon Crawler Java Remake");
        setSize(400, 110);
        setResizable(false);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.add(box);
        panel.add(nameField);
        panel.add(startButton);
        add(panel, BorderLayout.CENTER);

        startButton.addActionListener(new StartButtonActionListener());

        setVisible(true);
    }

    class StartButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText().trim();
            String cast = (String) box.getSelectedItem();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(MenuFrame.this,
                        "Please enter a name!",
                        "Missing name",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            player.setName(name);
            try {
                // itt töltjük be az XML-t
                holder.model = loadAll("res/data.xml");

                // jelezzük a main szálnak, hogy mehet tovább
                latch.countDown();

                // menü bezárása
                dispose();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(MenuFrame.this,
                        "Error loading game data: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
