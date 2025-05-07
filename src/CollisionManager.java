import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CollisionManager {
    Pipe pipchekPipe;
    FlappyBird birChekBird;
    Background bgCheck;
    boolean gameOver = false;
    Timer collisionTimer;

    public CollisionManager(Pipe pipe, FlappyBird bird, Background background) {
        this.birChekBird = bird;
        this.pipchekPipe = pipe;
        this.bgCheck = background;
        
        collisionTimer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkCollision();
                
            }
        });
    
        collisionTimer.start();  
    }

    public void checkCollision() {
        Rectangle birdRect = new Rectangle(40, (int) birChekBird._birdY, 50, 50);

        for (Pipe pipe : pipchekPipe.pipes) {
            Rectangle pipeRect = new Rectangle(pipe._pipeX + 350, pipe._totY, pipe._pipeWidth, pipe._pipeHeight);
            if (birdRect.intersects(pipeRect)) {
                handleGameOver();
                return;
            }
        }

        if (birChekBird._birdY >= 620) {
            handleGameOver();
        }
    }
    
    private void handleGameOver() {
        if (!gameOver) {
            gameOver = true;
            birChekBird.pause();
            pipchekPipe.pause();
            bgCheck.pauseMusic();
            collisionTimer.stop();
            JOptionPane.showMessageDialog(null, "GAME OVER", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);  
        }
    }
}