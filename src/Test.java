import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Test {

    private static final String VOICENAME_kevin = "kevin";
    private String text; // string to speech

    public Test(String text) {
        this.text = text;
    }

    public void speak() {
        Voice voice;
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice(VOICENAME_kevin);
        voice.allocate();
        voice.speak(text);
    }

    public static void main(String[] args) {
        Window app = new Window();
        app.setVisible(true);
        String text = Window.getText();
        Test freeTTS = new Test(text);
        freeTTS.speak();
    }
}