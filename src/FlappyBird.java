import javax.sound.sampled.*;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;
import java.io.File; 
public class FlappyBird extends JPanel implements KeyListener {
    float _birdY = 320;
    float _velocityY = 3.2f;  //to move the bird (up/down)
    float _gravity = 0.8f;   //to affect velocity like real world
    Image spriIcon;
    
    public FlappyBird(){
        addKeyListener(this);
        setFocusable(true); 
        requestFocusInWindow();  //make the panal be focused on from keyboard
        setOpaque(false);
        spriIcon = new ImageIcon("assets/bird_sprite.png").getImage();
        
        Timer t = new Timer(12, new ActionListener() {  
            /*
             * the timer is adjusted to run the updateBird Method each 16 ms (or 60 FPS)
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBird();
            };
        });
        t.start();
    }
    
    public void birdGraphics(Graphics g){  //Control The Bird Graphics
        if (spriIcon != null) {
            g.drawImage(spriIcon, 40, (int) _birdY, 50, 50, this);
        } else {
            System.out.println("Sprite image is null!");
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {  // Delete the Old Bird sprite To display the new one 
        super.paintComponent(g);
        birdGraphics(g);
    }


    public void updateBird(){
        /*
         * the physics for the bird where velocity is affected by gravity then the bird vertical postion is affected 
         * by velocity to make the movement as close as real world gravity
         */
        _velocityY += _gravity;
        _birdY += _velocityY;
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) { //to make the player control the bird
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                _velocityY = -11.0f;
                
                // a sound effect to play every time the player press Space Bar
                try {
                AudioInputStream audio = AudioSystem.getAudioInputStream(new File("assets/jump.wav"));
                Clip clip = AudioSystem.getClip(); //CLip to run the audio
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

    @Override
    public void keyTyped(KeyEvent e) {/*..*/}
    @Override
    public void keyReleased(KeyEvent e) {/*..*/}
    
}