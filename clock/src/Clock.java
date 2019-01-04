import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Clock extends JFrame {
    public Clock(){
        super("Clock");
//        this.setBounds(300,300,300,200); // if I have pack() inside initComponents() I don't need to set Size of the frame, just location.
        this.setLocation(300,300);
        initComponents();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        panel.add(lable);
        panel.add(time);
        ActionListener watch = new ClockListener();
        this.getContentPane().add(panel);
        Timer timer = new Timer(1000, watch);
        timer.start();
        pack();
    }
    JPanel panel = new JPanel();
    JLabel lable = new JLabel("Time: ");
    JLabel time = new JLabel(getTime());
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
