package edu.nyu.cs.cs101.consumers;

import java.util.ArrayList;


/**
 * An <code>EvadignBall</code> is a <code>Ball</code> that is always trying to
 * move in the direction away from the nearest ball to it.
 */

public class EvadingBall extends ExpandableBall  {
	
    /**
     * Constructor with arguments
     * 
     * @param xPos location for this <code>Ball</code>
     * @param yPos location for this <code>Ball</code>
     */
	
    public EvadingBall(int xPos, int yPos) {
        super(xPos, yPos);
        // Set color to green
        this.setColor(0, 255, 50);
    }
    
    @Override
    public String toString() {
        return super.toString() + " is an Evading Ball";
    }

    /**
     * Always accelerates away from the closest ball.
     * @param objects list of balls that it may want to try and evade
     */
    void accelerate(ArrayList<GeometricObject> objects) {  
    	for (GeometricObject eBall : objects ) {
    		// Finds if the eBall is an EvadingBall
    		if (eBall instanceof EvadingBall) {	
    			
    			// Finds closest object to that object
    	        GeometricObject closestObject = super.getClosest(eBall, objects);
    	        
    	        // Move away from the closest object
    	        eBall.decelerate(closestObject.getX(), closestObject.getY());
    		}
    	}
    }
}
