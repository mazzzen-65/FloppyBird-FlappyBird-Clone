import java.awt.*;

import javax.swing.*;

public class CollisionManager extends Rectangle {
    JLabel groundImg;
    JPanel ground;
    CollisionManager(){
    groundImg = new JLabel(new ImageIcon("assets/ground.png"));
    ground.add(groundImg);
    }
    
}
