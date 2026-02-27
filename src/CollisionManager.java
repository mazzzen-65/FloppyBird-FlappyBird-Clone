import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CollisionManager {
    Pipe pipchekPipe;
    FlappyBird birChekBird;
    Background bgCheck;
    boolean gameOver = false;
    Timer collisionTimer;

    public CollisionManager(Pipe pipe, FlappyBird bird, Background background) { //linking the elements to the collision manager class
        this.birChekBird = bird;
        this.pipchekPipe = pipe;
        this.bgCheck = background;
        
        collisionTimer = new Timer(10, new ActionListener() { // a timer to constantly check for the collision
            @Override
            public void actionPerformed(ActionEvent e) {
                checkCollision();
                
            }
        });
    
        collisionTimer.start();  
    }

    public void checkCollision() { 
        /*
         * using the rectangle class we first draw an illusinary rectangle around the bird 
         * a for loop to draw a rectangle around each pipe 
         * then using the intersects function if the bird intersects with the pipe 
         * we run the handleGameOver function
         */
        Rectangle birdRect = new Rectangle(40, (int) birChekBird._birdY, 50, 50);

        for (Pipe pipe : pipchekPipe.pipes) {  //for loop to handle each pipe respectvly 
            Rectangle pipeRect = new Rectangle(pipe._pipeX + 350, pipe._totY, pipe._pipeWidth, pipe._pipeHeight);
            if (birdRect.intersects(pipeRect)) {
                handleGameOver();
                return;
            }
        }

        if (birChekBird._birdY >= 620 || birChekBird._birdY <= -70 ) {     
            handleGameOver();
        }
    }
    
    private void handleGameOver() { // a gameOver Logic
        if (!gameOver) {
            gameOver = true;
            birChekBird.pause();
            pipchekPipe.pause();
            bgCheck.pauseMusic();
            collisionTimer.stop();
            JOptionPane.showMessageDialog(null, "خسرت", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);  
        }
    }
}