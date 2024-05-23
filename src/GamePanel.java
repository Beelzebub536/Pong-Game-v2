import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {
    static final int WIDTH = 800;
    static final int HEIGHT = (WIDTH / 16) * 9;
    static final int CEILING = 25;

    public final Player player1 = new Player(CEILING + (HEIGHT - CEILING) / 2 - Player.PADDLE_HEIGHT / 2);
    public final Player player2 = new Player(CEILING + (HEIGHT - CEILING) / 2 - Player.PADDLE_HEIGHT / 2);
    public final Ball ball = new Ball();
    CheckCollision cK = new CheckCollision();
    private final JLabel scoreBoard;
    public static Timer timer, fpsTimer;
    private int frame = 0;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        addKeyListener(new KeyboardInputs());
        setFocusable(true);

        scoreBoard = new JLabel("Player 1: " + player1.getScore() + " | Player 2: " + player2.getScore());
        scoreBoard.setForeground(Color.WHITE);
        scoreBoard.setFont(new Font("Arial", Font.PLAIN, 18));
        add(scoreBoard, BorderLayout.NORTH);

        timer = new Timer(1000 / 240, this);
        fpsTimer = new Timer(1000, e -> {
            System.out.println("FPS = " + frame);
            frame = 0;
        });
        fpsTimer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawLine(20, CEILING, WIDTH - 20, CEILING);
        g.drawLine(WIDTH / 2, CEILING + 20, WIDTH / 2, HEIGHT - 20);
        g.fillRect(0, player1.getPaddleY(), Player.PADDLE_WIDTH, Player.PADDLE_HEIGHT);
        g.fillRect(WIDTH - Player.PADDLE_WIDTH, player2.getPaddleY(), Player.PADDLE_WIDTH, Player.PADDLE_HEIGHT);
        g.fillOval(ball.getBallX(), ball.getBallY(), Ball.BALL_SIZE, Ball.BALL_SIZE);
    }

    private void updateScoreLabel() {
        scoreBoard.setText("Player 1: " + player1.getScore() + " | Player 2: " + player2.getScore());
    }

    public void actionPerformed(ActionEvent e) {
        try {
            cK.checkCollision(player1, player2, ball);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        updateScoreLabel();
        frame++;
        repaint();
    }
}
