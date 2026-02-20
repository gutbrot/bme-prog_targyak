public class Application {
    public static void main() throws InterruptedException {
        Fifo fifo = new Fifo();

        Producer producer = new Producer("demo", fifo,1500);
        Consumer consumer = new Consumer(fifo, "demo", 700);

        producer.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        consumer.start();
    }
}
