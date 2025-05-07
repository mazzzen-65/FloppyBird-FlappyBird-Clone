import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CollisionManager {
    Pipe pipchekPipe;
    FlappyBird birChekBird;
    boolean gameOver = false;

    public CollisionManager(Pipe pipe, FlappyBird bird) {
        this.birChekBird = bird;
        this.pipchekPipe = pipe;
        Timer collisionTimer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkCollision();
            }
        });
    
        collisionTimer.start();  
    }

    public void checkCollision() {
        System.out.println("check is ");
        Rectangle birdRect = new Rectangle(40, (int) birChekBird._birdY, 50, 50);

        for (Pipe pipe : pipchekPipe.pipes) {
            Rectangle pipeRect = new Rectangle(pipe._pipeX + 300, pipe._totY, pipe._pipeWidth, pipe._pipeHeight);
            if (birdRect.intersects(pipeRect)) {
                gameOver = true;
                System.out.println("pipe ");
                return;
            }
        }

        if (birChekBird._birdY >= 640) {
            gameOver = true;
            System.out.println("bird");
        }
    }
}
