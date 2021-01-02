package ssss;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class main_2 {
    public static void main(String[] args) {
        final JFXPanel fxPanel = new JFXPanel();
        playMusic("C:\\\\Users\\Abdo Magdy\\Downloads\\National Anthem of USSR.wav");


    }

    public static void playMusic(String filePath)
    {
        // InputStream music;
        try
        {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(filePath)));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength()/2000);
        }
        catch (Exception e)                     // overriding
        {
            JOptionPane.showMessageDialog(null,"Error");
        }
    }

}
