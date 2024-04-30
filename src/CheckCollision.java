import java.awt.*;

public class CheckCollision {
    public void checkCollision(Player player1, Player player2, Ball circle){
        Rectangle paddle1 = new Rectangle(0,player1.getPaddleY(), Player.PADDLE_WIDTH, Player.PADDLE_HEIGHT);
        Rectangle paddle2 = new Rectangle(GamePanel.WIDTH - Player.PADDLE_WIDTH, player2.getPaddleY(), Player.PADDLE_WIDTH, Player.PADDLE_HEIGHT);
        Rectangle ball = new Rectangle(circle.getBallX(), circle.getBallY(), Ball.BALL_SIZE, Ball.BALL_SIZE);
        if (ball.intersects(paddle1) || ball.intersects(paddle2)) {
            circle.setBallXSpeed(-1*circle.getBallXSpeed());
        }

        if (circle.getBallX() <= 0 || circle.getBallX() >= GamePanel.WIDTH - Ball.BALL_SIZE) {
            if (circle.getBallX() <= 0)
                player2.setScore(10+player2.getScore());
            else
                player1.setScore(10+player1.getScore());
            circle.resetBall();
        }
    }
}
