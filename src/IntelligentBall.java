package edu.nyu.cs.cs101.consumers;

import java.util.ArrayList;

/**
 * An intelligent ball is a <code>Ball</code> that:
 * <ol>
 * <li>Tries to accelerate towards smaller balls that are near it (to consume
 * them)
 * <li>Tries to accelerate away from larger balls that are near it (to evade
 * them)
 * </ol>
 *  
 *  @author : Katie Kroik
 * TODO: Write this entire class.
 * 
 */
public class IntelligentBall extends ExpandableBall {
    /**
     * Constructor with arguments
     * 
     * @param xPos location for this Ball
     * @param yPos location for this Ball
     */
    public IntelligentBall(int xPos, int yPos) {
        super(xPos, yPos);
        this.setColor(0, 0, 255);
    }
    
    @Override
    public String toString() {
        return super.toString() + " is an Intelligent ball";
    }
    
    /**
     * Tries to accelerate towards smaller balls that are near it
     */
    void accelerate(ArrayList<GeometricObject> objects) {
    	// loops all the objects
    	for (GeometricObject iBall : objects ) {
    		// Checks if they are an Intellegent ball
    		if (iBall instanceof IntelligentBall){
    			// Finds the closest object
    	        GeometricObject closestObject = super.getClosest(iBall, objects);
    	        
    	        if (closestObject.getArea() >= iBall.getArea()) {
        	        // Move away from the closest object, since it is bigger
    	        	iBall.decelerate(closestObject.getX(), closestObject.getY());
    	        }
    	        else if (closestObject.getArea() < iBall.getArea()) {
    	        	iBall.accelerate(closestObject.getX(), closestObject.getY());
    	        }
    		}
    	}
    }
}
