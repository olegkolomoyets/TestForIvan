import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private static JTextField input = new JTextField();
    private JLabel label = new JLabel("Enter your fucking text, bitch!");
    private JButton entButton = new JButton("Recognise");
    private JButton exButon = new JButton("Exit");


    private static final String VOICENAME_kevin = "kevin";
    private String text; // string to speech

    public Window(String text) {
        this.text = text;
    }

    public void speak() {
        Voice voice;
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice(VOICENAME_kevin);
        voice.allocate();
        voice.speak(text);
    }


    public Window() {
        super("Simple Example");
        this.setBounds(100, 100, 250, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(label);
        container.add(input);

        container.add(entButton);
        container.add(exButon);

        entButton.setSelected(true);
        exButon.setSelected(true);
        entButton.addActionListener(new ButtonEventListener());
        exButon.addActionListener(new ButtonEventListener());

    }

    public static String getText() {
        String text = input.getText();
        return text;
    }


    class ButtonEventListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Recognise")) {
                text = Window.getText();
                Window freeTTS = new Window(text);
                freeTTS.speak();
            }
            if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
            }
        }

    }

    public static void main(String[] args) {
        Window app = new Window();
        app.setVisible(true);
    }
}