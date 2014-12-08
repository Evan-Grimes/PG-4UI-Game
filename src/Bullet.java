import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.Image;

public class Bullet {

    private Image img;
    int k, nS;
    int EHMin, EWMin;
    static int X, Y, I, EX, EY, EH, EW;
    int x, y, dx, dy, nStahp, nStahp2, nCount, nCount2, nStop, nLeft, nRight, nHit;
    boolean shoot, stop, go;
    private final int bSpeed = 40;
    ImageIcon b1 = new ImageIcon("AuraSphere1.png");
    ImageIcon b2 = new ImageIcon("AuraSphere2.png");
    int imgWidth = b1.getIconHeight();
    int imgHeight = b2.getIconWidth();
    Image arnShooting[] = new Image[3];

    static void SetEnemy(int _x, int _y, int _EH, int _EW) {
        EX = _x;
        EY = _y;
        EH = _EH;
        EW = _EW;
    }

    static void SetPlayer(int _x, int _y, int _i) {
        X = _x;
        Y = _y;
        I = _i;
    }

    public Bullet() {
        nCount = 0;
        nCount2 = 0;
        nS = 1;
        nStahp = 400;
        nStahp2 = -400;
        nLeft = 0;
        nRight = 0;
        dx = 0;
        dy = 0;
        stop = false;
        shoot = false;
        go = false;
        arnShooting[1] = b1.getImage();
        arnShooting[2] = b2.getImage();
    }

    public void move() {
        Enemy.SetBullet(x, y);
        EHMin = EH - EY;
        EWMin = EW - EX;
        x += dx;
        y += dy;
            if (nLeft == 1) {
                if (x <= nStahp2) {
                    x = 9999;
                    y = 9999;
                    dx = 0;
                    nStahp2 = -400;
                    nS = 1;
                    nCount = 0;
                    nCount2 = 0;
                    nLeft = 0;
                    stop = false;
                }
            }
            if (nRight == 1) {
                if (x >= nStahp) {
                    x = 9999;
                    y = 9999;
                    dx = 0;
                    nStahp = 400;
                    nS = 1;
                    nCount = 0;
                    nCount2 = 0;
                    nRight = 0;
                    stop = false;
                }
        }
        if (y < EH && y > EHMin && x < EW && x > EWMin) {
            nHit++;
            System.out.println("Smack");
            
        }
    }

    public int getBX() {
        return x;
    }

    public int getBY() {
        return y;
    }

    public Image getImage() {
        img = arnShooting[k];
        if (nCount == 0) {
            k = 0;
            return img;
        }
        return img;
    }

    public void keyPressed2(KeyEvent w) {
        int code = w.getKeyCode();
        if (code == KeyEvent.VK_Q) {
            if (I == 0) { //Looking Left
                if (nS == 1) {
                    x = X;
                    y = Y;
                    stop = false;
                    shoot = true;
                    nLeft = 1;
                    k = 2;
                    dx = -bSpeed;
                    nCount2 = 1;
                    nCount = 2;
                    if (nCount2 == 1) {
                        nStahp2 += x;
                        nS = 2;

                    }
                }
            }
            if (I == 1) { // Looking Right
                if (nS == 1) {
                    x = X;
                    y = Y;
                    stop = false;
                    shoot = true;
                    nRight = 1;
                    k = 1;
                    dx = bSpeed;
                    nCount = nS;
                    nCount2 = 2;
                    if (nCount == 1) {
                        nStahp += x;
                        nS = 2;
                    }
                }
            }
        }

    }

    public void keyReleased2(KeyEvent w) {
        int code = w.getKeyCode();
        if (code == KeyEvent.VK_Q) {
            stop = true;
        }
    }
}
