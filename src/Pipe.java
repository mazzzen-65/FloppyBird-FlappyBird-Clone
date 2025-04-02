import javax.swing.*;
import javax.swing.Timer;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
/*
 * to handle the pipes
 * if anyone sees this just know that i messed up the names for the pipe files
 * so bottom is top , top is bottom (how silly)
 */
public class Pipe extends JPanel implements ActionListener{
    int _pipeX = WIDTH;
    int _pipeY = 0;
    int _totY = _pipeY;
    int _pipeWidth = 152;
    int _pipeHeight = 512;
    float _pipeVelocity = -4; // move the pipes by 4 frames
    Image pipeImage, pipeImageTop ,pipeImageBottom;
    ArrayList<Pipe> pipes;
    Timer pipeTimeSpawn;
    Timer pipeLoopTimer;
    boolean isTopPipe = false;
    Random random = new Random();
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
    Pipe(Image img, boolean isTop){
        // constructor to add the pipe img ,check if the top pipe
        pipeImage = img;
        isTopPipe = isTop;
    }

    public void placePipe(){
        /*
         * This method adds a new pipe to the array list.
         * paintComponent will then detect the stored pipes and draw them on the screen.
         * shift the pos by (pipeY and pipeHeight/24 and a num between [0,1] multiplied be (pipeHeight/2))
         * passing the arg isTop to check if it is the top pipe or not to prevent intersecting (not nessecary but    because i really messed up the nameing of the files and i'm lazy to just rename them)
        */
        int randY = (int) (_pipeY -_pipeHeight/24 - Math.random()*_pipeHeight/2);
        int gap = 150;
        Pipe topPipe = new Pipe(pipeImageTop , false); //bottom
        topPipe._totY = randY + _pipeHeight + gap;
        pipes.add(topPipe);
        Pipe bottPipe = new Pipe(pipeImageBottom , true); //top
        bottPipe._totY = randY;
        pipes.add(bottPipe);
    }

    public void drawPipe(Graphics g){
        /*
         * Draw the Pipes by first instantiate an Object called pipe to get the index at (i) by loop to draw in the screen
         * then keeps drawing but do not store here
         * we draw the pipes together by calling the pipeImage which has the Top and the Bottom Image
         */

        // Draw both pipes
        for (int i = 0 ; i < pipes.size() ; i++){
            Pipe pipe = pipes.get(i);
        if (pipe.pipeImage != null) {
                g.drawImage(pipe.pipeImage, pipe._pipeX + 300, pipe._totY, _pipeWidth, _pipeHeight,this);
            }
        else {
            System.out.println("Top pipe image is null!");   
        }
    }
    }
        
    
    public void movePipe(){
        /*
         * A move method to take each pipe then move it by adding the velocity to the X Position
         * if statment to remove any pipe that is < the origin point
         */
        for (int i = 0; i < pipes.size(); i++ ){
            Pipe pipe = pipes.get(i);
            pipe._pipeX += _pipeVelocity;
            if (pipe._pipeX < -395){
                pipes.remove(i);
                i--;
            }
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
