import javax.swing.*;
import java.awt.Image;

public class Enemy {

    private Image img;
    int k;
    int x, y, dx, dy;
    static int X, Y, I, BX, BY, nHit;
    int nWidth, nLength, EH, EW, nEXP, nSpawn;
    private final int nSpeed = 5;
    ImageIcon e1 = new ImageIcon("Groudon1.png");
    ImageIcon e2 = new ImageIcon("Groudon2.png");
    int imgWidth = e1.getIconHeight();
    int imgHeight = e2.getIconWidth();
    Image arnEnemy[] = new Image[3];
    int arnHit[] = new int[50];

    static void SetPlayer(int _x, int _y, int _i) {
        X = _x;
        Y = _y;
        I = _i;
    }

    static void SetBullet(int _x, int _y, int _nHit) {
        BX = _x;
        BY = _y;
        nHit = _nHit;
    }

    public Enemy() {
        dx = 0;
        dy = 0;
        x = 0;
        y = 0;
        nEXP = 5;
        arnEnemy[1] = e1.getImage();
        arnEnemy[2] = e2.getImage();
    }

    public void move() {
        EH = imgHeight + y - 30;
        EW = imgWidth + x - 30;
        x += dx;
        y += dy;
         Bullet.SetEnemy(x, y, EH, EW, k);

        if (k == 1 || k == 2) {
            if (X > x) {
                dx = nSpeed;
            } else if (X < x) {
                dx = -nSpeed;
            } else {
                dx = 0;
            }
            if (Y > y) {
                dy = nSpeed;
            } else if (Y < y) {
                dy = -nSpeed;
            } else {
                dy = 0;
            }
            
        }
    }

    public int getEX() {
        return x - 30;
    }

    public int getEY() {
        return y - 30;
    }

    public Image getImage() {
        img = arnEnemy[k];
        if (nHit == nEXP) {
            k = 0;
            x = 3000;
            y = 3000;
            nSpawn++;
            if (nSpawn >= 20) {
                nSpawn = 0;
                x = 100;
                y = 100;
                nEXP += 5;
            }
            return img;
        }
            if (X >= x) {
                k = 1;
                return img;
            }
            if (X <= x) {
                k = 2;
                return img;
            }
        return img;
    }

}
