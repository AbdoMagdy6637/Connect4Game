import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.swing.*;
public class Main {

    public static void main(String[] args) {

        // splach screen running

        int x=0;
        SplashScreen2 mySplashScreen = new SplashScreen2();
        mySplashScreen.setVisible(true);
        try {
            for (x = 0; x <= 100; x++) {
                SplashScreen2.progressBar.setValue(x);
                Thread.sleep(50);        //make it 100 to slow it
                SplashScreen2.loading.setText(Integer.toString(x)+" %");
                if (x==100)
                    mySplashScreen.dispose();
            }
        }catch(Exception ex)
            {
                ex.printStackTrace();
            }


        GameFrame ourGame=new GameFrame();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    menu frame = new menu();
                    frame.setLocation(350,45);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        if (menu.getSound())
        {
            playing_music_sad.playMusic1("C:\\Users\\Abdo Magdy\\Downloads\\The USSR Anthem But only 1 min.wav");

        }
    }

}
