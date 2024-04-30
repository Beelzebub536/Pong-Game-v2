package Controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {
    public static boolean upPressed = false;
    public static boolean downPressed = false;
    public static boolean wPress = false;
    public static boolean sPress = false;

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                wPress = true;
                break;
            case KeyEvent.VK_S:
                sPress = true;
                break;
            case KeyEvent.VK_UP:
                upPressed = true;
                break;
            case KeyEvent.VK_DOWN:
                downPressed = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                wPress = false;
                break;
            case KeyEvent.VK_S:
                sPress = false;
                break;
            case KeyEvent.VK_UP:
                upPressed = false;
                break;
            case KeyEvent.VK_DOWN:
                downPressed = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
