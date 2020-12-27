import java.awt.Color;
import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Game_Pannel extends JPanel{
	Image img;
	final int Unit=100;  // Unit length
	char[][] DrowCircle;  // represent our grid red >>'r'  , yellow >> 'y' , empty >> ' '
	public Game_Pannel() {
		DrowCircle = new char[7][6];
		for(int i=0;i<7;i++)
		{
			for(int j=0;j<6;j++)
			{
				DrowCircle[i][j]=' ';
			}
		}
		img =new ImageIcon("C:\\Users\\Abdo Magdy\\Downloads\\b4g.png").getImage();
		this.setPreferredSize(new Dimension(800,700));
	}
	
	public void DrawRed(int x,int y)
	{
		DrowCircle[x][y]= 'r';
	}
	// DrawRed takes the input of where red circle should be and put it in DrawCircle
	public void DrawYello(int x,int y)
	{
		DrowCircle[x][y]= 'y';
	}
	// DrawYello takes the input of where yellow circle should be and put it in DrawCircle

	public void paint(Graphics g)
	{
		Graphics2D Back_Ground_Image =(Graphics2D)g;
		Graphics2D Circles= (Graphics2D)g;
		Back_Ground_Image.drawImage(img,50,50,null); // the image of the circles holder
		
		for(int i=0;i<7;i++)
		{ 
			for(int j =0; j<6;j++)
			{
				if(DrowCircle[i][j]=='r')                                  // the drawing part
				{
					Circles.setColor(Color.RED);
					Circles.fillOval((i*Unit)+60, (j*98)+60, Unit, Unit);  // draw the circle
					
				}
				else if (DrowCircle[i][j]=='y') 
				{
					{
						Circles.setColor(Color.YELLOW);
						Circles.fillOval((i*Unit)+60, (j*98)+60, Unit, Unit);
						
					}
				}
				
			}
		}
	}
	/* paint method is responsible for rendering the background image and and circles depending on
	'r' or 'y' index in the DrawCircle 2D array */
}
