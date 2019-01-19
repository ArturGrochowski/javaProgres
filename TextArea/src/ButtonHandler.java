import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonHandler {


    ButtonHandler(JButton find, JButton swap) {
        find.addActionListener(new FindingHandler());
        swap.addActionListener(new SwappingHandler());
    }

    private class FindingHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            searchBegin = TextArea.textArea.getText().indexOf(TextArea.findThisText.getText(), searchBegin+TextArea.findThisText.getText().length());
            if(searchBegin == -1){
                searchBegin = TextArea.textArea.getText().indexOf(TextArea.findThisText.getText());
            }
            if(searchBegin >= 0 && TextArea.findThisText.getText().length() > 0){
                TextArea.textArea.requestFocus(); //otherwise the focus will by on the "Find" button and selection would not appear
                TextArea.textArea.select(searchBegin, searchBegin+TextArea.findThisText.getText().length());
            }
            System.out.println(searchBegin);

        }
    }
    private int searchBegin = 0;


    private class SwappingHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(TextArea.textArea.getSelectionStart()!=TextArea.textArea.getSelectionEnd()) {
                textSwapper();
            }
            else {
                TextArea.find.doClick(0);
                if(searchBegin >=0) {
                    textSwapper();
                }
            }

        }

        private void textSwapper(){
            TextArea.textArea.requestFocus();
            int jOptionPane = JOptionPane.showConfirmDialog(TextArea.scrollPane, "Do you wanna replace /" + TextArea.findThisText.getText() + "/ for /"  + TextArea.swapTheText.getText() + "/", "Replace warning!", JOptionPane.YES_NO_OPTION);
            if (jOptionPane == 0) {
                TextArea.textArea.replaceRange(TextArea.swapTheText.getText(), TextArea.textArea.getSelectionStart(), TextArea.textArea.getSelectionEnd());
            }
        }
    }
}
