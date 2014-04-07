import java.awt.Color;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numBolas)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        ArrayList<BouncingBall> bolas = new ArrayList<>();

        // crate and show the balls

        for (int i=0; i<numBolas; i++){
            Random aleatorio = new Random();
            int radio = aleatorio.nextInt(100);
            int red = aleatorio.nextInt(256);
            int green = aleatorio.nextInt(256);
            int blue = aleatorio.nextInt(256);
            int x = aleatorio.nextInt(240);
            int y = aleatorio.nextInt(400);
            BouncingBall ball = new BouncingBall(x,y , radio, new Color(blue, red , green), ground, myCanvas);
     
            bolas.add(ball);
            ball.draw();
        }
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(BouncingBall bola : bolas)
            {
                bola.move();
                // stop once ball has travelled a certain distance on x axis
                if(bola.getXPosition() >= 550) {

                    finished = true;
                }
            }
        }

    }
}
