package pac;
import javax.swing.*;
import java.util.concurrent.CountDownLatch;

public class GameEngine {

    public static final Model model = new Model();

    public static void main(String[] args) throws Exception {

        CountDownLatch latch = new CountDownLatch(1);

        SwingUtilities.invokeLater(() -> {
            new MenuFrame(model, latch);
        });

        latch.await();

        SwingUtilities.invokeLater(() -> {
            new GameFrame(model);
        });
    }

}
