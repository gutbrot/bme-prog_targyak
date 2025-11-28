package pac;
import javax.swing.*;
import java.util.concurrent.CountDownLatch;

public class GameEngine {

    public static final Model model = new Model();
    public static final Character player = new Character("", 0, 0);

    public static void main(String[] args) throws Exception {

        CountDownLatch latch = new CountDownLatch(1);

        SwingUtilities.invokeLater(() -> {
            new MenuFrame(player, model, latch);
        });

        latch.await();

        SwingUtilities.invokeLater(() -> {
            new GameFrame(model);
        });
    }

}
