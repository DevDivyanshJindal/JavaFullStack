import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame() {
        this.setTitle(" Divyansh Flappy Bird");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(new GamePanel());
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GameFrame();
    }
}

