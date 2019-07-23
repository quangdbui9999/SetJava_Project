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
public class EmptySetException extends RuntimeException
{
    //-----------------------------------------------------------------
    //  Creates the exception.
    //-----------------------------------------------------------------
    public EmptySetException()
    {
       super ("The set is empty.");
    }

    //-----------------------------------------------------------------
    //  Creates the exception with the specified message.
    //-----------------------------------------------------------------
    public EmptySetException (String message)
    {
       super (message);
    }
}