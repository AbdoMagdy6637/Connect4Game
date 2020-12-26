import java.awt.*;

public class Main {
    public static void main(String[] args) {
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


    }
}
