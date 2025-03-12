import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*; 
import java.util.ArrayList; 
import java.util.random.*;

public class FlappyBird extends JPanel {
    int _birdY = 320;
    float _velocity = 0.5f;
    float _gravity = 0.8f;
    
    
    public void birdGraphics(Graphics g){  //Control The Bird Graphics
       Graphics2D g2d = (Graphics2D) g;  
       g2d.setColor(Color.red);
       g2d.fillOval(100, _birdY, 100,100);    
    }

    @Override
    protected void paintComponent(Graphics g) {  // Delete the Old Bird sprite To display the new one 
        super.paintComponent(g);
        birdGraphics(g);
    }
    
    
}