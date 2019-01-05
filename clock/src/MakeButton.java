import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakeButton {

    public JButton makeButtonS (String name, int size, JLabel lable){
        JButton button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lable.setFont(new Font("Monospace", Font.PLAIN, size));
            }
        });
        return button;
    }
}
