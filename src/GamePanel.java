import Controls.KeyboardInputs;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener{
    static final int WIDTH = 800;
    static final int HEIGHT = (WIDTH/16)*9;
    static final int CEILING = 25;

    private final Player player1 = new Player(CEILING + (HEIGHT - CEILING) / 2 - Player.PADDLE_HEIGHT / 2);
    private final Player player2 = new Player(CEILING + (HEIGHT - CEILING) / 2 - Player.PADDLE_HEIGHT / 2);
    private final Ball ball = new Ball(WIDTH/2,HEIGHT/2);
    CheckCollision cK = new CheckCollision();
    private final JLabel scoreBoard;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyboardInputs());
        scoreBoard = new JLabel("Player 1: " + player1.getScore() + " | Player 2: " + player2.getScore());
        scoreBoard.setForeground(Color.WHITE);
        scoreBoard.setFont(new Font("Arial", Font.PLAIN, 18));
        add(scoreBoard, BorderLayout.NORTH);

        Timer timer = new Timer(1000 / 60, this);
        timer.start();
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
        cK.checkCollision(player1,player2,ball);
        player2.movePaddle2();
        player1.movePaddle1();
        ball.moveBall();
        updateScoreLabel();
        repaint();
    }

}

