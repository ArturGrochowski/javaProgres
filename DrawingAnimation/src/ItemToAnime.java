import javax.swing.*;
import java.awt.*;

public class ItemToAnime {

    public static Image getImage(){
        return ItemToAnime.image;
    }

    public void moveItem (JPanel moveArea) {

        Rectangle panelBound = moveArea.getBounds();
        x += deltaX;
        y += deltaY;

        if (y + yItemHight >= panelBound.getMaxY()){
            y = (int)(panelBound.getMaxY()-yItemHight);
            deltaY = -deltaY;
        }
        if (x + xItemWidth >= panelBound.getMaxX()){
            x = (int)(panelBound.getMaxX()-xItemWidth);
            deltaX = -deltaX;
        }
        if (y < panelBound.getMinY()){
            y = (int) panelBound.getMinY();
            deltaY = -deltaY;
        }
        if (x < panelBound.getMinX()){
            x = (int) panelBound.getMinX();
            deltaX = -deltaX;
        }
    }

    public static Image image = new ImageIcon("OKmini.png").getImage();

    int x = 0;
    int y = 20;
    int deltaX = 1;
    int deltaY = 1;
    int xItemWidth = image.getWidth(null);
    int yItemHight = image.getHeight(null);
}
