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
    float _pipeVelocity = -4; // move the pipes by 4 frames
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
        
        //Array to store the pipes into
        pipes = new ArrayList<>();
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
        //method to place the pipes (bottom , top)
        Pipe topPipe = new Pipe(pipeImageTop);
        pipes.add(topPipe);
        System.out.println("placed");
    }

    public void drawPipe(Graphics g){
        // Draw the bottom pipe
        if (pipeImageTop != null) {
            for (int i = 0 ; i < pipes.size() ; i++){
                Pipe pipe = pipes.get(i);
                g.drawImage(pipeImageTop, pipe._pipeX + 180, pipe._pipeY + 300, _pipeWidth, _pipeHeight,this);
            }
        } else {
            System.out.println("Top pipe image is null!");
        }
    
        // Draw the top pipe
        if (pipeImageBottom != null) {
            for (int i = 0; i < pipes.size(); i++){
                Pipe pipe = pipes.get(i);
                g.drawImage(pipeImageBottom, pipe._pipeX + 180, pipe._pipeY - 300 , _pipeWidth, _pipeHeight, this);
            }
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
