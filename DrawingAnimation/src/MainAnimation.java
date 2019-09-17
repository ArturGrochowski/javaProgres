import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAnimation extends JFrame {


    public MainAnimation(){
        this.setTitle("Animatino");
        this.setBounds(250,300,500,400);
        animationPanel.setBackground(Color.GRAY);
        JButton startButton = (JButton) buttonsPanel.add(new JButton("Start"));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startAnimation();
            }
        });

        JButton removeButton = (JButton) buttonsPanel.add(new JButton("Remove"));
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopAnimation();
            }
        });


        this.getContentPane().add(animationPanel);
        this.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void stopAnimation() {
        animationPanel.removeAnimedItem();
    }

    public void startAnimation() {
        animationPanel.addItemToAnime();
    }

    private JPanel buttonsPanel = new JPanel();
    private AnimationPanel animationPanel = new AnimationPanel();

    public static void main(String[] args) {
        new MainAnimation().setVisible(true);
    }


}