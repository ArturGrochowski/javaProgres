import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakeButton {

    public void makeRadioButton(String name, JLabel time, JLabel timeLable, Boolean trueFalse, ButtonGroup buttonGrSize, JPanel panelNorth){
        JRadioButton button = new JRadioButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLable.setVisible(trueFalse);
                time.setVisible(trueFalse);
            }
        });
        buttonGrSize.add(button);
        panelNorth.add(button);
        button.doClick();
    }

    public void makeButtonSize(String name, int size, JPanel panel, ButtonGroup buttonGrSize, JLabel lable){
        JButton button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lable.setFont(new Font("Monospace", Font.PLAIN, size));
            }
        });
        panel.add(button);
        buttonGrSize.add(button);
    }

    public void makeButtonColor (String name, JLabel lable, JPanel panle){
        JButton button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = new Color(((int)(Math.random() * 0x1000000)));
                Color co = new Color(((int)(Math.random() * 0x1000000)));
                lable.setForeground(c);
                panle.setBackground(co);
            }
        });
        panle.add(button).setBackground(Color.cyan);
    }
}
