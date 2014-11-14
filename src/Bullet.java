import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.Image;

public class Bullet {

    private Image img;
    int k, nS;
    static int X, Y, I;
    int bx, by, dx, dy, stahp, stahp2, nCount, nCount2;
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
        nCount2 = 0;
        nS = 1;
        stahp = 400;
        stahp2 = -400;
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
            k = 0;
            bx = X; //Lucario x
            by = Y; //Lucario y
            return img;
        }
        if (nCount2 == 0) {
            k = 0;
            bx = X; //Lucario x
            by = Y; //Lucario y
            return img;
        }
        if (shoot == true) {
            if (I == 0) {
                k = 2;
            }
            if (I == 1) {
                k = 1;
            }
        }
        return img;
    }

    public void keyPressed2(KeyEvent k) {
        int code = k.getKeyCode();
        if (code == KeyEvent.VK_Q) {
            if (I == 0) { //Looking Left
                shoot = true;
                dx = -BSPEED;
                nCount2 = nS;
                nCount = 2;
                System.out.println(nS + " " + nCount + " " + nCount2);
                if (nCount2 == 1) {
                    System.out.println(stahp2 + " " + bx);
                    stahp2 += bx;
                    System.out.println(stahp2 + " " + bx);
                    nS = 2;
                    System.out.println("Please Stahp");
                }
                if (bx < stahp2) {
                    System.out.println(nS + " " + nCount + " " + nCount2);
                    System.out.println("PLEASEEEE STAHPPPP!!!!!!");
                    dx = 0;
                    stahp2 = -400;
                    nS = 1;
                    System.out.println(nS + " " + nCount + " " + nCount2);
                    nCount = 0;
                    nCount2 = 0;
                }
            }
            if (I == 1) { // Looking Right
                shoot = true;
                dx = BSPEED;
                nCount = nS;
                nCount2 = 2;
                System.out.println(nS + " " + nCount + " " + nCount2);
                if (nCount == 1) {
                    System.out.println(stahp + " " + bx);
                    stahp += bx;
                    System.out.println(stahp + " " + bx);
                    nS = 2;
                    System.out.println("Please Stahp");
                }
                if (bx > stahp) {
                    System.out.println(nS + " " + nCount + " " + nCount2);
                    System.out.println("PLEASEEEE STAHPPPP!!!!!!");
                    dx = 0;
                    stahp = 400;
                    nS = 1;
                    System.out.println(nS + " " + nCount + " " + nCount2);
                    nCount = 0;
                    nCount2 = 0;
                }
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
