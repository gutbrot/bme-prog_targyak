public class Producer extends Thread{
    private int time;
    private String s;
    private final Fifo fifo;
    public Producer(String s, Fifo fifo, int time){
        this.s = s;
        this.fifo = fifo;
        this.time = time;
    }
    @Override
    public void run() {
        long count = 0;
        while (true) {
            String msg = s + " " + count;
            try {
                fifo.put(msg);

                long last5 = System.currentTimeMillis() % 100000L;
                System.out.println("produced " + msg + " " + String.format("%05d", last5));

                Thread.sleep(time);
                count++;
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }
}
