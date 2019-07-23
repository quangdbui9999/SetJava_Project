/*
 *  CSC-223 FA 2018 PROJECT:
 *  Programmer: Quang Bui, Tolu Somoye, Jae, Swanora
 *  Due Date: Thursday, November 29th, 2019
 *  Description: 
 */

package set;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javafx.scene.input.DataFormat;

/**
 * DRIVE FILR
 * Profesor: A. Wright
 * Programmer: Quang Bui
 */
public class CodeImplement {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        NumberOccurrence project = new NumberOccurrence();
        project.readFileLineByLine();
        
        project.createSortedSet();
        System.out.println(project);
        project.testHeadSet();
        project.testSubSet();
        project.testTailSet();
    }
}
