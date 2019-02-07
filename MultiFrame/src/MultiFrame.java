/*This Class create main window with button to create other window
* and 2 radio buttons to choos border style inside of this main frame
 */
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.BorderFactory.createTitledBorder;

public class MultiFrame extends JFrame {
    // this statinc int xy is to set location of new window (axis x, y)
    static int xy = 300;

    public MultiFrame(){
        initComponent();
    }
/* All components (buttons, menu), location and size of the main frame */
    public void initComponent() {
        this.setTitle("MultiFrame");
        this.setBounds(xy,xy,300,200);
        this.getContentPane().setLayout(new GridLayout(2,1));
        this.getContentPane().add(panel);
        this.getContentPane().add(panelEdge);
        this.setJMenuBar(menuNewFrame);
        JMenu menuColor = menuNewFrame.add(new JMenu("New Frame"));
        JMenu subMenuColor = new JMenu("Colors");
        menuColor.add(subMenuColor);
        JMenuItem subMenuText = new JMenuItem("Text Area");
        /* This lambda replacing an anonymous class. "e" stands for "void actiomPerformed(ActionEvent e)" method.
        * You can chceck how it looks like at the very bottom of this initComponent() method*/
        subMenuText.addActionListener(e -> {
            new MakeNewFrame(MultiFrame.this, textArea).setVisible(true);
            new DialogFrame("You've created " + DialogFrame.y + " text frame(s)").setVisible(true);
        });
        menuColor.add(subMenuText);
        JMenuItem subMenuRed = subMenuColor.add("Red");
        JMenuItem subMenuGreen = subMenuColor.add("Green");
        JMenuItem subMenuBlue = subMenuColor.add("Blue");
        JMenuItem subMenuOrange = subMenuColor.add("Orange");
        newColorFrame(subMenuRed, Color.red);
        newColorFrame(subMenuGreen, Color.green);
        newColorFrame(subMenuBlue, Color.blue);
        newColorFrame(subMenuOrange, Color.orange);
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

    public void newColorFrame (JMenuItem subMenuColor, Color color){
        subMenuColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MakeNewFrame(MultiFrame.this, color).setVisible(true);
                new DialogFrame().setVisible(true);
            }
        });
    }

    public void addRadioButton (String name, Border border){
        JRadioButton radioButton = new JRadioButton(name);
        /* "e" from lambda stands for "public void itemStateChanged(ItemEvent e)" method from anonymous class*/
        radioButton.addItemListener(e -> panelEdge.setBorder(createTitledBorder(border, name)));
        buttonGroup.add(radioButton);
        panelEdge.add(radioButton);
    }

    private JButton newFrameButton = new JButton("New Frame");
    private JPanel panel = new JPanel();
    private JPanel panelEdge = new JPanel();
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JMenuBar menuNewFrame = new JMenuBar();
    private JTextArea textArea = new JTextArea("Text Area");
}
