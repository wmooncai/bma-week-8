package com.wams.tasklist;

import java.sql.Timestamp;

/**
* 
* @author W. Mooncai
* 
* HomeworkTask Class
 * - Version 0.7 - Moved to project package and one public class / interface per file
* 
* @since 0.6
* 
* @param dueDate		Due date of this task
* @param courseName		Name of this task
* @param gradeVal		Numerical grade awarded to this task
* @param points			Points awarded to this task
* 
*/
public class HomeworkTask extends GeneralTask implements HomeworkTaskInterface {
	
	private long dueDate = System.currentTimeMillis();
	private StringBuffer courseName = new StringBuffer("Building Mobile Apps");
	private Grade grade = new Grade(0.0);
	private double points = 0.0;
	
	/**
	 * Base HomeworkTask constructor with no arguments
	 * 
	 * @since 0.6
	 * 
	 */
	public HomeworkTask() {
		
		super();

		setStrBuff(super.getTaskName(), "Homework Task", MAX_NAME_LEN);
		setStrBuff(super.getTaskNotes(), HW_NOTES_DEFAULT, MAX_HW_NOTES_LEN);
		
	}
	
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
		
		setStrBuff(super.getTaskNotes(), HW_NOTES_DEFAULT, MAX_HW_NOTES_LEN);
		
	}
	
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

		setStrBuff(super.getTaskNotes(), HW_NOTES_DEFAULT, MAX_HW_NOTES_LEN);
		
	}

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
		
		setStrBuff(super.getTaskNotes(), HW_NOTES_DEFAULT, MAX_HW_NOTES_LEN);
		setDueDate(dueDT);
		setStrBuff(courseName, cName, MAX_COURSENAME_LEN);
		grade.setGrade(hWGrade);
		setPoints(hWPoints);
		
	}

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
		
	}
	
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
		
	}

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
		
	}

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
		
	}

	/**
	 * Set HomeworkTask grade
	 * 
	 * @since 0.6
	 * 
	 * @return		Homework dueDate
	 */
	public Grade setGrade(double gradeIn) {
		
		return this.setGrade(gradeIn);
		
	}

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
			}
		}

		return returnString.toString();
		
	}

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
		
	}

}

