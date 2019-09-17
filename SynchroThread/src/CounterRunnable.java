public class CounterRunnable implements Runnable {

    public CounterRunnable (Counter counter, boolean increase){
        this.counter = counter;
        this.increase = increase;
    }

    @Override
    public void run() {

        synchronized (counter) {

            for (int i = 0; i < 10; i++) {
                if (increase)
                    counter.increaseCounter();
                else
                    counter.decreaseCounter();
            }

            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    boolean increase;
    Counter counter;
}
