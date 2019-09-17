import javax.swing.*;
import java.awt.*;

public class PanelDrowing extends JPanel {

    public PanelDrowing(){
        super();

        this.add(new JButton("Test"){
            public void paintComponent (Graphics graphics){
                super.paintComponent(graphics);

            }

        });
    }

    public void paintComponent (Graphics graphics){
        super.paintComponent(graphics);
        graphics.drawString("Example", 0,40);

        graphics.clearRect(20,20,10,20);
        graphics.drawLine(60,60,60,60);
        graphics.drawImage(new ImageIcon("OKmini.png").getImage(), 80, 80, null );

    }

    public static int i = 0;
}
