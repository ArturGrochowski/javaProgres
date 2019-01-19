import javax.swing.*;
import java.awt.*;


class TextArea extends JFrame {

    TextArea(){
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
        new ButtonHandler(find, swap);

//        textArea.selectAll();
//        textArea.select(0, 4);
//        textArea.replaceSelection("THIS ");
//        textArea.replaceRange("ThIs ",0,4);
//        textArea.insert("can ", 5);
//        textArea.append(".At the end");
//        textArea.select(textArea.getText().indexOf("it!!!"), textArea.getText().indexOf("!!!"));

    }
    static JTextArea textArea = new JTextArea("to jest test testowy do wyszukiwania słów testowych w klasie textArea. This is it!!!",7, 10);
    static JScrollPane scrollPane = new JScrollPane(textArea);
    private JPanel serchingPanel = new JPanel();
    static JButton find = new JButton("Find");
    static JTextField findThisText = new JTextField(10);
    private  JPanel swapPanel = new JPanel();
    private JLabel andLable = new JLabel("and");
    private JButton swap = new JButton("Swap");
    static JTextField swapTheText = new JTextField(10);


//    private class FindingHandler implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            searchBegin = textArea.getText().indexOf(findThisText.getText(), searchBegin+findThisText.getText().length());
//            if(searchBegin == -1){
//                searchBegin = textArea.getText().indexOf(findThisText.getText());
//            }
//            if(searchBegin >= 0 && findThisText.getText().length() > 0){
//                textArea.requestFocus(); //otherwise the focus will by on the "Find" button and selection would not appear
//                textArea.select(searchBegin, searchBegin+findThisText.getText().length());
//            }
//            System.out.println(searchBegin);
//
//        }
//    }
//    private int searchBegin = 0;
//
//
//    private class SwappingHandler implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if(textArea.getSelectionStart()!=textArea.getSelectionEnd()) {
//                textSwapper();
//            }
//            else {
//                find.doClick(0);
//                if(searchBegin >=0) {
//                    textSwapper();
//                }
//            }
//
//        }
//
//        private void textSwapper(){
//            textArea.requestFocus();
//            int jOptionPane = JOptionPane.showConfirmDialog(rootPane, "Do you wanna replace /" + findThisText.getText() + "/ for /"  + swapTheText.getText() + "/", "Replace warning!", JOptionPane.YES_NO_OPTION);
//            if(jOptionPane == 0) {
//                textArea.replaceRange(swapTheText.getText(), textArea.getSelectionStart(), textArea.getSelectionEnd());
//            }
//        }
//    }
}
