package com.wams.tasklist;

/**
 * 
 * @author W. Mooncai
 * @since 0.6
 * 
 * GeneralTask Class
 * - Version 0.7 - Moved to project package and one public class / interface per file
 * 
 * @param taskNotes		task notes field
 * 
 */
class GeneralTask extends Task implements GeneralTaskInterface {
	
	private StringBuffer taskNotes = new StringBuffer("New General Task Notes");
	
	// ************************************ Constructor - no args ************************************
	/**
	 * Basic GeneralTask constructor with no arguments
	 * 
	 * @since 0.6
	 * 
	 */
	public GeneralTask() {
		
		super();

		setStrBuff(super.getTaskName(), "New General Task", MAX_NAME_LEN);
		setStrBuff(taskNotes, super.getTaskName() + " Notes", MAX_NOTES_LEN);
		
	}

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

		setStrBuff(taskNotes, super.getTaskName() + " Notes", MAX_NOTES_LEN);
		
	}

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
		setStrBuff(super.getTaskName(), tName, MAX_NAME_LEN);
		
	}

	// ********************************* Constructor - with all args *********************************
	/**
	 * Constructor accepting arguments for all member fields
	 * 
	 * @since 0.6
	 * 
	 * @param tName			Task name
	 * @param startDT		Start date / time
	 * @param endDT			End date / time
	 * @param tName			Task name
	 * 
	 */
	public GeneralTask(String tName, long startDT, long endDT, String tNotes) {
		
		super(tName, startDT, endDT);
		
		setStrBuff(super.getTaskName(), tName, MAX_NAME_LEN);
		setStrBuff(taskNotes, tNotes, MAX_NOTES_LEN);

	}

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
		
	}

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
		
	}

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
			}
		}

		return returnString.toString();
		
	}

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
		
	}

}
