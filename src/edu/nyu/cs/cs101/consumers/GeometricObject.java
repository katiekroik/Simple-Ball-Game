package edu.nyu.cs.cs101.consumers;

import java.util.ArrayList;

/**
 * Base class for various other geometric objects.
 */
public abstract class GeometricObject implements Drawable, Movable {
    double maxSpeed = Driver.STARTING_MAX_SPEED;

    // Instance variables (unique to each object)
    protected double xPos = 0;
    protected double yPos = 0;
    protected double xSpeed = 0;
    protected double ySpeed = 0;

    /**
     * Constructor with arguments
     */
    GeometricObject(int x, int y) {
        xPos = x;
        yPos = y;
    }

    /**
     * Constructor with arguments
     */
    GeometricObject(double x, double y) {
        xPos = x;
        yPos = y;
    }

    /**
     * Copy constructor
     */
    GeometricObject(GeometricObject s) {
        this(s.xPos, s.yPos);
        xSpeed = s.xSpeed;
        ySpeed = s.ySpeed;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof GeometricObject)) {
            return false;
        }
        GeometricObject o = (GeometricObject) object;
        if (this.xPos != o.xPos) {
            return false;
        } else if (this.yPos != o.yPos) {
            return false;
        } else if (this.xSpeed != o.xSpeed) {
            return false;
        } else if (this.ySpeed != o.ySpeed) {
            return false;
        }
        return true;
    }

    /**
     * Finds the ball closest to <code>ball</code>.
     * 
     * @param object to find the closest to
     * @param objects to compare distances
     * @return the ball in balls that is closest to <code>ball</code>.
     */
    public static GeometricObject getClosest(GeometricObject object,
            ArrayList<GeometricObject> objects) {
        GeometricObject closestParticle = null;
        double shortestDistance = -1;

        // Get the first non-null Ball
        for (GeometricObject otherParticle : objects) {
            if ((otherParticle != null) && (otherParticle != object)) {
                if (shortestDistance == -1) {
                    closestParticle = otherParticle;
                    shortestDistance = distance(object, closestParticle);
                    continue;
                }
                double distance = distance(object, otherParticle);
                if (distance < shortestDistance) {
                    closestParticle = otherParticle;
                    shortestDistance = distance(object, closestParticle);
                }
            }
        }

        return closestParticle;
    }

    /**
     * Calculates the distance between two particles.
     * 
     * @param object1 the first object
     * @param object2 the other object
     * @return distance between two particles.
     */
    public static double distance(GeometricObject object1, GeometricObject object2) {
        // sqrt of ((change in X squared) + (change in Y squared))
        double deltaX = object1.xPos - object2.xPos;
        double deltaY = object1.yPos - object2.yPos;
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    @Override
    public String toString() {
        return "Object @(" + xPos + "," + yPos + ") with velocity (" + xSpeed + "," + ySpeed + ")";
    }

    double getX() {
        return xPos;
    }

    double getY() {
        return yPos;
    }

    @Override
    public void reverse() {
        xSpeed = -xSpeed;
        ySpeed = -ySpeed;
    }

    @Override
    public void reverseY() {
        ySpeed = -ySpeed;
    }

    @Override
    public void reverseX() {
        xSpeed = -xSpeed;
    }

    @Override
    public void move() {
        xPos += xSpeed;
        yPos += ySpeed;
    }

    @Override
    public void setSpeed(double xSpeed, double ySpeed) {
        setXSpeed(xSpeed);
        setYSpeed(ySpeed);
    }

    @Override
    public void setXSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    @Override
    public void setYSpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    @Override
    public void setPos(double x, double y) {
        xPos = x;
        yPos = y;
    }

    @Override
    public int getXSpeed() {
        return (int) xPos;
    }

    @Override
    public int getYSpeed() {
        // TODO Auto-generated method stub
        return (int) yPos;
    }

    @Override
    public void accelerate(double xPos, double yPos) {
        double deltaX = xPos - this.xPos;
        double deltaY = yPos - this.yPos;
        double total = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        xSpeed += deltaX / total;
        ySpeed += deltaY / total;
        if (xSpeed > maxSpeed)
            xSpeed = maxSpeed;
        if (xSpeed < -maxSpeed)
            xSpeed = -maxSpeed;
        if (ySpeed > maxSpeed)
            ySpeed = maxSpeed;
        if (ySpeed < -maxSpeed)
            ySpeed = -maxSpeed;
    }

    @Override
    public void decelerate(double xPos, double yPos) {
        double deltaX = xPos - this.xPos;
        double deltaY = yPos - this.yPos;
        double total = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        xSpeed -= deltaX / total;
        ySpeed -= deltaY / total;
        if (xSpeed > maxSpeed)
            xSpeed = maxSpeed;
        if (xSpeed < -maxSpeed)
            xSpeed = -maxSpeed;
        if (ySpeed > maxSpeed)
            ySpeed = maxSpeed;
        if (ySpeed < -maxSpeed)
            ySpeed = -maxSpeed;
    }

    abstract double getArea();

}
