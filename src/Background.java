import javax.swing.*;

public class Background extends JPanel {
    Background(){
        JLabel background = new JLabel(new ImageIcon("assets/background.png"));
        add(background);
    }
}