import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.Image;

public class Bullet {

    private Image img;
    int k, nS;
    static int X, Y, I;
    int x, y, dx, dy, stahp, stahp2, nCount, nCount2, nStop, nShoot, nLeft, nRight;
    boolean shoot, stop;
    private final int BSPEED = 40;
    ImageIcon b1 = new ImageIcon("Nothing.png");
    ImageIcon b2 = new ImageIcon("AuraSphere1.png");
    ImageIcon b3 = new ImageIcon("AuraSphere2.png");
    Image arnShooting[] = new Image[3];

    static void SetPlayer(int _x, int _y, int _i) {
        X = _x;
        Y = _y;
        I = _i;
    }

    public Bullet() {
        nCount = 0;
        nCount2 = 0;
        nS = 1;
        stahp = 400;
        stahp2 = -400;
        nLeft = 0;
        nRight = 0;
        dx = 0;
        dy = 0;
        stop = false;
        shoot = false;
        arnShooting[0] = b1.getImage();
        arnShooting[1] = b2.getImage();
        arnShooting[2] = b3.getImage();
    }

    public void move() {
        x += dx;
        y += dy;
        if (stop == false) {
            x = X; //Lucario X
            y = Y; //Lucario Y
        }
        if (stop == true) {
            if (nLeft == 1) {
                if (x <= stahp2) {
                    dx = 0;
                    stahp2 = -400;
                    nS = 1;
                    nCount = 0;
                    nCount2 = 0;
                    nLeft = 0;
                    stop = false;
                    System.out.println("Stop");
                }
            }
            if (nRight == 1) {
                    if (x >= stahp) {
                        nShoot = 0;
                        dx = 0;
                        stahp = 400;
                        nS = 1;
                        nCount = 0;
                        nCount2 = 0;
                        nRight = 0;
                        stop = false;
                        System.out.println("Stop");
                    }
                }
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
            System.out.println("PEW PEW");
            if (I == 0) { //Looking Left
                if (nS == 1) {
                    nLeft = 1;
                        nShoot =2;
                        k = 2;
                    shoot = true;
                    stop = false;
                    System.out.println("Pew Pews");
                    dx = -BSPEED;
                    nCount2 = nS;
                    nCount = 2;
                    if (nCount2 == 1) {
                        stahp2 += x;
                        nS = 2;
                        
            }
            }
            }
            if (I == 1) { // Looking Right
                if (nS == 1) {
                    System.out.println("PEW PEW");
                    shoot = true;
                    nRight = 1;
                    k = 1;
                    dx = BSPEED;
                    nCount = nS;
                    nCount2 = 2;
                    if (nCount == 1) {
                        stahp += x;
                        nS = 2;
                    }
                }
            }
        }
        Enemy.SetBullet(x, y);
    }

    public void keyReleased2(KeyEvent w) {
        int code = w.getKeyCode();
        if (code == KeyEvent.VK_Q) {
            stop = true;
        }
    }
}
