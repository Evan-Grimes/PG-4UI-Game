import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Player {

    private Image img;
    int i;
    int x, y, bx, by, dx, dy, backgroundX;
    private final int SPEED = 15;
    boolean left, right, up, down;
    ImageIcon p1 = new ImageIcon("Lucario1.png");// Looking Left
    ImageIcon p2 = new ImageIcon("Lucario2.png");// Looking Right
    int imgWidth = p1.getIconHeight();
    int imgHeight = p2.getIconWidth();
    Image arnRunning_R[] = new Image[2];

    public Player() {
        x = 550;
        y = 200;
        dx = 0;
        dy = 0;
        left = false;
        right = false;
        up = false;
        down = false;
        arnRunning_R[0] = p1.getImage();
        arnRunning_R[1] = p2.getImage();
    }

    public void move() {
        Bullet.SetPlayer(x,y,i);
        Enemy.SetPlayer(x,y,i);
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
        } else if (left == true) {
            i = 0;
        }
        return img;
    }
    public void keyPressed(KeyEvent w) {
        int code = w.getKeyCode();
        if (code == KeyEvent.VK_A) {
            left = true;
            right = false;
            dx = -SPEED;
        } else if (code == KeyEvent.VK_D) {
            right = true;
            left = false;
            dx = SPEED;
        } else if (code == KeyEvent.VK_W) {
            up = true;
            down = false;
            dy = -SPEED;
        } else if (code == KeyEvent.VK_S) {
            down = true;
            up = false;
            dy = SPEED;
        }
        
    }

    public void keyReleased(KeyEvent w) {
        int code = w.getKeyCode();
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
            if (down) {
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
