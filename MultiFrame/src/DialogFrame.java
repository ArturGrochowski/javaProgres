import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogFrame extends JDialog {

        public DialogFrame(){
            initComponent();
        }

        private void initComponent() {
            this.setTitle("Dialog " + i++);
            this.setBounds(300,330, 300,100);
            this.getContentPane().add(panel);
            this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            panel.add(lable);
            panel.add(closeButton);
            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DialogFrame.super.dispose();
                }
            });

        }

        private static int i = 1;
        private JButton closeButton = new JButton("OK");
        private JPanel panel = new JPanel();
        private JLabel lable = new JLabel("You've created " + i + " new frame(s)");
}
