import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAnimation extends JFrame {

    JButton startButton = new JButton("Start");
    JButton pauseButton = new JButton("Pause");
    JButton resumeButton = new JButton("Resume");


    public MainAnimation(){
        this.setTitle("Animatino");
        this.setBounds(250,300,500,400);
        animationPanel.setBackground(Color.GRAY);

        buttonsPanel.add(startButton);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    startAnimation();
            }
        });

        JButton removeButton = (JButton) buttonsPanel.add(new JButton("Remove"));
        buttonsPanel.add(pauseButton);
        removeButton.addActionListener(e -> removeAnimation());
        pauseButton.addActionListener(e -> pauseAnimation());
        resumeButton.addActionListener(e -> resumeAnimation());

        this.getContentPane().add(animationPanel);
        this.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void pauseAnimation() {
        buttonsPanel.remove(pauseButton);
        buttonsPanel.add(resumeButton);
        buttonsPanel.revalidate();
        buttonsPanel.repaint();
        AnimationPanel.pauseAnimation();
    }

    private void resumeAnimation(){
        buttonsPanel.remove(resumeButton);
        buttonsPanel.add(pauseButton);
        buttonsPanel.revalidate();
        buttonsPanel.repaint();
        AnimationPanel.resumeAnimation();
    }

    private void removeAnimation() {

        animationPanel.removeAnimedItem();
    }

    public void startAnimation()
    {
        animationPanel.addItemToAnime();
        resumeAnimation();
    }

    private JPanel buttonsPanel = new JPanel();
    private AnimationPanel animationPanel = new AnimationPanel();

    public static void main(String[] args) {
        new MainAnimation().setVisible(true);
    }


}