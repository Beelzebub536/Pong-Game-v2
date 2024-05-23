import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PongTitleScreen extends JPanel {
    private final Image background = new ImageIcon("PONG GAME.png").getImage();

    public PongTitleScreen() {
        setPreferredSize(new Dimension(GamePanel.WIDTH, GamePanel.HEIGHT));
        setBackground(Color.BLACK);
        setLayout(null);
        setFocusable(true);

        JButton playButton = new JButton();
        playButton.setBounds(353, 143, 100, 58);
        playButton.setOpaque(false);
        playButton.setContentAreaFilled(false);
        playButton.setBorderPainted(false);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameWindow.setCurrentState(GameState.GAME);
            }
        });
        add(playButton);

        JButton settingsButton = new JButton();
        settingsButton.setBounds(315, 220, 170, 58);
        settingsButton.setOpaque(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setBorderPainted(false);
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Settings button clicked!");
            }
        });
        add(settingsButton);

        JButton exitButton = new JButton();
        exitButton.setBounds(355, 300, 91, 58);
        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);
    }


    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, 0, 0, null);

        float thickness = 3.0f;
        g2d.setStroke(new BasicStroke(thickness));
        g2d.setColor(Color.WHITE);

        g2d.drawRoundRect(353, 143, 100, 58, 30, 30);
        g2d.drawRoundRect(315, 220, 170, 58, 30, 30);
        g2d.drawRoundRect(355, 300, 91, 58, 30, 30);
    }
}
