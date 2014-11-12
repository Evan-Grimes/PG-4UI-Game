import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Player {

    private Image img;
    int i;
    int x, y, bx, by, dx, dy, backgroundX;
    private final int SPEED = 8;
    boolean left, right, up, down, shoot;
    ImageIcon i1 = new ImageIcon("Lucario1.png");
    ImageIcon i2 = new ImageIcon("Lucario2.png");
    ImageIcon b1 = new ImageIcon("Bullet.png");
    Image arnRunning_R[] = new Image[2];

    public Player() {
        x = 350;
        y = 238;
        bx = 0;
        by = 0;
        dx = 0;
        dy = 0;
        left = false;
        right = false;
        up = false;
        down = false;
        shoot = false;
        arnRunning_R[0] = i1.getImage();
        arnRunning_R[1] = i2.getImage();
    }

    public void move() {
        x += dx;
        y += dy;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        img = arnRunning_R[i];
        if (right == true) {
            i = 1;
            System.out.println("Right");
        } else if (left == true) {
            i = 0;
            System.out.println("Left");
        } else if (up == true) {
            System.out.println("Up");

        } else if (down == true) {
            System.out.println("Down");
        }
        return img;
    }
    public void keyPressed(KeyEvent k) {
        int code = k.getKeyCode();
        if (code == KeyEvent.VK_A) {
            left = true;
            dx = -SPEED;
        } else if (code == KeyEvent.VK_D) {
            right = true;
            dx = SPEED;
        } else if (code == KeyEvent.VK_W) {
            up = true;
            dy = -SPEED;
        } else if (code == KeyEvent.VK_S) {
            down = true;
            dy = SPEED;
        }
        Bullet.SetVars(x,y, i);
    }

    public void keyReleased(KeyEvent k) {
        int code = k.getKeyCode();
        if (code == KeyEvent.VK_A) {
            left = false;
            if (right) {
            } else {
                dx = 0;
            }
        } else if (code == KeyEvent.VK_D) {
            right = false;
            if (left) {
            } else {
                dx = 0;
            }
        } else if (code == KeyEvent.VK_W) {
            up = false;
            if (up) {
            } else {
                dy = 0;
            }
        } else if (code == KeyEvent.VK_S) {
            down = false;
            if (up) {
            } else {
                dy = 0;
            }
        }
    }
    
}
