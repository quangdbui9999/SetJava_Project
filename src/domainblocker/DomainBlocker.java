/*
 *  CSC-223 FA 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: 
 *  Description: 
 */

package domainblocker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Programmed by: Quang Bui
 * Due Date: 
 * Description: 
 */
public class DomainBlocker {
    private TreeSet<String> blockSet;
    
    public DomainBlocker() throws FileNotFoundException{
        blockSet = new TreeSet<String>();
        
        File inputFile = new File("blockedDomains.txt");
        Scanner cin = new Scanner(inputFile);
        
        while(cin.hasNext()){
            blockSet.add(cin.nextLine());
        }
    }
    
    public boolean domainIsBlocked(String domain){
        return blockSet.contains(domain);
    }
}