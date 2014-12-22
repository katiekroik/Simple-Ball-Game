package edu.nyu.cs.cs101.consumers;

import java.util.ArrayList;

/**
 * A <code>ConsumingBall</code> is a <code>Ball</code> that is always
 * accelerating in the direction of the closest ball. In other words, it is
 * attempting to consume the closest ball (regardless if that ball is bigger or
 * smaller than it).
 *  * 
 * TODO: Complete the accelerate method
 * 
 * @author Katie Kroik
 */
public class ConsumingBall extends ExpandableBall {

    /**
     * Constructor with arguments
     * 
     * @param xPos location for this <code>Ball</code>
     * @param yPos location for this <code>Ball</code>
     */
    public ConsumingBall(int xPos, int yPos) {
        super(xPos, yPos);
        // Sets the color to red
        this.setColor(255, 0, 0);

    }

    @Override
    public String toString() {
        return super.toString() + " is a Consuming Ball";
    }

    /**
     * Consuming balls always accelerate towards the closest ball.
     * 
     * @param objects list of balls that it may want to try and consume
     */
    void accelerate(ArrayList<GeometricObject> objects) {
    	
    	for (GeometricObject cBall : objects ) {
    		// If the object is a Consuming ball
    		if (cBall instanceof ConsumingBall){
    			
    			// Gets the closest object to the consuming ball
    	        GeometricObject closestObject = super.getClosest(cBall, objects);
    	        
    	        // Accelerate towards the closest ball, regardless if bigger or not.
    	        cBall.accelerate(closestObject.getX(), closestObject.getY());
    		}
    	}
    }
}
