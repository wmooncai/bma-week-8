import java.sql.Timestamp;

/**
 * @author W. Mooncai
 * @version 0.6
 * @since 0.0
 * 
 * Crossfire BMA Week 6 Homework
 * Due: 10/15/2012
 * 
 *    Reading
 *        Chapter 8 in Java A Beginner's Guide - Interfaces and Packages
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
 *            Override methods in Task children when necessary
 *                At a bare minimum override toString for each child Task class
 *        Test new Task hierarchy
 *            In the Assignment class, create a method "private static void printTask(Task)" that prints out Task objects
 *            In Assignment's main() method, create at least one of each type of Task created earlier.
 *            Send each task to printTask()
 *            [bonus]: test the rest of your Task parent class' public interface.
 *
 *	This assignment is aimed at both giving a feeling for inheritance and for getting you thinking about implementation 
 *	ideas for your project.  It might be that your solution doesn't have a need to inheritance hierarchies.  
 *	That's fine but there are two goals here.
 *
 */

public class Assignment {

	public static void main(String[] args) {
		
		StringBuffer myTaskName = new StringBuffer("My Task ");
		
		// Instantiate new task objects
		GeneralTask task1 = new GeneralTask(myTaskName.append("1"), (System.currentTimeMillis() + 1));
		GeneralTask generalTask = new GeneralTask(myTaskName.replace((myTaskName.length() - 1)
				, (myTaskName.length()), "2"), (System.currentTimeMillis() + 2));
		GeneralTask task3 = new GeneralTask();
		
		// Output new task object contents
		System.out.println(task1.toString(Task.NAME_TO_STR));
		System.out.println(generalTask.toString(Task.NAME_TO_STR, Task.START_DATE_TO_STR));
		System.out.println(task3);
		
	} // main()

	/**
	 * Extract a character from a String
	 * 
	 * @since 0.0
	 * 
	 * @param values	String from which to extract a character
	 * @param index		Index of character to extract
	 * @return			Return the character at index.  If index is invalid, return null.
	 */
	static String getElement(String values, int index) {
		
		if ((index >= 0) && (index < values.length())) {
			return values.substring(index, index);
		} else return null;
		
	} // getElement(String, int)

	/**
	 * Extract a String element from a String array
	 * 
	 * @since 0.0
	 * 
	 * @param values	String from which to extract a character
	 * @param index		Index of character to extract
	 * @return			Return the character at index.  If index is invalid, return null.
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
	public static final int MAX_NAME_LEN = 20;
	
	public static final int NAME_TO_STR = 10;
	public static final int START_DATE_TO_STR = 20;
	public static final int END_DATE_TO_STR = 30;
	public static final int COMPETED_TO_STR = 40;
	
} // INTERFACE TaskInterface

/**
 * @author Wallace Mooncai
 * @since 0.0
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
	 * @since 0.0
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
	 * @since 0.0
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
	 * @since 0.0
	 * 
	 * @param startDT		Start date / time
	 * @param endDT			End date / time
	 * @param taskN			Task name
	 */
	
	public Task(long startDT, long endDT, StringBuffer taskN) {
		
		startDateTime = startDT;
		endDateTime = startDateTime - 1;
		
		sanitizeStrBuffLen(taskName, taskN, MAX_NAME_LEN);
		
	} // Task() - all args
	
	// **************************************** GETTERS ************************************************
	
	/**
	 * Return task completed status
	 * @since 0.6
	 * 
	 * @return		endDateTime
	 */
	public boolean getCompleted(){
		
		return completed;
		
	} // getCompleted()
	
	/**
	 * Return task end date / time
	 * @since 0.6
	 * 
	 * @return		endDateTime
	 */
	public long getEndDateTime(){
		
		return endDateTime;
		
	} // getEndDateTime()

	/**
	 * Return task start date / time
	 * @since 0.6
	 * 
	 * @return		startDateTime
	 */
	public long getStartDateTime(){
		
		return startDateTime;
		
	} // getStartDateTime()
	
	/**
	 * Return Task Name
	 * @since 0.6
	 * 
	 * @return		taskName
	 */
	public StringBuffer getTaskN() {
		
		return taskName;
		
	} // getTaskN()
	
	// **************************************** SETTERS ************************************************
	
	/**
	 * Set task completed status
	 */
	public void setCompleted(boolean status){
		
		completed = status;
		
	} // setCompleted()
	
	/**
	 * Set task end date / time
	 * @since 0.6
	 * 
	 * @return		success /fail
	 */
	public boolean setEndDateTime(long end){
		
		if (end < startDateTime) {
			return false;
		} else {
			endDateTime = end;
			return true;
		}
		
	} // setEndDateTime()

	/**
	 * Set task start date / time
	 * @since 0.6
	 * 
	 * @return		success /fail
	 */
	public boolean setStartDateTime(long start) {
		
		startDateTime = start;
		
		if ( startDateTime >= System.currentTimeMillis() ) {
			return true;
		} else return false;
		
	} // setStartDateTime()
	
	
	/**
	 * Set task name
	 * @since 0.6
	 * 
	 * @return		taskName
	 */
	public boolean setTaskName(StringBuffer name) {
		
		return sanitizeStrBuffLen(taskName, name, MAX_NAME_LEN);
		
	} // setTaskName()
	
	/**
	 * Sanitize an input string based on input string length and assign it to a class member string
	 * 
	 * @param memberString		member string receiving the newString
	 * @param newString			input string
	 * @param maxLen			max length of the member string as defined in the task object interface
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
	 * Function toString(Field Constant Flags) to pretty output desired member fields.
	 * The order of the field flags determines their output order.
	 * @since 0.0
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
				returnString.append("\n      Task Name: " + taskName.toString());
				break;
			case START_DATE_TO_STR:
				returnString.append("\nStart Date/Time: " + startDateTime + " (" + new Timestamp(startDateTime).toString() + ")");
				break;
			case END_DATE_TO_STR:
				returnString.append("\n  End Date/Time: " + endDateTime + " (" + new Timestamp(endDateTime).toString() + ")");
				break;
			case COMPETED_TO_STR:
				returnString.append("\n      Completed: " + completed);
				break;
			} // switch
		} // for loop
		
		return returnString.toString();
		
	} // toString(args)
	
	/**
	 * toString() will pretty output all Task fields
	 * @since 0.6
	 */
	public String toString() {
		
		return toString(NAME_TO_STR, START_DATE_TO_STR, END_DATE_TO_STR, COMPETED_TO_STR);
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
	
	protected StringBuffer taskNotes = new StringBuffer(MAX_NOTES_LEN);
	
	// ************************************ Constructor - no args ************************************
	/**
	 * Basic GeneralTask constructor with no arguments
	 * 
	 */
	public GeneralTask() {
		
		super();
		
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
		
	} // GeneralTask() - 2 args

	// ********************************* Constructor - with all super args *********************************
	/**
	 * Constructor accepting arguments for all member fields
	 * @since 0.6
	 * 
	 * @param startDT		Start date / time
	 * @param endDT			End date / time
	 * @param tName			Task name
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
	public StringBuffer getTaskNotes(){
		
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
	 * Function toString(Field Constant Flags) to pretty output desired member fields.
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
			} // switch
		} // for loop
		
		return returnString.toString();
		
	} // toString(args)
	
	/**
	 * toString() will pretty output all Task fields
	 * @since 0.6
	 * 
	 * @return String describing all member fields
	 */
	public String toString() {
		
		return toString(NAME_TO_STR, START_DATE_TO_STR, END_DATE_TO_STR, COMPETED_TO_STR, NOTES_TO_STR);
		
	} // toString()
	
} // CLASS GeneralTask

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
* @param DUEDATE_TO_STR			Flag for toString() to output the task duedate
* 
*/
interface HomeworkTaskInterface {
	
	// Constants
	public static final int MAX_NOTES_LEN = 500;
	public static final int MAX_GRADE_LEN = 2;
	public static final int MAX_COURSENAME_LEN = 20;
	public static final int DUEDATE_TO_STR = 60;
	
} // INTERFACE GeneralTaskInterface

/**
* 
* @author W. Mooncai
* @since 0.6
* 
* GeneralTask Class
* 
* @param dueDate		task duedate field
* 
*/
class HomeworkTask extends GeneralTask implements HomeworkTaskInterface {
	
	long dueDate = System.currentTimeMillis();
	String courseName = new String();
	StringBuffer grade = new StringBuffer(2);
	
	
	// ************************************ Constructor - no args ************************************
	/**
	 * Basic HomeworkTask constructor with no arguments
	 * 
	 */
	public HomeworkTask() {
		
		super();
		
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
	
	// ***************************************** toString() ******************************************
	
	/**
	 * Function toString(Field Constant Flags) to pretty output desired member fields.
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
			} // switch
		} // for loop
		
		return returnString.toString();
		
	} // toString(args)
	
	/**
	 * toString() will pretty output all Task fields
	 * @since 0.6
	 * 
	 * @return String describing all member fields
	 */
	public String toString() {
		
		return toString(NAME_TO_STR, START_DATE_TO_STR, END_DATE_TO_STR, COMPETED_TO_STR, NOTES_TO_STR);
		
	} // toString()
	
} // CLASS GeneralTask
