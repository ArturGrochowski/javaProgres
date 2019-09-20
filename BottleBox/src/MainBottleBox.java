import java.util.ArrayList;

public class MainBottleBox {
    public static void main(String[] args) {

        Box box = new Box();
        MakingBottleMachine makingBottleMachine = new MakingBottleMachine(box);
        SwapingBoxMachine swapingMachine = new SwapingBoxMachine(box);

        Thread production = new Thread(makingBottleMachine, "producer");
        Thread boxSwaper = new Thread(swapingMachine, "swaper");

        production.start();
        boxSwaper.start();
    }
}

class MakingBottleMachine implements Runnable {

    private Box box;
    private int numberOfButtles = 0;


    public MakingBottleMachine(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        synchronized (box){

            System.out.println(Thread.currentThread().getName() +": Starting production of bottles");
            while(true){
                while(box.isEmpty()){
                    try {
                        System.out.println(Thread.currentThread().getName() +": Box is full! Change the box.");
                        box.wait();
                        System.out.println(Thread.currentThread().getName() +": New box. Continueing bottles production");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() +": Number of produced bottles: "+ (++numberOfButtles));
                box.addBottleToBox(new Bottle());
                box.notifyAll();
            }
        }
    }
}
class SwapingBoxMachine implements Runnable {

    private Box box;

    public SwapingBoxMachine(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        synchronized (box){
            System.out.println(Thread.currentThread().getName() +": Preparing to to change the full box");

            while(true){
                while(!box.isEmpty()){
                    try {
                        System.out.println(Thread.currentThread().getName() +": Swaping is done.");
                        box.wait();
                        System.out.println(Thread.currentThread().getName() +": Swaping is in the process...");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                box.bottelQuantity();
                box.swaping();
                box.bottelQuantity();

                box.notifyAll();
            }
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
