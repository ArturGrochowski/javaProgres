import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

 class ToolBar extends JFrame {
    ToolBar() {
        initComponent();
    }

    private JButton buttonColorOff = new JButton("Turn color OFF");

     private void initComponent(){
        this.setTitle("Tool Bar");
        this.setBounds(300, 300, 500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout(2, 1));
        this.getContentPane().add(toolBar);
        this.getContentPane().add(panel);

        toolBar.add(new ColorButton(new ActionColor("Change color for blue", new ImageIcon("C:\\Users\\ARTUR\\IdeaProjects\\javaProgress\\ToolBar\\BLUE.png"), Color.BLUE)));
        toolBar.add(new ColorButton(new ActionColor("Change color for red", new ImageIcon("C:\\Users\\ARTUR\\IdeaProjects\\javaProgress\\ToolBar\\RED.png"), Color.RED)));
        toolBar.add(new ColorButton(new ActionColor("Change color for yellow", new ImageIcon("C:\\Users\\ARTUR\\IdeaProjects\\javaProgress\\ToolBar\\YELLOW.png"), Color.YELLOW)));
        toolBar.add(new ColorButton(new ActionColor("Change color for violet", new ImageIcon("C:\\Users\\ARTUR\\IdeaProjects\\javaProgress\\ToolBar\\VIOLET.png"), Color.MAGENTA)));
        toolBar.add(buttonColorOff);

        buttonColorOff.addActionListener(e -> {
            panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            panel.setBackground(UIManager.getColor ( "Panel.background" ));
            colorButton = null;
        });

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (colorButton != null){
                    panel.setBackground((Color) colorButton.getAction().getValue("Color"));
//                panel.setBackground(Color.red);
                }
            }
        });
    }
    private JPanel panel = new JPanel();
    private ColorButton colorButton = null;

     // ActionColor clas define how all buttons work
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
