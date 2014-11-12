import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.Image;

public class Bullet {

    private Image img;
    int k;
    static int X, Y, I;
    int bx, by, dx, dy, stahp, nCount;
    boolean shoot;
    private final int BSPEED = 30;
    ImageIcon b1 = new ImageIcon("Nothing.png");
    ImageIcon b2 = new ImageIcon("Untitled.png");
    ImageIcon b3 = new ImageIcon("Untitled2.png");
    Image arnShooting[] = new Image[3];

    static void SetVars(int x, int y, int i) {
        X = x;
        Y = y;
        I = i;
    }

    public Bullet() {
        nCount = 0;
        by = 200;
        bx = 0;
        stahp = 800;
        dx = 0;
        dy = 0;
        shoot = false;
        arnShooting[0] = b1.getImage();
        arnShooting[1] = b2.getImage();
        arnShooting[2] = b3.getImage();
    }

    public void move() {
        bx += dx;
        by += dy;
        
    }

    public int getBX() {
        return bx;
    }

    public int getBY() {
        return by;
    }

    public Image getImage() {
        img = arnShooting[k];
        if (nCount == 0) {
            bx = X; //Lucario x
            by = Y; //Lucario y
            k = 0;
        }
        if (shoot == true) {
            if (I == 0) {
                k = 2;
                System.out.println("PewPew");
            }
            if (I == 1) {
                k = 1;
                System.out.println("PewPew");
            }
        }
        return img;
        
    }
    

    public void keyPressed2(KeyEvent k) {
        int code = k.getKeyCode();
        if (code == KeyEvent.VK_Q) {
            if (I == 0) {
                shoot = true;
                dx = -BSPEED;
                nCount += 1;
            }
            if (I == 1) {
                shoot = true;
                dx = BSPEED;
                nCount += 1;
            }
            if (nCount == 1) {
                //stahp += bx;
                System.out.println("Please Stahp");
            }
            if (bx > stahp) {
                System.out.println("Stahppppppp");
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
