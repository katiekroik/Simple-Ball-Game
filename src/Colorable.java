package edu.nyu.cs.cs101.consumers;
/**
 * The colorable interface guarantees that an object will have color related attributes that can be
 * accessed using the following getter/setter methods.
 * 
 * @author Andrew Case <acase@cs.nyu.edu>
 * 
 */
public interface Colorable {
    /**
     * @return the red color component for this object (a value between 0 - 255)
     */
    int getRed();

    /**
     * @return the green color component for this object (a value between 0 - 255)
     */
    int getGreen();

    /**
     * @return the blue color component for this object (a value between 0 - 255)
     */
    int getBlue();
    /**
     * @param grayscale is the value to set all three color components to (valid values are between
     *        0-255). For example, if a user passes in the value 128, it will set the red, green,
     *        and blue components all to 128.
     */
    void setColor(int grayscale);

    /**
     * @param r is the red component for this objects color. Valid values are from 0-255.
     * @param g is the green component for this objects color. Valid values are from 0-255.
     * @param b is the blue component for this objects color. Valid values are from 0-255.
     */
    void setColor(int r, int g, int b);

}
