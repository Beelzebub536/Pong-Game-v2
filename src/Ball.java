public class Ball {
    public static final int BALL_SIZE = 20;
    static int ballX,ballY;
    private int ballXSpeed = 5, ballYSpeed = 5;
    public Ball(int ballX, int ballY){
        this.ballX = ballX;
        this.ballY = ballY;
    }
    public void resetBall(){
        ballX = GamePanel.WIDTH / 2 - BALL_SIZE / 2;
        ballY = GamePanel.HEIGHT / 2 - BALL_SIZE / 2;
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
        ballY += ballYSpeed;
        if (ballY <= GamePanel.CEILING || ballY >= GamePanel.HEIGHT - BALL_SIZE) {
            ballYSpeed = -ballYSpeed;
        }
    }
}
