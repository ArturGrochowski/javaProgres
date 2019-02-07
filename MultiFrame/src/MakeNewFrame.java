/*This class create new frame base on size and loctation of parent frame (MultiFrame) */

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MakeNewFrame  extends JFrame {

    /*this constructor is coled by button "New Frame" in main, parent frame (MultiFrame), and create new window*/
    public MakeNewFrame(JFrame parentFrame){
        MultiFrame.xy+=70;
        sliderComponent();
        int width = parentFrame.getBounds().width; // or parentFrame.getWidth().
        this.setSize(width, parentFrame.getHeight());
    }

    /*this constructor is coled from menu in main, parent frame (MultiFrame),
    and create new window with specific background color*/
    public MakeNewFrame(JFrame parentFrame, Color color){
        MultiFrame.xy+=70;
        sliderComponent();
        int width = parentFrame.getBounds().width; // or parentFrame.getWidth().
        this.setSize(width, parentFrame.getHeight());
        panel.setBackground(color);
        panelDown.setBackground(color);
        panelCentral.setBackground(color);

    }

    /*this constructor is coled from menu in main, parent frame (MultiFrame),
    and create new window with text area*/
    public MakeNewFrame(JFrame parentFrame, JTextArea textArea){
        MultiFrame.xy+=70;
        JMenuBar menuBar = new JMenuBar();
        Action actionSave = new ActionSave("Save");
        JCheckBoxMenuItem readOnly = new JCheckBoxMenuItem("read only");
        JMenuItem save = new JMenuItem(actionSave);
        JMenuItem read = new JMenuItem("Read");
        JButton saveButton = new JButton(actionSave);
        initComponent();
        panel.add(saveButton);
        actionSave.setEnabled(false);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Saving on your drive");
                actionSave.setEnabled(flagTextArea=false);
            }
        });
        save.setToolTipText("Saving the file on your drive");
        save.setMnemonic('s');
        save.setAccelerator(KeyStroke.getKeyStroke("ctrl s"));
        int width = parentFrame.getBounds().width; // or parentFrame.getWidth().
        this.setSize(width, parentFrame.getHeight());
        this.getContentPane().add(textArea);
        this.setJMenuBar(menuBar);
        JMenu menuFile = menuBar.add(new JMenu("File"));
        JMenuItem subMenuNew = menuFile.add("New file");
        subMenuNew.addActionListener(e -> MultiFrame.subMenuText.doClick());
        menuFile.addSeparator();
        menuFile.add(save);
        menuFile.add(read);
        menuFile.addSeparator();
        menuFile.add(readOnly);
        readOnly.addActionListener(e -> {
            if(readOnly.isSelected()){
                actionSave.setEnabled(false);
            } else {
                actionSave.setEnabled(flagTextArea);
            }
        });
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if(readOnly.isSelected()){
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(readOnly.isSelected()){
                    e.consume();
                } else if (!(textArea.getText() + e.getKeyChar()).equals(beforEdtitingTextArea)) {
                    beforEdtitingTextArea = textArea.getText()+ e.getKeyChar();
                    actionSave.setEnabled(flagTextArea=true);
                }
            }
        });
    }
/* this method create slider at the bottom of the frame to change background color of the frame*/
    private void sliderComponent(){
        initComponent();
        panelCentral.add(valueRGB);
        panelDown.add(slider, BorderLayout.SOUTH);
        valueRGB.setEditable(false);
        slider.setSnapToTicks(true);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                valueRGB.setText("RGB = "+ ((JSlider)e.getSource()).getValue());
                Color c = new Color(((JSlider)e.getSource()).getValue());
                panel.setBackground(c);
                panelCentral.setBackground(c);
                panelDown.setBackground(c);
            }
        });
    }
/*this method create new frame, set size, location and add buttons*/
    private void initComponent() {
        this.setTitle("New Frame " + ++i);
        this.setBounds(MultiFrame.xy,MultiFrame.xy/3, 300,200);
        this.getContentPane().add(panel, BorderLayout.NORTH);
        this.getContentPane().add(panelCentral, BorderLayout.CENTER);
        this.getContentPane().add(panelDown, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        panel.add(closeButton);
        panel.add(quitProgramButton);
        quitProgramButton.addActionListener(e -> System.exit(0));
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    MakeNewFrame.super.dispose();
                }
        });

    }

    private class ActionSave extends AbstractAction{

        public ActionSave(String name) {
            this.putValue(Action.NAME, name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Saving on your drive");
            this.setEnabled(flagTextArea=false);
        }
    }
/*"static int i" is counting how many frames has been created by initComponent();*/
    static int i = 0;
    private JButton closeButton = new JButton("Close");
    private JButton quitProgramButton = new JButton("Quit");
    private JPanel panel = new JPanel();
    private JPanel panelCentral = new JPanel();
    private JPanel panelDown = new JPanel();
    private JSlider slider = new JSlider(0, 999999999);
    private JTextField valueRGB = new JTextField("RGB = " + slider.getValue());
    private boolean flagTextArea = false;
    private String beforEdtitingTextArea = "";

}
