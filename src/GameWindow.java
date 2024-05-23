import javax.swing.*;

public class GameWindow {
    public static JFrame frame = new JFrame();
    private static GameState currentState;
    public static final GamePanel gamePanel = new GamePanel();
    private static final PongTitleScreen title = new PongTitleScreen();
    private static final PauseScreen pause = new PauseScreen();

    public GameWindow() {
        frame.setTitle("Pong Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        setCurrentState(GameState.TITLE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void setCurrentState(GameState state) {
        currentState = state;
        frame.getContentPane().removeAll();

        switch (state) {
            case TITLE -> {
                frame.add(title);
                title.requestFocusInWindow();
                GamePanel.timer.stop();
                GamePanel.fpsTimer.stop();
            }
            case GAME -> {
                frame.add(gamePanel);
                GamePanel.timer.start();
                GamePanel.fpsTimer.start();
                gamePanel.requestFocusInWindow();
            }
            case PAUSE -> {
                frame.add(pause);
                pause.requestFocusInWindow();
                GamePanel.timer.stop();
            }
        }
        frame.repaint();
        frame.pack();
    }

    public static GameState getCurrentState() {
        return currentState;
    }

    public static void main(String[] args) {
        new GameWindow();
    }
}
