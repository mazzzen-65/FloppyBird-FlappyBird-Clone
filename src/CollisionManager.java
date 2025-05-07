import java.awt.*;
import javax.swing.*;
/*
 * this Class is used to handle all of the Collisions 
 * For Pipes/Bird
 */
public class CollisionManager extends Rectangle {
    
        Pipe pipchekPipe = new Pipe();
        FlappyBird birChekBird = new FlappyBird();
        boolean gameOver = false ;
    
        public void checkCollision() {
            if (birChekBird._birdY == 640) {
                gameOver = true;
                System.out.println("stoped");
            }
        }
    }


