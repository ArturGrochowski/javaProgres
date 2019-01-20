import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiFrame extends JFrame {
    static int xy = 300;
    public MultiFrame(){
        initComponent();
    }

    private void initComponent() {
        this.setTitle("MultiFrame");
        this.setBounds(xy,xy,300,200);
        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        panel.add(newFrameButton);
        newFrameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MakeNewFrame(MultiFrame.this).setVisible(true);
                new DialogFrame().setVisible(true);
            }
        });
    }

    private JButton newFrameButton = new JButton("New Frame");
    private JPanel panel = new JPanel();
}
