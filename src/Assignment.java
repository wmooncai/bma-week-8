import java.sql.Timestamp;

/**
 * @author W. Mooncai
 * 
 * @version 0.6
 * 
 * Crossfire BMA Week 6 Homework
 * Due: 10/15/2012
 *
 */

public class Assignment {

	public static void main(String[] args) {
		
		int week = 6;
		
		switch (week) {
		
		case 6:
			week6Main();
			break;
			
		case 5:
			week5Main();
			break;

		} // switch (week)
		
	} // main()
	
	/**
	 * Week 6 Homework Main()
	 * 
	 * @since 0.6
	 * 
	 *    Read
	 *        + Chapter 8 in Java A Beginner's Guide - Interfaces and Packages
	 *        
	 *    Assignment
	 *        + Create a github repository to hold homework named bma-week-6 containing a class, Assignment
	 *        + Copy the Task class you created last week into the Assignment.java file
	 *           + The previous two tasks could be achieved by cloning your week 5 repository
	 *        + Apply access modifiers to your Task class
	 *            + All instances variables should be made private
	 *            + Determine what functionality and data you want to make accessible to outside callers via methods
	 *                Some examples could include the following but I'm not trying to design your solutions.  These are just ideas
	 *                    isComplete(): bool
	 *                    getCompletionDate(): Calendar
	 *                    getTitle(): String
	 *                    getDescription(): String
	 *                    hasPrerequisite(): bool
	 *                    getPrerequisite(): Task
	 *            + Implement whatever functionality you come up with in the last step
	 *        Create Task hierarchy 
	 *            + Consider different kinds of tasks (todo items) your todo list could have. 
	 *                + What extra functionality or behavior would they have?
	 *            + Consider what functionality and data would be common to all tasks
	 *            Refactor your Task class
	 *                + Make the base Task class abstract
	 *                + Hide all instance variables with private modifiers if you didn't already
	 *                	*** I used protected, otherwise, inheritance wouldn't work
	 *                + Implement the common functionality from above as methods
	 *                + Add accessors (getters and/or setters) for any member variables you think need them
	 *                    You don't necessarily need both
	 *                    Its easier to add one later if you need it than to take one away
	 *            + Override methods in Task children when necessary
	 *                + At a bare minimum override toString for each child Task class
	 *        Test new Task hierarchy
	 *            + In the Assignment class, create a method "private static void printTask(Task)" that prints out Task objects
	 *            + In Assignment's main() method, create at least one of each type of Task created earlier.
	 *            + Send each task to printTask()
	 *            + [bonus]: test the rest of your Task parent class' public interface.
	 *
	 *	This assignment is aimed at both giving a feeling for inheritance and for getting you thinking about implementation 
	 *	ideas for your project.  It might be that your solution doesn't have a need to inheritance hierarchies.  
	 *	That's fine but there are two goals here.
	 *
	 */
	
	private static void week6Main() {

		// Instantiate new task objects
		GeneralTask generalTask1 = new GeneralTask();
		
		HomeworkTask homeworkTask1 = new HomeworkTask("New Homework Task 1"
													, (System.currentTimeMillis() + 1));
		
		HomeworkTask homeworkTask2 = new HomeworkTask("New Homework Task 2"
													, (System.currentTimeMillis() + 2)
													, (System.currentTimeMillis() + 3)
													, "Homework Task 2 Note - This was a really big homework."
													, (System.currentTimeMillis() + 4)
													, "Building Mobile Apps Fall 2012"
													, 4.0
													, 100);
		
		// Output new task object contents using printTask()
		printTask(generalTask1);
		printTask(homeworkTask1);
		printTask(homeworkTask2);
		
		// Bonus: Test Task class public interface
		System.out.println("\nHW 6 Bonus - Test the Task class public interface:");
		
		// Each setter also tests its corresponding getter
		System.out.println(Task.getInterfaceConstants());
		generalTask1.setTaskName("Bonus " + generalTask1.getTaskName());
		generalTask1.setStartDateTime(generalTask1.getStartDateTime() + 1);
		generalTask1.setEndDateTime(generalTask1.getStartDateTime() + 1);
		generalTask1.setEndDateTime(generalTask1.getEndDateTime() - 1);  // Test conditional in setEndDateTime()
		generalTask1.setEndDateTime(generalTask1.getEndDateTime() - 2);  // Test conditional in setEndDateTime()
		generalTask1.setCompleted(true);
		
		printTask(generalTask1);
		
	} // week6Main()
	
	/**
	 * Week 5 Homework main()
	 * @version 0.6
	 * - Since HW6 modified Task Class to be abstract, Task instantiations were changed to GeneralTask instantiations
	 * @since 0.5
	 * (switched since 0.6)
	 * 
	 *     Read
	 *        + Chapter 7 in Java: A Beginner's Guide
	 *     
	 *     Programming assignment
	 *        + Create a github repository to hold homework.  It should be named bma-week-5.  It should contain an Assignment.java file
	 *        + Implement the following static method "static String getElement(String values, int index)"
	 *            + If the index is not a valid array index, return null
	 *                In the future we'll try to avoid this, but we currently don't have error handling in our toolbox
	 *            + Otherwise, return the array element at the index
	 *        + Implement a class named Task inside the Assignment.java file
	 *            + Do not create a new file.  Place the Task class immediately after the end of the Assignment class in Assignment.java
	 *            + Do not implement a main method in Task.
	 *            + Add the instance variables you think belong in a Task object
	 *            + Implement at least one parameterized constructor for the Task class
	 *            + Implement a no-argument constructor for the Task class
	 *            + Implement a main() method in the Assignment class that does the following
	 *                + Call every constructor implemented in Task at least once, assigning the resulting object to a variable
	 *                + Pass each Task object created to "System.out.println(aTask);"
	 *            + Try to run Assignment
	 *                Why didn't it work?  The compiler has no idea how to convert a Task object into a String
	 *            + Implement a toString() method in Task
	 *                + The signature has to be "public String toString()" exactly
	 *                + Create a String representation of a Task.  This does not need to display every piece of data in the class, 
	 *                just the core information.  "Task(title)" would be a sparse but acceptable implementation.
	 *            + Try to run Assignment again
	 *                + It should work.  If not, try debugging.  If that fails, send an email
	 *
	 */
	
	private static void week5Main() {

		String myTaskName = "My Task ";
		
		// Instantiate new task objects
		Task task1 = new GeneralTask((myTaskName + "1"), (System.currentTimeMillis() + 1));
		Task task2 = new GeneralTask((myTaskName + "2"), (System.currentTimeMillis() + 2));
		Task task3 = new GeneralTask();
		
		// Output new task object contents
		System.out.println(task1.toString(Task.NAME_TO_STR));
		System.out.println(task2.toString(Task.NAME_TO_STR, Task.START_DATE_TO_STR));
		System.out.println(task3);		
		
	} // week5Main()
	
	/**
	 * Output a Task to console
	 * 
	 * @since 0.6
	 * 
	 * @param taskIn	Task to output to console
	 * 
	 */
	private static void printTask(Task taskIn) {
		System.out.println(taskIn);
	} // printTask()

	/**
	 * Extract a character from a String
	 * 
	 * @since 0.5
	 * 
	 * @param values	String from which to extract a character
	 * @param index		Index of character to extract
	 * 
	 * @return			Return the character at index.  If index is invalid, return null.
	 * 
	 */
	static String getElement(String values, int index) {
		
		if ((index >= 0) && (index < values.length())) {
			return values.substring(index, index);
		} else return null;
		
	} // getElement(String, int)

	/**
	 * Extract a String element from a String array
	 * 
	 * @since 0.5
	 * 
	 * @param values	String from which to extract a character
	 * @param index		Index of character to extract
	 * 
	 * @return			Return the character at index.  If index is invalid, return null.
	 * 
	 */
	static String getElement(String[] values, int index) {
		
		if ((index >= 0) && (index < values.length)) {
			return values[index];
		} else return null;
		
	} // getElement(String[], int)
	
} // CLASS Assignment


/**
 * 
 * @author W. Mooncai
 * 
 * @since 0.6
 * 
 * Task Class Interface
 * 
 * @param MAX_NAME_LEN			Maximum length of the Task name
 * 
 * @param NAME_TO_STR			Flag for toString() to output the Task Name
 * @param START_DATE_TO_STR		Flag for toString() to output the Start Date/Time
 * @param END_DATE_TO_STR		Flag for toString() to output the End Date/Time
 * 
 */
interface TaskInterface {
	
	// Constants
	public static final int MAX_NAME_LEN = 30;
	
	public static final int NAME_TO_STR = 10;
	public static final int START_DATE_TO_STR = 20;
	public static final int END_DATE_TO_STR = 30;
	public static final int COMPLETED_TO_STR = 40;
	
} // INTERFACE TaskInterface

/**
 * @author Wallace Mooncai
 * 
 * @since 0.5
 * 
 * Class Task is a basic task class
 * 
 * - Version 0.6 changed to abstract class
 * 
 * @param taskName				Name of the Task
 * @param startDateTime			Task Start Date/Time
 * @param endDateTime			Task End Date/Time
 * @param completed				Flag to manually mark this task as complete
 * 
 */

abstract class Task implements TaskInterface {

	// Private Constant
	private static final String MY_TASK_NAME = "My Task ";
	
	// Member Fields
	protected StringBuffer taskName = new StringBuffer(MAX_NAME_LEN);
	protected long startDateTime;
	protected long endDateTime;
	protected boolean completed;
	
	// ************************************ Constructor - no args ************************************
	/**
	 * Task Constructor with no arguments
	 * 
	 * @since 0.5
	 * 
	 * Member fields set to defaults:
	 * @param taskName			Defaults to a generic task name
	 * @param startDateTime		Defaults to current date / time
	 * @param endDateTime		Defaults to current date / time minus 1ms
	 * @param completed			Flag to manually mark this task as complete; defaults to false (incomplete)
	 * 
	 */
	public Task() {
		
		setStrBuff(taskName, MY_TASK_NAME, MAX_NAME_LEN);
		
		startDateTime = System.currentTimeMillis();
		endDateTime = startDateTime - 1;
				
	} // Task()
	
	// *********************** Constructor - with task name and start time args **********************
	/**
	 * Task Constructor with arguments
	 * 
	 * @since 0.5
	 * 
	 * @param tName			Task name
	 * @param startDT		Set the start date / time.  End date / time is set 1ms prior to start date / time.
	 * 
	 */
	public Task(String tName, long startDT) {
		
		startDateTime = startDT;
		endDateTime = startDT - 1;
		
		setStrBuff(taskName, tName, MAX_NAME_LEN);
		
	} // Task() - 2 args
		
	// ********************************* Constructor - with all args *********************************
	/**
	 * Constructor accepting arguments for all member fields
	 * 
	 * @since 0.5
	 * 
	 * @param startDT		Start date / time
	 * @param endDT			End date / time
	 * @param tName			Task name
	 * 
	 */
	
	public Task(String tName, long startDT, long endDT) {
		
		startDateTime = startDT;
		endDateTime = startDateTime - 1;
		
		setStrBuff(taskName, tName, MAX_NAME_LEN);
		
	} // Task() - all args
	
	// **************************************** GETTERS ************************************************
	
	/**
	 * Return task completed status
	 * 
	 * @since 0.6
	 * 
	 * @return		endDateTime
	 * 
	 */
	public boolean isComplete(){
		
		return completed;
		
	} // getCompleted()
	
	/**
	 * Return task end date / time
	 * 
	 * @since 0.6
	 * 
	 * @return		endDateTime
	 * 
	 */
	public long getEndDateTime(){
		
		return endDateTime;
		
	} // getEndDateTime()

	/**
	 * Return task start date / time
	 * 
	 * @since 0.6
	 * 
	 * @return		startDateTime
	 * 
	 */
	public long getStartDateTime(){
		
		return startDateTime;
		
	} // getStartDateTime()
	
	/**
	 * Return Task Name
	 * 
	 * @since 0.6
	 * 
	 * @return		taskName
	 * 
	 */
	public StringBuffer getTaskName() {
		
		return taskName;
		
	} // getTaskN()
	
	/**
	 * Return all Task Class Interface constants as a formatted String
	 * 
	 * @since 0.6
	 * 
	 * @return		A formatted String listing all Task Interface constants
	 * 
	 */
	public static String getInterfaceConstants() {
		
		return   "\nTask class Interface constants:"
				+ "\n     MAX_NAME_LEN: " + MAX_NAME_LEN
				+ "\n      NAME_TO_STR: " + NAME_TO_STR
				+ "\nSTART_DATE_TO_STR: " + START_DATE_TO_STR
				+ "\n  END_DATE_TO_STR: " + END_DATE_TO_STR
				+ "\n COMPLETED_TO_STR: " + COMPLETED_TO_STR + "\n";
				
	} // getInterfaceConstants()
	
	// **************************************** SETTERS ************************************************
	
	/**
	 * Set task completed status
	 * 
	 * @since 0.6
	 * 
	 */
	public void setCompleted(boolean status){
		
		completed = status;
		
	} // setCompleted()
	
	/**
	 * Set task end date / time
	 * 
	 * @since 0.6
	 * 
	 * @return		success /fail
	 * 
	 */
	public boolean setEndDateTime(long endDT){
		
		if (endDT <= startDateTime) {
			return false;
		} else {
			endDateTime = endDT;
			return true;
		} // if
		
	} // setEndDateTime()

	/**
	 * Set task start date / time
	 * 
	 * @since 0.6
	 * 
	 * @return		success /fail
	 * 
	 */
	public boolean setStartDateTime(long startDT) {
		
		startDateTime = startDT;
		
		// start should be in the future
		if ( startDateTime >= System.currentTimeMillis() ) {
			return true;
		} else return false;
		
	} // setStartDateTime()

	/**
	 * Set task name using a String
	 * 
	 * @since 0.6
	 * 
	 * @return		taskName
	 * 
	 */
	public boolean setTaskName(String tName) {
		
		return setTaskName(new StringBuffer(tName));
		
	} // setTaskName(String)
	
	/**
	 * Set task name using a StringBuffer
	 * 
	 * @since 0.6
	 * 
	 * @return		taskName
	 * 
	 */
	public boolean setTaskName(StringBuffer tName) {
		
		return setStrBuff(taskName, tName, MAX_NAME_LEN);
		
	} // setTaskName(StringBuffer)
	
	/**
	 * Sanitize an input String and assign it to a StringBuffer
	 * 
	 * @since 0.6
	 * 
	 * @param memberString		member field receiving the newString value (this StringBuffer will change with valid newString)
	 * @param newString			input String
	 * @param maxLen			max length of the member String as defined in TaskInterface
	 * 
	 * @return					assignment status; a bad String length returns false
	 * 
	 */
	protected boolean setStrBuff(StringBuffer memberString, String newString, int maxLen) {
		
		// Sanitize newString and assign it to memberString
		if (newString != null) {
			if (newString.length() > 0) {
				if (newString.length() <= maxLen) {
					memberString.replace(0, (maxLen - 1), newString.toString());
					return true;
				} else {
					// Input notes newString is too long, so truncate and assign it
					memberString.replace(0, (maxLen - 1), newString.substring(0, maxLen));
					return true;
				}					// if maxLen
			} else return false;	// if length > 0
		} else return false;		// if null
		
	} // setStrBuff(.., String, ...)
	
	/**
	 * Wrapper for setStrBuff(..., String, ...) to take an input StringBuffer instead of String
	 * 
	 * @since 0.6
	 * 
	 * @param memberStringSB	String receiving String input newStringS
	 * @param newStringSB		Input StringBuffer to be assigned to memberStringSB
	 * @param maxLength			Maximum length of StringBuffer
	 * 
	 * @return					Success / Failure status
	 * 
	 */
	protected boolean setStrBuff(StringBuffer memberStringSB, StringBuffer newStringSB, int maxLength) {
		
		return setStrBuff(memberStringSB, newStringSB.toString(), maxLength);
		
	} // setStrBuff(..., StringBuffer, ...)
	
	// ********************************* Conversions *****************************************
	
	/**
	 * Function toString(Field Constant Flags) to output desired member fields with formatting.
	 * The order of the field flags determines their output order.
	 * 
	 * @since 0.5
	 * 
	 * @param Field Constant Flags		Public flags to indicate which member fields to output
	 * @return String describing selected member fields
	 * 
	 * @see TaskInterface for available field flags to choose from
	 * 
	 */
	public String toString(int ... varsToString) {
		
		StringBuffer returnString = new StringBuffer(0);

		for (int memberVar : varsToString) {
			switch (memberVar) {
			case NAME_TO_STR:
				returnString.append("\n      Task Name: " + taskName
								  + "\n      Task Hash: " + new String(this.getClass().toString()).substring(6) + "@"
								  						  + this.hashCode());
				break;
			case START_DATE_TO_STR:
				returnString.append("\nStart Date/Time: " + startDateTime + " (" + new Timestamp(startDateTime) + ")");
				break;
			case END_DATE_TO_STR:
				returnString.append("\n  End Date/Time: " + endDateTime + " (" + new Timestamp(endDateTime) + ")");
				break;
			case COMPLETED_TO_STR:
				returnString.append("\n      Completed: " + completed);
				break;
			} // switch (memberVar)
		} // for loop
		
		return returnString.toString();
		
	} // toString(args)
	
	/**
	 * toString() will format and output all Task fields
	 * 
	 * @since 0.6
	 * 
	 */
	public String toString() {
		
		return toString(NAME_TO_STR, START_DATE_TO_STR, END_DATE_TO_STR, COMPLETED_TO_STR);
		// return "\nTask Name: " + taskName.toString() + "\nstartDateTime: " + startDateTime + "\ncomplete: " + completed;

	} // toString()
	
} // CLASS Task

// ****************************************** GeneralTask *********************************************

/**
 * 
 * @author W. Mooncai
 * @since 0.6
 * 
 * General Task Class Interface
 * 
 * @param MAX_HW_NOTES_LEN			Maximum length of the Task notes
 * @param NAME_TO_STR			Flag for toString() to output the Task Notes
 * 
 */
interface GeneralTaskInterface {
	
	// Constants
	public static final int MAX_NOTES_LEN = 100;
	
	public static final int NOTES_TO_STR = 50;
	
} // INTERFACE GeneralTaskInterface

/**
 * 
 * @author W. Mooncai
 * @since 0.6
 * 
 * GeneralTask Class
 * 
 * @param taskNotes		task notes field
 * 
 */
class GeneralTask extends Task implements GeneralTaskInterface {
	
	protected StringBuffer taskNotes = new StringBuffer("New General Task Notes");
	
	// ************************************ Constructor - no args ************************************
	/**
	 * Basic GeneralTask constructor with no arguments
	 * 
	 * @since 0.6
	 * 
	 */
	public GeneralTask() {
		
		super();

		setStrBuff(taskName, "New General Task", MAX_NAME_LEN);
		setStrBuff(taskNotes, taskName + " Notes", MAX_NOTES_LEN);
		
	} // GeneralTask()
	
	// *********************** Constructor - with task name and start time args **********************
	/**
	 * GeneralTask Constructor with arguments
	 * 
	 * @since 0.6
	 * 
	 * @param tName			Task name
	 * @param startDT		Set the start date / time.  End date / time is set 1ms prior to start date / time.
	 * 
	 */
	public GeneralTask(String tName, long startDT) {
		
		super(tName, startDT);

		setStrBuff(taskNotes, taskName + " Notes", MAX_NOTES_LEN);
		
	} // GeneralTask() - 2 args

	// ********************************* Constructor - with all super args *********************************
	/**
	 * Constructor accepting arguments for all member fields
	 * 
	 * @since 0.6
	 * 
	 * @param startDT		Start date / time
	 * @param endDT			End date / time
	 * @param tName			Task name
	 * 
	 */
	public GeneralTask(String tName, long startDT, long endDT) {
		
		super(tName, startDT, endDT);
		
		// Use a GeneralTask specific taskName
		setStrBuff(taskName, tName, MAX_NAME_LEN);
		
	} // GeneralTask() - all GeneralTask args
	
	// ********************************* Constructor - with all args *********************************
	/**
	 * Constructor accepting arguments for all member fields
	 * 
	 * @since 0.6
	 * 
	 * @param startDT		Start date / time
	 * @param endDT			End date / time
	 * @param tName			Task name
	 * 
	 */
	public GeneralTask(String tName, long startDT, long endDT, String tNotes) {
		
		super(tName, startDT, endDT);
		
		setStrBuff(taskName, tName, MAX_NAME_LEN);
		setStrBuff(taskNotes, tNotes, MAX_NOTES_LEN);

	} // GeneralTask() - all args
	
	// **************************************** GETTERS ************************************************
	
	/**
	 * Return task notes
	 * 
	 * @since 0.6
	 * 
	 * @return		endDateTime
	 * 
	 */
	public StringBuffer getTaskNotes() {
		
		return taskNotes;
		
	} // getTaskNotes()
	
	// **************************************** SETTERS ************************************************
	
	/**
	 * Set task notes
	 * 
	 * @since 0.6
	 * 
	 * @return		success / failure
	 * 
	 */
	public boolean setTaskNotes(StringBuffer newString) {
		
		return setStrBuff(taskNotes, newString, MAX_NOTES_LEN);
		
	} // setTaskNotes()
	
	// ********************************* Conversions *****************************************
	
	/**
	 * Function toString(Field Constant Flags) to output desired member fields formatted.
	 * The order of the field flags determines their output order.
	 * 
	 * @since 0.6
	 * 
	 * @param Field Constant Flags		Public flags to indicate which member fields to output
	 * 
	 * @return	String describing selected member fields
	 * 
	 * @see GeneralTaskInterface and TaskInterface for available field flags to choose from
	 * 
	 */
	public String toString(int ... varsToString) {

		StringBuffer returnString = new StringBuffer(super.toString(varsToString));

		for (int memberVar : varsToString) {
			// Although we just have one new member field, I left the switch in place for future expansion
			switch (memberVar) {
			case NOTES_TO_STR:
				returnString.append("\n-    Task Notes: " + taskNotes.toString());
				break;
			} // switch (memberVar)
		} // for loop
		
		return returnString.toString();
		
	} // toString(args)
	
	/**
	 * toString() will format and output all Task member fields
	 * 
	 * @since 0.6
	 * 
	 * @return String describing all member fields
	 * 
	 */
	@Override
	public String toString() {
		
		return super.toString() + toString(NOTES_TO_STR);
		
	} // toString()
	
} // CLASS GeneralTask

/**
 * 
 * @author W. Mooncai
 * 
 * Constants for Grade Class
 * 
 * @since 0.6
 * 
 * @param MAX_GRADE		Maximum valid grade
 * @param MIN_GRADE		Minimum valid grade
 *
 */
interface GradeInterface {

	public static final double MAX_GRADE = 4.5;
	public static final double MIN_GRADE = 0.0;
	
} // GradeInterface

/**
 * 
 * @author W. Mooncai
 * @since 0.6
 * 
 * Grade class is for use with the HomeworkTask class.  It includes validity checking and conversion functions.
 *
 * @param gradeVal		Grade awarded to its task
 * 
 */
class Grade implements GradeInterface {
	
	private double gradeVal = 0.0;
	
	/**
	 * Base constructor with no arguments, initializes grade to 0.0
	 * 
	 * @since 0.6
	 * 
	 */
	Grade() {
		gradeVal = 0.0;
	} // Grade()
	
	/**
	 * Constructor with grade initialization value
	 * 
	 * @since 0.6
	 * 
	 * @param gradeIn	initial grade
	 * 
	 */
	Grade(double gradeIn) {
		if ( isValid(gradeIn) ) {
			gradeVal = gradeIn;
		} else {
			// TODO throw an exception for or otherwise handle an invalid grade
		}

	} // Grade(double)
	
	/**
	 * Confirm if a grade is valid or not
	 * 
	 * @since 0.6
	 * 
	 * @param gradeCandidate	Grade to verify validity
	 * 
	 * @return					Validity
	 * 
	 */
	public boolean isValid(double gradeCandidate) {
		
		if ( (gradeCandidate >= MIN_GRADE) && (gradeCandidate <= MAX_GRADE) ) {
			return true;
		} else {
			return false;
		}
		
	} // isValid()
	
	// **************************************** GETTERS ************************************************
	
	/**
	 * Return grade as a double
	 * 
	 * @since 0.6
	 * 
	 * @return		grade
	 * 
	 */
	public double getGrade() {
		
		return gradeVal;
		
	} // getGrade()
	
	// **************************************** SETTERS ************************************************
	
	/**
	 * Set grade with double as input
	 * 
	 * @since 0.6
	 * 
	 * @return		success / failure
	 * 
	 */
	public boolean setGrade(double newGrade) {
		
		if ( isValid(newGrade) ) {
			gradeVal = newGrade;
			return true;
		} else return false;
		
	} // setTaskNotes()
	
	// ********************************* Conversions *****************************************
	
	/**
	 * Returns the double value of gradeVal
	 * 
	 * @since 0.6
	 * 
	 * @return	grade as a double value
	 * 
	 */
	public double doubleValue() {
		
		return gradeVal;

	} // doubleValue()
	
	/**
	 * Returns letter representation of grade as a String
	 * 
	 * @since 0.6
	 * 
	 * @return		a String containing the letter representation of gradeVal
	 * 
	 */
	public String toString() {
		
		if (gradeVal >= 4.0) {
			return "A"; 
		} else if (gradeVal >= 3.0) {
			return "B";
		} else if (gradeVal >= 2.0) {
			return "C";
		} else if (gradeVal >= 1.0) {
			return "D";
		} else return "F";
		
	} // toString()
	
} // CLASS Grade


// #############################################################################################333

//****************************************** GeneralTask *********************************************

/**
* 
* @author W. Mooncai
* @since 0.6
* 
* Homework Task Class Interface constants
* 
* @param MAX_HW_NOTES_LEN			Maximum length of the Task notes
* 
* @param MAX_COURSENAME_LEN		Maximum length of the course name field
* @param MAX_GRADE_LEN			Maximum length of the grade field
* 
* @param DUEDATE_TO_STR			Flag for toString() to output the task duedate
* 
*/
interface HomeworkTaskInterface {
	
	// Constants
	public static final int MAX_HW_NOTES_LEN = 500;
	
	public static final int MAX_COURSENAME_LEN = 40;
	public static final int MAX_GRADE_LEN = 2;
	
	public static final int DUEDATE_TO_STR = 60;
	public static final int COURSENAME_TO_STR = 70;
	public static final int GRADE_TO_STR = 80;
	public static final int POINTS_TO_STR = 90;
	
} // INTERFACE GeneralTaskInterface

/**
* 
* @author W. Mooncai
* 
* HomeworkTask Class
* 
* @since 0.6
* 
* @param dueDate		Due date of this task
* @param courseName		Name of this task
* @param gradeVal			Numerical grade awarded to this task
* @param points			Points awarded to this task
* 
*/
class HomeworkTask extends GeneralTask implements HomeworkTaskInterface {
	
	private long dueDate = System.currentTimeMillis();
	private StringBuffer courseName = new StringBuffer("Building Mobile Apps");
	private Grade grade = new Grade(0.0);
	private double points = 0.0;
	
	// ************************************ Constructor - no args ************************************
	/**
	 * Base HomeworkTask constructor with no arguments
	 * 
	 * @since 0.6
	 * 
	 */
	public HomeworkTask() {
		
		super();

		setStrBuff(taskName, "New Homework Task", MAX_NAME_LEN);
		setStrBuff(taskNotes, taskName + " Notes", MAX_HW_NOTES_LEN);
		
	} // GeneralTask()
	
	// *********************** Constructor - with task name and start time args **********************
	/**
	 * HomeworkTask Constructor with arguments
	 * 
	 * @since 0.6
	 * 
	 * @param tName			Task name
	 * @param startDT		Set the start date / time.  End date / time is set 1ms prior to start date / time.
	 * 
	 */
	public HomeworkTask(String tName, long startDT) {
		
		super(tName, startDT);
		
		setStrBuff(taskNotes, "New Homework Task Notes", MAX_HW_NOTES_LEN);
		
	} // GeneralTask() - 2 args
		
	// ********************************* Constructor - with all super args *********************************
	/**
	 * HomeworkTask Constructor accepting arguments for all super member fields
	 * 
	 * @since 0.6
	 * 
	 * @param startDT		Start date / time
	 * @param endDT			End date / time
	 * @param tNotes		Task name
	 * 
	 */
	
	public HomeworkTask(String tName, long startDT, long endDT, String tNotes) {
		
		super(tName, startDT, endDT, tNotes);
		
	} // GeneralTask() - all super args
	
	// ********************************* Constructor - with all  args *********************************
	/**
	 * HomeworkTask Constructor accepting arguments for all member fields
	 * 
	 * @since 0.6
	 * 
	 * @param startDT		Start date / time
	 * @param endDT			End date / time
	 * @param tNotes		Task name
	 * 
	 * @param dueDT			Homework due date
	 * @param cName			Homework course name
	 * @param hWGrade		Homework grade
	 * @param hWPoints		Homework points
	 * 
	 */
	
	public HomeworkTask(String tName, long startDT, long endDT, String tNotes
						, long dueDT, String cName, double hWGrade, double hWPoints) {
		
		super(tName, startDT, endDT, tNotes);
		
		setDueDate(dueDT);
		setStrBuff(courseName, cName, MAX_COURSENAME_LEN);
		grade.setGrade(hWGrade);
		setPoints(hWPoints);
		
	} // GeneralTask() - all args
	
	// **************************************** GETTERS ************************************************
	
	/**
	 * Return HomeworkTask due date
	 * 
	 * @since 0.6
	 * 
	 * @return		Task due date
	 * 
	 */
	public long getDueDate() {
		
		return dueDate;
		
	} // getDueDate()
	
	/**
	 * Return HomeworkTask grade
	 * 
	 * @since 0.6
	 * 
	 * @return		Task grade
	 * 
	 */
	public Grade getGrade() {
		
		return grade;
		
	} // getGrade()
	
	/**
	 * Return HomeworkTask points
	 * 
	 * @since 0.6
	 * 
	 * @return		Task points
	 * 
	 */
	public double getPoints() {
		
		return points;
		
	} // getPoints()
	
	// **************************************** SETTERS ************************************************
	
	/**
	 * Set HomeworkTask dueDate
	 * 
	 * @since 0.6
	 * 
	 * @return		HomeworkTask dueDate
	 * 
	 */
	public long setDueDate(long dueDT) {
		
		return dueDT;
		
	} // setDueDate()
	
	/**
	 * Set HomeworkTask grade
	 * 
	 * @since 0.6
	 * 
	 * @return		Homework dueDate
	 */
	public Grade setGrade(double gradeIn) {
		
		return this.setGrade(gradeIn);
		
	} // setGrade()
	
	/**
	 * Set HomeworkTask points
	 * 
	 * @since 0.6
	 * 
	 * @return		Homework points
	 * 
	 */
	public boolean setPoints(double pointsIn) {
		
		if ( (pointsIn >= 0) && (pointsIn <= 100) ) {
			
			points = pointsIn;
			return true;
			
		} else return false;
		
	} // setPoints()
	
	// ********************************* Conversions *****************************************
	
	/**
	 * Function toString(Field Constant Flags) to output desired member fields formatted.
	 * The order of the field flags determines their output order.
	 * 
	 * @since 0.6
	 * 
	 * @param Field Constant Flags		Public flags to indicate which member fields to output
	 * 
	 * @return	String describing selected member fields
	 * 
	 * @see GeneralTaskInterface and TaskInterface for available field flags to choose from
	 * 
	 */
	public String toString(int ... varsToString) {

		StringBuffer returnString = new StringBuffer(super.toString(varsToString));

		for (int memberVar : varsToString) {
			switch (memberVar) {
			case DUEDATE_TO_STR:
				returnString.append("\n--     Due Date: " + dueDate + " (" + new Timestamp(dueDate) + ")");
				break;
			case COURSENAME_TO_STR:
				returnString.append("\n--  Course Name: " + courseName);
				break;
			case GRADE_TO_STR:
				returnString.append("\n--        Grade: " + grade);
				break;
			case POINTS_TO_STR:
				returnString.append("\n--       Points: " + points);
				break;
			} // switch (memberVar)
		} // for loop
		
		return returnString.toString();
		
	} // toString(args)
	
	/**
	 * toString() will format and output all Task fields
	 * 
	 * @since 0.6
	 * 
	 * @return String describing all member fields
	 * 
	 */
	@Override
	public String toString() {
		
		return super.toString() + toString(DUEDATE_TO_STR, COURSENAME_TO_STR, GRADE_TO_STR, POINTS_TO_STR);
		
	} // toString()
	
} // CLASS GeneralTask
