import javax.swing.*;
import java.awt.Image;

public class Enemy {
    private Image img;
    int k;
    int x, y, dx, dy;
    static int X, Y, I;
    ImageIcon e1 = new ImageIcon("Nothing.png");
    ImageIcon e2 = new ImageIcon("Groudon1.png");
    ImageIcon e3 = new ImageIcon("Groudon2.png");
    Image arnEnemy[] = new Image[3];
    static void SetVars(int _x, int _y, int _i) {
        X = _x;
        Y = _y;
        I = _i;
    }
    public Enemy() {
        dx = 0;
        dy = 0;
        arnEnemy[0] = e1.getImage();
        arnEnemy[1] = e2.getImage();
        arnEnemy[2] = e3.getImage();
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public int getEX() {
        return x;
    }

    public int getEY() {
        return y;
    }
    public Image getImage() {
        img = arnEnemy[k];
            if (I == 1) {
                k = 1;
                return img;
            }
            if (I == 0) {
                k = 2;
                return img;
            }
        return img;
    }
}
