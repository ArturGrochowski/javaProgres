import javax.swing.*;
import java.awt.*;

public class Body extends JFrame {
    public Body(){
/*        JFrame frame = new JFrame("frame name");
        frame.setBounds(200, 300, 300, 400);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(3);
//        frame.setIconImage(Toolkit.getDefaultToolkit().getImage());
        frame.setVisible(true);
    }
//*/
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(width/4, height/4);
        int frameWidth = this.getWidth();
        int frameHeight = this.getHeight();
//        this.setBounds(200, 200, 300, 300); // this is setting starting point (x, y) and size of frame (width, height)
        this.setTitle("My first frame");
        this.setResizable(true);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
//        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Icon.jpg")));
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("Icon.jpg"));
//        this.pack(); // because of this all components of this frame can by handled faster.
        this.setLocation((width-frameWidth)/2, (height-frameHeight)/2);
        initComponents();
    }

    JButton top;
    JButton bottom;
    JButton left;
    JButton right;
    JButton center;
    public void initComponents(){
        top = new JButton("Heya! ;)");
        bottom = new JButton("red");
        left = new JButton("green");
        right = new JButton("blue");
        center = new JButton("white");
        Container container = getContentPane(); // pobierz zawartość szybki // get pane content
        container.add(top, BorderLayout.PAGE_START);
        container.add(bottom, BorderLayout.PAGE_END);
        container.add(left, BorderLayout.WEST);
        container.add(right, BorderLayout.EAST);
        container.add(center, BorderLayout.CENTER);
    }
    public Body(String method){
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(width/4, height/4);
        int frameWidth = this.getWidth();
        int frameHeight = this.getHeight();
        this.setTitle("My first frame");
        this.setResizable(true);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("Icon.jpg"));
        this.pack(); // because of this all components of this frame can by handled faster.
        this.setLocation((width-frameWidth)/4, (height-frameHeight)/4);
        initComponents();
    }

}
