/*
 *  CSC-223 FA 2018 PROJECT:
 *  Programmer: Quang Bui, Tolu Somoye, Jae, Swanora
 *  Due Date: Thursday, November 29th, 2019
 *  Description: EqualSetDemo is a class will compare Two Set
 *  Two Set instances are equal if they contain the same elements. 
 *  Essentially, Sets cannot contain duplicate elements, but two Sets 
 *  can be equal and contain the same elements as one another.
 */

package exception;

import set.ArraySet;

/**
 * DRIVE FILR
 * Profesor: A. Wright
 * Programmer: Quang Bui
 */
public class EqualSetDemo {
    private ArraySet<Integer> firstSet;
    private ArraySet<Integer> secondSet;
    
    public EqualSetDemo(){
        firstSet = new ArraySet<Integer>();
        secondSet = new ArraySet<Integer>();
    }
    
    private boolean equalsDemo(){
        if(firstSet == null || secondSet == null){
            return false;
        }
        if(firstSet.size() != secondSet.size()){
            return false;
        }
        
        /**
         * After that, containsAll(...) will return false as soon as 
         * it finds an element in the other set that is not also in this set. 
         * But if all elements are present in both sets, 
         * it will need to test all of them.
         * 
         * The worst case performance therefore occurs when the two sets are 
         * equal but not the same objects. That cost is 
         * O(N) or O(NlogN) depending on the implementation of this.containsAll(c).
         * 
         * And you get close-to-worst case performance if the sets 
         * are large and only differ in a tiny percentage of the elements.
         */
        return firstSet.containsAll(secondSet);
    }
    
    /**
     * firstSet and secondSet have 2 elements in the Set
     * But the element of Two Sets are not the same
     */
    private void test1(){
        firstSet.add(5);
        firstSet.add(10);
        
        secondSet.add(15);
        secondSet.add(10);
        this.display();
    }
    
    /**
     * firstSet has 3 elements and secondSet has 2 elements in the Set
     */
    private void test2(){
        firstSet.add(5);
        firstSet.add(10);
        firstSet.add(15);
        
        secondSet.add(15);
        secondSet.add(10);
        this.display();
    }
    
    /**
     * firstSet has 2 elements and secondSet has 3 elements in the Set
     */
    private void test3(){
        firstSet.add(5);
        firstSet.add(10);
        
        secondSet.add(15);
        secondSet.add(10);
        secondSet.add(5);
        this.display();
    }
    
    /**
     * firstSet and secondSet have 2 elements in the Set
     * firstSet and secondSet have the same value of element
     */
    private void test4(){
        firstSet.add(5);
        firstSet.add(15);
        
        secondSet.add(15);
        secondSet.add(5);
        this.display();
    }
    
    /**
     * firstSet and secondSet have 2 elements in the Set
     * firstSet and secondSet have the same value of element
     * but they have the same case when they duplicate the element
     * in the Set
     */
    private void test5(){
        firstSet.add(5);
        firstSet.add(15);
        firstSet.add(5);
        firstSet.add(15);
        //firstSet.add(12);
        firstSet.add(10);
        
        secondSet.add(15);
        secondSet.add(5);
        secondSet.add(10);
        secondSet.add(15);
        this.display();
    }
    
    private void display(){
        if(this.equalsDemo()){
            System.out.println("Two Sets are EQUALS");
        }else{
            System.out.println("Two Sets are NOT EQUALS");
        }
    }
    
    /**
     * Test the operation of two Sets
     * @param args 
     */
    public static void main(String[] args) {
        EqualSetDemo compareTwoSets;
        
        System.out.println("Test Set 1:");
        compareTwoSets = new EqualSetDemo();
        compareTwoSets.test1();
        
        System.out.println("Test Set 2:");
        compareTwoSets = new EqualSetDemo();
        compareTwoSets.test2();
        
        System.out.println("Test Set 3:");
        compareTwoSets = new EqualSetDemo();
        compareTwoSets.test3();
        
        System.out.println("Test Set 4:");
        compareTwoSets = new EqualSetDemo();
        compareTwoSets.test4();
        
        System.out.println("Test Set 5:");
        compareTwoSets = new EqualSetDemo();
        compareTwoSets.test5();
    }
}
