import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.Scanner;
import java.io.*;

public class Board extends JPanel implements ActionListener {

    static boolean drawn = false;

    private Player p;
    private Bullet b;
    private Timer timer;
    private Image background;

    public Board() throws FileNotFoundException {
        super();
        p = new Player();
        b = new Bullet();
        addKeyListener(new Movement());
        setFocusable(true);
        ImageIcon i1 = new ImageIcon("Background.png");
        background = i1.getImage();
        timer = new Timer(80, this);
        timer.start();
        int atk = 1;
  int lvl = 0;
  int hp = 0;
  String slvl = new String();
  Scanner sin = new Scanner(new FileReader("level.txt"));
  while (sin.hasNext()) {
  slvl = sin.next();
  }
  if (slvl.equals("one")) {
  lvl = 1;
  atk = 5;
  hp = 25;
  } else if (slvl.equals("two")) {
  lvl = 2;
  atk = 10;
  hp = 50;
  } else if (slvl.equals("three")) {
  lvl = 3;
  atk = 15;
  hp = 75;
  } else if (slvl.equals("four")) {
  lvl = 4;
  atk = 20;
  hp = 100;
  } else if (slvl.equals("five")) {
  lvl = 5;
  atk = 25;
  hp = 125;
  }
  JLabel tHp = new JLabel("Health: " + hp);
  JLabel tAtk = new JLabel("Attack: " + atk);
  JLabel tLvl = new JLabel("Level: " + lvl);
  add(tLvl);
  add(tHp);
  add(tAtk);
  //tLvl.setComponentZOrder(tLvl, 1);
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

    private class Movement extends KeyAdapter {

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
