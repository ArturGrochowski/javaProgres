/*this class crate poping dialg window every timie you create new frame witn info how many frames you've created*/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogFrame extends JDialog {

    public DialogFrame(){
        initComponent();
    }

    public DialogFrame(String text){
        initComponent();
        lable.setText(text);
    }

    private void initComponent() {
        this.setTitle("Dialog " + MakeNewFrame.i);
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

/*"static int y" is counting how many text area frames you've created by initTextComponent()*/
    static int y = 0;
    private JButton closeButton = new JButton("OK");
    private JPanel panel = new JPanel();
    private JLabel lable = new JLabel("You've created " + MakeNewFrame.i + " new frame(s)");
}
