import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AnimationPanel extends JPanel {

    private static volatile boolean paused = false;
    private static final Object lock = new Object();

    public void addItemToAnime() {


        itemsList.add(new ItemToAnime());
        thread = new Thread(threadGroup, new ItemRunnable((ItemToAnime) itemsList.get(itemsList.size()-1)) );
        thread.start();
        threadGroup.list();
        isListEmpty();

    }

    public static void pauseAnimation(){
        paused = true;
    }

    public static void resumeAnimation(){
        if(paused){
            paused = false;
            synchronized (lock){
                lock.notifyAll();
            }
        }
    }

    public void paintComponent (Graphics graphics){
        super.paintComponent(graphics);
        for(int i = 0; i < itemsList.size(); i++){
            graphics.drawImage(ItemToAnime.getImage(), ((ItemToAnime)itemsList.get(i)).x, ((ItemToAnime)itemsList.get(i)).y, null);
        }
    }

    ArrayList itemsList = new ArrayList();
    JPanel thisPannel = this;
    Thread thread;
    ThreadGroup threadGroup = new ThreadGroup("Group of animedItems");
    static boolean ISlistEMPTY;

    public void isListEmpty(){
        if (itemsList.size() == 0)
            ISlistEMPTY = true;

        ISlistEMPTY = false;
    }

    public void removeAnimedItem() {
        threadGroup.interrupt();
    }

    public class ItemRunnable implements Runnable{

        public ItemRunnable(ItemToAnime itemToAnime){
            this.itemToAnime = itemToAnime;
        }

        @Override
        public void run() {

            while(true){
                synchronized (lock){
                    while (paused){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                this.itemToAnime.moveItem(thisPannel);
                repaint();
                try{
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                    itemsList.clear();
                    repaint();
                }
            }

//            try {
//                while (!Thread.currentThread().isInterrupted()){
//                    isListEmpty();
//
//                    this.itemToAnime.moveItem(thisPannel);
//                    repaint(); // this.paint(this.getGraphics());
//
//                        Thread.sleep(1);
//
//                }
//            } catch (InterruptedException e) {
//                System.out.println(e.getMessage());
//                itemsList.clear();
//                repaint();
//            }
        }
        ItemToAnime itemToAnime;
    }
}
