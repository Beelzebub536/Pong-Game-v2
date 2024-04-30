import Controls.KeyboardInputs;

public class Player {
    public static final int PADDLE_WIDTH = 10;
    public static final int PADDLE_HEIGHT = 80;
    private int paddleY;
    private final int PADDLE_SPEED = 10;
    private int score = 0;


    public Player(int paddleY) {
        this.paddleY = paddleY;
    }

    public int getPaddleY() {
        return paddleY;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setPaddleY(int paddleY) {
        this.paddleY = paddleY;
    }

    public void movePaddle1() {

        if (KeyboardInputs.wPress && paddleY > GamePanel.CEILING) {
            paddleY -= PADDLE_SPEED;
        }

        if (KeyboardInputs.sPress && paddleY < GamePanel.HEIGHT - PADDLE_HEIGHT) {
            paddleY += PADDLE_SPEED;
        }
    }
    public void movePaddle2(){
        if (KeyboardInputs.upPressed && paddleY > GamePanel.CEILING) {
            paddleY -= PADDLE_SPEED;
        }
        if (KeyboardInputs.downPressed && paddleY < GamePanel.HEIGHT - PADDLE_HEIGHT) {
            paddleY += PADDLE_SPEED;
        }
    }


}