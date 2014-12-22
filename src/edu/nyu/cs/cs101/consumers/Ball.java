package edu.nyu.cs.cs101.consumers;

import processing.core.PApplet;

/**
 * The Ball class is based on a generic <code>GeometricObject</code> and has
 * agreed to implement the <code>Colorable</code> and <code>Drawable</code>
 * interfaces so that code using the <code>Ball</code> class can check if it's
 * an instance of those interfaces and be sure that those methods are defined.
 * 
 * TODO: I have implemented the Drawable methods for you. Your job is to
 * implement the Colorable methods.
 * 
 * TODO: Implement any abstract methods from the base class (GeometricObject)
 * 
 * @author Katie Kroik
 */
public class Ball extends GeometricObject implements Colorable {

    /**
     * Checks if a collision occurred between two <code>Ball</code> objects.
     * 
     * @param ball1 Ball to check
     * @param ball2 Ball to check
     * @return true if ball1 and ball2 are overlapping; otherwise false
     */
    public static boolean isCollision(Ball ball1, Ball ball2) {
        // No collision if either ball doesn't exist
        if ((ball1 == null) || (ball2 == null) || (ball1 == ball2)) {
            return false;
        }

        // No collision if they are too far apart
        if (Ball.distance(ball1, ball2) > (ball1.radius + ball2.radius)) {
            return false;
        }

        return true;
    }

    // Size of this ball
    protected double radius = 10.0;

    // Colorable attributes associated with this object
    protected int red = 0;
    protected int green = 0;
    protected int blue = 0;


    /**
     * Constructor with arguments
     * 
     * @param x location for this Ball
     * @param y location for this Ball
     */
    Ball(int x, int y) {
        super(x, y);
    }

    /**
     * Constructor with arguments
     * 
     * @param x location for this Ball
     * @param y location for this Ball
     * @param radius for the ball
     */
    Ball(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    /**
     * Copy constructor - creates a new copy of Ball b.
     */
    Ball(Ball b) {
        super(b);
        this.radius = b.radius;
    }

    /**
     * Checks if two objects ('this' object and Ball b) are equivalent (have the
     * same data).
     * 
     * @param b ball to compare this object to
     * @return true if <code>b</code> is equivalent to this object, otherwise
     *         false
     */
    public boolean equals(Ball b) {
        // this line would check to see if two objects are the same object
        // return super.equals(b);

        // Instead we're checking if the data is equivalent
        if (!super.equals(b))
            return false;
        if (this.radius != b.radius)
            return false;

        // If none of the data differs, everything is equivalent
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " is a ball with radius=" + radius;
    }

    /**
     * @return the radius of this ball
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @param radius to set the ball to
     */
    public void setRadius(double radius) {
        if (radius >= 0) {
            this.radius = radius;
        }
    }

    @Override
    public void draw(PApplet applet) {
        
        if (applet == null)
            return;
        
        applet.fill(red, green, blue);
        applet.ellipse((float) xPos, (float) yPos, (float) (radius * 2), (float) (radius * 2));
    }

	@Override
	public int getRed() {
		return red;
	}

	@Override
	public int getGreen() {
		return green;
	}

	@Override
	public int getBlue() {
		return blue;
	}

	@Override
	public void setColor(int grayscale) {
		red = grayscale;
		green = grayscale;
		blue = grayscale;
	}

	@Override
	public void setColor(int r, int g, int b) {
		red = r;
		green = g;
		blue = b;	
	}

	@Override
	double getArea() {
		return Math.PI*radius*radius;
	}   
}