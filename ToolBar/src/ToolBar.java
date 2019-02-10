import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class ToolBar extends JFrame {
    ToolBar() {
        initComponent();
    }

    private JButton buttonColorOff = new JButton("Turn color OFF");

     private void initComponent(){
        this.setTitle("Tool Bar");
        this.setBounds(300, 300, 500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout(4, 1));
        this.getContentPane().add(toolBar);
        this.getContentPane().add(panel);
        this.getContentPane().add(lablePanel);
        this.getContentPane().add(scrolList);

        toolBar.add(new ColorButton(new ActionColor("Change color for blue", new ImageIcon("C:\\Users\\ARTUR\\IdeaProjects\\javaProgress\\ToolBar\\BLUE.png"), Color.BLUE)));
        toolBar.add(new ColorButton(new ActionColor("Change color for red", new ImageIcon("C:\\Users\\ARTUR\\IdeaProjects\\javaProgress\\ToolBar\\RED.png"), Color.RED)));
        toolBar.add(new ColorButton(new ActionColor("Change color for yellow", new ImageIcon("C:\\Users\\ARTUR\\IdeaProjects\\javaProgress\\ToolBar\\YELLOW.png"), Color.YELLOW)));
        toolBar.add(new ColorButton(new ActionColor("Change color for violet", new ImageIcon("C:\\Users\\ARTUR\\IdeaProjects\\javaProgress\\ToolBar\\VIOLET.png"), Color.MAGENTA)));
        toolBar.add(buttonColorOff);
        lablePanel.add(choosenLesson);
        itemList.addListSelectionListener(e -> {
            if(!e.getValueIsAdjusting()){
                String tmp = "";

                modelList.removeAllElements();
               List<String> list = (List<String>)((JList)e.getSource()).getSelectedValuesList();
               for(Object o : list){
                   modelList.addElement((String) o);
                   tmp = modelList.toString();
                   tmp = tmp.substring(1, tmp.length()-1);
               }

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
}
