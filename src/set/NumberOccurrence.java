/*
 *  CSC-223 FA 2018 PROJECT:
 *  Programmer: Quang Bui, Tolu Somoye, Jae, Swanora
 *  Due Date: Thursday, November 29th, 2019
 *  Description: The NumberOccurrence class will read the Data from file
 * following the rule of line by line. When it read the file line by
 * line, each line will be a String, so they will have the same character
 * in the String (one line). Each character in a line will be
 * add to a Set, our Group will use Set feature to count the number of 
 * occurrence of each character in a String (one line), and then
 * output the position of each character
 */
package set;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author cim217
 */
public class NumberOccurrence {
    /**
     * wholeString will storage the file's content in the String, include
     * the duplicate character
     */
    private String wholeString;
    /**
     * a characterSet's string with no duplicate character
     * Example:
     * String has content is "GroupProject"
     * characterSet is "GroupPject"
     */
    private ArraySet<Character> characterSet;
    /**
     * the number occurrence of each character in the wholeString
     */
    private ArrayList<Integer> numberOccurrence;
    
    private SortedSet<String> mySortedSet;
    
    /**
     *  D E F A U L T   C O N S T R U C T O R
     * Pre-condition: The ArraySet class will be defined
     * Post-condition: initialize all the default value for each instance
     * variable
     */
    public NumberOccurrence(){
        this.wholeString = "";
        this.characterSet = new ArraySet<Character>();
        this.numberOccurrence = new ArrayList<Integer>();
        //mySortedSet = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER).descendingSet();
        mySortedSet = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
    }
    
    /**
     * Accessor: getWholeString()
     * @return all the character in the file, include the duplicate
     * element
     * Pre-condition: none
     * Post-condition: return all the character in the file, 
     * include the duplicate element
     */
    public String getWholeString(){
        return this.wholeString;
    }
    
    /**
     * Mutator: printFormat()
     * Pre-condition: nothing
     * Post-condition: print the line at the appropriate position
     */
    private void printFormat(PrintWriter pw){
        if(pw != null){
            pw.println();
        }else{
            System.out.println();
        }
        
        for(int i = 1; i <= 140; i++){
            if (i == 1 || i == 14 || i == 29 || i == 50 || i == 140){
                if(pw != null){
                    pw.print("+");
                }else{
                    System.out.print("+");
                }
            }else{
                if(pw != null){
                    pw.print("-");
                }else{
                    System.out.print("-");
                }
            }
        }
    }
    
    /**
     * Mutator: printTile()
     * Pre-condition: printFormat()
     * Post-condition: just print the Title of each column
     */
    private void printTile(PrintWriter pw){
        if(pw == null){
            printFormat(null);
            System.out.printf("\n| %-10s | %-12s | %-18s | %-87s |",
                "Order", "Character", "Number Appearance", 
                "Position");
            printFormat(null);
        }else{
            printFormat(pw);
            pw.printf("\n| %-10s | %-12s | %-18s | %-87s |",
                "Order", "Character", "Number Appearance", 
                "Position");
            printFormat(pw);
        }
    }
    
    /**
     * Method: displayFromFile(String content, int lineNumber, PrintWriter pw)
     * @param content the content of each line form file
     * @param lineNumber which line in the file
     * @param pw using to write the data to file
     * Pre-condition: numberOfAppear(content, unique, PrintWriter); is defined
     * Post-condition: output the information of each line in the content
     * String (include the order, the character, number occurrence and
     * the position)
     * if pw is null, output the data to text file, otherwise, output the
     * data to the screen output
     */
    private void displayFromFile(String content, int lineNumber, PrintWriter pw){
        char[] charArray = content.toCharArray();
        ArraySet<Character> unique = createSet(charArray);
        if(pw == null){
            System.out.print("\nRow \"" + lineNumber + "\" has content: \"" + content + "\"");
            System.out.println(". Length: \"" + content.length() + "\".");
            printTile(null);
            numberOfAppear(content, unique, null);
            System.out.println("\n\nMove row \"" + lineNumber + "\" in the Set. Here is Sets: ");
            System.out.println(unique);
        }else{
            pw.print("\nRow \"" + lineNumber + "\" has content: \"" + content + "\"");
            pw.println(". Length: \"" + content.length() + "\".");
            printTile(pw);
            numberOfAppear(content, unique, pw);
            pw.println("\n\nMove row \"" + lineNumber + "\" in the Set. Here is Sets: ");
            pw.println(unique);
        }
        characterSet.addAll(unique);
        //mySortedSet.addAll(unique)
    }
    
    /**
     * Method: displayWhoFile(PrintWriter pw)
     * @param pw using to write the data to file
     * Pre-condition: numberOfAppear(content, unique, PrintWriter); is defined
     * Post-condition: output the information of each line in the content
     * String (include the order, the character, number occurrence and
     * the position)
     * if pw is null, output the data to text file, otherwise, output the
     * data to the screen output
     */
    private void displayWhoFile(PrintWriter pw){
        char[] charArray = wholeString.toCharArray();
        ArraySet<Character> unique = createSet(charArray);
        if(pw == null){
            System.out.println("\nThe whole file has string is : \"" + wholeString + "\"");
            printTile(null);
            numberOfAppear(wholeString, unique, null);
            System.out.println("\n\nMove File's content in the Set. Here is Sets: ");
            System.out.println(unique);
        }else{
            pw.println("\nThe whole file has string is : \"" + wholeString + "\"");
            printTile(pw);
            numberOfAppear(wholeString, unique, pw);
            pw.println("\n\nMove File's content in the Set. Here is Sets: ");
            pw.println(unique);
        }
    }
    
    /**
     * Method: writeFile(String content, int lineNumber)
     * @param content the content is one line from File
     * @param lineNumber 
     * @throws IOException is thrown when file is not successfully written 
     * Pre-condition: displayFromFile(content, lineNumber, pw) is defined
     * Post-condition: write data to output file
     * if lineNumber == 1, the content in the File's name will be clear and
     * write the new data from file with PrintWriter pw = new PrintWriter(fw);
     * if lineNumber >= 2, the content in the File's name will keep
     * original and continue to write the new data with
     * PrintWriter pw = new PrintWriter(fw, true);
     */
    private void writeFile(String content, int lineNumber) throws IOException {
        File file = new File("output.txt");
        if(lineNumber == 1){
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            displayFromFile(content, lineNumber, pw);
            pw.close();
            fw.close();
        }else if(lineNumber >= 2){
            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);
            displayFromFile(content, lineNumber, pw);
            pw.close();
            fw.close();
        }
    }
    
    /**
     * Method: readFileLineByLine() 
     * @throws IOException when the input's file name does not exists
     * in the disk
     * Pre-condition: displayFromFile(lineContent, countLine, null)
     * and writeFile(lineContent, countLine) are defined
     * Post-condition: read the data form file line by line.
     * In each line, lineContent variable will get one line from file
     * and displayFromFile(lineContent, countLine, null) method will
     * output the information and writeFile(lineContent, countLine)
     * method will write the data to output file of the lineContent data.
     */
    public void readFileLineByLine() throws IOException{
        String lineContent = ""; // store one line
        int countLine = 0; // what is line?
        
        //Scanner cin = new Scanner(System.in);
        //System.out.print("Please enter the file name: ");
        //String fileName = cin.nextLine();
        
        //File fileInput = new File(fileName);
        File fileInput = new File("input.txt");
        FileReader readerFile = new FileReader(fileInput);
	BufferedReader readBuffer = new BufferedReader(readerFile);
        
        while ((lineContent = readBuffer.readLine()) != null) {
            this.wholeString += lineContent;
            if(lineContent.equalsIgnoreCase("")){
                countLine++;
                System.out.println("\nRow " + countLine + ":");
                System.out.println("There are no characters in the String.");
            }else{
                countLine++;
                this.displayFromFile(lineContent, countLine, null);
                this.writeFile(lineContent, countLine);
            }
	}
        
        for(int i = 0; i < characterSet.size(); i++){
            ArrayList<Integer> myPosition = indexPosition(wholeString, characterSet.getIndex(i));
            numberOccurrence.add(myPosition.size());
        }
        this.displayWhoFile(null);
        this.writeFile(wholeString, countLine);
        //this.displayWhoFile(pw);
        
	readBuffer.close();
        readerFile.close();
    }
    
    /**
     * Method: numberOfAppear(String content, ArraySet<Character> unique, PrintWriter pw)
     * @param content content is a line from File
     * @param unique the set with no duplicate in the content String
     * @param pw write the data to output file
     * Pre-condition: indexPosition(content, unique.getIndex(i)) is defined
     * Post-condition: output the position and number occurrence of each 
     * character in the unique ArraySet 
     * if pw is null, output the data to text file, otherwise, output the
     * data to the screen output
     */
    private void numberOfAppear(String content, ArraySet<Character> unique, PrintWriter pw)
    {
        String connectString = "";
        for(int i = 0; i < unique.size(); i++){
            ArrayList<Integer> myPosition = indexPosition(content, unique.getIndex(i));
            //numberOccurrence.add(myPosition.size());
            if(pw == null){
                System.out.format("\n| %-10s | %-12s | %-18s |", (i + 1), unique.getIndex(i), myPosition.size());
            }else{
                pw.format("\n| %-10s | %-12s | %-18s |", (i + 1), unique.getIndex(i), myPosition.size());
            }
            
            for(int k = 0; k < myPosition.size(); k++){
                // output the position
                connectString += myPosition.get(k) + " ";
            }
            if(pw == null){
                System.out.format(" %-87s |", connectString);
                printFormat(null);
            }else{
                pw.format(" %-87s |", connectString);
                printFormat(pw);
            }
            connectString = "";
        }
    }
    
    /**
     * Methods: createSet(char[] arrayCharacter)
     * @param arrayCharacter arrayCharacter is a string of one file from
     * File
     * @return the set with no duplicated character
     * Pre-condition: add(element) of ArraySet class is defined
     * Post-condition: return the set with no duplicated character
     */
    private ArraySet<Character> createSet(char[] arrayCharacter) {
        ArraySet<Character> sets = new ArraySet<Character>();
        for(Character element: arrayCharacter) {
            if(element != ' ' && element != ','){
                sets.add(element);
            }
        }
        return sets;
    }
    
    /**
     * Method: indexPosition(String str, char c)
     * @param oneLine oneLine is a line from file
     * @param c c is the charater in the String oneLine
     * @return the array of position of the same character 'c' in the 
     * String oneLine
     * Pre-condition: none
     * Post-condition: return the array of position of the same 
     * character 'c' in the String oneLine
     */
    private ArrayList<Integer> indexPosition(String oneLine, char c){
        ArrayList<Integer> myPosition = new ArrayList<Integer>();
        
        for(int i = 0; i < oneLine.length(); i++){
            if(oneLine.charAt(i) == c){
                myPosition.add(i);
            }
        }
        return myPosition;
    }
    
    /**
     * Pre-condition: none
     * Post-condition: Create a sorted set with all the elements 
     * are ordered in their natural ordering
     */
    public void createSortedSet(){
        for(int i = 0; i < wholeString.length(); i++){
            String indexContent = Character.toString(wholeString.charAt(i));
            if(!indexContent.equalsIgnoreCase(" ")
                    && !indexContent.equalsIgnoreCase(",")
                    && !indexContent.equalsIgnoreCase(":")){
                mySortedSet.add(indexContent);
            }
        }
    }
    
    /**
     * Pre-condition: createSortedSet() method must be defined
     * Post-condition: returns a view of the portion of the Set whose 
     * elements are strictly less than toElement
     */
    public void testHeadSet(){
        
        Scanner cin = new Scanner(System.in);
        
        System.out.println("Test headSet() method: ");
        System.out.print("Enter a character: ");
        String head = cin.nextLine();
        System.out.println("HeadSet() result with the character \'" + head + "\':");
        SortedSet headSet = mySortedSet.headSet(new String(head));
        Iterator headSetIt = headSet.iterator();

        while (headSetIt.hasNext()) {
            String element = (String) headSetIt.next();
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    /**
     * Pre-condition: createSortedSet() method must be defined
     * Post-condition: returns a view of the portion of the Set whose elements 
     * range from fromElement, inclusive, to toElement, exclusive
     */
    public void testSubSet(){
        Scanner cin = new Scanner(System.in);
        
        System.out.println("Test subSet() method: ");
        String head = "";
        String tail = "";
        do{
            System.out.print("Enter first character: ");
            head = cin.nextLine();
            System.out.print("Enter second character: ");
            tail = cin.nextLine();
            
            if(head.compareTo(tail) > 0){
                System.out.println("Data is not valid");
            }
        }while(head.compareTo(tail) > 0);
        System.out.println("SubSet() result from \'" + head + "\' to \'" + tail + "\':");
        SortedSet subSet = mySortedSet.subSet(new String(head), new String(tail));
        Iterator subSetIt = subSet.iterator();

        while (subSetIt.hasNext()) {
            String element = (String) subSetIt.next();
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    /**
     * Pre-condition: createSortedSet() method must be defined
     * Post-condition: returns a view of the portion of the Set whose elements 
     * are greater than or equal to fromElement
     */
    public void testTailSet(){
        Scanner cin = new Scanner(System.in);
        
        System.out.println("Test tailSet() method: ");
        System.out.print("Enter a character: ");
        String tail = cin.nextLine();
        System.out.println("TailSet() result with the character \'" + tail + "\':");
        SortedSet tailSet = mySortedSet.tailSet(new String("S"));
        Iterator tailSetIt = tailSet.iterator();
        
        while (tailSetIt.hasNext()) {
            String element = (String) tailSetIt.next();
            System.out.print(element + " ");
        }
        System.out.println();
        
        // first: returns the first (lowest) element currently in the Set.
        System.out.println("The first element is: \"" + mySortedSet.first() + "\"");
        // last: returns the last (highest) element currently in the Set.
        System.out.println("The last element is: \"" + mySortedSet.last() + "\"");
    }
    
    public void implementSortedSetDescending(){
        // Test headSet()
        // returns a view of the portion of the Set whose 
        // elements are strictly less than toElement
        System.out.println("HeadSet() result:");
        SortedSet headSet = mySortedSet.headSet(new String("s"));
        Iterator headSetIt = headSet.iterator();

        while (headSetIt.hasNext()) {
            String element = (String) headSetIt.next();
            System.out.print(element + " ");
        }
        System.out.println();
 
        // Test subSet()
        // returns a view of the portion of the Set whose elements 
        // range from fromElement, inclusive, to toElement, exclusive
        System.out.println("subSet() result:");
        SortedSet subSet = mySortedSet.subSet(new String("r"), new String("a"));
        Iterator subSetIt = subSet.iterator();

        while (subSetIt.hasNext()) {
            String element = (String) subSetIt.next();
            System.out.print(element + " ");
        }
        System.out.println();
        
        // Test tailSet()
        // returns a view of the portion of the Set whose elements 
        // are greater than or equal to fromElement
        System.out.println("tailSet() result:");
        SortedSet tailSet = mySortedSet.tailSet(new String("e"));
        Iterator tailSetIt = tailSet.iterator();
        
        while (tailSetIt.hasNext()) {
            String element = (String) tailSetIt.next();
            System.out.print(element + " ");
        }
        System.out.println();
        
        // first: returns the first (lowest) element currently in the Set.
        System.out.println("The first element is: \"" + mySortedSet.first() + "\"");
        // last: returns the last (highest) element currently in the Set.
        System.out.println("The last element is: \"" + mySortedSet.last() + "\"");
    }
    
    /**
     * Accessor: toString
     * @return the information of the set with no duplicate character
     * Pre-condition: none
     * Post-condition: return the information of the set with 
     * no duplicate character
     */
    public String toString(){
        String result = "\n\n";
        if(mySortedSet.isEmpty()){
            result += "The Sorted Set is Empty.\n";
        }else{
            result += "The original String: \"" + this.getWholeString() + "\"\n";
            result += "Here is our Sorted Set\n";
            
            for(String element : mySortedSet){
                result += element;
            }
            result += "\n";
        }
        return result;
    }
}
