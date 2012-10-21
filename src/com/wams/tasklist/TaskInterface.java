package com.wams.tasklist;

/**
 * 
 * @author W. Mooncai
 * 
 * @since 0.6
 * 
 * Task Class Interface
 * 
 * - Version 0.7
 * -- Moved to project package and one public class / interface per file
 * -- Added TASK_ID_TO_STR and TASK_HASH_SALT constatnts for use with Comparable Interface
 * 
 * @param MAX_NAME_LEN			Maximum length of the Task name
 * 
 * @param NAME_TO_STR			Flag for toString() to output the Task Name
 * @param START_DATE_TO_STR		Flag for toString() to output the Start Date/Time
 * @param END_DATE_TO_STR		Flag for toString() to output the End Date/Time
 * 
 */
interface TaskInterface {
	
	public static final int MAX_NAME_LEN = 30;
	
	public static final int TASK_HASH_SALT = 1940;
	public static final int TASK_ID_TO_STR = 5;
	
	public static final int NAME_TO_STR = 10;
	public static final int START_DATE_TO_STR = 20;
	public static final int END_DATE_TO_STR = 30;
	public static final int COMPLETED_TO_STR = 40;
	
}