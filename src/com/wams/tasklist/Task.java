package com.wams.tasklist;

import java.sql.Timestamp;

import com.wams.tasklist.TaskFilter.*;

/**
 * @author Wallace Mooncai
 * 
 * @since 0.5
 * 
 * Class Task is a basic task class
 * 
 * - Version 0.6 changed to abstract class
 * - Version 0.7 - Moved to project package and one public class / interface per file
 * 
 * @param taskName				Name of the Task
 * @param startDateTime			Task Start Date/Time
 * @param endDateTime			Task End Date/Time
 * @param completed				Flag to manually mark this task as complete
 * 
 */

public abstract class Task implements TaskInterface, Comparable<Task> {

	private static final String MY_TASK_NAME = "My Task ";
	
	private String taskID;
	private StringBuffer taskName = new StringBuffer(MAX_NAME_LEN);
	private long startDateTime;
	private long endDateTime;
	private boolean completed;
	
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

		startDateTime = System.currentTimeMillis();
		endDateTime = startDateTime - 1;
		
		setTaskNameAndID(MY_TASK_NAME);
				
	}
	
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
		
		setTaskNameAndID(tName);
		
	}
		
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
		
		setTaskNameAndID(tName);
		
	}
	
	/**
	 * Helper to set instance taskName and taskID and is guaranteed to set both fields at least with default values
	 * 
	 * @since 0.7
	 * 
	 * @param tNameIn		Value to set taskName with
	 * 
	 */
	private void setTaskNameAndID(String tNameIn) {
		
		if (setStrBuff(taskName, tNameIn, MAX_NAME_LEN)) {
			taskID = taskName.toString();
		} else {
			taskID = new String(this.getClass().toString()).substring(6)
				+ "@" + this.hashCode();
			setStrBuff(taskName, taskID, MAX_NAME_LEN);
		}
		
	}
	
	// ******************************* COMPARABLE IMPLEMENTATION ***************************************

	/**
	 * @author W. Mooncai
	 * 
	 * Implementation for Comparable Interface
	 * 
	 * @since 0.7
	 * 
	 */
	public boolean equals(Object obj) {
		
		if (!(obj instanceof Task))
            return false;
        Task task = (Task) obj;
        return task.taskID.equals(taskID);
        
	}
	
	/**
	 * @author W. Mooncai
	 * 
	 * Implementation for Comparable Interface
	 * 
	 * @since 0.7
	 * 
	 */
	public int hashCode() {
		
		return TASK_HASH_SALT * taskID.hashCode();
		
	}
	
	/**
	 * @author W. Mooncai
	 * 
	 * Implementation for Comparable Interface
	 * 
	 * @since 0.7
	 * 
	 */
	public int compareTo(Task task) {
		
		int priorCompare = taskID.compareTo(task.taskID);
		return (priorCompare != 0 ? priorCompare : taskID.compareTo(task.taskID));
		
	}
	
	// toString() is implemented at the end of this class
	
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
		
	}

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
		
	}

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
		
	}

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
		
	}

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
				
	}

	// **************************************** SETTERS ************************************************
	
	/**
	 * Set task completed status
	 * 
	 * @since 0.6
	 * 
	 */
	public void setCompleted(boolean status){
		
		completed = status;
		
	}

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
		}
		
	}

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
		
		// startDT should be in the future
		if ( startDateTime >= System.currentTimeMillis() ) {
			return true;
		} else return false;
		
	}

	/**
	 * Set task name using a String
	 * 
	 * @since 0.6
	 * 
	 * - Version 0.7 added sanitization for null as new value
	 * 
	 * @return		taskName
	 * 
	 */
	public boolean setTaskName(String tName) {
		
		if (tName == null) {
			return false;
		} else return setTaskName(new StringBuffer(tName));
		
	}

	/**
	 * Set task name using a StringBuffer
	 * 
	 * @since 0.6
	 * 
	 * - Version 0.7 added sanitization for null as new value
	 * 
	 * @return		taskName
	 * 
	 */
	public boolean setTaskName(StringBuffer tName) {
		
		if (tName == null) {
			return false;
		} else return setStrBuff(taskName, tName, MAX_NAME_LEN);
		
	}

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
				}
			} else return false;
		} else return false;
		
	}

	/**
	 * Wrapper for setStrBuff(..., String, ...) to take an input StringBuffer instead of String
	 * 
	 * @since 0.6
	 * 
	 * - Version 0.7 added sanitization for null as new value
	 * 
	 * @param memberStringSB	String receiving String input newStringS
	 * @param newStringSB		Input StringBuffer to be assigned to memberStringSB
	 * @param maxLength			Maximum length of StringBuffer
	 * 
	 * @return					Success / Failure status
	 * 
	 */
	protected boolean setStrBuff(StringBuffer memberStringSB, StringBuffer newStringSB, int maxLength) {
		
		if (newStringSB == null) {
			return false;
		} else return setStrBuff(memberStringSB, newStringSB.toString(), maxLength);
		
	}

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
			}
		}

		return returnString.toString();
		
	}

	/**
	 * toString() will format and output all Task fields
	 * 
	 * @since 0.6
	 * 
	 */
	public String toString() {
		
		return toString(NAME_TO_STR, START_DATE_TO_STR, END_DATE_TO_STR, COMPLETED_TO_STR);

	}

}
