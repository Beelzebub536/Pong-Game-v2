import java.util.Random;

public class Ball {
    public static final int BALL_SIZE = 20;
    private int ballX, ballY;
    private final int BALL_SPEED = 2;
    private int ballXSpeed = BALL_SPEED, ballYSpeed = BALL_SPEED;
    private final Random random = new Random();

    public Ball() {
        resetBall();
    }

    public void resetBall() {
        ballXSpeed = BALL_SPEED;
        ballYSpeed = BALL_SPEED;
        int halfW = GamePanel.WIDTH / 2;
        int halfH = GamePanel.HEIGHT / 2;
        if (random.nextBoolean()) {
            ballXSpeed *= -1;
        }
        if (random.nextBoolean()) {
            ballYSpeed *= -1;
        }
        ballX = random.nextInt((int) (halfW - halfW * 0.2), (int) (halfW + halfW * 0.2));
        ballY = random.nextInt((int) (halfH - halfH * 0.2), (int) (halfH + halfH * 0.2));
    }

    public int getBallX() {
        return ballX;
    }

    public int getBallY() {
        return ballY;
    }

    public int getBallXSpeed() {
        return ballXSpeed;
    }

    public int getBallYSpeed() {
        return ballYSpeed;
    }

    public void setBallX(int ballX) {
        this.ballX = ballX;
    }

    public void setBallY(int ballY) {
        this.ballY = ballY;
    }

    public void setBallXSpeed(int ballXSpeed) {
        this.ballXSpeed = ballXSpeed;
    }

    public void setBallYSpeed(int ballYSpeed) {
        this.ballYSpeed = ballYSpeed;
    }

    public void moveBall() {
        ballX += ballXSpeed;
        if (ballY + ballYSpeed <= GamePanel.CEILING) {
            ballYSpeed = -ballYSpeed;
            ballY = ballYSpeed - ballY + 2*GamePanel.CEILING;
            if (ballXSpeed > 0)
                ballXSpeed++;
            else
                ballXSpeed--;
        } else if (ballY + ballYSpeed >= GamePanel.HEIGHT - BALL_SIZE) {
            ballY = 2*(GamePanel.HEIGHT - BALL_SIZE) - ballYSpeed - ballY;
            ballYSpeed = -ballYSpeed;
            if (ballXSpeed > 0)
                ballXSpeed++;
            else
                ballXSpeed--;
        } else
            ballY += ballYSpeed;
    }
}
