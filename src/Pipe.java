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
    Pipe(){
        /*
         * Constructor to render and handle placment or the timer for the pipes
         */

         //load pipe images
        Image pipeImageTop = new ImageIcon("assets/toppipe.png").getImage();
        Image pipeImageBottom = new ImageIcon("assets/bottompipe.png").getImage();
        
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
    
    }
    
}
