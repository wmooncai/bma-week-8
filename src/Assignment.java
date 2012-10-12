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
 *            Determine what functionality and data you want to make accessible to outside callers via methods
 *                Some examples could include the following but I'm not trying to design your solutions.  These are just ideas
 *                    isComplete(): bool
 *                    getCompletionDate(): Calendar
 *                    getTitle(): String
 *                    getDescription(): String
 *                    hasPrerequisite(): bool
 *                    getPrerequisite(): Task
 *            Implement whatever functionality you come up with in the last step
 *        Create Task hierarchy 
 *            Consider different kinds of tasks (todo items) your todo list could have. 
 *                What extra functionality or behavior would they have?
 *            Consider what functionality and data would be common to all tasks
 *            Refactor your Task class
 *                Make the base Task class abstract
 *                Hide all instance variables with private modifiers if you didn't already
 *                Implement the common functionality from above as methods
 *                Add accessors (getters and/or setters) for any member variables you think need them
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
		Task task1 = new Task(myTaskName.append("1"), (System.currentTimeMillis() + 1));
		Task task2 = new Task(myTaskName.replace((myTaskName.length() - 1)
				, (myTaskName.length()), "2"), (System.currentTimeMillis() + 2));
		Task task3 = new Task();
		
		// Output new task object contents
		System.out.println(task1.toString(Task.NAME_TO_STR));
		System.out.println(task2.toString(Task.NAME_TO_STR, Task.START_DATE_TO_STR));
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
 * @author Wallace Mooncai
 * @since 0.0
 * 
 * Class Task is a basic task class
 * 
 * @param MAX_NAME_LEN			Maximum length of the Task name
 * 
 * @param NAME_TO_STR			Flag for toString() to output the Task Name
 * @param START_DATE_TO_STR		Flag for toString() to output the Start Date/Time
 * @param END_DATE_TO_STR		Flag for toString() to output the End Date/Time
 * 
 * @param taskName				Name of the Task
 * @param startDateTime			Task Start Date/Time
 * @param endDateTime			Task End Date/Time
 * @param completed				Flag to manually mark this task as complete
 * 
 */

abstract class Task {

	// Constants
	private static final String MY_TASK_NAME = "My Task ";
	public static final int MAX_NAME_LEN = 20;
	
	public static final int NAME_TO_STR = 10;
	public static final int START_DATE_TO_STR = 20;
	public static final int END_DATE_TO_STR = 30;
	public static final int COMPETED_TO_STR = 40;
	
	// Fields
	private StringBuffer taskName = new StringBuffer(MAX_NAME_LEN);
	private long startDateTime;
	private long endDateTime;
	private boolean completed;
	
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
	 * @param dateTime		Set the start date / time.  End date / time is set 1ms prior to start date / time.
	 * 
	 */
	public Task(StringBuffer taskN, long dateTime) {
		
		startDateTime = dateTime;
		endDateTime = dateTime - 1;
		
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
		
		if (taskN.length() > MAX_NAME_LEN) {
			taskName = (StringBuffer) taskN.subSequence(0, MAX_NAME_LEN);
		} else taskName.replace(0, taskName.length(), taskN.toString());
		
	} // Task() - all args
	
	// **************************************** GETTERS ************************************************
	
	/**
	 * Return task completed status
	 * @return		endDateTime
	 */
	public boolean getCompleted(){
		
		return completed;
		
	} // getCompleted()
	
	/**
	 * Return task end date / time
	 * @return		endDateTime
	 */
	public long getEndDateTime(){
		
		return endDateTime;
		
	} // getEndDateTime()

	/**
	 * Return task start date / time
	 * @return		startDateTime
	 */
	public long getStartDateTime(){
		
		return startDateTime;
		
	} // getStartDateTime()
	
	/**
	 * Return Task Name
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
	 * Return task start date / time
	 * @return		success /fail
	 */
	public boolean setStartEndDateTime(long start) {
		
		
	} // setStartDateTime()
	
	
	/**
	 * Set task name
	 * @return		taskName
	 */
	public boolean setTaskName(String name) {
		
		if (taskName.length() < MAX_NAME_LEN) {
			taskName.replace(0, taskName.length(), name);
			return true;
		}
		
	} // setTaskName()
	
	
	// ***************************************** toString() ******************************************
	/**
	 * Function toString(Field Constant Flags) to pretty output desired member fields.
	 * @since 0.0
	 * 
	 * @param Field Constant Flags		Public flags to indicate which member fields to output
	 * @return String describing all member fields
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
	 * @since 0.0
	 */
	public String toString() {
		
		return toString(NAME_TO_STR, START_DATE_TO_STR, END_DATE_TO_STR, COMPETED_TO_STR);
		// return "\nTask Name: " + taskName.toString() + "\nstartDateTime: " + startDateTime + "\ncomplete: " + completed;
		
	} // toString()
	
} // CLASS Task
