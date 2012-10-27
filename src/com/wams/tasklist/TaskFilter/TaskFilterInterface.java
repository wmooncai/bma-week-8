package com.wams.tasklist.TaskFilter;

import com.wams.tasklist.*; 
 
/**
 * @author W. Mooncai
 * 
 * Method signatures to implement task presentation
 * 
 * @since 0.7
 * 
 */
public interface TaskFilterInterface extends TaskComparatorInterface, UtilsInterface {

	public static final int OPERATION_NULL = 200;
	public static final int OPERATION_SORT = 210;
	public static final int OPERATION_FILTER = 220;
	public static final int OPERATION_FILTER_SORT = 230;
	public static final int OPERATION_DEFAULT = OPERATION_FILTER_SORT;
	
	public Task[] filter(Task[] tasks);
	
}
