/*
 *  CSC-223 FA 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: 
 *  Description: 
 */

package set;
import java.util.Iterator;
/**
 * Programmed by: Quang Bui
 * Due Date: 
 * Description: 
 */
//********************************************************************
//  SetADT.java       Authors:  Lewis/Chase
//
//  Defines the interface to a set collection.
//********************************************************************

public interface SetADT<T> extends Iterable<T> {

    /**
     * Adds one element to this set, ignoring duplicates. 
     * @param element the element will be added
     */
    public void add(T element);
    
    /**
     * Adds all elements in the specified Collection to the Set 
     * @param set contains the elements will be added to the
     * original set.
     */
    public void addAll(SetADT<T> set);

    /**
     * Removes all of the elements from this set
     */
    public void clear();

    /**
     * Removes and returns a random element from this set. 
     */
    public T removeRandom();

    /** 
     * Removes and returns the specified element from this set. 
     * @param element the element will be removed
     */
    public T remove(T element);

    /** 
     * Removes from this set all the elements of the specified set. 
     * Returns true if this set has been modified as a result of this 
     * method call.
     * @param set the set contains the element will be removed
     */
    public boolean removeAll(SetADT<T> set);

    /**  
     * Returns the union of this set and the parameter 
     * @param set the set contains the element will be union
     * to the original set
     */
    public SetADT<T> union(SetADT<T> set);

    /**  
     * Returns true if this set contains the parameter
     * @param target the target need to check does it exist in the set
     */
    public boolean contains(T target);

    /**  
     * Returns true if this set and the parameter contain exactly
     * the same elements 
     * @param set the set contains the element will be compare
     * exactly to the original set
     */
    public boolean equals(SetADT<T> set);

    /**  
     * Returns true if this set contains all the elements 
     * of the specified collection 
     * @param set the set contains the element will be contained
     * in the set
     */
    public boolean containsAll(SetADT<T> set);

    /**  
     * Returns a new set which is the intersection of this set 
     * and the parameter set. 
     * @param set the set contains the element will be intersect
     * to the original set
     */
    public SetADT<T> intersection(SetADT<T> set);

    /** 
     * Retains only those elements in this set that 
     * are contained in the specified set.
     * Returns true if this set has been modified 
     * as a result of this method call.
     * @param set the set contains the element will be retained
     */
    public boolean retainAll(SetADT<T> set);

    /**  
     * Returns true if this set contains no elements 
     */
    public boolean isEmpty();

    /**  
     * Returns the number of elements in this set 
     */
    public int size();

    /**  
     * Returns a string representation of this set
     */
    public String toString();

}