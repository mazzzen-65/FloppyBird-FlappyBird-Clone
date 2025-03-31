import javax.swing.*;

import java.awt.event.ActionListener;
import java.io.*;
import javax.sound.sampled.*;

public class Background extends JPanel {
    Background(){
        JLabel background = new JLabel(new ImageIcon("assets/background.png"));
        add(background);
        playMusic();
    }
    public static void playMusic(){
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("assets/background_ost.wav"));
            Clip clip = AudioSystem.getClip(); //CLip to run the audio
            clip.open(audio);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Error in music assets");
        }
    }
}