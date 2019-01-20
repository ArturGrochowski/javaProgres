import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakeNewFrame  extends JFrame {

    public MakeNewFrame(JFrame parentFrame){
        MultiFrame.xy+=70;
        initComponent();
        int width = parentFrame.getBounds().width; // or parentFrame.getWidth().
        this.setSize(width, parentFrame.getHeight());
    }

    private void initComponent() {
        this.setTitle("New Frame " + ++i);
        this.setBounds(MultiFrame.xy,MultiFrame.xy/3, 300,200);
        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        panel.add(closeButton);
        panel.add(quitProgramButton);
        quitProgramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    MakeNewFrame.super.dispose();
                }
        });

    }

    private static int i = 0;
    private JButton closeButton = new JButton("Close");
    private JButton quitProgramButton = new JButton("Quit");
    private JPanel panel = new JPanel();
}
