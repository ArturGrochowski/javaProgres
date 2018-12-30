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
    public void buttonBuilder(String name, Color color){
        JButton button = new JButton(name);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(color);
            }
        });
    }

    public void initComponents(){
        JButton heyColor = new JButton("Heya! :)");
        heyColor.addActionListener(new ActListener(Color.yellow));
        panel.add(heyColor);
        this.getContentPane().add(panel);
        buttonBuilder("Black", Color.black);
        buttonBuilder("White", Color.white);
        buttonBuilder("Red", Color.red);
        buttonBuilder("Green", Color.green);
        buttonBuilder("Blue", Color.blue);
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
