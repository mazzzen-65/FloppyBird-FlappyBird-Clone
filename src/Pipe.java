import javax.swing.*;
import javax.swing.Timer;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
/*
 * to handle the pipes
 */
public class Pipe extends JPanel{
    int _pipeX = WIDTH;
    int _pipeY = 0;
    int _pipeWidth = 64;
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
    // Draw the top pipe
    if (pipeImageTop != null) {
        g.drawImage(pipeImageTop, _pipeX, _pipeY, _pipeWidth, _pipeHeight, this);
    } else {
        System.out.println("Top pipe image is null!");
    }

    // Draw the bottom pipe
    if (pipeImageBottom != null) {
        g.drawImage(pipeImageBottom, _pipeX, _pipeY + 600, _pipeWidth, _pipeHeight, this); // Adjust Y position for bottom pipe
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
