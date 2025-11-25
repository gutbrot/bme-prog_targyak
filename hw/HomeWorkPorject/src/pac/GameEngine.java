package pac;
import javax.swing.*;
import java.util.concurrent.CountDownLatch;

public class GameEngine {

    static Character player = new Character("", 0, 0);

    public static void main(String[] args) throws Exception {

        CountDownLatch latch = new CountDownLatch(1);
        ModelHolder holder = new ModelHolder();

        SwingUtilities.invokeLater(() -> {
            new MenuFrame(player, holder, latch);
        });

        latch.await();

        SwingUtilities.invokeLater(() -> {
            new GameFrame(holder.model.map);
        });
    }

    static class ModelHolder {
        public Model model;
    }
}
