package etc;
import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class SimplePiano1 extends JFrame implements KeyListener {
    private Map<Integer, Integer> keyToNote = new HashMap<>();
    private Synthesizer synthesizer;
    private MidiChannel midiChannel;
    private JLabel keyPressedLabel;

    public SimplePiano1() {
        // Set up the window
        setTitle("Simple Piano");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        
        // Add a label to display the pressed key
        keyPressedLabel = new JLabel();
        add(keyPressedLabel);
        // Initialize the MIDI synthesizer
        try {
            synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            midiChannel = synthesizer.getChannels()[0];
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
        
        // Map computer keyboard keys to MIDI note numbers
        keyToNote.put(KeyEvent.VK_1, 60);
        keyToNote.put(KeyEvent.VK_2, 61);
        keyToNote.put(KeyEvent.VK_3, 62);
        keyToNote.put(KeyEvent.VK_4, 63);
        keyToNote.put(KeyEvent.VK_5, 64);
        keyToNote.put(KeyEvent.VK_6, 65);
        keyToNote.put(KeyEvent.VK_7, 66);
        keyToNote.put(KeyEvent.VK_8, 67);
        keyToNote.put(KeyEvent.VK_9, 68);
        keyToNote.put(KeyEvent.VK_0, 69);
        keyToNote.put(KeyEvent.VK_MINUS, 70);
        keyToNote.put(KeyEvent.VK_EQUALS, 71);
        keyToNote.put(KeyEvent.VK_BACK_SPACE, 72);
        
        // Display the window
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        keyPressedLabel.setText("Key pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
        if (keyToNote.containsKey(keyCode)) {
            int noteNumber = keyToNote.get(keyCode);
            midiChannel.noteOn(noteNumber, 100);
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyToNote.containsKey(keyCode)) {
            int noteNumber = keyToNote.get(keyCode);
            midiChannel.noteOff(noteNumber);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        // Do nothing
    }
    
    public static void main(String[] args) {
        new SimplePiano1();
    }
}
