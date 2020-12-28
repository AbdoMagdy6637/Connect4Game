import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;


public class GameFrame extends JFrame implements MouseListener {

    Game_Pannel Pannel;
    public static Game_Player_Panel Player_Panel;
    final int Unit = 100;
    int Column_Num;
    int[] counter;
    boolean Player1_Turn;
    boolean Check_In_Range = false;
    //2 boolean static  with false value  represent player1Input ,player2Input  we will change it when click on playerVsPlayer OR playerVsComputer
    static boolean player1Input = false, player2Input = false;
    public static int once = 0;         // to deal with bug of showing inputs before u choose playerVsPlayer OR playerVsComputer
    public static boolean secondFrame = false;
    int titleCounter = 2;

    public GameFrame() {

        Pannel = new Game_Pannel();
        Player_Panel = new Game_Player_Panel();

        //Player_Panel.Add_Player_Name();
        counter = new int[7];
        Column_Num = 0;
        Player1_Turn = true;

        for (int i = 0; i < 7; i++) {
            counter[i] = 6;
        }

        Pannel.addMouseListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(Pannel);
        this.add(Player_Panel, BorderLayout.NORTH);
        this.pack();                            // ????????????????????
        this.setLocationRelativeTo(null);

       // if u make the function work then put set visible in it
//       if (menu.getMakeSecondFrameVisible()==true)
//            {
//            }
       //         this.setVisible(true);





        this.setTitle("Red Plays first");
        Player_Panel.Game_Name();                   //?????????????
    }


        /*abdo*/
        public static void click(int x, int y) throws AWTException{//to make virtual click automatic given x-position and y-positio
        Robot bot = new Robot();
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
        boolean[] col = {true,true,true,true,true,true,true} ;//to check if the 7 columns complete or not 
        /*abdo*/



    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub


        if (titleCounter % 2 != 0) {
            this.setTitle("Red is playing");
        } else
            this.setTitle("Yellow is playing");

        // titleCounter++;
        for (int i = 0; i < 7; i++) {
            //if(e.getX() >=0 && e.getX() < )
            if (e.getX() < (Unit * i) + Unit && e.getX() >= (Unit * i)) {
                Column_Num = i;
                counter[Column_Num]--;
                Check_In_Range = true;
            }
        }

        if (menu.getAI() ){
    }
        char[][] d = Pannel.DrowCircle;//facilate the appression
<<<<<<< HEAD
        
=======
>>>>>>> 93c47b593936f81b06f8464011b483032c7031ed
        if(Player1_Turn) {
            Pannel.DrawRed(Column_Num, counter[Column_Num]);
            Player_Panel.Show_Current_Player(1);
            Player1_Turn = false;
            titleCounter++;

            if (menu.getAI() ){
            /*abdo*/
<<<<<<< HEAD
                boolean cond=false;//
                for(int i=0;i<7;i++)
                {
                    if(Pannel.DrowCircle[0][i]!='5')
                    col[i]=false;
                }
                //column
                for(int i=0 ; i<7;i++){
                         if( ( d[5][i]=='r' && d[4][i]=='r' &&d[3][i]=='r' && d[2][i]=='5')||(d[4][i]=='r' && d[3][i]=='r' &&d[2][i]=='r' && d[1][i]=='5')||
                              (d[3][i]=='r' && d[2][i]=='r' &&d[1][i]=='r' && d[0][i]=='5')||(d[5][i]=='y' && d[4][i]=='y' &&d[3][i]=='y' && d[2][i]=='5')||
                              (d[4][i]=='y' && d[3][i]=='y' &&d[2][i]=='y' && d[1][i]=='5')||(d[3][i]=='y' && d[2][i]=='y' &&d[1][i]=='y' && d[0][i]=='5') ){
                                try {click(500+(i*100), 200);} catch (AWTException ex) { }//click((Unit*i)+Unit , (int) w.getHeight()/2)
                                cond=true;
                                System.out.println("not randomC");
                                break;
                      }
                  }
                //row
                  for(int i=0 ; i<=5;i++){
                      if( (d[i][0]=='r' && d[i][1]=='r' &&d[i][2]=='r' && d[i][3]=='5')||(d[i][1]=='r' && d[i][2]=='r' &&d[i][3]=='r' && d[i][4]=='5')||
                          (d[i][2]=='r' && d[i][3]=='r' &&d[i][4]=='r' && d[i][5]=='5')||(d[i][3]=='r' && d[i][4]=='r' &&d[i][5]=='r' && d[i][6]=='5')||
                          (d[i][4]=='r' && d[i][5]=='r' &&d[i][6]=='r' && d[i][3]=='5')||(d[i][0]=='r' && d[i][1]=='y' &&d[i][2]=='y' && d[i][3]=='5')||
                          (d[i][1]=='y' && d[i][2]=='y' &&d[i][3]=='y' && d[i][4]=='5')||(d[i][2]=='y' && d[i][3]=='y' &&d[i][4]=='y' && d[i][5]=='5')||
                          (d[i][3]=='y' && d[i][4]=='y' &&d[i][5]=='y' && d[i][6]=='5')||(d[i][4]=='y' && d[i][5]=='y' &&d[i][6]=='y' && d[i][3]=='5')){
                          for(int j=6 ; j>=0;j--){
                              if( d[i][j]=='5'){
                                   try {
                                    if(col[j]==true){click(500+(j*100), 200);}} catch (AWTException ex) { }//click((Unit*i)+Unit , (int) w.getHeight()/2)
                                  break;
                              }
                          }             
                            cond=true;
                            System.out.println("not randomR");
                      }           
                    }


                if(cond==false){
                    for(int k=0 ; k<7;k++){
                        int colNum=(int)(Math.random() * (6 - 0+ 1) + 0);//the colNum is random value generated from 0 to 6 to play in random columns
                        if(col[colNum]==true){
                            try {click(500+(colNum*100) , 200);} catch (AWTException ex) { }
                             System.out.println("random");
                            break;
                        }
                    }
                }
          


        }
/*abdo*/
=======
        boolean cond=false;//
        //column
        for(int i=0 ; i<7;i++){
                 if( ( d[5][i]=='r' && d[4][i]=='r' &&d[3][i]=='r' && d[2][i]=='5')||(d[4][i]=='r' && d[3][i]=='r' &&d[2][i]=='r' && d[1][i]=='5')||
                      (d[3][i]=='r' && d[2][i]=='r' &&d[1][i]=='r' && d[0][i]=='5')||(d[5][i]=='y' && d[4][i]=='y' &&d[3][i]=='y' && d[2][i]=='5')||
                      (d[4][i]=='y' && d[3][i]=='y' &&d[2][i]=='y' && d[1][i]=='5')||(d[3][i]=='y' && d[2][i]=='y' &&d[1][i]=='y' && d[0][i]=='5') ){
                        try {click(500+(i*100), 200);} catch (AWTException ex) { }//click((Unit*i)+Unit , (int) w.getHeight()/2)
                        cond=true;
                        System.out.println("not randomC");
                        break;
              }
          }
        //row
          for(int i=0 ; i<=5;i++){
              if( (d[i][0]=='r' && d[i][1]=='r' &&d[i][2]=='r' && d[i][3]=='5')||(d[i][1]=='r' && d[i][2]=='r' &&d[i][3]=='r' && d[i][4]=='5')||
                  (d[i][2]=='r' && d[i][3]=='r' &&d[i][4]=='r' && d[i][5]=='5')||(d[i][3]=='r' && d[i][4]=='r' &&d[i][5]=='r' && d[i][6]=='5')||
                  (d[i][4]=='r' && d[i][5]=='r' &&d[i][6]=='r' && d[i][3]=='5')||(d[i][0]=='r' && d[i][1]=='y' &&d[i][2]=='y' && d[i][3]=='5')||
                  (d[i][1]=='y' && d[i][2]=='y' &&d[i][3]=='y' && d[i][4]=='5')||(d[i][2]=='y' && d[i][3]=='y' &&d[i][4]=='y' && d[i][5]=='5')||
                  (d[i][3]=='y' && d[i][4]=='y' &&d[i][5]=='y' && d[i][6]=='5')||(d[i][4]=='y' && d[i][5]=='y' &&d[i][6]=='y' && d[i][3]=='5')){
                  for(int j=6 ; j>=0;j--){
                      if( d[i][j]=='5'){
                          try {click(500+(j*100), 200);} catch (AWTException ex) { System.out.println("error");}
                          break;
                      }
                  }             
                    cond=true;
                    System.out.println("not randomR");
              }           
            }
      for(int i=0;i<7;i++)
      {
          if(Pannel.DrowCircle[0][i]!='5')
          col[i]=false;
      }
        int random_int = 0;
        if(cond==false){

            if(col[0]==false){
                random_int = (int)(Math.random() * (1100 - 600 + 1) + 600);
            }
            if(col[1]==false){
                random_int = (int)(Math.random() * (1100 - 700 + 1) + 700);
            }
            if(col[2]==false){
                random_int = (int)(Math.random() * (1100 - 800 + 1) + 800);
            }
            if(col[3]==false){
                random_int = (int)(Math.random() * (1100 - 900 + 1) + 900);
            }
            if(col[4]==false){
                random_int = (int)(Math.random() * (800 - 500 + 1) + 500);
            }
            if(col[5]==false){
                random_int = (int)(Math.random() * (900 - 500 + 1) + 500);
            }
            if(col[6]==false){
                random_int = (int)(Math.random() * (900 - 500 + 1) + 500);
            }
          try {click(random_int, 200);} catch (AWTException ex) { }
          System.out.println("random");
      }
            }
>>>>>>> 93c47b593936f81b06f8464011b483032c7031ed

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
            {   //ZZZ
                int responce = JOptionPane.showConfirmDialog(null, "RED WIN!! \n WANT TO PLAY AGAIN", "CONFIRME", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(responce == JOptionPane.YES_OPTION)
                {
                    Player1_Turn = true;
                    Pannel.make_zero();
                    for(int i=0; i<7;i++)
                    {
                        counter[i]=6;
                    }
                    Pannel.repaint();
                }

                if(responce == JOptionPane.NO_OPTION)
                {
                    System.exit(0);
                }
                if(responce == JOptionPane.CLOSED_OPTION)
                {
                    System.exit(0);
                }
                this.setTitle("RED is A Winner");
                //  System.exit(0);
            }
        }

        if (Game_Pannel.checkWinner==-1)   // 1 for red   -1 for yellow and 2 for no one
        {
            if (Game_Pannel.checkWinner==-1)
            {   //ZZZ
                int responce = JOptionPane.showConfirmDialog(null, "YELLOW WIN!! \n WANT TO PLAY AGAIN", "CONFIRME", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(responce == JOptionPane.YES_OPTION)
                {
                    Pannel.make_zero();
                    for(int i=0; i<7;i++)
                    {
                        counter[i]=6;
                    }
                    Pannel.repaint();
                }

                if(responce == JOptionPane.NO_OPTION)
                {
                    System.exit(0);
                }
                if(responce == JOptionPane.CLOSED_OPTION)
                {
                    System.exit(0);
                }


                this.setTitle("YELLOW is A Winner");
                //System.exit(0);
            }
        }

        if (Game_Pannel.cellsCounter==42)
        {
            int responce = JOptionPane.showConfirmDialog(null, "NO One WON!! \n WANT TO PLAY AGAIN", "CONFIRME", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(responce == JOptionPane.YES_OPTION)
            {
                Pannel.make_zero();
                for(int i=0; i<7;i++)
                {
                    counter[i]=6;
                }
                Pannel.repaint();
            }

            if(responce == JOptionPane.NO_OPTION)
            {
                System.exit(0);
            }
            if(responce == JOptionPane.CLOSED_OPTION)
            {
                System.exit(0);
            }

        }

    }


    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        this.player1Input=true;
        this.player2Input=true;

        once++;
        if (once==1)                // for input names
        {
        if (player1Input==true)
        { Player_Panel.Add_Player_Name(JOptionPane.showInputDialog("enter player 1 name"),0); }
        if (player2Input==true && menu.getAI()==false)    // dont showing input message  if playing with comp.
        {  Player_Panel.Add_Player_Name(JOptionPane.showInputDialog("enter player 2 name"),1);}

        }

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


