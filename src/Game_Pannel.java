import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.*;

public class Game_Pannel extends JPanel{




    Image img;
    final int Unit=100;  // Unit length
    char[][] DrowCircle;  // represent our grid red >>'r'  , yellow >> 'y' , empty >> ' '
    int i;  // usage For loops
    int j;  // usage For loops
    public static int checkWinner= 0;
    public static int cellsCounter=0;
    public Game_Pannel() {
        DrowCircle = new char[6][7];
        for( i=0;i<6;i++)
        {
            for( j=0;j<7;j++)
            {
                DrowCircle[i][j]='5';
                //ccccc++;
            System.out.print(DrowCircle[i][j]);
            }
            System.out.println(" ");
        }

        img =new ImageIcon("C:\\Users\\Abdo Magdy\\Downloads\\b4g2.png").getImage();
        this.setPreferredSize(new Dimension(700,600));

    }


    // to reset after play again confirm
    public void make_zero(){
        for( i=0;i<6;i++)
        {
            for( j=0;j<7;j++)
            {

                DrowCircle[i][j] = ' ';
            }
            System.out.println(" ");
        }
    }
    // DrawRed takes the input of where red circle should be and put it in DrawCircle

    public void DrawRed(int x,int y)
    {
        // cant add circles
        try                                 //if u erase this try catch with which in DrawYellow it will not run because this ArrayIndexOutOfBoundsException
        {  DrowCircle[y][x]= 'r';
            checkWinner=win(DrowCircle);
            System.out.println(checkWinner);
            cellsCounter++;

            }
        catch (Exception ee)
        {
            JOptionPane.showMessageDialog(this,"the Column is already full");
            DrowCircle[y][x]= 'r';  //trying to solv bug of colors turn
            System.err.println("cant add circles");

        }



            // these 2 for loop for Update  data 'r' 'y' ' '
        System.out.println("-----------------------");
        for( i=0;i<6;i++)
        {
            for( j=0;j<7;j++)
            {

                System.out.print(DrowCircle[i][j]);
            }
            System.out.println(" ");
        }


    }

    // DrawYello takes the input of where yellow circle should be and put it in DrawCircle

    public void DrawYello(int x,int y)
    {

        try
        {  DrowCircle[y][x]= 'y';
            checkWinner=win(DrowCircle);
            System.out.println(checkWinner);
            cellsCounter++;

        }
        catch (Exception ee)
        {
            JOptionPane.showMessageDialog(this,"the Column is already full");
            DrowCircle[y][x]= 'y';      //trying to solv bug of colors turn
            System.err.println("Cant Add More");    //cant add circles
        }


        // these 2 for loop for checking what happend in display data 'r' 'y' ' '
        System.out.println("-----------------------");
        for( i=0;i<6;i++)
        {
            for( j=0;j<7;j++)
            {

                System.out.print(DrowCircle[i][j]);
            }
            System.out.println(" ");
        }

    }

    public static int win(char[][] arr)
    {
        int p1=0;
        int p2=0;
        boolean pl1=false;
        boolean pl2=false;
        //horoizontal
        for(int i=0 ; i<6 ; i++)
        {
            if(pl1==true || pl2==true)
                break;
            p1=0;
            p2=0;
            for(int j=0 ; j<7 ; j++)
            {
                if(arr[i][j]=='r')
                {
                    p2=0;
                    p1++;
                }
                else if(arr[i][j]=='y')
                {
                    p1=0;
                    p2++;
                }
                else
                {
                    p1=0;
                    p2=0;
                }
                if(p1==4) {
                    pl1 = true;
                    break;
                }
                else if (p2==4) {
                    pl2 = true;
                    break;
                }
            }
        }
        //vertical
        for(int i=0 ; i<7 ; i++)
        {
            if(pl1==true || pl2==true)
                break;
            p1=0;
            p2=0;
            for(int j=0 ; j<6 ; j++)
            {
                if(arr[j][i]=='r')
                {
                    p2=0;
                    p1++;
                }
                else if(arr[j][i]=='y')
                {
                    p1=0;
                    p2++;
                }
                else
                {
                    p1=0;
                    p2=0;
                }
                if(p1==4) {
                    pl1 = true;
                    break;
                }
                else if (p2==4) {
                    pl2 = true;
                    break;
                }
            }
        }
        //diagonal
        for(int i=3 ; i<6 ; i++)
        {
            if(pl1==true || pl2==true)
                break;
            for(int j=0 ; j<4 ; j++)
            {
                if(pl1==true || pl2==true)
                    break;
                if(arr[i][j]=='r' && arr[i-1][j+1]=='r' && arr[i-2][j+2]=='r' && arr[i-3][j+3]=='r')
                    pl1=true;
                else if(arr[i][j]=='y' && arr[i-1][j+1]=='y' && arr[i-2][j+2]=='y' && arr[i-3][j+3]=='y')
                    pl2=true;
            }
        }
        for(int i=3 ; i<6 ; i++)
        {
            if(pl1==true || pl2==true)
                break;
            for(int j=6 ; j>=3 ; j--)
            {
                if(pl1==true || pl2==true)
                    break;
                if(arr[i][j]=='r' && arr[i-1][j-1]=='r' && arr[i-2][j-2]=='r' && arr[i-3][j-3]=='r')
                    pl1=true;
                else if(arr[i][j]=='y' && arr[i-1][j-1]=='y' && arr[i-2][j-2]=='y' && arr[i-3][j-3]=='y')
                    pl2=true;
            }
        }
        if(pl1)
            return 1;
        else if(pl2)
            return -1;
        else
            return 2;
    }


    public void paint(Graphics g)
    {

        Graphics2D Back_Ground_Image =(Graphics2D)g;
        Graphics2D Circles= (Graphics2D)g;
        Back_Ground_Image.drawImage(img,0,0,null); // the image of the circles holder

        for(int i=0;i<6;i++)
        {
            for(int j =0; j<7;j++)
            {
                if(DrowCircle[i][j]=='r')                                  // the drawing part
                {
                    Circles.setColor(Color.RED);
                    Circles.fillOval((j*Unit), (i*Unit), Unit, Unit);  // draw the circle

                }
                else if (DrowCircle[i][j]=='y')
                {
                    {
                        Circles.setColor(Color.YELLOW);
                        Circles.fillOval((j*Unit), (i*Unit), Unit, Unit);

                    }
                }


            }
        }


    }
	/* paint method is responsible for rendering the background image and and circles depending on
	'r' or 'y' index in the DrawCircle 2D array */
}