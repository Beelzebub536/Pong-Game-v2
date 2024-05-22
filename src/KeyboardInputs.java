import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {
    public static boolean upPressed = false;
    public static boolean downPressed = false;
    public static boolean wPress = false;
    public static boolean sPress = false;

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (GameWindow.getCurrentState() == GameState.GAME)
                GameWindow.setCurrentState(GameState.TITLE);
            else
                GameWindow.setCurrentState(GameState.GAME);
        }
        if(GameWindow.getCurrentState() == GameState.GAME) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W -> wPress = true;
                case KeyEvent.VK_S -> sPress = true;
                case KeyEvent.VK_UP -> upPressed = true;
                case KeyEvent.VK_DOWN -> downPressed = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (GameWindow.getCurrentState() == GameState.GAME) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W -> wPress = false;
                case KeyEvent.VK_S -> sPress = false;
                case KeyEvent.VK_UP -> upPressed = false;
                case KeyEvent.VK_DOWN -> downPressed = false;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}


