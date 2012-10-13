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
		HomeworkTask homeworkTask1 = new HomeworkTask(new StringBuffer("New Homework Task 1")
													, (System.currentTimeMillis() + 1));
		HomeworkTask homeworkTask2 = new HomeworkTask(new StringBuffer("New Homework Task 2")
													, (System.currentTimeMillis() + 2));
		
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

		StringBuffer myTaskName = new StringBuffer("My Task ");
		
		// Instantiate new task objects
		Task task1 = new GeneralTask(myTaskName.append("1"), (System.currentTimeMillis() + 1));
		Task task2 = new GeneralTask(myTaskName.replace((myTaskName.length() - 1)
				, (myTaskName.length()), "2"), (System.currentTimeMillis() + 2));
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
 * @param taskName				Name of the Task
 * @param startDateTime			Task Start Date/Time
 * @param endDateTime			Task End Date/Time
 * @param completed				Flag to manually mark this task as complete
 * 
 */

abstract class Task implements TaskInterface {

	// Private Constant
	private static final String MY_TASK_NAME = "My Task ";
	
	// Fields
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
		 
		taskName.replace(0, taskName.length(), MY_TASK_NAME);

		startDateTime = System.currentTimeMillis();
		endDateTime = startDateTime - 1;
				
	} // Task()
	
	// *********************** Constructor - with task name and start time args **********************
	/**
	 * Task Constructor with arguments
	 * 
	 * @since 0.5
	 * 
	 * @param taskN			Task name
	 * @param startDT		Set the start date / time.  End date / time is set 1ms prior to start date / time.
	 * 
	 */
	public Task(StringBuffer taskN, long startDT) {
		
		startDateTime = startDT;
		endDateTime = startDT - 1;
		
		if (taskN.length() > MAX_NAME_LEN) {
			taskName = (StringBuffer) taskN.subSequence(0, MAX_NAME_LEN);
		} else taskName.replace(0, taskName.length(), taskN.toString());
		
	} // Task() - 2 args
		
	// ********************************* Constructor - with all args *********************************
	/**
	 * Constructor accepting arguments for all member fields
	 * 
	 * @since 0.5
	 * 
	 * @param startDT		Start date / time
	 * @param endDT			End date / time
	 * @param taskN			Task name
	 * 
	 */
	
	public Task(long startDT, long endDT, StringBuffer taskN) {
		
		startDateTime = startDT;
		endDateTime = startDateTime - 1;
		
		sanitizeStrBuffLen(taskName, taskN, MAX_NAME_LEN);
		
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
	public boolean getCompleted(){
		
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
	public boolean setEndDateTime(long end){
		
		if (end <= startDateTime) {
			return false;
		} else {
			endDateTime = end;
			return true;
		}
		
	} // setEndDateTime()

	/**
	 * Set task start date / time
	 * 
	 * @since 0.6
	 * 
	 * @return		success /fail
	 * 
	 */
	public boolean setStartDateTime(long start) {
		
		startDateTime = start;
		
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
	public boolean setTaskName(String name) {
		
		return setTaskName(new StringBuffer(name));
		
	} // setTaskName(String)
	
	/**
	 * Set task name using a StringBuffer
	 * 
	 * @since 0.6
	 * 
	 * @return		taskName
	 * 
	 */
	public boolean setTaskName(StringBuffer name) {
		
		return sanitizeStrBuffLen(taskName, name, MAX_NAME_LEN);
		
	} // setTaskName(StringBuffer)
	
	/**
	 * Sanitize an input string based on input string length and assign it to a class member string
	 * @since 0.6
	 * 
	 * @param memberString		member string receiving the newString
	 * @param newString			input string
	 * @param maxLen			max length of the member string as defined in the task object interface
	 * 
	 * @return					assignment status; a bad member string length returns false
	 * 
	 */
	protected boolean sanitizeStrBuffLen(StringBuffer memberString, StringBuffer newString, int maxLen) {
		
		// Sanitize newString and assign it to memberString
		if (newString.length() > 0) {
			if (newString.length() <= maxLen) {
				memberString.replace(0, (maxLen - 1), newString.toString());
				return true;
			} else {
				// Input notes is too long, so truncate and save it
				memberString.replace(0, (maxLen - 1), newString.substring(0, maxLen));
				return true;
			} // if-else inner
		} // if outer
		
		return false;
		
	} // sanitizeStrBuffLen()
	
	// ***************************************** toString() ******************************************
	
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
 * @param MAX_NOTES_LEN			Maximum length of the Task notes
 * 
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
	 * @since 0.6
	 * 
	 */
	public GeneralTask() {
		
		super();

		taskName.replace(0, taskName.length(), "New General Task");
		taskNotes.replace(0, taskNotes.length(), "New General Task Notes");
		
	} // GeneralTask()
	
	// *********************** Constructor - with task name and start time args **********************
	/**
	 * GeneralTask Constructor with arguments
	 * @since 0.6
	 * 
	 * @param taskN			Task name
	 * @param sDateTime		Set the start date / time.  End date / time is set 1ms prior to start date / time.
	 * 
	 */
	public GeneralTask(StringBuffer taskN, long sDateTime) {
		
		super(taskN, sDateTime);

		taskNotes.replace(0, taskNotes.length(), "New Homework Task Notes");
		
	} // GeneralTask() - 2 args

	// ********************************* Constructor - with all super args *********************************
	/**
	 * Constructor accepting arguments for all member fields
	 * @since 0.6
	 * 
	 * @param startDT		Start date / time
	 * @param endDT			End date / time
	 * @param tName			Task name
	 * 
	 */
	public GeneralTask(long startDT, long endDT, StringBuffer tName) {
		
		super(startDT, endDT, tName);
		
		sanitizeStrBuffLen(taskName, tName, MAX_NAME_LEN);
		
	} // GeneralTask() - all GeneralTask args
	
	// ********************************* Constructor - with all args *********************************
	/**
	 * Constructor accepting arguments for all member fields
	 * @since 0.6
	 * 
	 * @param startDT		Start date / time
	 * @param endDT			End date / time
	 * @param tName			Task name
	 * 
	 */
	public GeneralTask(long startDT, long endDT, StringBuffer tName, StringBuffer tNotes) {
		
		super(startDT, endDT, tName);
		
		sanitizeStrBuffLen(taskName, tName, MAX_NAME_LEN);
		sanitizeStrBuffLen(taskNotes, tNotes, MAX_NOTES_LEN);

	} // GeneralTask() - all args
	
	// **************************************** GETTERS ************************************************
	
	/**
	 * Return task notes
	 * @since 0.6
	 * 
	 * @return		endDateTime
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
	 * @return		endDateTime
	 */
	public boolean setTaskNotes(StringBuffer newString) {
		
		return sanitizeStrBuffLen(taskNotes, newString, MAX_NOTES_LEN);
		
	} // setTaskNotes()
	
	// ***************************************** toString() ******************************************
	
	/**
	 * Function toString(Field Constant Flags) to output desired member fields formatted.
	 * The order of the field flags determines their output order.
	 * @since 0.6
	 * 
	 * @param Field Constant Flags		Public flags to indicate which member fields to output
	 * 
	 * @return	String describing selected member fields
	 * 
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
	 * @since 0.6
	 * 
	 * @return String describing all member fields
	 */
	@Override
	public String toString() {
		
		return super.toString() + toString(NOTES_TO_STR);
		
	} // toString()
	
} // CLASS GeneralTask

/**
 * 
 * @author W. Mooncai
 * @since 0.6
 * 
 * Grade class is for use with the HomeworkTask class.  It includes validity checking and conversion functions.
 *
 * @param grade		Grade awarded to its task
 */
class Grade {
	private double grade = 0.0;
	
	public static final double MAX_GRADE = 4.5;
	public static final double MIN_GRADE = 0.0;
	
	/**
	 * Base constructor initializes grade to 0.0
	 * 
	 */
	Grade() {
		grade = 0.0;
	} // Grade()
	
	/**
	 * Constructor receiving the grade to initialize with
	 * 
	 * @param gradeIn	initial grade
	 * 
	 */
	Grade(double gradeIn) {
		if ( isValid(gradeIn) ) {
			grade = gradeIn;
		} else {
			// TODO throw an exception for or otherwise handle an invalid grade
		}

	} // Grade(double)
	
	/**
	 * Confirm if a grade is valid or not
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
	
	/**
	 * Returns the double value of this Grade object
	 * 
	 * @return	grade as a double value
	 * 
	 */
	public double doubleValue() {
		return new Double(grade).doubleValue();
	} // doubleValue()
	
	/**
	 * Returns letter grade as a String
	 * - A String was used for future feature upgrade to add + and - grades
	 * 
	 * @return a String containing the grade in letter format
	 * 
	 */
	public String toLetter() {
		
		if (grade >= 4.0) {
			return "A"; 
		} else if (grade >= 3.0) {
			return "B";
		} else if (grade >= 2.0) {
			return "C";
		} else if (grade >= 1.0) {
			return "D";
		} else return "F";
		
	} // toString()
	
	/**
	 * Returns numerical grade as a String
	 * 
	 * @return		a String containing the double integer grade
	 * 
	 */
	public String toString() {
		return new Double(grade).toString();
	} // toString()
	
} // CLASS Grade


// #############################################################################################333

//****************************************** GeneralTask *********************************************

/**
* 
* @author W. Mooncai
* @since 0.6
* 
* Homework Task Class Interface
* 
* @param MAX_NOTES_LEN			Maximum length of the Task notes
* 
* @param MAX_COURSENAME_LEN		Maximum length of the course name field
* @param MAX_GRADE_LEN			Maximum length of the grade field
* 
* @param DUEDATE_TO_STR			Flag for toString() to output the task duedate
* 
*/
interface HomeworkTaskInterface {
	
	// Constants
	public static final int MAX_NOTES_LEN = 500;
	
	public static final int MAX_COURSENAME_LEN = 20;
	public static final int MAX_GRADE_LEN = 2;
	
	public static final int DUEDATE_TO_STR = 60;
	public static final int COURSENAME_TO_STR = 70;
	public static final int GRADE_TO_STR = 80;
	public static final int POINTS_TO_STR = 90;
	
} // INTERFACE GeneralTaskInterface

/**
* 
* @author W. Mooncai
* @since 0.6
* 
* HomeworkTask Class
* 
* @param dueDate		Due date of this task
* @param courseName		Name of this task
* @param grade			Numerical grade awarded to this task
* @param points			Points awarded to this task
* 
*/
class HomeworkTask extends GeneralTask implements HomeworkTaskInterface {
	
	private long dueDate = System.currentTimeMillis();
	private String courseName = "Building Mobile Apps";
	private Grade grade = new Grade(0.0);
	private double points = 0.0;
	
	// ************************************ Constructor - no args ************************************
	/**
	 * Basic HomeworkTask constructor with no arguments
	 * 
	 */
	public HomeworkTask() {
		
		super();

		taskName.replace(0, taskName.length(), "New Homework Task");
		taskNotes.replace(0, taskNotes.length(), "New Homework Task Notes");
		
	} // GeneralTask()
	
	// *********************** Constructor - with task name and start time args **********************
	/**
	 * HomeworkTask Constructor with arguments
	 * @since 0.6
	 * 
	 * @param taskN			Task name
	 * @param sDateTime		Set the start date / time.  End date / time is set 1ms prior to start date / time.
	 * 
	 */
	public HomeworkTask(StringBuffer taskN, long sDateTime) {
		
		super(taskN, sDateTime);
		
		taskNotes.replace(0, taskNotes.length(), "New Homework Task Notes");
		
	} // GeneralTask() - 2 args
		
	// ********************************* Constructor - with all args *********************************
	/**
	 * Constructor accepting arguments for all member fields
	 * @since 0.6
	 * 
	 * @param startDT		Start date / time
	 * @param endDT			End date / time
	 * @param taskN			Task name
	 */
	
	public HomeworkTask(long startDT, long endDT, StringBuffer tNotes) {
		
		super(startDT, endDT, tNotes);
		
	} // GeneralTask() - all args
	
	// **************************************** GETTERS ************************************************
	
	/**
	 * Return Task due date
	 * @since 0.6
	 * 
	 * @return		Task due date
	 */
	public long getDueDate() {
		
		return dueDate;
		
	} // getDueDate()
	
	/**
	 * Return Task grade
	 * @since 0.6
	 * 
	 * @return		Task grade
	 */
	public Grade getGrade() {
		
		return grade;
		
	} // getGrade()
	
	/**
	 * Return Task points
	 * @since 0.6
	 * 
	 * @return		Task points
	 */
	public double getPoints() {
		
		return points;
		
	} // getPoints()
	
	// **************************************** SETTERS ************************************************
	
	/**
	 * Set task due date
	 * 
	 * @since 0.6
	 * 
	 * @return		Homework dueDate
	 */
	public long setDueDate(long dueDT) {
		
		return dueDT;
		
	} // setDueDate()
	
	/**
	 * Set task grade
	 * 
	 * @since 0.6
	 * 
	 * @return		Homework dueDate
	 */
	public Grade setGrade(float gradeIn) {
		
		return this.setGrade(gradeIn);
		
	} // setgrade()
	
	/**
	 * Set task points
	 * 
	 * @since 0.6
	 * 
	 * @return		Homework points
	 */
	public float setPoints(float pointsIn) {
		
		return pointsIn;
		
	} // setgrade()
	// ***************************************** toString() ******************************************
	
	/**
	 * Function toString(Field Constant Flags) to output desired member fields formatted.
	 * The order of the field flags determines their output order.
	 * @since 0.6
	 * 
	 * @param Field Constant Flags		Public flags to indicate which member fields to output
	 * 
	 * @return	String describing selected member fields
	 * 
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
	 * @since 0.6
	 * 
	 * @return String describing all member fields
	 */
	@Override
	public String toString() {
		
		return super.toString() + toString(DUEDATE_TO_STR, COURSENAME_TO_STR, GRADE_TO_STR, POINTS_TO_STR);
		
	} // toString()
	
} // CLASS GeneralTask
