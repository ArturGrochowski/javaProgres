import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Clock extends JFrame {
    public Clock(){
        super("Clock");
        this.setBounds(300,300,300,200); // if I have pack() inside initComponents() I don't need to set Size of the frame, just location.
//        this.setLocation(300,300);
        initComponents();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        panel.add(lable);
        panel.add(time);
        ActionListener watch = new ClockListener();

        JRadioButton radioButtonS = new JRadioButton("Hide");
        JRadioButton radioButtonM = new JRadioButton("Show", true); //the "true" doesn't "doClick();", just setting the default position

        radioButtonS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lable.setVisible(false);
                time.setVisible(false);
            }
        });
        radioButtonM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lable.setVisible(true);
                time.setVisible(true);
            }
        });

        new MakeButton().makeButtonSize("Size 10", 10, panel2, buttonGrSize, lable);
        new MakeButton().makeButtonSize("Size 15", 15, panel2, buttonGrSize, lable);
        new MakeButton().makeButtonSize("Size 20", 20, panel2, buttonGrSize, lable);
        new MakeButton().makeButtonColor("Color", lable, panel);

        buttonGrSize.add(radioButtonS);
        buttonGrSize.add(radioButtonM);

        panel1.add(radioButtonS);
        panel1.add(radioButtonM);

        this.getContentPane().add(panel, BorderLayout.PAGE_END);
        this.getContentPane().add(panel1, BorderLayout.NORTH);
        this.getContentPane().add(panel2, BorderLayout.CENTER);
        Timer timer = new Timer(1000, watch);
        timer.start();
        radioButtonM.doClick();

//        pack();
    }


    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JLabel lable = new JLabel("Time: ");
    JLabel time = new JLabel(getTime());
    JLabel testLable = new JLabel();
    ButtonGroup buttonGrSize = new ButtonGroup(); // this group make one choice from all added buttons possible.

    private class ClockListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            time.setText(getTime());
        }
    }
    public String getTime(){
        GregorianCalendar calendar = new GregorianCalendar();
        String h = ""+calendar.get(Calendar.HOUR_OF_DAY);
        String min = ""+calendar.get(Calendar.MINUTE);
        String sec = ""+calendar.get(Calendar.SECOND);
        if (Integer.parseInt(h)<10)
            h =  "0"+h;
        if (Integer.parseInt(min)<10)
            min =  "0"+min;
        if (Integer.parseInt(sec)<10)
            sec =  "0"+sec;
        return h +":"+ min +":"+ sec;
    }

}
