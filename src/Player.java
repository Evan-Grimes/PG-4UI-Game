import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Player {

    private Image img;
    int i;
    int x, y, dx, dy, PlayerX1, PlayerY1, backgroundX;
    long time;
    private final int SPEED = 8;
    boolean left, right, up, down, releaseRight, releaseLeft, releaseUp, releaseDown;
    ImageIcon i1 = new ImageIcon("Lucario1.png");
    ImageIcon i2 = new ImageIcon("Lucario2.png");
    Image arnRunning_R[] = new Image[2];

    public Player() {
        x = 350;
        y = 238;
        dx = 0;
        dy = 0;
        PlayerX1 = 0;
        PlayerY1 = 0;
        left = false;
        right = false;
        up = false;
        down = false;
        releaseUp = false;
        releaseDown = false;
        releaseRight = false;
        releaseLeft = false;
        arnRunning_R[0] = i1.getImage();
        arnRunning_R[1] = i2.getImage();

    }

    public void move() {
        x += dx;
        PlayerX1 = (PlayerX1 - dx);
        y += dy;
        PlayerY1 = (PlayerY1 - dx);

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
            releaseRight = false;
            i = 1;
            System.out.println("Right");
        } else if (left == true) {
            releaseLeft = false;
            i = 0;
            System.out.println("Left");
        } else if (up == true) {
            releaseDown = false;
            System.out.println("Up");
        
        } else if (down == true) {
            releaseUp = false;
            System.out.println("Down");
        }
        return img;
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            left = true;
            dx = -SPEED;
        } else if (code == KeyEvent.VK_RIGHT) {
            right = true;
            dx = SPEED;
        } else if (code == KeyEvent.VK_UP) {
            up = true;
            dy = -SPEED;
        } else if (code == KeyEvent.VK_DOWN) {
            down = true;
            dy = SPEED;
        }
    }

    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            left = false;
            releaseLeft = true;
            if (right) {
                dx = -SPEED;
            } else {
                dx = 0;
            }
        } else if (code == KeyEvent.VK_RIGHT) {
            right = false;
            releaseRight = true;
            if (left) {
                dx = SPEED;
            } else {
                dx = 0;
            }
        } else if (code == KeyEvent.VK_UP) {
            up = false;
            releaseUp = true;
            if (up) {
                dy = -SPEED;
            }else {
                dy = 0;
            }
            } else if (code == KeyEvent.VK_DOWN) {
            down = false;
            releaseDown = true;
            if (up) {
                dy = SPEED;
            }else {
                dy = 0;
            }
        }
    }
}
