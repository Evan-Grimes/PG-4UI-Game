import javax.swing.JFrame;
public class Frame extends JFrame {

    public Frame() {
        add(new PanBoard());
        setTitle("Movement");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 400); //1370, 730 for fullscreen for laptop
        this.setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
