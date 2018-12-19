//********************************************************************************************************
// CLASS: GradebookReader.java
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
import java.util.Scanner;

/**
 * GradebookReader() reads the gradebook info from the file whose name is passed to the ctor.
 * Once the input file has been read, it will return a Roster object containing the list of
 * Students in the course.
 */
public class GradebookReader  {

    /**
     * mIn is used to read from the input file.
     */
    private Scanner mIn;

    /**
     * Attempts to open the gradebook file for reading. If successful, mIn will be used to read
     * from the file. If the file cannot be opened, a FileNotFoundException will be thrown.
     *
     * Note that this  method does not actually read the information from the file. That is done
     * lated when readRoster() is called from Main.run().
     *
     * @throws FileNotFoundException
     *
     * @param pFname The name of the file to be opened for reading. For this project it will be
     *               "gradebook.txt"
     */
    public GradebookReader(String pFname) throws FileNotFoundException {
        mIn = new Scanner(new File(pFname));
    }

    /**
     * Reads the exam scores for a Student.
     *
     * The number of exams is stored in a public class constant declared in CourseConstants.
     *
     * @param pStudent The student for whom we are going to read the exam scores from the input
     *                  file.
     */
    private void readExam(Student pStudent) {
        for (int n = 0; n < CourseConstants.NUM_EXAMS; ++n) {
            pStudent.addExam(mIn.nextInt());
        }
    }

    /**
     * Called to read the gradebook information. Calls readRoster() to read the student records and
     * then sorts the roster by last name.
     *
     * Called from Main.run().
     *
     * @return The roster of students that was read from the input file.
     */
    public Roster readGradebook() {
        Roster roster = readRoster();
        roster.sortRoster();
        return roster;
    }

    /**
     * Reads the homework scores for a Student.
     *
     * @param pStudent The student for whom we are going to read the homeworl scores from the input
     *                  file.
     */
    private void readHomework(Student pStudent) {
        for (int n = 0; n < CourseConstants.NUM_HOMEWORKS; ++n) {
            pStudent.addHomework(mIn.nextInt());
        }
    }

    /**
     * Reads the student information for each student in the input file, adding each student to
     * the roster.
     *
     * Called from readGradebook().
     *
     * @return The roster of students that was read from the input file.
     */
    private Roster readRoster() {
        Roster roster = new Roster();
        while (mIn.hasNext()) {
            // See Software Requirement 1 for the format of each Student record in the input file.
            String lastName = mIn.next();
            String firstName = mIn.next();
            Student student = new Student(firstName, lastName);
            readHomework(student);
            readExam(student);
            roster.addStudent(student);
        }
        return roster;
    }
}