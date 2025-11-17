import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaesarFrame extends JFrame {
    private final Character[] alphabet = new Character[26];
    private final JTextField textField = new JTextField(20);
    private final JButton button = new JButton("Code!");
    JLabel output = new JLabel("Output: ");
    private JComboBox<Character> box;

    public CaesarFrame() {
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('A' + i);
        }
        box = new JComboBox<>(alphabet);

        // Frame beállítások
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SwingLab");
        setSize(400, 110);
        setResizable(false);
        setLocationRelativeTo(null);

        // Layout
        setLayout(new BorderLayout());

        // Felső panel: combo + szövegmező + gomb
        JPanel felso = new JPanel();
        felso.add(box);
        felso.add(textField);
        felso.add(button);

        // Alsó panel: output label

        JPanel also = new JPanel();
        also.add(output);

        // Paneleket hozzáadjuk a frame-hez
        add(felso, BorderLayout.NORTH);
        add(also, BorderLayout.SOUTH);

        // Gomb eseménykezelő
        button.addActionListener(new OkButtonActionListener());


        setVisible(true);
    }

    class OkButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = textField.getText();
            Character selected = (Character) box.getSelectedItem();

            if (selected != null) {
                String coded = caesarCode(text, selected);
                output.setText("Output: " + coded);
            }
        }
    }

    private String caesarCode(String input, char offset) {
        int shift = offset - 'A';

        char[] output = new char[input.length()];

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                int pos = c - 'A';
                int newPos = (pos + shift) % 26;
                output[i] = (char) ('A' + newPos);
            } else {
                output[i] = c;
            }
        }
        return new String(output);
    }
}
