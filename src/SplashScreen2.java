import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SplashScreen2 extends JFrame {
    public JPanel contentPane;
    public static JProgressBar progressBar;
    public static JLabel loading;
    public SplashScreen2()
    {
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(400,50,900,750);
        contentPane=new JPanel();
        this.contentPane.setBackground(Color.black);
        this.contentPane.setBorder(new EmptyBorder(5,5,5,5));
        this.setContentPane(contentPane);
        this.contentPane.setLayout(null);

        JLabel myLabel=new JLabel("");
        ImageIcon icon =new ImageIcon(this.getClass().getResource("splash4.gif"));
        myLabel.setIcon(icon);
        myLabel.setBounds(370, 150, 480, 291);// best place for  splach2 splash4
       // myLabel.setBounds(-150, 11, 500, 200);  // best place for  splach2
        contentPane.add(myLabel);


        progressBar=new JProgressBar();
        progressBar.setForeground(new Color(0,128,128));
        progressBar.setBounds(20,700,860,16);
        contentPane.add(progressBar);
        loading=new JLabel();
        loading.setBounds(450,650,46,14);
        loading.setForeground(Color.WHITE);
        contentPane.add(loading);

    }

}
