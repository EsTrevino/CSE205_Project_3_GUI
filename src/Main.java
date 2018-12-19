//********************************************************************************************************
// CLASS: Main.java
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Fall-B, 2018
// Project Number: Project #3
//
// AUTHOR
// Esteban Trevino, ECTREVIN, sttrevino2@gmail.com //
// ********************************************************************************************************

import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFrame;

/**
 * The Main class containing the main() and run() methods.
 */
public class Main {

    /**
     * The Roster of students that is read from the input file "gradebook.txt".
     */
    Roster mRoster;

    /**
     * A reference to the View object.
     */
    View mView;

    /**
     * main()
     * This is where execution starts. Instantiate a Main object and then call run().
     */
     public static void main(String[] args) {
        Main mainObj = new Main();
        mainObj.run();
    }
    /**
     * exit() is called when the Exit button in the View is clicked. When we exit we have to write
     * the roster to the output file "gradebook.txt". Then we exit the program with a code of 0.
     *
     * We open the file and write the roster to it in a try-catch block, where we catch a
     * FileNotFoundException that will be thrown if for some reason, we cannot open "gradebook.txt"
     * for writing.
     */
    public void exit(){
        try{
            GradebookWriter gbWriter = new GradebookWriter("gradebook.txt");
            gbWriter.writeGradeBook(getRoster());
            System.exit(0);
        } catch (FileNotFoundException e){
            getView().messageBox("Could not open gradebook.txt for writing. Exiting without saving.");
           System.exit(-1);
        }
    }

    /**
     * Accessor method for mRoster.
     */
    private Roster getRoster() {
        return mRoster;
    }

    /**
     * Accessor method for mView.
     */
    private View getView() {
        return mView;
    }

    /**
     * run() is the main routine and is called from main().
     */
    private void run() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        setView(new View(this));
        try{
            GradebookReader gbReader = new GradebookReader("gradebook.txt");
            Roster roster = gbReader.readGradebook();
            setRoster(roster);

        }catch(FileNotFoundException e){
            getView().messageBox("Could not open gradebook.txt for reading. Exiting");
            System.exit(-1);
        }

    }

    /**
     * search() is called when the Search button is clicked in the View. The input parameter is
     * the last name of the Student to search the roster for. Call getStudent(pLastName) on the
     * Roster object (call getRoster() to get the reference to the Roster) to get a reference to
     * the Student with that last name. If the student is not located, getStudent() returns null.
     *
     * @param pLastName The last name of the student who we will search the Roster for.
     **/
    public Student search(String pLastName){
       return getRoster().getStudent(pLastName);
    }

    /**
     * Mutator method for mRoster.
     */
    private void setRoster(Roster pRoster) {
        mRoster = pRoster;
    }

    /**
     * Mutator method for mView.
     */
    private void setView(View pView) {
        mView = pView;
    }
}
