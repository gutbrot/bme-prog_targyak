class Consumer extends Thread {
    private final Fifo fifo;
    private final String s;
    private final int nMillis;

    public Consumer(Fifo f, String s, int n) {
        super("Consumer-" + s);
        this.fifo = f;
        this.s = s;
        this.nMillis = n;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                String item = fifo.get();
                long last5 = System.currentTimeMillis() % 100000L;
                System.out.println("consumed " + s + " " + item + " " + String.format("%05d", last5));
                Thread.sleep(nMillis);
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }
}
