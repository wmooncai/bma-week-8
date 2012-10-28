package com.wams.tasklist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.wams.tasklist.TaskFilter.TaskFilter;
import com.wams.tasklist.TaskFilter.TaskComparatorInterface;

/**
 * @author W. Mooncai
 * 
 * @version 0.7
 * 
 * Crossfire BMA Week 7 Homework
 * Due: 10/22/2012
 * 
 * - Version 0.7 - Moved to project package and one public class / interface per file
 *
 */

public class Assignment implements TaskComparatorInterface {

	public static void main(String[] args) {
		
		int week = 8;
		
		switch (week) {
		
		case 8:
			week8Main();
			break;
			
		case 7:
			week7Main();
			break;
			
		case 6:
			week6Main();
			break;
			
		case 5:
			week5Main();
			break;

		default:
			System.out.println("Specify a main to run in Assignment.java!");
			break;
			
		} // switch (week)
		
	} // main()
	
	/**
	 * 
	 * Week 8 Homework Main()
	 * 
	 * @since 0.8
	 * 
	 * All instances of arrays being replaced by generic Lists, which is
	 * actually more likely to result in lines of code being removed than
	 * added.  One thing to note is that the pattern I'm suggesting is to
	 * declare Lists and use ArrayLists.  For example, if you have a
	 * CompositeTask that contains other tasks that is currently implemented
	 * as array, this would be the move forward
	 *
	 * Old class:
	 * CompositeTask extends Task {
     *   	private Task[] componentTasks;
	 *
     *   	public CompositeTask() {
     *			componentTasks = new Task[]{...};
     *		}
     * }
     * 
     * New class:
     * CompositeTask extends Task {
     * 		private List<Task> componentTasks;
	 *
     *		public CompositeTask() {
     *			componentTasks = new ArrayList<Task>();
     *			//add components here
     *		}
	 * }
	 * 
	 * The jist of this is to use the interface and not the implementation.  So if you all of a sudden realize you prize insertion performance over random access, its as simple a change as doing this
	 *  
	 *  old: componentTasks = new ArrayList<Task>();
	 *  new: componentTasks = new LinkedList<Task>();
	 *  
	 *  and nothing else changes. 
     *   
	 */
	
	private static void week8Main() {
		
		long now = System.currentTimeMillis();
		
		List<Task> tasks = new ArrayList<Task>();
				tasks.add( new GeneralTask("General Task 2", now, (now - 1)) );
				
				tasks.add( new HomeworkTask("Homework Task 2", (now + 300)
						, (now + 299), "Homework Task 2 Notes - Big Bird says 123!"
						, (now + 299), "Building Mobile Apps", 4.5, 100) );
				
				tasks.add( new GeneralTask("General Task 1", (now + 200)
						, (now + 199), "General Task 1 Notes - la la lala la la") );
				
				tasks.add( new HomeworkTask("Homework Task 1", (now + 100), (now + 99)
						, "Homework Task 1 Notes - Elmo says ABC!") );

		tasks.get(0).setCompleted(true);
		tasks.get(1).setCompleted(true);
				
		System.out.println(Arrays.asList(tasks).toString() + "\n\n##########################\n\n");
		 
		
		List<TaskFilter> taskFilters = new ArrayList<TaskFilter>();
			taskFilters.add( new TaskFilter(tasks, FIELD_TASK_NAME, SORT_ASC) {
				@Override
				public String toString() {
					// Return ONLY the Task array (not the other TaskFilter member fields);
					StringBuffer output = new StringBuffer();
					for(Task t : this.getArray()) {
						output.append(t.toString() + "\n\n--------------------\n");
					}
					return output.toString();
				}
			} );
			taskFilters.add( new TaskFilter(tasks, FIELD_START_DT, SORT_DESC) );
			taskFilters.add( new TaskFilter(tasks, FIELD_START_DT, SORT_ASC) );
			taskFilters.add( new TaskFilter(tasks, FIELD_END_DT, SORT_DESC) );
			taskFilters.add( new TaskFilter(tasks, FIELD_END_DT, SORT_ASC) );
			taskFilters.add( new TaskFilter(tasks, FIELD_COMPLETED, SORT_ASC) );
			taskFilters.add( new TaskFilter(tasks, FIELD_COMPLETED, SORT_DESC) );
		
		// TaskFilter sorts by default when Full Featured constructor is used and specifies sort parameters
		System.out.println( "TaskFilter[] Output\n(Anonymous output is seen in first Array element (sort by Task name)\n without TaskFilter member fields: filterField and sortOrder):\n"
			+ "\n" + Arrays.deepToString(taskFilters.toArray()));
		
	}
	
	
	/**
	 * 
	 * Week 7 Homework Main()
	 * 
	 * @since 0.7
	 * 
	 *  Read Chapter 9 "Exception Handling" in Java: A Beginner's Guide
	 *  
	 *	Assignment
     *   + Create a github repository to hold homework named bma-week-7 containing a class, Assignment, in the default package
     *   + Take your Task hierachy from week 6 and place into one or more packages
     *       + Create a base package for your application
     *           + Including a unique prefix is optional (com.crossfireconsulting for example)
     *           +  The application prefix should be present.  Tasklist, todolist, todo, whatever...
     *       + Its time we move to one class per file, so make each file live in its own class (anonymous and inner classes are obviously exceptions)
	 *   + Implement a package called TaskFilter off of the application root package that will filter tasks 
     *       + Implement the TaskFilter interface.  The most simple interface I can think of would be "public Task[] filter(Task[] tasks);"
     *       + 3.2) Implement at least one class that implements TaskFilter
     *           hint: you can bring in as much or as little data and behavior as long as you implement the public interface
     *           hint: remember this involves by reference semantics.  You don't want to destroy the original collection of tasks
     *   In Assignment.java
     *       + Create a collection of Task objects representative of your hierarchy
     *       + Create a collection of TaskFilter objects
     *           + Include at least one concrete class from 3.2 above
     *           + Include at least one anonymous class that is defined on the spot
     *       + Filter the collection of Task objects and print the resulting collection of Task objects
     *       
     *   Git:
     *   Starting with this HW, I duplicated the previous week's HW repo to retain prior commits.
     *   - https://help.github.com/articles/duplicating-a-repo
     *   
	 */
	
	private static void week7Main() {
		
		long now = System.currentTimeMillis();
		
		Task tasks[] = {
				new GeneralTask("General Task 2", now, (now - 1)),
				new HomeworkTask("Homework Task 2", (now + 300)
						, (now + 299), "Homework Task 2 Notes - Big Bird says 123!"
						, (now + 299), "Building Mobile Apps", 4.5, 100),
				new GeneralTask("General Task 1", (now + 200)
						, (now + 199), "General Task 1 Notes - la la lala la la"),
				new HomeworkTask("Homework Task 1", (now + 100), (now + 99)
						, "Homework Task 1 Notes - Elmo says ABC!")
		};

		tasks[0].setCompleted(true);
		tasks[1].setCompleted(true);
		
		TaskFilter[] taskFilters = {
			new TaskFilter(tasks, FIELD_TASK_NAME, SORT_ASC) {
				@Override
				public String toString() {
					// Return ONLY the Task array (not the other TaskFilter member fields);
					StringBuffer output = new StringBuffer();
					for(Task t : this.getArray()) {
						output.append(t.toString() + "\n\n--------------------\n");
					}
					return output.toString();
				}
			}
			, new TaskFilter(tasks, FIELD_START_DT, SORT_DESC)
			, new TaskFilter(tasks, FIELD_START_DT, SORT_ASC)
			, new TaskFilter(tasks, FIELD_END_DT, SORT_DESC)
			, new TaskFilter(tasks, FIELD_END_DT, SORT_ASC)
			, new TaskFilter(tasks, FIELD_COMPLETED, SORT_ASC)
			, new TaskFilter(tasks, FIELD_COMPLETED, SORT_DESC)
		};
		
		// TaskFilter sorts by default when Full Featured constructor is used and specifies sort parameters
		System.out.println( "TaskFilter[] Output\n(Anonymous output is seen in first Array element (sort by Task name)\n without TaskFilter member fields: filterField and sortOrder):\n"
			+ "\n" + Arrays.deepToString(taskFilters));

	}
	
	
	/**
	 * Week 6 Homework Main()
	 * 
	 * @since 0.6
	 * 
	 *    Read
	 *        + Chapter 8 in Java A Beginner's Guide - Interfaces and Packages
	 *        
	 *    Assignment
	 *        + Create a github repository to hold homework named bma-week-6 containing a class, Assignment
	 *        + Copy the Task class you created last week into the Assignment.java file
	 *           + The previous two tasks could be achieved by cloning your week 5 repository
	 *        + Apply access modifiers to your Task class
	 *            + All instances variables should be made private
	 *            + Determine what functionality and data you want to make accessible to outside callers via methods
	 *                Some examples could include the following but I'm not trying to design your solutions.  These are just ideas
	 *                    isComplete(): bool
	 *                    getCompletionDate(): Calendar
	 *                    getTitle(): String
	 *                    getDescription(): String
	 *                    hasPrerequisite(): bool
	 *                    getPrerequisite(): Task
	 *            + Implement whatever functionality you come up with in the last step
	 *        Create Task hierarchy 
	 *            + Consider different kinds of tasks (todo items) your todo list could have. 
	 *                + What extra functionality or behavior would they have?
	 *            + Consider what functionality and data would be common to all tasks
	 *            Refactor your Task class
	 *                + Make the base Task class abstract
	 *                + Hide all instance variables with private modifiers if you didn't already
	 *                	XXX I used protected, otherwise, inheritance wouldn't work
	 *                  * Class member fields are now privatized and are accessed via getters and setters
	 *                + Implement the common functionality from above as methods
	 *                + Add accessors (getters and/or setters) for any member variables you think need them
	 *                    You don't necessarily need both
	 *                    Its easier to add one later if you need it than to take one away
	 *            + Override methods in Task children when necessary
	 *                + At a bare minimum override toString for each child Task class
	 *        Test new Task hierarchy
	 *            + In the Assignment class, create a method "private static void printTask(Task)" that prints out Task objects
	 *            + In Assignment's main() method, create at least one of each type of Task created earlier.
	 *            + Send each task to printTask()
	 *            + [bonus]: test the rest of your Task parent class' public interface.
	 *
	 *	This assignment is aimed at both giving a feeling for inheritance and for getting you thinking about implementation 
	 *	ideas for your project.  It might be that your solution doesn't have a need to inheritance hierarchies.  
	 *	That's fine but there are two goals here.
	 *
	 */
	
	private static void week6Main() {

		// Instantiate new task objects
		GeneralTask generalTask1 = new GeneralTask();
		
		HomeworkTask homeworkTask1 = new HomeworkTask("New Homework Task 1"
													, (System.currentTimeMillis() + 1));
		
		HomeworkTask homeworkTask2 = new HomeworkTask("New Homework Task 2"
													, (System.currentTimeMillis() + 2)
													, (System.currentTimeMillis() + 3)
													, "Homework Task 2 Note - This was a really big homework."
													, (System.currentTimeMillis() + 4)
													, "Building Mobile Apps Fall 2012"
													, 4.0
													, 100);
		
		// Output new task object contents using printTask()
		printTask(generalTask1);
		printTask(homeworkTask1);
		printTask(homeworkTask2);
		
		// Bonus: Test Task class public interface
		System.out.println("\nHW 6 Bonus - Test the Task class public interface:");
		
		// Each setter also tests its corresponding getter
		System.out.println(Task.getInterfaceConstants());
		generalTask1.setTaskName("Bonus " + generalTask1.getTaskName());
		generalTask1.setStartDateTime(generalTask1.getStartDateTime() + 1);
		generalTask1.setEndDateTime(generalTask1.getStartDateTime() + 1);
		generalTask1.setEndDateTime(generalTask1.getEndDateTime() - 1);  // Test conditional in setEndDateTime()
		generalTask1.setEndDateTime(generalTask1.getEndDateTime() - 2);  // Test conditional in setEndDateTime()
		generalTask1.setCompleted(true);
		
		printTask(generalTask1);
		
	} // week6Main()
	
	/**
	 * Week 5 Homework main()
	 * @version 0.6
	 * - Since HW6 modified Task Class to be abstract, Task instantiations were changed to GeneralTask instantiations
	 * @since 0.5
	 * (switched since 0.6)
	 * 
	 *     Read
	 *        + Chapter 7 in Java: A Beginner's Guide
	 *     
	 *     Programming assignment
	 *        + Create a github repository to hold homework.  It should be named bma-week-5.  It should contain an Assignment.java file
	 *        + Implement the following static method "static String getElement(String values, int index)"
	 *            + If the index is not a valid array index, return null
	 *                In the future we'll try to avoid this, but we currently don't have error handling in our toolbox
	 *            + Otherwise, return the array element at the index
	 *        + Implement a class named Task inside the Assignment.java file
	 *            + Do not create a new file.  Place the Task class immediately after the end of the Assignment class in Assignment.java
	 *            + Do not implement a main method in Task.
	 *            + Add the instance variables you think belong in a Task object
	 *            + Implement at least one parameterized constructor for the Task class
	 *            + Implement a no-argument constructor for the Task class
	 *            + Implement a main() method in the Assignment class that does the following
	 *                + Call every constructor implemented in Task at least once, assigning the resulting object to a variable
	 *                + Pass each Task object created to "System.out.println(aTask);"
	 *            + Try to run Assignment
	 *                Why didn't it work?  The compiler has no idea how to convert a Task object into a String
	 *            + Implement a toString() method in Task
	 *                + The signature has to be "public String toString()" exactly
	 *                + Create a String representation of a Task.  This does not need to display every piece of data in the class, 
	 *                just the core information.  "Task(title)" would be a sparse but acceptable implementation.
	 *            + Try to run Assignment again
	 *                + It should work.  If not, try debugging.  If that fails, send an email
	 *
	 */
	
	private static void week5Main() {

		String myTaskName = "My Task ";
		
		// Instantiate new task objects
		Task task1 = new GeneralTask((myTaskName + "1"), (System.currentTimeMillis() + 1));
		Task task2 = new GeneralTask((myTaskName + "2"), (System.currentTimeMillis() + 2));
		Task task3 = new GeneralTask();
		
		// Output new task object contents
		System.out.println(task1.toString(Task.NAME_TO_STR));
		System.out.println(task2.toString(Task.NAME_TO_STR, Task.START_DATE_TO_STR));
		System.out.println(task3);		
		
	} // week5Main()
	
	/**
	 * Output a Task to console
	 * 
	 * @since 0.6
	 * 
	 * @param taskIn	Task to output to console
	 * 
	 */
	private static void printTask(Task taskIn) {
		System.out.println(taskIn);
	} // printTask()

	/**
	 * Extract a character from a String
	 * 
	 * @since 0.5
	 * 
	 * @param values	String from which to extract a character
	 * @param index		Index of character to extract
	 * 
	 * @return			Return the character at index.  If index is invalid, return null.
	 * 
	 */
	static String getElement(String values, int index) {
		
		if ((index >= 0) && (index < values.length())) {
			return values.substring(index, index);
		} else return null;
		
	} // getElement(String, int)

	/**
	 * Extract a String element from a String array
	 * 
	 * @since 0.5
	 * 
	 * @param values	String from which to extract a character
	 * @param index		Index of character to extract
	 * 
	 * @return			Return the character at index.  If index is invalid, return null.
	 * 
	 */
	static String getElement(String[] values, int index) {
		
		if ((index >= 0) && (index < values.length)) {
			return values[index];
		} else return null;
		
	} // getElement(String[], int)
	
} // CLASS Assignment

