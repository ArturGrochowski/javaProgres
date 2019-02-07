/*This class create new frame base on size and loctation of parent frame (MultiFrame) */

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        initComponent();
        int width = parentFrame.getBounds().width; // or parentFrame.getWidth().
        this.setSize(width, parentFrame.getHeight());
        this.getContentPane().add(textArea);

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
/*"static int i" is counting how many frames has been created by initComponent();*/
    static int i = 0;
    private JButton closeButton = new JButton("Close");
    private JButton quitProgramButton = new JButton("Quit");
    private JPanel panel = new JPanel();
    private JPanel panelCentral = new JPanel();
    private JPanel panelDown = new JPanel();
    private JSlider slider = new JSlider(0, 999999999);
    private JTextField valueRGB = new JTextField("RGB = " + slider.getValue());
}
