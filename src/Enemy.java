import javax.swing.*;
import java.awt.Image;

public class Enemy {

    private Image img;
    int k;
    int nHit;
    int x, y, dx, dy;
    static int X, Y, I, BX, BY;
    int nWidth, nLength, EH, EW;
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

    static void SetBullet(int _x, int _y) {
        BX = _x;
        BY = _y;
    }

    public Enemy() {
        dx = 0;
        dy = 0;
        x = 0;
        y = 0;
        //nWidth = 0;
        //nLength = 0;
        arnEnemy[1] = e1.getImage();
        arnEnemy[2] = e2.getImage();
    }

    public void move() {
        EH = imgHeight + y - 30;
        EW = imgWidth + x - 30;
        Bullet.SetEnemy(x, y, EH, EW);
        x += dx;
        y += dy;
        nHit = y + 30;
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

    public int getEX() {
        return x - 30;
    }

    public int getEY() {
        return y - 30;
    }

    public Image getImage() {
        img = arnEnemy[k];
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
