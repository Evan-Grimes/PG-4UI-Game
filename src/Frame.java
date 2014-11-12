import javax.swing.JFrame;

public class Frame extends JFrame {

    public Frame() {
        add(new Board());
        setTitle("Movement");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); //1370, 730 for fullscreen
        this.setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
