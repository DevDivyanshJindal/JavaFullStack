import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private final int PANEL_WIDTH = 800;
    private final int PANEL_HEIGHT = 600;

    private final int BIRD_SIZE = 40;
    private int birdX = 100;
    private int birdY = PANEL_HEIGHT / 2;
    private int birdVelocity = 0;
    private int gravity = 1;
    private final int jumpStrength = -10;

    private ArrayList<Rectangle> pipes;
    private Timer timer;
    private Random random;

    private boolean gameOver = false;

    private Image birdImage;
    private Image pipeImage;
    private Image backgroundImage;

    public GamePanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setFocusable(true);
        this.addKeyListener(this);

        
        birdImage = new ImageIcon("bird.png").getImage();
        pipeImage = new ImageIcon("pipe.png").getImage();
        backgroundImage = new ImageIcon("pxfuel.jpg").getImage();

        pipes = new ArrayList<>();
        random = new Random();
        timer = new Timer(20, this);

        
        addPipe(true);
        addPipe(true);

        timer.start();
    }

    private void addPipe(boolean start) {
        int gap = 150;
        int pipeWidth = 60;
        int pipeHeight = 50 + random.nextInt(PANEL_HEIGHT - gap - 100);

        if (start) {
            pipes.add(new Rectangle(PANEL_WIDTH + pipes.size() * 300, 0, pipeWidth, pipeHeight));
            pipes.add(new Rectangle(PANEL_WIDTH + pipes.size() * 300, pipeHeight + gap, pipeWidth, PANEL_HEIGHT - pipeHeight - gap));
        } else {
            pipes.add(new Rectangle(pipes.get(pipes.size() - 1).x + 300, 0, pipeWidth, pipeHeight));
            pipes.add(new Rectangle(pipes.get(pipes.size() - 1).x, pipeHeight + gap, pipeWidth, PANEL_HEIGHT - pipeHeight - gap));
        }
    }

    private void movePipes() {
        for (int i = 0; i < pipes.size(); i++) {
            Rectangle pipe = pipes.get(i);
            pipe.x -= 5;

            if (pipe.x + pipe.width < 0) {
                pipes.remove(pipe);
                if (i % 2 == 0) {
                    addPipe(false);
                }
            }
        }
    }

    private void checkCollision() {
        Rectangle bird = new Rectangle(birdX, birdY, BIRD_SIZE, BIRD_SIZE);

        for (Rectangle pipe : pipes) {
            if (pipe.intersects(bird)) {
                gameOver = true;
                timer.stop();
            }
        }

        if (birdY > PANEL_HEIGHT || birdY < 0) {
            gameOver = true;
            timer.stop();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        
        g.drawImage(backgroundImage, 0, 0, PANEL_WIDTH, PANEL_HEIGHT, null);

        
        g.drawImage(birdImage, birdX, birdY, BIRD_SIZE, BIRD_SIZE, null);

        
        for (Rectangle pipe : pipes) {
            g.drawImage(pipeImage, pipe.x, pipe.y, pipe.width, pipe.height, null);
        }

        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("Game Over!", PANEL_WIDTH / 3, PANEL_HEIGHT / 2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        birdY += birdVelocity;
        birdVelocity += gravity;

        movePipes();
        checkCollision();

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (gameOver) {
                // Restart the game
                birdY = PANEL_HEIGHT / 2; 
                birdVelocity = 0;         
                pipes.clear();            
                addPipe(true);            
                addPipe(true);
                gameOver = false;         
                timer.start();            
            } else {
                birdVelocity = jumpStrength; 
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
