import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAreaMain extends JFrame {

    public TextAreaMain(){
        initComponent();
    }

    private void initComponent() {
        this.setTitle("Teks searcher");
        this.setBounds(300,300,300,250);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().add(scrollPane, BorderLayout.NORTH);
        serchingPanel.add(find);
        serchingPanel.add(findThisText);
        serchingPanel.add(andLable);
        swapPanel.add(swap);
        swapPanel.add(swapTheText);
        this.getContentPane().add(serchingPanel, BorderLayout.CENTER);
        this.getContentPane().add(swapPanel, BorderLayout.SOUTH);
        find.addActionListener(new FindingHandler());
        swap.addActionListener(new SwappingHandler());

//        textArea.selectAll();
//        textArea.select(0, 4);
//        textArea.replaceSelection("THIS ");
//        textArea.replaceRange("ThIs ",0,4);
//        textArea.insert("can ", 5);
//        textArea.append(".At the end");
//        textArea.select(textArea.getText().indexOf("it!!!"), textArea.getText().indexOf("!!!"));

    }
    private JTextArea textArea = new JTextArea("to jest test testowy do wyszukiwania słów testowych w klasie textArea. This is it!!!",7, 10);
    private JScrollPane scrollPane = new JScrollPane(textArea);
    private JPanel serchingPanel = new JPanel();
    private JButton find = new JButton("Find");
    private JTextField findThisText = new JTextField(10);
    private  JPanel swapPanel = new JPanel();
    private JLabel andLable = new JLabel("and");
    private JButton swap = new JButton("Swap");
    private JTextField swapTheText = new JTextField(10);


    public static void main(String[] args) {
        new TextAreaMain().setVisible(true);
    }

    private class FindingHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            searchBegin = textArea.getText().indexOf(findThisText.getText(), searchBegin+findThisText.getText().length());
            if(searchBegin == -1){
                searchBegin = textArea.getText().indexOf(findThisText.getText());
            }
            if(searchBegin >= 0 && findThisText.getText().length() > 0){
                textArea.requestFocus(); //otherwise the focus will by on the "Find" button and selection would not appear
                textArea.select(searchBegin, searchBegin+findThisText.getText().length());
            }
            System.out.println(searchBegin);

        }
    }
    private int searchBegin = 0;


    private class SwappingHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(textArea.getSelectionStart()!=textArea.getSelectionEnd()) {
                textSwapper();
            }
            else {
                find.doClick();
                if(searchBegin >=0) {
                    textSwapper();
                }
            }

        }

        private void textSwapper(){
            JOptionPane.showConfirmDialog(rootPane, "Do you wanna replace /" + findThisText.getText() + "/ for /"  + swapTheText.getText() + "/");
            textArea.replaceRange(swapTheText.getText(), textArea.getSelectionStart(), textArea.getSelectionEnd());
        }
    }
}
