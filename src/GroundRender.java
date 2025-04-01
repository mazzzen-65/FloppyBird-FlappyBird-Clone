import java.awt.*;
import javax.swing.*;

/*
 * A class to Handle the Ground Rendering 
*/

public class GroundRender extends JPanel {
    Image _grdTexture;
    public GroundRender(){
        _grdTexture = new ImageIcon("assets/ground.png").getImage();
        setOpaque(true);
    }
    
    public void groundDraw(Graphics g){
        g.drawImage(_grdTexture, 0, 440, 340,50,this);
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        groundDraw(g);
    }    
}
