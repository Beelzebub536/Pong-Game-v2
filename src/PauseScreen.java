import javax.swing.*;
import java.awt.*;

public class PauseScreen extends JPanel {
    public PauseScreen() {
        setPreferredSize(new Dimension(GamePanel.WIDTH, GamePanel.HEIGHT));
        setBackground(Color.BLACK);
        addKeyListener(new KeyboardInputs());
        setFocusable(true);
        setLayout(new GridBagLayout());

        JButton resumeButton = new JButton("Resume");
        resumeButton.addActionListener(e -> GameWindow.setCurrentState(GameState.GAME));
        resumeButton.setFont(new Font("Arial", Font.BOLD, 24));

        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(e -> {
            restartGame();
            GameWindow.setCurrentState(GameState.GAME);
        });
        restartButton.setFont(new Font("Arial", Font.BOLD, 24));

        JButton backToStartButton = new JButton("Back to Start");
        backToStartButton.addActionListener(e -> backToTitle());
        backToStartButton.setFont(new Font("Arial", Font.BOLD, 24));

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        exitButton.setFont(new Font("Arial", Font.BOLD, 24));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.NONE;

        // Add vertical space above the first button
        gbc.weighty = 1;
        add(Box.createVerticalGlue(), gbc);

        // Add the buttons
        add(resumeButton, gbc);
        add(restartButton, gbc);
        add(backToStartButton, gbc);
        add(exitButton, gbc);

        // Add vertical space below the last button
        add(Box.createVerticalGlue(), gbc);
    }
    private void restartGame() {
        GameWindow.gamePanel.player1.resetPaddle();
        GameWindow.gamePanel.player1.resetScore();
        GameWindow.gamePanel.player2.resetScore();
        GameWindow.gamePanel.player2.resetPaddle();
        GameWindow.gamePanel.ball.resetBall();
    }

    private void backToTitle() {
        restartGame();
        GameWindow.setCurrentState(GameState.TITLE);
    }
}
