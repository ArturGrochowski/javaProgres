import javax.swing.*;

public class ClockMain {
    public static void main(String[] args) {
        new Clock().setVisible(true);
        try {
            //This look and feel works
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

            //None of these do.
//                UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
//                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
//                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");



        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
