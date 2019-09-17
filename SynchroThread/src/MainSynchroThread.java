import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainSynchroThread {
    public static void main(String[] args) {

        Runnable printing = new PrintRunnable();

        Thread thread1 = new Thread(printing, "Thread 1");
        Thread thread2 = new Thread(printing, "Thread 2");

        thread2.start();
        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());


        Counter counter = new Counter();

        Thread thread3 = new Thread(new CounterRunnable(counter, false), "Decreasing");
        Thread thread4 = new Thread(new CounterRunnable(counter, true), "Increasing");

        thread3.start();
        thread4.start();

        Lock lock = new ReentrantLock();

        Thread thread5 = new Thread(new LockRunnable(lock), "LOCKED Thread5");
        Thread thread6 = new Thread(new LockRunnable(lock), "LOCKED Thread6");

        thread5.start();
        thread6.start();
    }


}
