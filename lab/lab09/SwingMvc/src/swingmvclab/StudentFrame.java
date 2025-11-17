package swingmvclab;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import javax.swing.*;

public class StudentFrame extends JFrame {

    // Ne modositsd!
    private StudentData data;


    private void initComponents() {
        setLayout(new BorderLayout());

        JTable table = new JTable();
        table.setModel(data);
        table.setFillsViewportHeight(true);

        JScrollPane pane = new JScrollPane(table);

        add(pane, BorderLayout.CENTER);
    }

    // Ne modositsd!
    @SuppressWarnings("unchecked")
    public StudentFrame() {
        super("Hallgatoi nyilvantartas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        try {
            data = new StudentData();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"));
            data.students = (List<Student>)ois.readObject();
            ois.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"));
                    oos.writeObject(data.students);
                    oos.close();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        setMinimumSize(new Dimension(500, 200));
        initComponents();
    }

    // Ne modositsd!
    public static void main(String[] args) {
        StudentFrame sf = new StudentFrame();
        sf.setVisible(true);
    }
}
