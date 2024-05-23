import java.awt.Rectangle;

public class CheckCollision {
    public void checkCollision(Player player1, Player player2, Ball circle) throws InterruptedException {
        Rectangle paddle1 = new Rectangle(0, player1.getPaddleY(), Player.PADDLE_WIDTH, Player.PADDLE_HEIGHT);
        Rectangle paddle2 = new Rectangle(GamePanel.WIDTH - Player.PADDLE_WIDTH, player2.getPaddleY(), Player.PADDLE_WIDTH, Player.PADDLE_HEIGHT);
        Rectangle ball = new Rectangle(circle.getBallX(), circle.getBallY(), Ball.BALL_SIZE, Ball.BALL_SIZE);

        if (ball.intersects(paddle1) || ball.intersects(paddle2)) {
            circle.setBallXSpeed(-circle.getBallXSpeed());
            circle.setBallX(circle.getBallX() + circle.getBallXSpeed());
            Player.PADDLE_SPEED++;
        }

        if (circle.getBallX() <= 0 || circle.getBallX() >= GamePanel.WIDTH - Ball.BALL_SIZE) {
            if (circle.getBallX() <= 0)
                player2.setScore(player2.getScore() + 10);
            else
                player1.setScore(player1.getScore() + 10);
            circle.resetBall();
            player1.resetPaddle();
            player2.resetPaddle();
            Player.PADDLE_SPEED=Player.SPEED;
            Thread.sleep(1000);
        }
        player2.movePaddle2();
        player1.movePaddle1();
        if (!(ball.intersects(paddle1) || ball.intersects(paddle2)))
            circle.moveBall();
    }
}
