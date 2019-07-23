/*
 *  CSC-223 FA 2018 PROJECT:
 *  Programmer: Quang Bui, Tolu Somoye, Jae, Swanora
 *  Due Date: Thursday, November 29th, 2019
 *  Description: 
 */

package set;

import exception.EmptySetException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Programmed by: Quang Bui
 * Due Date: 
 * Description: 
 */
public class ArraySet<T> implements SetADT<T>{
    private static final int DEFAULT_CAPACITY = 100;
    private static final int NOT_FOUND = -1;
    private int count;  // the current number of elements in the set
    private T[] contents;

    public T getIndex(int index){
        return contents[index];
    }
    
    /**
     * Creates an empty set using the default capacity.
     * Pre-condition: the conversion constructor with one parameter
     * must be defined
     * Post-condition: Creates an empty set using the default capacity.
     */
    public ArraySet()
    {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty set using the specified capacity.
     * @param initialCapacity 
     * Pre-condition: none
     * Post-condition: Creates an empty set using the specified capacity.
     */
    public ArraySet(int initialCapacity)
    {
        count = 0;
        contents = (T[])(new Object[initialCapacity]);
    }
        
    /**
     * Mutator: add(T element)
     * @param element the element will be add in the Sets
     * Pre-condition: contains(element) and expandCapacity() method
     * defined
     * Post-condition: Adds the specified element to the set if it is 
     * not already present. 
     * Expands the capacity of the set array if necessary.
     */
    public void add(T element)
    {
        // check the element is not contain in the Sets
        if (!(contains(element)))
        {
            if (size() == contents.length)
                expandCapacity();

            contents[count] = element;
            count++;
        }
    }

    /**
     * Mutator: addAll(SetADT<T> set)
     * @param set the element will be add in the Sets
     * Pre-condition: none
     * Post-condition: Adds the contents of the parameter to this set
     */
    public void addAll(SetADT<T> set)
    {
        Iterator<T> scan = set.iterator();
        while (scan.hasNext())
            add (scan.next());
    }

    /**
     * Accessor: removeRandom() 
     * @return the elements will be removed. 
     * @throws EmptySetException if the Set is empty
     * Pre-condition: none
     * Post-condition: Removes a random element from the set and 
     * returns the elements will be removed. 
     * Throws an EmptySetException if the set is empty.
     */
    public T removeRandom() throws EmptySetException
    {
        Random rand = new Random();
        if (isEmpty())
            throw new EmptySetException();

        int selectedRemove = rand.nextInt(count);

        T result = contents[selectedRemove];

        contents[selectedRemove] = contents[count-1];  // fill the gap
        contents[count-1] = null;
        count--;

        return result;
    }

    /**
     * Accessor:  T remove(T target) 
     * @param target
     * @return the elements will be removed. 
     * @throws EmptySetException if the set is empty.
     * @throws NoSuchElementException if the target is not exist
     * in the Set
     * Pre-condition: none
     * Post-condition: Removes a random element from the set and 
     * returns the elements will be removed. 
     * Throws an EmptySetException if the set is empty.
     */
    public T remove(T target) throws EmptySetException,
        NoSuchElementException
    {
        int search = NOT_FOUND;

        if (isEmpty())
            throw new EmptySetException();

        for (int index=0; index < count && search == NOT_FOUND; index++)
            if (contents[index].equals(target))
                search = index;

        if (search == NOT_FOUND)
            throw new NoSuchElementException();

        T result = contents[search];

        contents[search] = contents[count-1];
        contents[count-1] = null;
        count--;

        return result;
    }

    /**
     * Accessor: SetADT<T> union (SetADT<T> set)
     * @param set the elements in the sets
     * @return a new set that is the union of this set and the
     * parameter.
     * Pre-condition: add() method defined
     * Post-condition: Returns a new set that is the union of 
     * this set and the parameter.
     */
    public SetADT<T> union (SetADT<T> set)
    {
        ArraySet<T> bothSet = new ArraySet<T>();

        for (int index = 0; index < count; index++)
            bothSet.add (contents[index]);

        Iterator<T> scan = set.iterator();
        while (scan.hasNext())
            bothSet.add (scan.next());

        return bothSet;
    }


    /**
     * Accessor: contains(T target)
     * @param target does the element contain in the Set
     * @return true if the element is exist in the Set, otherwise
     * return false
     * Pre-condition: none
     * Post-condition: return true if the element is exist in
     * the Set, otherwise return false
     */
    public boolean contains(T target)
    {
        for (T element: this) {
            if (element.equals(target)) {
                return true;
            }
        }
	return false;
    }

    /**
     * Accessor: equals (SetADT<T> set)
     * @param set the elements in the set 
     * @return true if this set contains exactly the same 
     * elements as the parameter
     * Pre-condition: addAll(element) method defined
     * Post-condition: return true if this set contains exactly the same 
     * elements as the parameter
     */
    public boolean equals (SetADT<T> set)
    {
        boolean isEqual = false;
        ArraySet<T> array1 = new ArraySet<T>();
        ArraySet<T> array2 = new ArraySet<T>();
        T obj;

        if (size() == set.size())
        {
            array1.addAll(this);
            array2.addAll(set);

            Iterator<T> scan = set.iterator();

            while (scan.hasNext())
            {
                obj = scan.next();
                if (array1.contains(obj))
                {
                    array1.remove(obj);
                    array2.remove(obj);
                }
            }

            if(array1.isEmpty() && array1.isEmpty()){
                isEqual = true;
            }
        }

        return isEqual;
    }

    /**
     * Accessor:  isEmpty()
     * @return  true if this set is empty and false otherwise.
     */
    public boolean isEmpty()
    {
        return (count == 0);
    }

    /**
     * Accessor:  size()
     * @return the number of elements currently in this set.
     */
    public int size()
    {
        return count;
    }

    /**
     * Accessor: iterator()
     * @return an iterator for the elements currently in this set.
     * Pre-condition: ArrayIterator<T> class defined
     * Post-condition: return true if this set contains exactly the same 
     * elements as the parameter
     */
    public Iterator<T> iterator()
    {
        return new ArrayIterator<T> (contents, count);
    }

    /**
     * Accessor: toString()
     * @return a string representation of this set.
     * Pre-condition: size() method defined
     * Post-condition: return a string representation of this set.
     */
    public String toString()
    {
        String result = "";
        if(size() == 0){
            result += "Empty Set.";
        }else{
            result += "There are \"" + this.size() + "\" elements in the Set.\n";
            result += "\"";
            for (int index=0; index < count; index++){
                result += contents[index].toString() + "";
            }
            result += "\"";
        }

        return result;
    }

    
    /**
     * Mutator: clear()
     * Pre-condition: size() method defined
     * Post-condition: Remove all of the elements from this set
     */
    public void clear() {
	while (count > 0) {
            contents[--count] = null;
        }
    }

    /**
     * Accessor: containsAll(SetADT<T> set) 
     * @param set contains some elements in the set
     * @return true is the original set contains all the elements
     * in the sets, otherwise return false
     * Pre-condition: none
     * Post-condition: return true is the original set contains 
     * all the elements in the sets, otherwise return false
     */
    public boolean containsAll(SetADT<T> set) {

        for (T element: set) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;

    }

    /**
     * Accessor: 
     * @param set contains some elements
     * @return the union of original set and set is passed as
     * parameter
     * Pre-condition: contains() method defined
     * Post-condition: return the union of original set and set is passed
     * as parameter
     */
    public SetADT<T> intersection(SetADT<T> set) {
    	SetADT<T> common = new ArraySet<T>();

        for (T element: set) {
            if (contains(element)) {
                common.add(element);
            }
        }

        return common;
    }

    /**
     * Accessor: removeAll(SetADT<T> set)
     * @param set contains some elements to be removed
     * @return true if all the elements in the set are removed 
     * successfully, otherwise return false
     * Pre-condition: contains() method defined
     * Post-condition: Removes all items from this set that are contained 
     * in the 'set' paramater.  Returns true if true if this set 
     * changed as a result of the call.
     */
    public boolean removeAll(SetADT<T> set) {
        boolean itemRemoved = false;

        for (T element: set) {
            if(contains(element)) { 
                 remove(element); 
                 itemRemoved = true;
            }
	}
    	return itemRemoved;
    }

    /******************************************************************
        Retains only the elements in this set that are contained in the
        specified collection.  Returns true if this collection changed
        as a result of the call.
    ******************************************************************/
    /**
     * Accessor: retainAll(SetADT<T> set)
     * @param set contains some elements to be retained
     * @returns true if this collection changed as a 
     * result of the call.
     * Pre-condition: none
     * Post-condition: Retains only the elements in this set that 
     * are contained in the specified collection. 
     * Returns true if this collection changed as a 
     * result of the call.
     */
    public boolean retainAll(SetADT<T> set) {
        boolean setChanged = false;

        for (int i=0; i < count; i++) {
            if (!set.contains(contents[i]) ) {
                contents[i] = contents[--count];
                contents[count] = null;
                setChanged = true;
	        i--;
            }
        }

        return setChanged;
    }

    /**
     * Accessor: SetADT<T> clone()
     * @return returns a shallow copy of this set. 
     * The elements themselves are not cloned.
     * Pre-condition: none
     * Post-condition: returns a shallow copy of this set. 
     * The elements themselves are not cloned.
     */
    public SetADT<T> clone() {
        SetADT<T> cloned = new ArraySet<T>(count);

        for (T element: this) {
            cloned.add(element);
        }

        return cloned;
    }

    /**
     * Mutator: expandCapacity()
     * Pre-condition: none
     * Post-condition: Creates a new array to store the contents 
     * of the set with twice the capacity of the old one.
     */
    private void expandCapacity()
    {
        T[] newSize = (T[])(new Object[contents.length*2]);

        for (int index=0; index < contents.length; index++)
            newSize[index] = contents[index];

        contents = newSize;
    }
}