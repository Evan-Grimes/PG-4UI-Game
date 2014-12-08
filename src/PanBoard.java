import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class PanBoard extends JPanel implements ActionListener {

    static boolean drawn = false;
    private Player p;
    private Bullet b;
    private Enemy e;
    private Timer timer;
    private Image background;
    static int nAtk, nLvl, nHp, nCurrxp, nXpgoal, nHit, nHit1;
    static String sName;
    Label JLabel;
    int nChange = 1;

    static void setStats(int _Lvl, int _Atk, int _Hp, String _sName,
            int _currxp, int _xpgoal) {
        nAtk = _Atk;
        nLvl = _Lvl;
        nHp = _Hp;
        sName = _sName;
        nCurrxp = _currxp;
        nXpgoal = _xpgoal;
    }

    static void setHit(int _nHit, int _nHit1) {
        nHit = _nHit;
        nHit1 = _nHit;
    }

    public PanBoard() {
        super();
        p = new Player();
        b = new Bullet();
        e = new Enemy();
        addKeyListener(new Movement());
        setFocusable(true);
        ImageIcon i1 = new ImageIcon("Background.png");
        background = i1.getImage();
        timer = new Timer(80, this);
        timer.start();
        Label();
        /*JLabel tHp = new JLabel("Health: " + Hp);
         JLabel tAtk = new JLabel("Attack: " + Atk);
         JLabel tLvl = new JLabel("Level: " + Lvl);
         JLabel tName = new JLabel(sName + ":");
         JLabel tcurrxp = new JLabel("Experience:  " + currxp);
         JLabel txpgoal = new JLabel("/ " + xpgoal);
         if (Lvl == 5) {
         tcurrxp = new JLabel("Score: " + currxp);
         txpgoal = new JLabel(" ");
         }
         add(tName);
         /dd(tLvl);
         add(tHp);
         add(tAtk);
         add(tcurrxp);
         add(txpgoal);*/
    }

    private void Label() {

        if (nHit == nHit1) {
            System.out.println(nHit + " " + nHit1);
            setLayout(new FlowLayout());
            add(JLabel = new Label(sName + "  -  Level: "
                    + nLvl + "  Health: " + nHp + "  Attack: " + nAtk + "  Experience: "
                    + nHit + " / " + nXpgoal), BorderLayout.NORTH);
            //nHit1 -= nChange;
            //nChange = 0;
        } else if (nHit > nHit1) {
            System.out.println("CHANGE");
            RemoveLabel();
        } else {
            //add(JLabel);
        }
    }

    private void RemoveLabel() {
        System.out.println("IS GOOD");
        remove(JLabel);
        nHit1++;
        //nChange = 1;
    }

    public void actionPerformed(ActionEvent arg0) {
        Label();
        p.move();
        b.move();
        e.move();
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, 0, 0, null);
        g2d.drawImage(b.getImage(), b.getBX(), b.getBY(), null);
        g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);
        g2d.drawImage(e.getImage(), e.getEX(), e.getEY(), null);
    }

    private class Movement extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent w) {
            b.keyReleased2(w);
            p.keyReleased(w);
        }

        @Override
        public void keyPressed(KeyEvent w) {
            b.keyPressed2(w);
            p.keyPressed(w);
        }
    }
}
