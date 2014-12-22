package edu.nyu.cs.cs101.consumers;

import processing.core.PApplet;

/**
 * Classes that are "Drawable" mean that they can be drawn using a processing PApplet object that
 * has been already instantiated with a valid canvas to draw on.  Drawable objects can call any of the
 * methods associated with processing in order to draw their object to the canvas.
 * 
 * @author Andrew Case <acase@cs.nyu.edu>
 * 
 */
public interface Drawable {
    /**
     * Draws this object using the Processing applet associated with it.
     */
    void draw(PApplet applet);
}
