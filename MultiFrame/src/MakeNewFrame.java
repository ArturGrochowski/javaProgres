import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakeNewFrame  extends JFrame {

    public MakeNewFrame(){
        MultiFrame.xy+=70;
        initComponent();
    }

    private void initComponent() {
        this.setTitle("New Frame");
        this.setBounds(MultiFrame.xy,MultiFrame.xy/3,300,200);
        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        panel.add(closeButton);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    MakeNewFrame.super.dispose();
                }
        });

    }

    private JButton closeButton = new JButton("Close");
    private JPanel panel = new JPanel();
}
