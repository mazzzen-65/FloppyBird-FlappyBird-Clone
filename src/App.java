import javax.swing.*;
/*
 * The main Frame for the Game
 */
class GameWindow extends JFrame {
    int WIDTH = 340;
    int HEIGHT = 800;
    public GameWindow(){
        setTitle("Floppy Bird");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a JLayeredPane for layering components
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, WIDTH, HEIGHT);
        add(layeredPane);
        
        // Render the Bird Sprite
        ImageIcon icon = new ImageIcon("assets/bird_sprite.png");
        setIconImage(icon.getImage());

        // Add BackGround
        Background background = new Background();
        background.setBounds(0, 0, WIDTH, HEIGHT);
        layeredPane.add(background, Integer.valueOf(0)); // Add to the bottom layer


        // Add Bird Sprite
        FlappyBird sprite = new FlappyBird();
        sprite.setBounds(0, 0, WIDTH, HEIGHT);
        layeredPane.add(sprite, Integer.valueOf(1)); // Add above the background
        sprite.requestFocusInWindow();


        // Add Ground
        GroundRender ground = new GroundRender();
        ground.setBounds(0, 640, WIDTH, 50);
        layeredPane.add(ground, Integer.valueOf(2)); // Add above the bird sprite

        setVisible(true);
    }
    
}
public class App {
    public static void main(String[] args) throws Exception {
        new GameWindow();
    }
}