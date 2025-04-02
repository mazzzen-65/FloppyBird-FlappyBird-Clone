import javax.swing.*;
import javax.swing.Timer;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
/*
 * to handle the pipes
 * if anyone sees this just know that i messed up the names for the pipe files so bottom is top , top is bottom (how silly)
 */
public class Pipe extends JPanel implements ActionListener{
    int _pipeX = WIDTH;
    int _pipeY = 0;
    int _pipeWidth = 172;
    int _pipeHeight = 512;
    float _pipeVelocity = -4; // move the pipes by 4 frames
    Image pipeImage, pipeImageTop ,pipeImageBottom;
    ArrayList<Pipe> pipes;
    Timer pipeTimeSpawn;
    Timer pipeLoopTimer;
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
        /*
         * Timer to spawn pipes 
         * Every 1.5 seconds a stored pipe in the Array called pipe us placed in the frame
         */
        pipeTimeSpawn = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placePipe();
            }
        });
        pipeTimeSpawn.start();
        
        // A timer to move the pipes
        pipeLoopTimer = new Timer(16, this);
        pipeLoopTimer.start();

    }
    Pipe(Image img){
        // constructor to add the pipe img
        pipeImage = img;
    }

    public void placePipe(){
        /*
         * This method adds a new pipe to the array list.
        * paintComponent will then detect the stored pipes and draw them on the screen.
        */
        Pipe topPipe = new Pipe(pipeImageTop);
        pipes.add(topPipe);
    }

    public void drawPipe(Graphics g){
        /*
         * Draw the Pipes by first instantiate an Object called pipe to get the index at (i) by loop to draw in the screen
         * then keeps drawing but do not store here
         */

        // Draw the bottom pipe
        if (pipeImageTop != null) {
            for (int i = 0 ; i < pipes.size() ; i++){
                Pipe pipe = pipes.get(i);
                g.drawImage(pipeImageTop, pipe._pipeX + 300, pipe._pipeY + 350, _pipeWidth, _pipeHeight,this);
            }
        } else {
            System.out.println("Top pipe image is null!");
        }
    
        // Draw the top pipe
        if (pipeImageBottom != null) {
            for (int i = 0; i < pipes.size(); i++){
                Pipe pipe = pipes.get(i);
                g.drawImage(pipeImageBottom, pipe._pipeX + 300, pipe._pipeY - 350 , _pipeWidth, _pipeHeight, this);
            }
        } else {
            System.out.println("Bottom pipe image is null!");
        }
        }
    
    public void movePipe(){
        /*
         * A move method to take each pipe then move it by adding the velocity to the X Position
         */
        for (int i = 0; i < pipes.size(); i++ ){
            Pipe pipe = pipes.get(i);
            pipe._pipeX += _pipeVelocity;
        }
    }

    
    
    @Override
    protected void paintComponent(Graphics g){
        /*
         * keeps looking at the method draw pipe to check for 2 things (there is pipes drawn , there is pipes stored in the array) so if found -> actually draws in the screen
         */
        super.paintComponent(g);
        drawPipe(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        movePipe();
        repaint();
    }
    
}
