
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.*;

public class menu extends JFrame implements ActionListener {
    Game_Player_Panel Player_Panel;            // for input problem
    Timer tt=new Timer(50,this); //moving names
    boolean showing_names=false;
    //moving names variables
    int b1=0,b2=0 ,bb1=5,bb2=5;
    int c1=0,c2=0 ;
    int d1=750,d2=0 ,dd1=5,dd2=5;
    int e1=750,e2=0 ;
    int f1=0,f2=550 ,ff1=5,ff2=5;  // change 550 when u fix the size of background to more than 550
    int g1=800,g2=550 ,gg1=5,gg2=5; // change 550 when u fix the size of background to more than 550
    int showingCounter=0;           // to show names on click developers
    public static boolean makeSecondFrameVisible=false;
    public static boolean AI=false;
    JLabel name1,name2,name3,name4,name5, name6;


    GameFrame pannel ;



    JButton playerVsPlayer;
    JPanel mainMenu_panel;
    JLabel Connect_4;
    JButton playerVsComputer;
    JButton developers;
    JButton Exit;
    JLabel background;
    private JPanel contentPane;
    private boolean opening=true;

    public menu() {
         Player_Panel=new Game_Player_Panel();          // for input problem

        pannel = new GameFrame();



        tt.start();  //moving names
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocation(50,200);  in main
        this.setVisible(opening);
        this.setTitle("If U See This That Mean We Did It , Congratulations !!!");
       // this.setSize(600,00);  in main
        setBounds(100, 100, 970, 673);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

         mainMenu_panel = new JPanel();
        mainMenu_panel.setBounds(10, 10, 933, 588);
        mainMenu_panel.setBackground(new Color(25, 25, 112));
        contentPane.add(mainMenu_panel);

        mainMenu_panel.setLayout(null);



         Connect_4 = new JLabel("");
        Connect_4.setBounds(138, 96, 646, 124);
        mainMenu_panel.add(Connect_4);
        Connect_4.setIcon(new ImageIcon("C:\\Users\\Abdo Magdy\\Downloads\\connect 4.jpg"));
        Connect_4.setBackground(new Color(30, 144, 255));
        Connect_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 50));
        Connect_4.setForeground(new Color(240, 248, 255));
        Connect_4.setHorizontalAlignment(SwingConstants.CENTER);
        Connect_4.setToolTipText("");

        playerVsPlayer = new JButton("");
        playerVsPlayer.setIcon(new ImageIcon("C:\\Users\\Abdo Magdy\\Downloads\\player vs player.jpg"));
        playerVsPlayer.setBackground(new Color(0, 191, 255));
        playerVsPlayer.setFont(new Font("Tahoma", Font.BOLD, 17));
        playerVsPlayer.setBounds(265, 288, 427, 58);
        mainMenu_panel.add(playerVsPlayer);

         playerVsComputer = new JButton("");
        playerVsComputer.setIcon(new ImageIcon("C:\\Users\\Abdo Magdy\\Downloads\\player vs computer.jpg"));
        playerVsComputer.setFont(new Font("Tahoma", Font.BOLD, 17));
        playerVsComputer.setBackground(new Color(0, 191, 255));
        playerVsComputer.setBounds(265, 356, 427, 58);
        mainMenu_panel.add(playerVsComputer);

         developers = new JButton("");

        developers.setIcon(new ImageIcon("C:\\Users\\Abdo Magdy\\Downloads\\developers.jpg"));
        developers.setFont(new Font("Tahoma", Font.BOLD, 17));
        developers.setBackground(new Color(0, 191, 255));
        developers.setBounds(265, 424, 427, 58);
        mainMenu_panel.add(developers);

         Exit = new JButton("");
        Exit.setIcon(new ImageIcon("C:\\Users\\Abdo Magdy\\Downloads\\Exit.jpg"));
        Exit.setFont(new Font("Tahoma", Font.BOLD, 17));
        Exit.setBackground(new Color(0, 191, 255));
        Exit.setBounds(265, 492, 427, 58);
        mainMenu_panel.add(Exit);

         background = new JLabel("New label");
        background.setIcon(new ImageIcon("C:\\Users\\Abdo Magdy\\Downloads\\Background_1_940x750.png"));
        background.setBounds(0, 0, 933, 588);
        mainMenu_panel.add(background);
        mainMenu_panel.setLayout(null);        // to make setBounds working well


        //names names names names names names
        name1=new JLabel("Amer Homs");
        name1.setVisible(showing_names);
        name1.setForeground(Color.black);
        name1.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 20));
        name1.setBounds(b1,b2,200,25);
        background.add(name1);

        name2=new JLabel("Abdo Magdy");
        name2.setVisible(showing_names);
        name2.setForeground(Color.red);
        name2.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 20));
        name2.setBounds(c1,c2,200,25);
        background.add(name2);

        name3=new JLabel("Abdelaziz");
        name3.setVisible(showing_names);
        name3.setForeground(Color.red);
        name3.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 20));
        name3.setBounds(d1,d2,200,25);
        background.add(name3);

        name4=new JLabel("Abdallah");
        name4.setVisible(showing_names);
        name4.setForeground(Color.black);
        name4.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 20));
        name4.setBounds(d1,d2,200,25);
        background.add(name4);

        name5=new JLabel("Abdo Elshazly");
        name5.setVisible(showing_names);
        name5.setForeground(Color.white);
        name5.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 20));
        name5.setBounds(f1,f2,200,25);
        background.add(name5);

        name6=new JLabel("Abdo Adel");
        name6.setVisible(showing_names);
        name6.setForeground(Color.white);
        name6.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 20));
        name6.setBounds(g1,g2,200,25);
        background.add(name6);


        //Events  addActionListener
        playerVsPlayer.addActionListener(this);
        playerVsComputer.addActionListener(this);
        developers.addActionListener(this);
        Exit.addActionListener(this);

    }

        public static boolean getAI()
        {
            return AI;
        }

    public static boolean getMakeSecondFrameVisible()
    {
        return makeSecondFrameVisible;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==playerVsPlayer)
        {
            pannel.setVisible(true);
          //  GameFrame.setSecondFrame();
            makeSecondFrameVisible=true;
            opening=false;
        this.setVisible(opening);
        this.setTitle("Welcome");
//        GameFrame.player1Input=true;
//        GameFrame.player2Input=true;

        }

        if (e.getSource()==playerVsComputer)
        {
            pannel.setVisible(true);
            makeSecondFrameVisible=true;
            opening=false;
            AI=true;            // to make ai work
            this.setVisible(opening);
//
//            GameFrame.player1Input=true;
//            GameFrame.player2Input=true;

        }


        if (e.getSource()==Exit)
        {
            System.exit(0);
        }

        // moving names

        if (e.getSource()==developers)
        {
            showingCounter++;
            if(showingCounter %2!=0)
            {
             showing_names=true;
            }
            else
            {showing_names=false;}
                //making names visible
            name1.setVisible(showing_names);
            name2.setVisible(showing_names);
            name3.setVisible(showing_names);
            name4.setVisible(showing_names);
            name5.setVisible(showing_names);
           name6.setVisible(showing_names);

        }

        //setting names in specific places on background
        name1.setBounds(b1,b2,200,25);
        name2.setBounds(c1,c2,200,25);
        name3.setBounds(d1,d2,200,25);
        name4.setBounds(e1,e2,200,25);
        name5.setBounds(f1,f2,200,25);
        name6.setBounds(g1,g2,200,25);

        if (b1<0 || b1>background.getWidth()-65)    //Abdo Magdy Moving
        { bb1=-bb1;}
        else if (b2<0 || b2>background.getHeight()-25)      //25 size of name height
        { bb2=-bb2;}
        b1+=bb1;  //mechanism 1
        b2+=bb2;

        if (c1<0 || c1>background.getWidth()-65)        //Amer Homs Moving
        { bb1=-bb1;}
        else if (c2<0 || c2>background.getHeight()-25)      //25 size of name height
        { bb2=-bb2;}
        c1+=-bb1;   //mechanism 1
        c2+=-bb2;

        if (d1<750 || d1>background.getWidth())         //Abdallah Moving
        { dd1=-dd1;}
        else if (d2<0 || d2>background.getHeight()-25)   //25 size of name height
        { dd2=-dd2;}
        d1-=-dd1;       //mechanism 2
        d2-=-dd2;

        if (e1<750 || e1>background.getWidth())         //Abdelaziz Moving
        { dd1=-dd1;}
        else if (e2<0 || e2>background.getHeight()-25)   //25 size of name height
        { dd2=-dd2;}
        e1-=dd1;        //mechanism 2
        e2-=dd2;

        if (f1<0 || f1>background.getWidth()-140)  //140 size  of name width  //Abdo Elshazly Moving
        { ff1=-ff1;}
        else if (f2<0 || f2>background.getHeight()-25) //25 size of name height
        {ff2=-ff2;}
        f1-=ff1;
        f2-=ff2;

        if (g1<0 || g1>background.getWidth()-100)  //100 size  of name width  //Abdo Adel Moving
        { gg1=-gg1;}
        else if (g2<0 || g2>background.getHeight()-25) //25 size of name height
        {gg2=-gg2;}
        g1-=gg1;
        g2-=gg2;


    }

}

