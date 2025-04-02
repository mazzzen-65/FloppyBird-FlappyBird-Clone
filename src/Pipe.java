import javax.swing.*;
import javax.swing.Timer;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
/*
 * to handle the pipes
 * if anyone sees this just know that i messed up the names for the pipe so bottom = top , top = bottom (how silly)
 */
public class Pipe extends JPanel{
    int _pipeX = WIDTH;
    int _pipeY = 0;
    int _pipeWidth = 172;
    int _pipeHeight = 512;
    Image pipeImage, pipeImageTop ,pipeImageBottom;
    ArrayList<Pipe> pipes;
    Timer pipeTime;
    public Pipe(){
        /*
         * Constructor to render and handle placment or the timer for the pipes
         */

         //load pipe images
        pipeImageTop = new ImageIcon("assets/toppipe.png").getImage();
        pipeImageBottom = new ImageIcon("assets/bottompipe.png").getImage();
        setOpaque(false);
        
        //timer to spawn pipes
        pipeTime = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placePipe();
            }
        });
        pipeTime.start();
        

    }
    Pipe(Image img){
        // constructor to add the pipe img
        pipeImage = img;
    }

    public void placePipe(){
        //method to place the pipes
        Pipe topPipe = new Pipe(pipeImageTop);
        add(topPipe);
    }

    public void drawPipe(Graphics g){
    // Draw the bottom pipe
    if (pipeImageTop != null) {
        g.drawImage(pipeImageTop, _pipeX + 180, _pipeY + 300, _pipeWidth, _pipeHeight, this);
    } else {
        System.out.println("Top pipe image is null!");
    }

    // Draw the top pipe
    if (pipeImageBottom != null) {
        g.drawImage(pipeImageBottom, _pipeX + 180, _pipeY - 300 , _pipeWidth, _pipeHeight, this);
    } else {
        System.out.println("Bottom pipe image is null!");
    }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        drawPipe(g);
    }
    
}
