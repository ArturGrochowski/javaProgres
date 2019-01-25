import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakeNewFrame  extends JFrame {

    public MakeNewFrame(JFrame parentFrame){
        MultiFrame.xy+=70;
        initComponent();
        int width = parentFrame.getBounds().width; // or parentFrame.getWidth().
        this.setSize(width, parentFrame.getHeight());
    }

    public MakeNewFrame(JFrame parentFrame, Color color){
        MultiFrame.xy+=70;
        initComponent();
        int width = parentFrame.getBounds().width; // or parentFrame.getWidth().
        this.setSize(width, parentFrame.getHeight());
        panel.setBackground(color);
        panelDown.setBackground(color);
        panelCentral.setBackground(color);

    }

    public MakeNewFrame(JFrame parentFrame, TextArea textArea){
        MultiFrame.xy+=70;
        initComponent();
        int width = parentFrame.getBounds().width; // or parentFrame.getWidth().
        this.setSize(width, parentFrame.getHeight());
    }

    private void initComponent() {
        this.setTitle("New Frame " + ++i);
        this.setBounds(MultiFrame.xy,MultiFrame.xy/3, 300,200);
        this.getContentPane().add(panel, BorderLayout.NORTH);
        this.getContentPane().add(panelCentral, BorderLayout.CENTER);
        this.getContentPane().add(panelDown, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        panel.add(closeButton);
        panel.add(quitProgramButton);
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
        quitProgramButton.addActionListener(e -> System.exit(0));
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    MakeNewFrame.super.dispose();
                }
        });

    }

    private static int i = 0;
    private JButton closeButton = new JButton("Close");
    private JButton quitProgramButton = new JButton("Quit");
    private JPanel panel = new JPanel();
    private JPanel panelCentral = new JPanel();
    private JPanel panelDown = new JPanel();
    private JSlider slider = new JSlider(0, 999999999);
    private JTextField valueRGB = new JTextField("RGB = " + slider.getValue());
}
