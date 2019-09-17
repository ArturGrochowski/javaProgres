import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AnimationPanel extends JPanel {

    public void addItemToAnime() {


        itemsList.add(new ItemToAnime());
        thread = new Thread(threadGroup, new ItemRunnable((ItemToAnime) itemsList.get(itemsList.size()-1)) );
        thread.start();
        threadGroup.list();

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

    public void removeAnimedItem() {
        threadGroup.interrupt();
    }

    public class ItemRunnable implements Runnable{

        public ItemRunnable(ItemToAnime itemToAnime){
            this.itemToAnime = itemToAnime;
        }

        @Override
        public void run() {

            try {
                while (!Thread.currentThread().isInterrupted()){

                    this.itemToAnime.moveItem(thisPannel);
                    repaint(); // this.paint(this.getGraphics());

                        Thread.sleep(1);

                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                itemsList.clear();
                repaint();
            }
        }
        ItemToAnime itemToAnime;
    }
}
