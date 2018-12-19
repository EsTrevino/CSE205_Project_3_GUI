//********************************************************************************************************
// CLASS: GradebookWriter.java
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Fall-B, 2018
// Project Number: Project #3
//
// AUTHOR
// Esteban Trevino, ECTREVIN, sttrevino2@gmail.com //
// ********************************************************************************************************

// Import statements.
import java.io.PrintWriter;
import java.io.FileNotFoundException;


/**
 * GradebookWriter inherits from PrintWriter and writes the gradebook info to the file whose name
 * is passed to the ctor.
 */
public class GradebookWriter extends PrintWriter {

    /**
     * Call the super class ctor that takes a String as the argument, i.e, PrintWriter(String).
     * The PrintWriter ctor opens the file named by pFname for writing. It will throw a
     * FileNotFoundException if the file could not be opened for writing. We throw the exception
     * here as well where it will eventually be caught in Main.exit() -- see Software Requirements
     * 11 and 12.
     *
     * @param pFname The name of the output file to be opened for writing.
     */
    GradebookWriter(String pFname) throws FileNotFoundException {
        super(pFname);
    }

    /**
     * Writes the gradebook info to the output file which was opened in the ctor.
     * 
     * @param pRoster The roster of students.
     */
    public void writeGradeBook(Roster pRoster){
        for(Student student : pRoster.getStudentList()){
            super.println(student);
        }
        super.close();
    }
}
