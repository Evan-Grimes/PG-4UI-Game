import javax.swing.JFrame;
import java.io.*;
public class Frame extends JFrame {

    public Frame() throws FileNotFoundException{
        add(new Board());
        setTitle("Movement");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 400); //1370, 730 for fullscreen
        this.setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
