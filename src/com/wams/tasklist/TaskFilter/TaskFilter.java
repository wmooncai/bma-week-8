/**
 * 
 */
package com.wams.tasklist.TaskFilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.wams.tasklist.Task;

/**
 * @author W. Mooncai
 * @since 0.7
 *
 */

public class TaskFilter implements TaskFilterInterface {
	
	Task workingArray[];
	
	short filterField = -1;
	
	public TaskFilter(Task[] taskArray) {
		
		workingArray = filterByName(taskArray.clone());
		
	}
	
	public TaskFilter(Task[] taskArray, short filterField) {
		
		workingArray = filterByName(taskArray.clone());
		
		this.filterField = filterField;
		
		
	}	
	
	public Task[] filterByName(Task[] tasks) {
		
		List<Task> taskList = Arrays.asList(tasks);
		Collections.sort(taskList);
		
		return (Task[]) taskList.toArray();
	}
	
	public String toString() {
		
		StringBuffer output = new StringBuffer();
		
		for(Task t : workingArray) {
			output.append(t.toString() + "\n\n--------------------\n");
		}
		// System.out.println(output.toString());
		
		return output.toString();
	}
}
