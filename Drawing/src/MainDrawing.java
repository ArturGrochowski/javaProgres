import javax.swing.*;

public class MainDrawing extends JFrame {

    public MainDrawing() {

        this.setTitle("Drawing");
        this.setBounds(250,300,300,250);

        this.getContentPane().add(panelDrowing);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MainDrawing().setVisible(true);
    }

    PanelDrowing panelDrowing = new PanelDrowing();
}
