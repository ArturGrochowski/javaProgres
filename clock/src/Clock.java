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
//        setLayout(new BorderLayout());
        panel.add(lable);
        multiPanel.add(panelPageEnd);
//        panelPageEnd.add(multiPanel);
//        panelPageEnd.add(time);

        ActionListener watch = new ClockListener();

        new MakeButton().makeRadioButton("Hide", time, timeLable, false, buttonGrSize, panelNorth);
        new MakeButton().makeRadioButton("Show", time, timeLable, true, buttonGrSize, panelNorth);
        new MakeButton().makeButtonSize("Size 10", 10, panelCenter, buttonGrSize, lable);
        new MakeButton().makeButtonSize("Size 15", 15, panelCenter, buttonGrSize, lable);
        new MakeButton().makeButtonSize("Size 20", 20, panelCenter, buttonGrSize, lable);
        new MakeButton().makeButtonColor("Color", lable, panelCenter);
        JCheckBox bold = new JCheckBox("Bold");
        JCheckBox italic = new JCheckBox("Italic");
        panelNorth.add(bold);
        panelNorth.add(italic);
        lable.setFont(new Font("Arial", Font.PLAIN, 12));
        class ChackBoxHandler implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                int style = Font.PLAIN;
                if(bold.isSelected()) style += Font.BOLD;
                if(italic.isSelected()) style += Font.ITALIC;
                lable.setFont(new Font("Arial", style, 12));
            }
        }
        ActionListener boxListener = new ChackBoxHandler();
        bold.addActionListener(boxListener);
        italic.addActionListener(boxListener);


//        this.getContentPane().add(panelPageEnd, BorderLayout.PAGE_END);
        this.getContentPane().add(multiPanel, BorderLayout.PAGE_END);
        this.getContentPane().add(panelNorth, BorderLayout.NORTH);
        this.getContentPane().add(panelCenter, BorderLayout.CENTER);
//        multiPanel.setLayout(new BorderLayout());
//        this.getContentPane().add(panel, BorderLayout.WEST);
        multiPanel.add(panel, BorderLayout.NORTH);
        multiPanel.add(timeLable, BorderLayout.SOUTH);
        multiPanel.add(time, BorderLayout.SOUTH);
        Timer timer = new Timer(1000, watch);
        timer.start();

//        pack();
    }


    JPanel panelPageEnd = new JPanel();
    JPanel panelNorth = new JPanel();
    JPanel panelCenter = new JPanel();
    JPanel panel = new JPanel();
    JLabel lable = new JLabel("TIMEX");
    JLabel timeLable = new JLabel("Time: ");
    JLabel time = new JLabel(getTime());
    JPanel multiPanel = new JPanel();
    JLabel lableBox = new JLabel();
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
