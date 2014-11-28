import javax.swing.*;
import java.awt.Image;

public class Enemy {

    private Image img;
    int k;
    int x, y, dx, dy, speed;
    static int X, Y, I, BX, BY;
    ImageIcon e1 = new ImageIcon("Groudon1.png");
    ImageIcon e2 = new ImageIcon("Groudon2.png");
    Image arnEnemy[] = new Image[3];

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
        arnEnemy[1] = e1.getImage();
        arnEnemy[2] = e2.getImage();
    }

    public void move() {
        x += dx;
        y += dy;
        if (X > x) {
            dx = 5;
        } else if (X < x) {
            dx = -5;
        } else {
            dx  = 0;
            
        }
        if (Y > y) {
            dy = 5;
        } else if (Y < y) {
            dy = -5;
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
