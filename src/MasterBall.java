package edu.nyu.cs.cs101.consumers;

import java.util.ArrayList;

/**
 * Master Ball : a ball that is stationary that shrinks any ball that touches it to a tiny size.
 * @author Katie Kroik
 *
 */
public class MasterBall extends ExpandableBall {

	MasterBall(int x, int y) {
		super(x, y);
		this.setColor(200, 102, 0);
	}
	
    /**
     * Accelerates towards larger balls around it.
     */
    void accelerate(ArrayList<GeometricObject> objects) {
    	// loops all the objects
    	for (GeometricObject mBall : objects ) {
    		
    		// Checks if they are a Master Ball
    		if (mBall instanceof MasterBall){
    			// Finds the closest object
    	        GeometricObject closestObject = super.getClosest(mBall, objects); 
    	        
    	        // If the closestObject is larger
    	        if (closestObject.getArea() > mBall.getArea()) {
    	        	
        	        // Move towards the larger object
    	        	mBall.accelerate(closestObject.getX(), closestObject.getY());

    	        }
    		}
    	}
    }
}
