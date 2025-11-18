package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame{
    private JComboBox<String> box;
    private final JTextField nameField = new JTextField(20);
    private final JButton startButton = new JButton("Play!");

    public MenuFrame(){
        // JBox init
        // TODO cast laod from files
        String[] casts = {"Warrior", "Mage", "Monk"};
        box = new JComboBox<>(casts);

        // Frame init
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dungeon Crawler Java Remake");
        setSize(400, 110);
        setResizable(false);
        setLocationRelativeTo(null);

        // Layout
        setLayout(new BorderLayout());

        // Panel
        JPanel panel = new JPanel();
        panel.add(box);
        panel.add(nameField);
        panel.add(startButton);

        // Start Button
        startButton.addActionListener(new StartButtonActionListener());

        add(panel,BorderLayout.CENTER);

        setVisible(true);
    }

    class StartButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO window close, save character, open GameFrame
        }
    }
}
