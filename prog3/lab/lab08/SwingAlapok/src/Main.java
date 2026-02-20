import javax.swing.*;

public class Main {
    public static void main(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CaesarFrame frame = new CaesarFrame();
            }
        });
    }

}
