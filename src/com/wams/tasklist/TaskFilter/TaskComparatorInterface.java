package com.wams.tasklist.TaskFilter;

/**
 * 
 * @author W. Mooncai
 * 
 * @since 0.7
 *
 */
public interface TaskComparatorInterface {
	
	public static final boolean SORT_ASC = true;
	public static final boolean SORT_DESC = false;
	public static final boolean SORT_DEFAULT = SORT_DESC;

	public static final int FIELD_NULL = 0;
	public static final int FIELD_TASK_NAME = 50;
	public static final int FIELD_START_DT = 60;
	public static final int FIELD_END_DT = 70;
	public static final int FIELD_COMPLETED = 80;
	public static final int FIELD_DEFAULT = FIELD_TASK_NAME;

}
