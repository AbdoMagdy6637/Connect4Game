import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Game_Player_Panel extends JPanel{
    JLabel Text_Field ;
    String[] Player_Name = new String[2];
    public Game_Player_Panel()
    {

        this.setBackground(new Color(65,65,200));
        //this.setAlignmentY(TOP_ALIGNMENT);
        this.setLayout(new BorderLayout());
        this.setBounds(0,0,800,100);

        Text_Field = new JLabel();
        Text_Field.setFont(new Font("Ink Free",Font.BOLD,75));
        Text_Field.setHorizontalAlignment(JLabel.CENTER);
        Text_Field.setText( "Connect 4 Game");
        Text_Field.setOpaque(true);

        this.add(Text_Field);
    }
    public void Game_Name()
    {
        try {
            Thread.sleep(1500);
            Text_Field.setText(Player_Name[0]+"'s turn");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Text_Field.setBackground(new Color(255,255,255));
        Text_Field.setFont(new Font("Boulder",Font.BOLD,75));
        Text_Field.setForeground(new Color(0,0,0));
        Text_Field.setText( "Connect 4 Game");
       // Text_Field.setText(Player_Name[0]+ " turn");
    }
    public  void Add_Player_Name(String Player_Name,int counter)
    {
        this.Player_Name[counter]=Player_Name;
    }
    public void Show_Current_Player(int counter)
    {

        Text_Field.setText(Player_Name[counter]+ "'s turn");
        if(counter == 0)
        {
            Text_Field.setBackground(new Color(0, 0, 0));
            Text_Field.setForeground(new Color(255, 255, 255));
        }
        if(counter == 1)
        {
            Text_Field.setBackground(new Color(0, 0, 0f));
            Text_Field.setForeground(new Color(255, 255, 255));
        }
    }
}
