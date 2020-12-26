import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameFrame extends JFrame implements MouseListener
{

    Game_Pannel Pannel;
    public static Game_Player_Panel Player_Panel;
    final int  Unit =100;
    int Column_Num ;
    int[] counter;
    boolean Player1_Turn;
    boolean Check_In_Range =false;

    int titleCounter=2;
    public GameFrame() {

        Pannel = new Game_Pannel();
        Player_Panel = new Game_Player_Panel();

     //   Pannel.availableToAdd();
        Player_Panel.Add_Player_Name(JOptionPane.showInputDialog("enter player 1 name"),0);
        Player_Panel.Add_Player_Name(JOptionPane.showInputDialog("enter player 2 name"),1);
        //Player_Panel.Add_Player_Name();
        counter=new int[7];
        Column_Num=0;
        Player1_Turn=true;

        for(int i=0; i<7;i++)
        {
            counter[i]=6;
        }

        Pannel.addMouseListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(Pannel);
        this.add(Player_Panel,BorderLayout.NORTH);
        this.pack();                            // ????????????????????
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("Red Plays first");
        Player_Panel.Game_Name();                   //?????????????
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub


        if (titleCounter %2!=0 )
        {
            this.setTitle("Red is playing");
        }
        else
            this.setTitle("Yellow is playing");

       // titleCounter++;
        for(int i=0;i<7;i++)
        {
            //if(e.getX() >=0 && e.getX() < )
            if(e.getX() <(Unit*i)+Unit && e.getX() >=(Unit*i))
            {
                Column_Num=i;
                counter[Column_Num]--;
                Check_In_Range =true;
            }
        }

        if(Player1_Turn)
        {
            Pannel.DrawRed(Column_Num, counter[Column_Num]);
            Player_Panel.Show_Current_Player(1);
            Player1_Turn=false;
            titleCounter++;


        }
        else if(!Player1_Turn)
        {
            Pannel.DrawYello(Column_Num, counter[Column_Num]);
            Player_Panel.Show_Current_Player(0);
            Player1_Turn=true;
            titleCounter++;
        }
        else
        {
            System.out.println("Error yasta");
        }
        Pannel.repaint();


        if (Game_Pannel.checkWinner==1)   // 1 for red   -1 for yellow and 2 for no one
        {
            if (Game_Pannel.checkWinner==1)
            {
                JOptionPane.showMessageDialog(null,"RED is A Winner ");
                this.setTitle("RED is A Winner");
          //  System.exit(0);
            }
        }

        if (Game_Pannel.checkWinner==-1)   // 1 for red   -1 for yellow and 2 for no one
        {
            if (Game_Pannel.checkWinner==-1)
            {
                JOptionPane.showMessageDialog(null,"YELLOW is A Winner ");
                this.setTitle("YELLOW is A Winner");
         //       System.exit(0);
            }
        }

        if (Game_Pannel.cellsCounter==42)
        {
            JOptionPane.showMessageDialog(null,"NO One Win ");
            System.exit(0);
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}


