import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
//import java.util.Date;

public class Board extends JPanel implements ActionListener {

    static boolean drawn = false;

    private Player p;
    private Bullet b;
    private Timer timer;
    private Image background;

    public Board() {
        super();
        p = new Player();
        b = new Bullet();
        addKeyListener(new ActionListener());
        setFocusable(true);
        ImageIcon i1 = new ImageIcon("Background.png");
        background = i1.getImage();
        timer = new Timer(80, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent arg0) {
        p.move();
        b.move();
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, 0, 0, null);
        g2d.drawImage(b.getImage(), b.getBX(), b.getBY(), null);
        g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);
    }

    private class ActionListener extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent k) {
            b.keyReleased2(k);
            p.keyReleased(k);
        }

        @Override
        public void keyPressed(KeyEvent k) {
           b.keyPressed2(k);
           p.keyPressed(k);
        }
    }
}
