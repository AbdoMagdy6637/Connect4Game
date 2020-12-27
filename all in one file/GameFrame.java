import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class GameFrame extends JFrame implements MouseListener
	{
	
	Game_Pannel Pannel;
	
	final int  Unit_Lenght =100;
	int Column_Num ;
	int[] counter;
	boolean Player1_Turn;
	
	public GameFrame() {
		
		Pannel = new Game_Pannel();
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
	    this.pack();
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		

		for(int i=1;i<=7;i++)
		{
			if(e.getX()<Unit_Lenght*i-50 && e.getX()>(Unit_Lenght*i)-Unit_Lenght-50)
				{
				Column_Num=i-2;
					counter[Column_Num]--;
				}
		}
		if(Player1_Turn)
		{
		Pannel.DrawRed(Column_Num, counter[Column_Num]); 
		Player1_Turn=false;
		}
		else if(!Player1_Turn)
		{
		Pannel.DrawYello(Column_Num, counter[Column_Num]); 
		Player1_Turn=true;
		}
		Pannel.repaint();
		
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


		public static void main(String[] args) {
			GameFrame ourGame=new GameFrame();
		}
}
