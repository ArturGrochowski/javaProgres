import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MakeMenuButton extends JButton implements FocusListener, ActionListener {
    private Color colorFocusGained = Color.red;
    private Color colorDafault = Color.blue;


    public MakeMenuButton(String name, Color colorDefault, Color colorFocusGained, JPanel panelMenu){
        super(name);
        this.addFocusListener(this);
        this.addActionListener(this);
        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                keyPressedHandler(e, panelMenu);
//                    myMenu.keyPressedHandler(e, panelMenu);
            }

        });
        this.setBackground(colorDefault);
        this.colorDafault = colorDefault;
        this.colorFocusGained = colorFocusGained;
    }

    private void keyPressedHandler(KeyEvent e, JPanel panelMenu) {

        int menuLength = panelMenu.getComponentCount();
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            System.out.println("down przed" + myMenu.i);
            panelMenu.getComponent(myMenu.i++).requestFocus();
            System.out.println("down po" + myMenu.i);
            if (myMenu.i>=3){
                myMenu.i=0;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_UP){
            System.out.println("up przed" + myMenu.i);
            panelMenu.getComponent(myMenu.i).requestFocus();
            System.out.println("up po" + myMenu.i);
            if(myMenu.i==0){
                myMenu.i=3;
            }
            myMenu.i--;
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
//            MakeMenuButton tmp = (MakeMenuButton) e.getSource(); tmp.doClick();
            ((MakeMenuButton)e.getSource()).doClick();
        }
    }
//FocusListener has 2 methods overrided below. When you click on button your program focussing on the component.
    @Override
    public void focusGained(FocusEvent e) {
        this.setBackground(colorFocusGained);
    }

    @Override
    public void focusLost(FocusEvent e) {
        this.setBackground(colorDafault);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, ((MakeMenuButton)e.getSource()).getText());
    }
}
