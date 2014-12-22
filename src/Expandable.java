package edu.nyu.cs.cs101.consumers;

/**
 * Some objects can grow or shrink at a specific rate. Classes that implement this interface are
 * guaranteed to be able to grow and shrink.
 * 
 * @author acase@cs.nyu.edu
 * 
 */
public interface Expandable {
    /**
     * Causes an object to grow in size
     */
    void grow();

    /**
     * Causes an object to shrink in size
     */
    void shrink();
}
