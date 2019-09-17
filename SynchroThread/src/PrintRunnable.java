public class PrintRunnable implements Runnable {

    static String[] message = {"This", "is", "a", "synchro", "printed", "message"};

    @Override
    public void run() {
        display(Thread.currentThread().getName());
    }

    public synchronized void display (String threadName) {

        for (int i =0; i< message.length; i++){
            System.out.println(threadName + ": " + message[i]);

            try{
                Thread.sleep(100);
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
