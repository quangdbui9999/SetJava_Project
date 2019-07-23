/*
 *  CSC-223 FA 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: 
 *  Description: 
 */

package domainblocker;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * DRIVE FILR
 * Profesor: A. Wright
 * Programmer: Quang Bui
 */
public class DomainChecker {
    public static void main(String[] args) throws FileNotFoundException {
        DomainBlocker blocker = new DomainBlocker();
        Scanner scan = new Scanner(System.in);

        String domain;
        
        do
        {
            System.out.print("Enter a domain (DONE to quit): ");
            domain = scan.nextLine();

            if (!domain.equalsIgnoreCase("DONE"))
            {
                if (blocker.domainIsBlocked(domain))
                    System.out.println("That domain is blocked.");
                else
                    System.out.println("That domain is fine.");
            }
        } while (!domain.equalsIgnoreCase("DONE"));
    }
}
