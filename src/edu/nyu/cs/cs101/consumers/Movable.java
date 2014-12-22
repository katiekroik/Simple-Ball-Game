package edu.nyu.cs.cs101.consumers;
public interface Movable {
    int getXSpeed();
    int getYSpeed();    
    void setSpeed(double xSpeed, double ySpeed);
    void setXSpeed(double speed);
    void setYSpeed(double speed);
    void move();
    void reverseX();
    void reverseY();
    void reverse();
    void setPos(double x, double y);

    /**
     * Accelerate towards a given location
     * 
     * @param xPos the x location to accelerate towards
     * @param yPos the y location to accelerate towards
     */
    void accelerate(double xPos, double yPos);

    /**
     * Accelerate away from a given location
     * 
     * @param xPos the x location to accelerate away from
     * @param yPos the y location to accelerate away from
     */
    void decelerate(double xPos, double yPos);

}
