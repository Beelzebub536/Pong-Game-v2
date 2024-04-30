import java.util.Random;

public class Ball {
    public static final int BALL_SIZE = 20;
    private int ballX,ballY;
    private final int ballSpeed = 5;
    private int ballXSpeed = ballSpeed, ballYSpeed = ballSpeed;
    private Random random = new Random();

    public Ball(){
        resetBall();
    }

    public void resetBall(){
        ballXSpeed = ballSpeed;
        ballYSpeed = ballSpeed;
        int halfW = GamePanel.WIDTH / 2;
        int halfH = GamePanel.HEIGHT / 2;
        if(random.nextInt(2) == 1) {
            ballXSpeed *= -1;
        }
        if (random.nextInt(2)== 1){
            ballYSpeed *= -1;
        }
        ballX=random.nextInt((int) (halfW-halfW*0.35), (int) (halfW+halfW*0.35));
        ballY=random.nextInt((int) (halfH-halfH*0.35), (int) (halfH+halfH*0.35));
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

    public void setBallXSpeed(int ballXSpeed) {
        this.ballXSpeed = ballXSpeed;
    }

    public void setBallYSpeed(int ballYSpeed) {
        this.ballYSpeed = ballYSpeed;
    }

    public void moveBall() {
        ballX += ballXSpeed;
        ballY += ballYSpeed;
        if (ballY <= GamePanel.CEILING || ballY >= GamePanel.HEIGHT - BALL_SIZE) {
            ballYSpeed = -ballYSpeed;
            if (ballXSpeed >0)
                ballXSpeed+=1;
            else
                ballXSpeed-=1;
        }
    }
}
