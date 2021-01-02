import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class playing_music_sad {
    public playing_music_sad()
    {

    }
    public static void playMusic1(String filePath)   //anthem russian
    {
        // InputStream music;
        try
        {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(filePath)));
            {clip.start();}
            Thread.sleep(clip.getMicrosecondLength()/2000); // if it increase it will play it fast if decrease it will take some time to play
        }
        catch (Exception e)                     // overriding
        {
            JOptionPane.showMessageDialog(null,"Error");
        }
    }
    public static void playMusic2(String filePath)      //nanii
    {
        // InputStream music;
        try
        {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(filePath)));
            {clip.start();}
            Thread.sleep(clip.getMicrosecondLength()/2000); // if it increase it will play it fast if decrease it will take some time to play
        }
        catch (Exception e)                     // overriding
        {
            JOptionPane.showMessageDialog(null,"Error");
        }
    }
}
