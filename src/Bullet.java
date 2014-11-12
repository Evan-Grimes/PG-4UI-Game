import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.Image;

public class Bullet {

    private Image img;
    int i;
    int bx, by, dx, dy, x, y, stahp, nCount;
    boolean shoot;
    private final int BSPEED = 20;
    ImageIcon b1 = new ImageIcon("Untitled.png");
    ImageIcon b2 = new ImageIcon("Nothing.png");
    ImageIcon i1 = new ImageIcon("Lucario1.png");
    Image arnShooting[] = new Image[2];

    public Bullet() {
        nCount = 0;
        x = 350;
        y = 238;
        by = 200;
        bx = 0;
        stahp = 350;
        dx = 0;
        dy = 0;
        shoot = false;
        arnShooting[0] = b1.getImage();
        arnShooting[1] = b2.getImage();
    }

    public void move() {
        bx += dx;
        by += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getBX() {
        return bx;
    }

    public int getBY() {
        return by;
    }

    public Image getImage() {
        img = arnShooting[i];
        if (nCount == 0) {
            bx = x; //Lucario x
            by = y; //Lucario y
            i = 1;
            //System.out.println("No PewPew");
        }
        if (shoot == true) {
            i = 0;
            System.out.println("PewPew");
        }
        return img;
    }

    public void keyPressed2(KeyEvent k) {
        int code = k.getKeyCode();
        if (code == KeyEvent.VK_Q) {
            shoot = true;
            dx = BSPEED;
            nCount+= 1;
        if (nCount == 1) {
            stahp += bx;
        }
        if (bx > stahp) {
            dx = 0;
            nCount = 0;
        }
        }
    }

    public void keyReleased2(KeyEvent k) {
        int code = k.getKeyCode();
        if (code == KeyEvent.VK_Q) {
            shoot = false;

        }
    }
}
