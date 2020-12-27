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
        public static void click(int x, int y) throws AWTException{
        Robot bot = new Robot();
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
        boolean[] col = {false,false,false,false,false,false,false} ;
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
        /*abdo*/
        int[] arr = new int[20] ;
        for(int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        /*abdo*/
    }
        if(Player1_Turn) {
            Pannel.DrawRed(Column_Num, counter[Column_Num]);
            Player_Panel.Show_Current_Player(1);
            Player1_Turn = false;
            titleCounter++;

            if (menu.getAI() ){
            /*abdo*/

            boolean cond=false;
            //col
            for(int i=0 ; i<7;i++){
                if( (Pannel.DrowCircle[5][i]=='r' && Pannel.DrowCircle[4][i]=='r' &&Pannel.DrowCircle[3][i]=='r' && Pannel.DrowCircle[2][i]=='5')
                        ||(Pannel.DrowCircle[4][i]=='r' && Pannel.DrowCircle[3][i]=='r' &&Pannel.DrowCircle[2][i]=='r' && Pannel.DrowCircle[1][i]=='5')
                        ||(Pannel.DrowCircle[3][i]=='r' && Pannel.DrowCircle[2][i]=='r' &&Pannel.DrowCircle[1][i]=='r' && Pannel.DrowCircle[0][i]=='5') ){
                    try {click(500+(i*100), 200);} catch (AWTException ex) {System.out.println("error2"); }
                    cond=true;
                    System.out.println("not randomC");
                    break;
                }else if( (Pannel.DrowCircle[5][i]=='y' && Pannel.DrowCircle[4][i]=='y' &&Pannel.DrowCircle[3][i]=='y' && Pannel.DrowCircle[2][i]=='5')
                        ||(Pannel.DrowCircle[4][i]=='y' && Pannel.DrowCircle[3][i]=='y' &&Pannel.DrowCircle[2][i]=='y' && Pannel.DrowCircle[1][i]=='5')
                        ||(Pannel.DrowCircle[3][i]=='y' && Pannel.DrowCircle[2][i]=='y' &&Pannel.DrowCircle[1][i]=='y' && Pannel.DrowCircle[0][i]=='5') ){
                    try {click(500+(i*100), 200);} catch (AWTException ex) { System.out.println("error2");}
                    cond=true;
                    System.out.println("not randomC computer");
                    break;
                }
            }
            //row
            for(int i=0 ; i<=5;i++){
                if( (Pannel.DrowCircle[i][0]=='r' && Pannel.DrowCircle[i][1]=='r' &&Pannel.DrowCircle[i][2]=='r' && Pannel.DrowCircle[i][3]=='5')
                        ||(Pannel.DrowCircle[i][1]=='r' && Pannel.DrowCircle[i][2]=='r' &&Pannel.DrowCircle[i][3]=='r' && Pannel.DrowCircle[i][4]=='5')
                        ||(Pannel.DrowCircle[i][2]=='r' && Pannel.DrowCircle[i][3]=='r' &&Pannel.DrowCircle[i][4]=='r' && Pannel.DrowCircle[i][5]=='5')
                        ||(Pannel.DrowCircle[i][3]=='r' && Pannel.DrowCircle[i][4]=='r' &&Pannel.DrowCircle[i][5]=='r' && Pannel.DrowCircle[i][6]=='5')
                        ||(Pannel.DrowCircle[i][4]=='r' && Pannel.DrowCircle[i][5]=='r' &&Pannel.DrowCircle[i][6]=='r' && Pannel.DrowCircle[i][3]=='5')){
                    for(int j=6 ; j>=0;j--){
                        if( Pannel.DrowCircle[i][j]=='5'){
                            try {click(500+(j*100), 200);} catch (AWTException ex) { System.out.println("error");}
                            break;
                        }
                    }
                    cond=true;
                    System.out.println("not randomR");
                }else if( (Pannel.DrowCircle[i][0]=='r' && Pannel.DrowCircle[i][1]=='y' &&Pannel.DrowCircle[i][2]=='y' && Pannel.DrowCircle[i][3]=='5')
                        ||(Pannel.DrowCircle[i][1]=='y' && Pannel.DrowCircle[i][2]=='y' &&Pannel.DrowCircle[i][3]=='y' && Pannel.DrowCircle[i][4]=='5')
                        ||(Pannel.DrowCircle[i][2]=='y' && Pannel.DrowCircle[i][3]=='y' &&Pannel.DrowCircle[i][4]=='y' && Pannel.DrowCircle[i][5]=='5')
                        ||(Pannel.DrowCircle[i][3]=='y' && Pannel.DrowCircle[i][4]=='y' &&Pannel.DrowCircle[i][5]=='y' && Pannel.DrowCircle[i][6]=='5')
                        ||(Pannel.DrowCircle[i][4]=='y' && Pannel.DrowCircle[i][5]=='y' &&Pannel.DrowCircle[i][6]=='y' && Pannel.DrowCircle[i][3]=='5')){
                    for(int j=6 ; j>=0;j--){
                        if( Pannel.DrowCircle[i][j]=='5'){
                            try {click(500+(j*100), 200);} catch (AWTException ex) { System.out.println("error");}
                            break;
                        }
                    }
                    cond=true;
                    System.out.println("not randomR computer");
                }
            }

            for( int i=0;i<6;i++)
            {
                for( int j=0;j<7;j++)
                {

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


            /*abdo*/
        }


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


