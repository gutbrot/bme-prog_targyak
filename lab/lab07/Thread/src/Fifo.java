import java.util.LinkedList;

public class Fifo {
    private static final int CAPACITY = 10;
    private final LinkedList<String> queue = new LinkedList<>();

    public synchronized void put(String s) throws InterruptedException {
        while (queue.size() >= CAPACITY) {
            wait();
        }
        queue.addLast(s);
        notifyAll();
    }
    public synchronized String get() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        String value = queue.removeFirst();
        notifyAll();
        return value;
    }
}
