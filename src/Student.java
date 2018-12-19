//********************************************************************************************************
// CLASS: Student.java
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Fall-B, 2018
// Project Number: Project #3
//
// AUTHOR
// Esteban Trevino, ECTREVIN, sttrevino2@gmail.com //
// ********************************************************************************************************

// Import statements.
import java.lang.Comparable;
import java.util.ArrayList;

/**
 * The Student class stores the gradebook information for one Student.
 *
 * Note that Student implements the java.lang.Comparable<Student> interface because we are going
 * to be sorting the roster of students by last name so we need to be able to compare the last
 * names of two students A and B to determine if A < B, or if A = B, or if A > B. See the
 * compareTo() method.
 */
public class Student implements Comparable<Student>{

    /**
     * mExamList is an ArrayList of Integers storing the student's exam scores.
     */
    private ArrayList<Integer> mExamList = new ArrayList<>();
    
    /**
     * The student's first name.
     */
    private String mFirstName;

    /**
     * mHomework List is an ArrayList of Integers storing the student's homework scores.
     */
    private ArrayList<Integer> mHomeworkList;

    /**
     * The student's lst name.
     */
    private String mLastName;

    /**
     *constructor for Student Class. Sets instance variables and declares ArrayLists for use in class
     */
    public Student(String pFirstName, String pLastName){

        setFirstName(pFirstName);
        setLastName(pLastName);

        ArrayList<Integer> examList = new ArrayList<>();
        setExamList(examList);

        ArrayList<Integer> homeWorkList = new ArrayList<>();
        setHomeworkList(homeWorkList);
    }

    /**
     * Adds an exam score pScore to the exam list
     */
    public void addExam(int pScore){
        getExamList().add(pScore);
    }

    /**
     * Adds a homework score pScore to the homework list
     */
    public void addHomework(int pScore){
        getHomeworkList().add(pScore);
    }

    /**
     * This method compares the last name of 'this' Student to the last name of pStudent to
     * determine if the last name of 'this' Student is <, =, or > the last name of pStudent.
     * It is called during the quick sort routine in Sorter.partition().
     */
    @Override
    public int compareTo(Student pStudent){
        if(this.getLastName().compareTo(pStudent.getLastName()) < 0 ){
            return -1;
        } else if (this.getLastName().compareTo(pStudent.getLastName()) > 0 ){
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Accessor method to retrieve an exam score from the list of exams.
     */
    public int getExam(int pNum) {
        return getExamList().get(pNum);
    }

    /**
     * Accessor method for mExamList.
     */
    private ArrayList<Integer> getExamList() {
        return mExamList;
    }

    /**
     * Accessor method for mFirstName.
     */
    public String getFirstName() {
        return mFirstName;
    }

    /**
     * Accessor method to retrieve a homework score from the list of homeworks.
     */
    public int getHomework(int pNum) {
        return getHomeworkList().get(pNum);
    }

    /**
     * Accessor method for mHomeworkList.
     */
    private ArrayList<Integer> getHomeworkList() {
        return mHomeworkList;
    }

    /**
     * Accessor method for mLastName.
     */
    public String getLastName() {
        return mLastName;
    }

    /**
     * Mutator method to store an exam score into the list of exam scores.
     */
    public void setExam(int pNum, int pScore) {
        getExamList().set(pNum, pScore);
    }

    /**
     * Mutator method for mExamList.
     */
    private void setExamList(ArrayList<Integer> pExamList) {
        mExamList = pExamList;
    }

    /**
     * Mutator method for mFirstName.
     */
    public void setFirstName(String pFirstName) {
        mFirstName = pFirstName;
    }

    /**
     * Mutator method to store a homework score into the list of homework scores.
     */
    public void setHomework(int pNum, int pScore) {
        getHomeworkList().set(pNum, pScore);
    }

    /**
     * Mutator method for mHomeworkList.
     */
    private void setHomeworkList(ArrayList<Integer> pHomeworkList) {
        mHomeworkList = pHomeworkList;
    }

    /**
     * Mutator method for mLastName.
     */
    public void setLastName(String pLastName) {
        mLastName = pLastName;
    }

    /**
     * Returns a String representation of this Student. The format of the returned string shall be
     * such that the Student information can be printed to the output file in this format:
     *
     *     lastname firstname hw1 hw2 hw3 hw4 exam1 exam2
     *
     * where the fields are separated by spaces, except there is not space following exam2.
     */
    @Override
    public String toString(){

       String output = this.getLastName() + " " + this.getFirstName() + " ";

       for(int i = 0; i < CourseConstants.NUM_HOMEWORKS; i++){
           output += this.getHomework(i) + " ";
       }

       for(int i = 0; i < CourseConstants.NUM_EXAMS; i++){
           output += this.getExam(i) +  " ";
       }

        return output.trim();
    }
}
