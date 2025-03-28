import javax.swing.*;

class GameWindow extends JFrame {
    int WIDTH = 340;
    int HEIGHT = 640;
    public GameWindow(){  //Constructor to Control the Game Window
        setTitle("Floppy Bird");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setVisible(true);
        FlappyBird sprite = new FlappyBird();
        sprite.setBounds(0, 0, WIDTH, HEIGHT);
        add(sprite);
        sprite.requestFocusInWindow();
    }
    
}
public class App {
    public static void main(String[] args) throws Exception {
        new GameWindow();
    }
}