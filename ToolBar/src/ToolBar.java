import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

class ToolBar extends JFrame {
    ToolBar() {
        initComponent();
    }

    private JButton buttonColorOff = new JButton("Turn color OFF");

     private void initComponent(){
        this.setTitle("Tool Bar");
        this.setBounds(300, 300, 400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout(4, 1));
        this.getContentPane().add(toolBar);
        this.getContentPane().add(panel);
        this.getContentPane().add(lablePanel);
        this.getContentPane().add(scrolList);
        String[] months = new DateFormatSymbols().getMonths();
        MySpinnerListModel monthModel = new MySpinnerListModel(cutArray(months, 0, 11));
        JSpinner spinner = new JSpinner(monthModel);
//        spinner.setEditor(new JTextArea("Wird example"));
        SpinnerNumberModel numberModel = new SpinnerNumberModel(1, 1, 5, 2);
        JSpinner spinner2 = new JSpinner(numberModel);
        Calendar calendar = Calendar.getInstance();
        Date startDate = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -20);
        Date minDate = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 40);
        Date maxDate = calendar.getTime();
        SpinnerDateModel spinnerDateModel = new SpinnerDateModel(startDate, minDate, maxDate, Calendar.DAY_OF_MONTH);
        JSpinner spinner3 = new JSpinner(spinnerDateModel);

        panel.add(spinner);
        panel.add(spinner2);
        panel.add(spinner3);

        toolBar.add(new ColorButton(new ActionColor("Change color for blue", new ImageIcon("C:\\Users\\ARTUR\\IdeaProjects\\javaProgress\\ToolBar\\BLUE.png"), Color.BLUE)));
        toolBar.add(new ColorButton(new ActionColor("Change color for red", new ImageIcon("C:\\Users\\ARTUR\\IdeaProjects\\javaProgress\\ToolBar\\RED.png"), Color.RED)));
        toolBar.add(new ColorButton(new ActionColor("Change color for yellow", new ImageIcon("C:\\Users\\ARTUR\\IdeaProjects\\javaProgress\\ToolBar\\YELLOW.png"), Color.YELLOW)));
        toolBar.add(new ColorButton(new ActionColor("Change color for violet", new ImageIcon("C:\\Users\\ARTUR\\IdeaProjects\\javaProgress\\ToolBar\\VIOLET.png"), Color.MAGENTA)));
        toolBar.add(buttonColorOff);
        lablePanel.add(choosenLesson);
        itemList.addListSelectionListener(e -> {
            if(!e.getValueIsAdjusting()){
                modelList.removeAllElements();
                String tmp = "";
                List<String> list = ((JList<String>)e.getSource()).getSelectedValuesList();

               for(Object o : list){
                   modelList.addElement((String) o);
                   tmp = modelList.toString();
                   tmp = tmp.substring(1, tmp.length()-1);
               }
/*
*       This part of code with Object[] lessonsList was replaced by code obove with List<String> List
* */
//                Object[] lessonsList = ((ArrayList) ((JList) e.getSource()).getSelectedValuesList()).toArray();
//                for (Object o : (((JList) e.getSource()).getSelectedValuesList()).toArray()) {
//                    /* This part with JList is was replaced by cod below with DefaultListModel wich give .addElement(); method
//                     * */
////                    tmp += "    " + (String) lessonsList[i];
//                    modelList.addElement((String) o);
//                }
                choosenLesson.setText(tmp);

            }
        });
/*
*    buttonColorOff ActionListener seting backgrund color for default color of the frame / Panel.
* */
        buttonColorOff.addActionListener(e -> {
            panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            panel.setBackground(UIManager.getColor ( "Panel.background" ));
            itemList.setBackground(UIManager.getColor ( "Panel.background" ));
            lablePanel.setBackground(UIManager.getColor ( "Panel.background" ));
            colorButton = null;
        });

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (colorButton != null){
                    panel.setBackground((Color) colorButton.getAction().getValue("Color"));
                    itemList.setBackground((Color) colorButton.getAction().getValue("Color"));
                    lablePanel.setBackground((Color) colorButton.getAction().getValue("Color"));
                }
            }
        });
    }
    private JPanel panel = new JPanel();
    private ColorButton colorButton = null;
    private JList<String> itemList = new JList<>(new String[]{"MATH", "IT", "PHYSICS", "CHEMISTRY", "BIOLOGY", "HISTORY", "ART", "MUSIC", "GEOGRAPHY", "ENGLISH", "POLISH", "PE" });
    private DefaultListModel<String> modelList = new DefaultListModel<>();
    private JScrollPane scrolList = new JScrollPane(itemList);
    private JLabel choosenLesson = new JLabel();
    private JPanel lablePanel = new JPanel();

     // ActionColor class define how all buttons work
    public class ActionColor extends AbstractAction {

        private ActionColor(String toolTip, Icon icon, Color color) {

            this.putValue(Action.SHORT_DESCRIPTION, toolTip);
            this.putValue(Action.SMALL_ICON, icon);
            this.putValue("Color", color);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            colorButton = (ColorButton) e.getSource();
        }
    }

    private class ColorButton extends JButton{

        private ColorButton(ActionColor actionColor) {
            // calling constructor from JButton class
            super(actionColor);
            this.addActionListener(e -> {
                for(int i = 0; i < toolBar.getComponentCount(); i++){
                    if(toolBar.getComponent(i) instanceof ColorButton){
                        ColorButton tmp = (ColorButton) toolBar.getComponent(i);
                        tmp.setBackground(Color.WHITE);
                        tmp.setSelected(false);
                        //  hotSpot is the point of the Icon/ image where the click, press take place. To set the hotSpot you have to create new Point object and set axes x, y by pixels of the icon, image
                        panel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("C:\\Users\\ARTUR\\IdeaProjects\\javaProgress\\ToolBar\\PAINTING.png").getImage(), new Point(0, 0), "custom cursor" ));
                    }

                }
                thisButton.setBackground((Color) actionColor.getValue("Color"));
                thisButton.setSelected(true);
            });
        }

        public void setSelected (boolean select){
            this.selected = select;
        }
        ColorButton thisButton = this;
        boolean selected = false;
    }

    private JToolBar toolBar = new JToolBar("New Frame");

    /**
     * is cutting array form <code>first</code> to <code>end</code>
     * @param array Object with gonna by cutted
     * @param first index where cutter is starting
     * @param end index where cutter is ending
     * @return shorter Object (tmp)
     */
    public Object[] cutArray(Object[] array, int first, int end){

        // almost like try{}Catch{} ;)  just in case @param end would by bigger then size of array
        end = end > array.length-1 || end < 0 ? array.length-1 : end;
        first = first < 0 || first > end ? 0 : first;

        Object[] tmp = new Object[end+1-first];

        for(int i = first, j = 0; i <= end ; i++, j++){
             tmp[j] = array[i];
        }

        return tmp;
    }
}
