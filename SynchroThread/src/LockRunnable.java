import java.util.concurrent.locks.Lock;

public class LockRunnable implements Runnable {

    public LockRunnable(Lock lock){
        this.lock = lock;
    }

    static String[] message = {"This", "is", "the", "LOCKED", "synchro"};

    @Override
    public void run() {
        display(Thread.currentThread().getName());
    }

    public void display (String threadName) {


        lock.lock();
        try {
            for (int i = 0; i < message.length; i++) {
                System.out.println(threadName + ": " + message[i]);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        } finally {
            lock.unlock();
        }
    }


    private Lock lock;
}
