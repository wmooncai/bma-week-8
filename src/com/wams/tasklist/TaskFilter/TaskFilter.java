/**
 * 
 */
package com.wams.tasklist.TaskFilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.wams.tasklist.Task;
import com.wams.tasklist.HomeworkTaskInterface;
import com.wams.tasklist.GeneralTaskInterface;
/**
 * @author W. Mooncai
 * @since 0.7
 *
 * Take a Task[] and massage the array contents, initially sort the array by its various member fields.
 * 
 */

public class TaskFilter implements TaskFilterInterface, TaskComparatorInterface, GeneralTaskInterface, HomeworkTaskInterface {
	
	Task taskArray[];
	
	int filterField = FILTER_FIELD_DEFAULT;
	boolean sortOrder = SORT_DESC;
	
	/**
	 * Default constructor
	 * 
	 * @since 0.7
	 * 
	 * @param taskArray			Input Task array is cloned, so original array is not changed
	 * 
	 */
	public TaskFilter(Task[] taskArray) {
		
		setArray(taskArray.clone());
		
		setFilterField(FILTER_FIELD_DEFAULT);
		setSortOrder(SORT_DEFAULT);
	}
	
	/**
	 * Full featured constructor
	 * 
	 * @since 0.7
	 * 
	 * Set all TaskFilter member fields upon instantiation.
	 * 
	 * @param taskArray			Input Task array is cloned, so original array is not changed
	 * @param filterField		Task field upon which to sort 
	 * @param sortOrder			Direction of sort, ascending or descending
	 * 
	 */
	public TaskFilter(Task[] taskArray, int filterField, boolean sortOrder) {
		
		setArray(taskArray);
		
		setFilterField(filterField);
		setSortOrder(sortOrder);
		
		taskArray = filter();
		
	}
	
	// ************************** OPERATIONS **********************************
	
	/**
	 * Sorts the input Task array
	 * 
	 * @since 0.7
	 * 
	 * @param sortTasks		Input Task array to sort
	 * @return				The sorted Task array
	 * 
	 */
	public Task[] sort(Task[] sortTasks) {
		
		List<Task> taskList = Arrays.asList(sortTasks);
		
		// Collections.sort(taskList);
		Collections.sort(taskList, new TaskComparator(filterField, sortOrder));
		
		return (Task[]) taskList.toArray();
	}
	
	/**
	 * Wrapper for sort(Task[]) to fulfill Homework 7 requirements
	 * 
	 * @since 0.7
	 * 
	 * @return		The sorted Task array
	 * 
	 */
	public Task[] filter(Task[] filterTasks) {
		return sort(filterTasks);
	}
	
	/**
	 * Wrapper for filter(Task[]) to provide a default filter() alternative
	 * 
	 * @since 0.7
	 * 
	 * @return		The sorted Task array
	 * 
	 */
	public Task[] filter() {
		return filter(taskArray);
	}
	
	// **************************************** GETTERS ************************************************

	/**
	 * Return field by with to sort the Task array as defined in TaskComparatorInterface.
	 * 
	 * @since 0.7
	 * 
	 * @return		filterField
	 * 
	 */
	public int getFilterField() { return filterField; }
	
	/**
	 * Return sort order as defined in TaskComparatorInterface.
	 * 
	 * @since 0.7
	 * 
	 * @return		sortOrder
	 */
	public boolean getSortOrder() { return sortOrder; }
	
	/**
	 * Return Task array
	 * 
	 * @since 0.7
	 * 
	 * @return		Task array
	 * 
	 */
	public Task[] getArray() { return taskArray; }
	
	// **************************************** SETTERS ************************************************

	/**
	 * Set the field by which to sort the Task array.
	 * 
	 * @since 0.7
	 * 
	 * @param filterField		Set with constant from TaskComparatorInterface
	 * 
	 * @return					Success / failure.
	 * 
	 */
	public boolean setFilterField(int filterField) {
		
		switch (filterField) {
		
		case FILTER_FIELD_TASK_NAME:
		case FILTER_FIELD_START_DT:
		case FILTER_FIELD_END_DT:
		case FILTER_FIELD_COMPLETED:
			this.filterField = filterField;
			return SUCCESS;
		default: return FAILURE;
		
		}
		
	}
	
	/**
	 * Set Task array sort order.
	 * 
	 * @since 0.7
	 * 
	 * @param filterField		Set with constant from TaskComparatorInterface
	 * 
	 * @return					Success / failure.
	 * 
	 */
	public boolean setSortOrder(boolean sortOrder) {
		
		this.sortOrder = sortOrder;
		return SUCCESS;
		
	}
	
	/**
	 * Set the Task array.
	 * 
	 * @since 0.7
	 * 
	 * @param arrayIn		Input Task array.
	 * @return				Success / failure.
	 */
	public boolean setArray(Task[] arrayIn) {
		
		Task[] arrayOut = new Task[arrayIn.length];
		
		if (arrayIn instanceof Task[]) {
			// this.taskArray = arrayIn.clone();
			System.arraycopy(arrayIn, 0, arrayOut, 0, arrayIn.length);
			taskArray = arrayOut;
			return SUCCESS;
		} else return FAILURE;
		
	}
	
	// ********************************* Conversions *****************************************

	/**
	 * Return a String representation of this object.
	 * 
	 * @since 0.7
	 * 
	 * @return String representation of this object.
	 * 
	 */
	public String toString() {
		
		StringBuffer output = new StringBuffer("\nSort by flag: "
				+ ( (filterField == FILTER_FIELD_TASK_NAME) ? "FILTER_FIELD_TASK_NAME" 
						: (filterField == FILTER_FIELD_START_DT) ? "FILTER_FIELD_START_DT" 
								: (filterField == FILTER_FIELD_END_DT) ? "FILTER_FIELD_END_DT" 
										: (filterField == FILTER_FIELD_COMPLETED)
										? "FILTER_FIELD_COMPLETED" : "ERROR - UNKNOWN" )
				+ "\n    Order by: "
				+ ( (sortOrder == SORT_ASC) ? "ASC" : "DESC" ) + "\n");
		
		for(Task t : taskArray) {
			output.append(t.toString() + "\n\n--------------------\n");
		}
		
		return output.toString();
		
	}
	
}
