//********************************************************************************************************
// CLASS: View.java
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Fall-B, 2018
// Project Number: Project #3
//
// AUTHOR
// Esteban Trevino, ECTREVIN, sttrevino2@gmail.com //
// ********************************************************************************************************

import sun.tools.jps.Jps;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * The View class implements the GUI. It is a subclass of JFrame and implements the ActionListener
 * interface so that we can respond to user-initiated GUI events.
 */
public class View extends JFrame implements ActionListener {

    /**
     * The width of the View.
     */
    public static final int FRAME_WIDTH  = 500;

    /**
     * The height of the View.
     */
    public static final int FRAME_HEIGHT = 250;

    /**
     * When the View() ctor is called from Main.run() to create the View, run() passes a reference
     * to the Main object as the argument to View(). We save that reference into mMain and then
     * later we can use mMain to communicate with the Main class.
     *
     * mMain is made accessible within this class via accessor/mutator methods getMain() and
     * setMain().
     */
    private Main mMain;

    /*
     * Declare GUI related instance variables for the buttons and text fields.
     */
    private JButton mClearButton;
    private JTextField[] mExamText;
    private JButton mExitButton;
    private JTextField[] mHomeworkText;
    private JButton mSaveButton;
    private JButton mSearchButton;
    private JTextField mSearchText;

    /**
     * mStudent is a reference to the Student object which we are currently displaying data for
     * in the View. mStudent is made accessible within the View using accessor and mutator methods
     * getStudent() and setStudent().
     */
    private Student mStudent;

    /**
     * The View constructor creates the GUI interface and makes the frame visible at the end.
     *
     * @param pMain is an instance of the Main class. This links the View to the Main class so
     * they may communicate with each other.
     */
    public View(Main pMain) {

        /**
         * Save a reference to the Main object pMain into instance var mMain by calling setMain().
         */
        setMain(pMain);

        // PSEUDOCODE:
        // Create a JPanel named panelSearch which uses the FlowLayout
        JPanel panelSearch = new JPanel();
        panelSearch.setLayout(new FlowLayout());

        // Add a JLabel "Student Name: " to panelSearch
        JLabel snLabel = new JLabel("Student Name");
        panelSearch.add(snLabel);
        // Create mSearchText and make the field 25 cols wide
        mSearchText = new JTextField(25);
        // Add mSearchText to the panel
        panelSearch.add(mSearchText);

        // Create mSearchButton with the label "Search"
        mSearchButton = new JButton("Search");
        // Make this View the action listener for the button
        mSearchButton.addActionListener(this);
        // Add the button to the panel
        panelSearch.add(mSearchButton);



        // PSEUDOCODE:
        // Create a JPanel named panelHomework which uses the FlowLayout
        // Add a JLabel "Homework: " to the panel
        // Create mHomeworkText which is an array of CourseConstants.NUM_HOMEWORKS JTextFields
        // For i = 0 to CourseConstants.NUM_HOMEWORKS - 1 Do
        //     Create a textfield mHomeworkText[i] displaying 5 cols
        //     Add mHomeworkText[i] to the panel
        // End For
        JPanel panelHomework = new JPanel();
        JLabel hwLabel = new JLabel("Homework: ");
        panelHomework.add(hwLabel);
        mHomeworkText = new JTextField[CourseConstants.NUM_HOMEWORKS];
        for(int i = 0; i <= CourseConstants.NUM_HOMEWORKS - 1; i++){
            mHomeworkText[i] = new JTextField(5);
            panelHomework.add(mHomeworkText[i]);
        }
        // Create the exam panel which contains the "Exam: " label and the two exam text fields.
        // The pseudocode is omitted because this code is very similar to the code that creates the
        // panelHomework panel above.
        JPanel panelExam = new JPanel();
        JLabel examLabel = new JLabel("Exam: ");
        panelExam.add(examLabel);
        mExamText = new JTextField[CourseConstants.NUM_EXAMS];
        for(int i = 0; i <= CourseConstants.NUM_EXAMS - 1; i++){
            mExamText[i] = new JTextField(5);
            panelExam.add(mExamText[i]);
        }

        // PSEUDOCODE:
        // Create a JPanel named panelButtons using FlowLayout
        // Create the Clear button mClearButton labeled "Clear"
        // Make this View the action listener for mClearButton
        // Add the  Clear button to the panel
        // Repeat the three above statements for the Save button
        // Repeat the three above statements for the Exit button
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout());
        mClearButton = new JButton("Clear");
        mClearButton.addActionListener(this);
        panelButtons.add(mClearButton);
        mSaveButton = new JButton("Save");
        mSaveButton.addActionListener(this);
        panelButtons.add(mSaveButton);
        mExitButton = new JButton("Exit");
        mExitButton.addActionListener(this);
        panelButtons.add(mExitButton);

        // PSEUDOCODE:
        // Create a JPanel named panelMain using a vertical BoxLayout
        // Add panelSearch to panelMain.
        // Add panelHomework to panelMain
        // Add panelExam to panelMain
        // Add panelButtons to panelMain
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.add(panelSearch);
        panelMain.add(panelHomework);
        panelMain.add(panelExam);
        panelMain.add(panelButtons);

        // Set the title of the View to whatever you want by calling setTitle()
        setTitle("Title");
        
        // Set the size of the View to FRAME_WIDTH x FRAME_HEIGHT
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        
        // Make the View non-resizable
        setResizable(false);
        
        // Set the default close operation to JFrame.EXIT_ON_CLOSE. What this does is if the user
        // clicks on the button in the View's titlebar to close the View, then the View will
        // be closed (as opposed to making the View dance around on the screen).
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Add panelMain to the View.
        add(panelMain);
        
        // *** If you are a Mac user, call pack() now to pack the View. I'm not exactly sure what
        // *** this does but if you do not do it, your View window may be too small for the
        // *** contents.
        
        // Now display the View by calling setVisible().
        setVisible(true);
    }

    /**
     * Called when one of the JButtons is clicked. Detects which button was clicked and handles it.
     *
     * Make sure to write the @Override annotation to prevent accidental overloading because we are
     * overriding JFrame.actionPerformed().
     */
    @Override
    public void actionPerformed(ActionEvent pEvent){
        if(pEvent.getActionCommand().equals("Search")){
            String lastName = mSearchText.getText();
            if(lastName.equals("")){
                messageBox("Please enter the student's last name.");
            } else {
                setStudent(getMain().search(lastName));
                if(getStudent() == null){
                    messageBox("Student not found. Try again.");
                }else{
                    displayStudent(getStudent());
                }
            }
        } else if(pEvent.getActionCommand().equals("Save")){
            if(getStudent() != null){
                saveStudent(getStudent());
            }
        } else if(pEvent.getActionCommand().equals("Clear")){
            clear();
        } else if(pEvent.getActionCommand().equals("Exit")){
            if(getStudent() != null){
                saveStudent(getStudent());
                getMain().exit();
            }
        }
    }

    /**
     * Called when the Clear button is clicked. Clears all of the text fields by setting the
     * contents of each to the empty string.
     *
     * After clear() returns, no student information is being edited or displayed and mStudent
     * has been set to null.
     */
    private void clear(){
        mSearchText.setText("");
        for(int i = 0; i <= CourseConstants.NUM_HOMEWORKS - 1; i++){
            mHomeworkText[i].setText("");
        }
        for(int i = 0; i <= CourseConstants.NUM_EXAMS - 1; i++){
            mExamText[i].setText("");
        }
        setStudent(null);
    }

    /**
     * Displays the homework and exam scores for a student in the mHomeworkText and mExamText text
     * fields.
     * @param pStudent is the Student who's scores we are going to use to populate the text fields.
     */
    private void displayStudent(Student pStudent){
        for(int i = 0; i <= CourseConstants.NUM_HOMEWORKS - 1; i++){
            int hw = pStudent.getHomework(i);
            String hwstr = Integer.toString(hw);
            mHomeworkText[i].setText(hwstr);
        }
        for(int i = 0; i <= CourseConstants.NUM_EXAMS - 1; i++){
            int exam = pStudent.getExam(i);
            String examstr = Integer.toString(exam);
            mExamText[i].setText(examstr);
        }
    }


    /**
     * Accessor method for mMain.
     */ 
    private Main getMain() {
        return mMain;
    }    

    /**
     * Accessor method for mStudent.
     */ 
    private Student getStudent() {
        return mStudent;
    }

    /**
     * Displays a message box containing some text. Note: pass 'this' as the first argument to
     * JOptionPane.showMessageDialog() to make the View the parent window of the message dialog.
     * This will cause the message dialog to be centered in the View. If you pass null as the
     * first argument, then the message dialog will not have a parent window and it will be
     * displayed in the center of the screen.
     */
    public void messageBox(String pMessage) {
        JOptionPane.showMessageDialog(this, pMessage, "Message", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Retrieves the homework and exam scores for pStudent from the text fields and writes the
     * results to the Student record in the Roster.
     */
    private void  saveStudent(Student pStudent){
        for(int i = 0; i <= CourseConstants.NUM_HOMEWORKS - 1; i++){
            String hwstr = mHomeworkText[i].getText();
            int hw = Integer.parseInt(hwstr);
            pStudent.setHomework(i, hw);
        }
        for(int i = 0; i <= CourseConstants.NUM_EXAMS - 1; i++){
            String examstr = mExamText[i].getText();
            int exam = Integer.parseInt(examstr);
            pStudent.setExam(i, exam);
        }

    }
    
    /**
     * Mutator method for mMain.
     */ 
    private void setMain(Main pMain) {
        mMain = pMain;
    }    

    /**
     * Mutator method for mStudent.
     */ 
    private void setStudent(Student pStudent) {
        mStudent = pStudent;
    }

}
