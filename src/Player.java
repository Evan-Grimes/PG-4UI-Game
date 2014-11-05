import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Player {

    private Image img;
    int x, y, dx, dy, backgroundX, BeginingY, L_and_R_Counter = 0, RedPlatformX1, PlayerX = 350, speedCoutner = 0, U_and_D_Counter = 0;
    long time;
    private final int SPEED = 8, GRAV = 1;
    boolean left, right, isJumping, isCrouching, releaseRight, releaseLeft;
    private int Xmin, Xmax, Ymin, Ymax;
    ImageIcon i1 = new ImageIcon("Fkyou.png");
    Image arnRunning_R[] = new Image[1];

    public Player() {
        x = 350;
        y = 238;
        dx = 0;
        dy = 0;
        backgroundX = 0;
        RedPlatformX1 = 600;
        left = false;
        right = false;
        isJumping = false;
        isCrouching = false;
        Xmin = 350;
        Xmax = 450;
        releaseRight = false;
        releaseLeft = false;
        arnRunning_R[0] = i1.getImage();

    }

    public void move() {
        x += dx;
        PlayerX = (PlayerX - dx);
        RedPlatformX1 = (RedPlatformX1 - dx);
        if (isJumping) {
            y = 238 - (int) (90 * (((float) U_and_D_Counter) / 4));
            System.out.println(y);
        }
        if (!isJumping && !isOnPlatform1()) {
            isJumping = false;
            y = 238;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        img = i1.getImage();
        if (right == true) {
            releaseLeft = false;
            img = arnRunning_R[0];
        } else if (left == true) {
            releaseRight = false;
            img = arnRunning_R[0];
        } else if (isJumping == true) {
            img = arnRunning_R[0];
        } else if (releaseLeft == true) {
            img = i1.getImage();
        }
        return img;
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            left = true;
            dx = SPEED;
        } else if (code == KeyEvent.VK_RIGHT) {
            right = true;
            dx = -SPEED;
        } else if (code == KeyEvent.VK_UP) {
            isJumping = true;
        } else if (code == KeyEvent.VK_DOWN) {
            isCrouching = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (!isOnPlatform1()) {
            U_and_D_Counter = 0;
            L_and_R_Counter = 0;
        }
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
            isJumping = false;
        }
    }

    public boolean isOnPlatform1() {
        if (PlayerX < (RedPlatformX1 - 28) || PlayerX > (RedPlatformX1 + 50)) {
            return false;
        } else {
            return U_and_D_Counter == 4;
        }
    }
}
