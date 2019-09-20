import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainBottleBox {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Box box = new Box();
        MakingBottleMachine makingBottleMachine = new MakingBottleMachine(box, lock, condition);
        SwapingBoxMachine swapingMachine = new SwapingBoxMachine(box, lock, condition);

        Thread production = new Thread(makingBottleMachine, "producer");
        Thread boxSwaper = new Thread(swapingMachine, "swaper");

        production.setPriority(Thread.NORM_PRIORITY);
        boxSwaper.setPriority(Thread.NORM_PRIORITY);

        production.start();
        boxSwaper.start();
    }
}

class MakingBottleMachine implements Runnable {

    private Box box;
    private int numberOfButtles = 0;
    private Lock lock;
    private Condition condition;


    public MakingBottleMachine(Box box, Lock lock, Condition condition) {
        this.box = box;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        lock.lock();
        try{

            System.out.println(Thread.currentThread().getName() +": Starting production of bottles");
            while(true){
                while(box.isEmpty()){
                    try {
                        System.out.println(Thread.currentThread().getName() +": Box is full! Change the box.");
                       // box.wait();    this is used with synchronized(box) insead lock.lock();
                        condition.await();
                        System.out.println(Thread.currentThread().getName() +": New box. Continueing bottles production");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() +": Number of produced bottles: "+ (++numberOfButtles));
                box.addBottleToBox(new Bottle());
                //box.notifyAll(); used with suchronized(box)
                condition.signalAll();
            }
        } finally{
            lock.unlock();
        }
    }
}
class SwapingBoxMachine implements Runnable {

    private Box box;
    private Lock lock;
    private Condition condition;

    public SwapingBoxMachine(Box box, Lock lock, Condition condition) {
        this.box = box;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() +": Preparing to to change the full box");

            while(true){
                while(!box.isEmpty()){
                    try {
                        System.out.println(Thread.currentThread().getName() +": Swaping is done.");
                        //box.wait();
                        condition.await();
                        System.out.println(Thread.currentThread().getName() +": Swaping is in the process...");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                box.bottelQuantity();
                box.swaping();
                box.bottelQuantity();

                //box.notifyAll();
                condition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}

class Box {

    public synchronized boolean isEmpty() {

        if(bottelList.size() == CAPACITY)
            return true;

        return false;
    }

    public synchronized int bottelQuantity() {
        System.out.println(Thread.currentThread().getName() + " Quantity of bottel in the box = " + this.bottelList.size());
        return this.bottelList.size();
    }

    public synchronized void addBottleToBox(Bottle bottle){
        bottelList.add(bottle);
    }

    public synchronized void swaping(){
        System.out.println(Thread.currentThread().getName() +": Swaping boxs");
        bottelList.clear();

    }

    private final int CAPACITY = 10;
    private ArrayList bottelList = new ArrayList(CAPACITY);
}

class Bottle {
    public Bottle() {

    }
}
