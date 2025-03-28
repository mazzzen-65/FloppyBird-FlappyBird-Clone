import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*; 
import java.util.ArrayList; 
import java.util.random.*;

public class FlappyBird extends JPanel implements KeyListener {
    float _birdY = 320;
    float _velocity = 4.2f;
    float _gravity = 0.8f;
    Image spriIcon;
    
    public FlappyBird(){
        addKeyListener(this);
        setFocusable(true); 
        requestFocusInWindow();  //make the panal be focused on from keyboard
        setOpaque(false);
        spriIcon = new ImageIcon("assets/bird_sprite.png").getImage();
        
        Timer t = new Timer(16, new ActionListener() {
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


    public void updateBird(){  //bird physics
        _velocity += _gravity;
        _birdY += _velocity;
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) { //to make the player control the bird (type for a single press)
        switch (e.getKeyChar()) {
            case 'w':
                _velocity = -8.0f;
                break;
        
            default:
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {/*..*/}
    @Override
    public void keyReleased(KeyEvent e) {/*..*/}
    
}