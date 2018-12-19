//********************************************************************************************************
// CLASS: Roster.java
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Fall-B, 2018
// Project Number: Project #3
//
// AUTHOR
// Esteban Trevino, ECTREVIN, sttrevino2@gmail.com //
// ********************************************************************************************************

// Import statements.
import java.util.ArrayList;

/**
 * The Roster class encapsulates an ArrayList<Student> object named mStudentList which stores the
 * information for each student that was read from "gradebook.txt" when the app started.
 */
public class Roster {

    /**
     * Declare mStudentList as ArrayList<Student>
     */
    ArrayList<Student> mStudentList;

    /**
     * Roster class constructorå
     */
    public Roster(){
        mStudentList = new ArrayList<>();
        setStudentList(mStudentList);
    }

    /**
     * addStudent()
     *
     * Adds pstudent to the ArrayList
     */
    public void addStudent(Student pStudent){
        getStudentList().add(pStudent);
    }

    /**
     * getStudent()
     *
     * Searches mStudentList for a Student with pLastName.
     */
    public Student getStudent(String pLastName){
        int index = Searcher.search(getStudentList(), pLastName);
        if(index == -1){
            return null;
        } else{
            return getStudentList().get(index);
        }
    }

    /**
     * getStudentList()
     *
     * Accessor method for mStudentList.
     */
    public ArrayList<Student> getStudentList() {
        return mStudentList;
    }

    /**
     * setStudentList()
     *
     * Mutator method for mStudentList.
     */
    private void setStudentList(ArrayList<Student> pStudentList) {
        mStudentList = pStudentList;
    }

    /**
     * sortRoster()
     * Called to sort the roster by last name.
     */
    public void sortRoster(){
        Sorter.sort(getStudentList());
    }

    /**
     * Returns a String representation of this Roster. toString() methods are very handy for
     * debugging because given access to a Roster object, say named roster, then you can print
     * the entire roster in one statement: System.out.println(roster);
     */
    @Override
    public String toString() {
        String result = "";
        for (Student student : getStudentList()) {
            result += student + "\n";
        }
        return result;
    }
}
