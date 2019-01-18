import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class TextField extends JTextField{

    public void initComponent(JTextField jTextField1){
        jTextField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                jTextFieldKeyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                jTextFieldKeyPressed(e);
            }
        });
    }
    private void jTextFieldKeyTyped(KeyEvent e){
        if(notANumber(e.getKeyChar())){
            e.consume();
        }
    }

    private boolean notANumber(char ch){
        if(ch >= '0' && ch <= '9')
            return false;
        return true;
    }

    private void jTextFieldKeyPressed(KeyEvent evt){
        if(evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V){
            Clipboard clipboard  = Toolkit.getDefaultToolkit().getSystemClipboard();
            DataFlavor flavor = DataFlavor.stringFlavor;
            String cBoard = "";
            String cBoard2 = "";
            try {
                cBoard = (String)clipboard.getData(flavor);
                System.out.println(cBoard + "   try");//getData(flavor) return an object so it has to by casted to String and try/catch
            } catch (UnsupportedFlavorException e1) {
                System.out.println("It's not a numer or a letter" + "\n" + e1.getMessage());
                e1.printStackTrace();
            } catch (IOException e1) {
                System.out.println(e1.getMessage());
                e1.printStackTrace();
            }
            for (int i = 0 ; i<cBoard.length(); i++){
                System.out.println("for loop");
                if (notANumber(cBoard.charAt(i))){
                    System.out.println("int i = " + i + " ");
                    System.out.println("it's not a number");
                    char ch = anChar(cBoard, i);
                    cBoard.replace(ch+"", "x");
                    System.out.println("for cBoard = " +cBoard);
                    System.out.println("for cBoard2 = " +cBoard2);
//                    break;
                } else {
                    cBoard2 += cBoard.charAt(i);
                }
            }

            StringSelection stringSelection = new StringSelection(cBoard2);
            clipboard.setContents(stringSelection, null);
        }
    }
    private char anChar (String cBoard, int i){
        return cBoard.charAt(i);
    }

}
