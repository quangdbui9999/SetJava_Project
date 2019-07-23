/*
 *  CSC-223 FA 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: 
 *  Description: 
 */

package exception;

/**
 * Programmed by: Quang Bui
 * Due Date: 
 * Description: 
 */
public class ElementNotFoundException extends RuntimeException
{
   //-----------------------------------------------------------------
   //  Sets up this exception with an appropriate message.
   //-----------------------------------------------------------------
   public ElementNotFoundException (String collection)
   {
      super ("The target element is not in this " + collection);
   }
}