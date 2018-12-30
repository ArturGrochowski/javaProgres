import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Events extends JFrame {
    public Events(){
        super("Events");
        this.setBounds(300,300,300,300);
        initComponents();
        this.setDefaultCloseOperation(3);
    }

    public void initComponents(){
        JButton redColor = new JButton("Red");
        JButton whiteColor = new JButton("White");
        JButton greenColor = new JButton("Green");
        JButton blueColor = new JButton("Blue");
        JButton heyColor = new JButton("Heya! :)");
        redColor.addActionListener(new ActListener(Color.red));
        whiteColor.addActionListener(new ActListener(Color.white));
        greenColor.addActionListener(new ActListener(Color.green));
        blueColor.addActionListener(new ActListener(Color.blue));
        heyColor.addActionListener(new ActListener(Color.yellow));
        panel.add(redColor);
        panel.add(whiteColor);
        panel.add(greenColor);
        panel.add(blueColor);
        panel.add(heyColor);
        this.getContentPane().add(panel);
    }

    JPanel panel = new JPanel();

    private class ActListener implements ActionListener {
        Color color;

        public ActListener(Color color) {
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(color);
        }
    }
}
