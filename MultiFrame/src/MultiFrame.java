import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.BorderFactory.createTitledBorder;

public class MultiFrame extends JFrame {
    static int xy = 300;
    public MultiFrame(){
        initComponent();
    }

    public void initComponent() {
        this.setTitle("MultiFrame");
        this.setBounds(xy,xy,300,200);
        this.getContentPane().setLayout(new GridLayout(2,1));
        this.getContentPane().add(panel);
        this.getContentPane().add(panelEdge);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        panel.add(newFrameButton);
        panel.setBorder(createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Creator", TitledBorder.CENTER, TitledBorder.TOP));
        addRadioButton("EtchedBorder", BorderFactory.createEtchedBorder());
        addRadioButton("LoweredBevelBrd", BorderFactory.createLoweredBevelBorder());
        newFrameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MakeNewFrame(MultiFrame.this).setVisible(true);
                new DialogFrame().setVisible(true);
            }
        });
    }

    public void addRadioButton (String name, Border border){
        JRadioButton radioButton = new JRadioButton(name);
        radioButton.addItemListener(e -> panelEdge.setBorder(createTitledBorder(border, name)));
        buttonGroup.add(radioButton);
        panelEdge.add(radioButton);
    }

    private JButton newFrameButton = new JButton("New Frame");
    private JPanel panel = new JPanel();
    private JPanel panelEdge = new JPanel();
    private ButtonGroup buttonGroup = new ButtonGroup();
}
