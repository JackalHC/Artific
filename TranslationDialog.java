package java8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class TranslationDialog extends JFrame {
    private final JTextArea inputTextArea;
    private final JTextArea outputTextArea;

    public TranslationDialog() {
        setTitle("Translation Dialog");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        inputTextArea = new JTextArea(10, 30);
        outputTextArea = new JTextArea(10, 30);
        outputTextArea.setEditable(false);

        JScrollPane inputScrollPane = new JScrollPane(inputTextArea);
        JScrollPane outputScrollPane = new JScrollPane(outputTextArea);

        JButton translateButton = new JButton("翻译");
        translateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 这里编写翻译的代码逻辑
                String inputText = inputTextArea.getText();
                String translatedText = translate(inputText);
                outputTextArea.setText(translatedText);
            }
        });

        add(inputScrollPane);
        add(translateButton);
        add(outputScrollPane);

        pack();
        setVisible(true);
    }

    // 编写翻译逻辑的方法
    private String translate(String inputText) {
        // 这里调用翻译API或翻译算法
        // 返回翻译后的文本
        return "Translate this sentence from me";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TranslationDialog();
            }
        });
    }
}