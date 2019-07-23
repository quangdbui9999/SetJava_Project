/*
 *  CSC-223 FA 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: 
 *  Description: 
 */

package set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Programmed by: Quang Bui
 * Due Date: 
 * Description: 
 */
public class ArrayIterator<T> implements Iterator<T>
{
    private int count;    // the number of elements in the collection
    private int current;  // the current position in the iteration 
    private T[] items; 

    /**
     * C O N V E R S I O N  C O N S T R U C T O R
     * @param collection the collection will be assign to an Array
     * @param size the size of collection
     * Pre-condition: none
     * Post-condition: Sets up this iterator using the specified items.
     */
    public ArrayIterator (T[] collection, int size)
    {
        items = collection;
        count = size;
        current = 0;
    }

    /**
     * Accessor: hasNext()
     * @return true if this iterator has at least one more element 
     * to deliver in the iteration.
     * Pre-condition: none
     * Post-condition: return true if this iterator has at least 
     * one more element to deliver in the iteration.
     */
    public boolean hasNext()
    {
        return (current < count);
    }

    /**
     * Accessor: next()
     * @return true if this iterator has at least one more element 
     * to deliver in the iteration.
     * Pre-condition: none
     * Post-condition: Returns the next element in the iteration. 
     * If there are no more elements in this itertion, 
     * a NoSuchElementException is thrown.
     */
    public T next()
    {
        if (!hasNext())
           throw new NoSuchElementException();

        current++;

        return items[current - 1]; 

    }

    /**
     * The remove operation is not supported in this collection.
     * @throws UnsupportedOperationException 
     */
    public void remove() throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException();
    }
}