package com.wams.tasklist.TaskFilter;

import java.util.Comparator;

import com.wams.tasklist.Task;


/**
 * @author W. Mooncai
 * 
 * Helper class implements Comparator<Object> interface to allow sorting of a group of objects.
 * 
 * @since 0.7
 *
 */
public class TaskComparator implements Comparator<Object>, TaskComparatorInterface {

	int filterField = FIELD_DEFAULT;
	boolean sortOrder = SORT_DESC;
	
	/**
	 * Default constructor, sorting by FILTER_FIELD_DEFAULT (should be Task Name), descending.
	 * 
	 * @since 0.7
	 * 
	 */
	public TaskComparator() {
		
		this.filterField = FIELD_DEFAULT;
		this.sortOrder = SORT_DESC;
		
	}
	
	/**
	 * Constructor accepting two variable sort parameters.
	 * 
	 * @since 0.7
	 * 
	 * @param filterField		Specifies which Task field to sort on
	 * @param sortOrder			Specifies sort order
	 * 
	 */
	public TaskComparator(int filterField, boolean sortOrder) {
		
		this.filterField = filterField;
		this.sortOrder = sortOrder;
		
	}
	
	// **************************** HELPER METHODS ****************************
	
	/**
	 * Helper to compare two boolean values.
	 * 
	 * @since 0.7
	 * 
	 * @param b1	First boolean value to compare
	 * @param b2	Second boolean value to compare
	 * @return		Comparison result
	 * 
	 */
	private int compareBool(boolean b1, boolean b2) {
		
		if (b1 == b2) {
			return 0;
		} else if (sortOrder == SORT_ASC) {
			return ( b1 == true ) ? 1 : -1;
		} else return ( b1 == true ) ? -1 : 1;
		
	}
	
	/**
	 * Helper to compare two long (date/time) values.
	 * 
	 * @since 0.7
	 * 
	 * @param l1	First long value to compare.
	 * @param l2	Second long value to compare.
	 * @return		Comparison result
	 * 
	 */
	private int compareLong(long l1, long l2) {
		
		if (l1 == l2) {
			return 0;
		} else if (sortOrder == SORT_ASC) {
			return (l1 < l2) ? -1 : 1;
		} else {
			return (l1 < l2) ? 1 : -1;
		}
	}
	
	// **************************** PRIMARY METHOD ****************************
	
	/**
	 * Implementation of Comparator<Object> interface.  The Task Name may only
	 *  be sorted ascending.  All other fields to sort by may be sorted either
	 *  ascending or descending.
	 * 
	 * @since 0.7
	 * 
	 * @param obj1		First Task object to compare.
	 * @param obj2		Second Task object to compare.
	 * 
	 * @return			Comparison outcome.
	 * 
	 */
	public int compare(Object obj1, Object obj2) {
		Task task1 = (Task) obj1;
		Task task2 = (Task) obj2;
		
		switch (filterField) {
		
		case FIELD_START_DT:
			return compareLong(task1.getStartDateTime(), task2.getStartDateTime());
			
		case FIELD_END_DT:
			return compareLong(task1.getEndDateTime(), task2.getEndDateTime());
			
		case FIELD_COMPLETED:
			return compareBool(task1.isComplete(), task2.isComplete());
			
		case FIELD_TASK_NAME:
		default:
			return task1.getTaskName().toString()
					.compareTo(task2.getTaskName().toString());
		}
		
	}
	
}
