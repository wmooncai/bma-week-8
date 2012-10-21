package com.wams.tasklist;

/**
* 
* @author W. Mooncai
* @since 0.6
* 
* Homework Task Class Interface constants
 * v0.7 - Moved to project package and one public class per file
* 
* @param MAX_HW_NOTES_LEN			Maximum length of the Task notes
* 
* @param MAX_COURSENAME_LEN		Maximum length of the course name field
* @param MAX_GRADE_LEN			Maximum length of the grade field
* 
* @param DUEDATE_TO_STR			Flag for toString() to output the task duedate
* 
*/
public interface HomeworkTaskInterface {
	
	public static final String HW_NOTES_DEFAULT = "Homework Task Notes";
	public static final int MAX_HW_NOTES_LEN = 500;
	
	public static final int MAX_COURSENAME_LEN = 40;
	public static final int MAX_GRADE_LEN = 2;
	
	public static final int DUEDATE_TO_STR = 60;
	public static final int COURSENAME_TO_STR = 70;
	public static final int GRADE_TO_STR = 80;
	public static final int POINTS_TO_STR = 90;
	
}
