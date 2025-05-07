import javax.sound.sampled.*;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;
import java.io.File;

public class FlappyBird extends JPanel implements KeyListener {
    float _birdY = 320;
    float _velocityY = 2.2f;  // to move the bird (up/down)
    float _gravity = 0.8f;    // to affect velocity like real world
    Image spriIcon;
    
    // Added a boolean flag to check if game is over
    private boolean isGameOver = false;
    
    // Timer is now a class member to access in pause() and resume()
    Timer t;

    public FlappyBird(){
        addKeyListener(this);
        setFocusable(true); 
        requestFocusInWindow();  // make the panel focused from keyboard
        setOpaque(false);
        spriIcon = new ImageIcon("assets/bird_sprite.png").getImage();
        
        t = new Timer(12, new ActionListener() {  
            /*
             * the timer is adjusted to run the updateBird Method every 12 ms (or ~83 FPS)
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBird();
            }
        });
        t.start();
    }
    
    public void birdGraphics(Graphics g){  // Control The Bird Graphics
        if (spriIcon != null) {
            g.drawImage(spriIcon, 40, (int) _birdY, 50, 50, this);
        } else {
            System.out.println("Sprite image is null!");
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {  // Delete the Old Bird sprite to display the new one 
        super.paintComponent(g);
        birdGraphics(g);
    }

    public void updateBird(){
        /*
         * the physics for the bird where velocity is affected by gravity, 
         * then the bird's vertical position is affected by velocity to make the movement 
         * as close to real world gravity
         */
        _velocityY += _gravity;
        _birdY += _velocityY;
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) { // to make the player control the bird
        // Check if game is over, if yes, don't react to space bar
        if (isGameOver) {
            return; // Exit the method early if game is over
        }
        
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                _velocityY = -11.0f;
                
                // a sound effect to play every time the player presses the Space Bar
                try {
                    AudioInputStream audio = AudioSystem.getAudioInputStream(new File("assets/jump.wav"));
                    Clip clip = AudioSystem.getClip(); // CLip to run the audio
                    clip.open(audio);
                    clip.start();
                }
                catch (Exception ee){
                    JOptionPane.showMessageDialog(null,"Error in music assets");
                }
                break;
        
            default:
                break;
        }
    }

    // Pause the bird's movement and set game over flag
    public void pause() {
        if (t != null) {
            t.stop();
            isGameOver = true; // Set game over flag to true when paused
        }
    }
    
    // Resume the bird's movement and reset game over flag
    public void resume() {
        if (t != null) {
            isGameOver = false; // Reset game over flag
            t.start();
        }
    }
    
    // Add a method to check if game is over (useful for other classes)
    public boolean isGameOver() {
        return isGameOver;
    }
    
    // Add a method to set game over status (useful for other classes)
    public void setGameOver(boolean status) {
        isGameOver = status;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {/*..*/}
    @Override
    public void keyReleased(KeyEvent e) {/*..*/}
}