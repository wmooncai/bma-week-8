package com.wams.tasklist;

/**
 * 
 * @author W. Mooncai
 * @since 0.6
 * 
 * Grade class is for use with the HomeworkTask class.  It includes validity checking and conversion functions.
 * v0.7 - Moved to project package and one public class / interface per file
 *
 * @param gradeVal		Grade awarded to its task
 * 
 */
public class Grade implements GradeInterface {
	
	private double gradeVal = 0.0;
	
	/**
	 * Base constructor with no arguments, initializes grade to 0.0
	 * 
	 * @since 0.6
	 * 
	 */
	Grade() {
		gradeVal = 0.0;
	}

	/**
	 * Constructor with grade initialization value
	 * 
	 * @since 0.6
	 * 
	 * @param gradeIn	initial grade
	 * 
	 */
	Grade(double gradeIn) {
		if ( isValid(gradeIn) ) {
			gradeVal = gradeIn;
		} else {
			// TODO throw an exception for or otherwise handle an invalid grade
		}

	}

	/**
	 * Confirm if a grade is valid or not
	 * 
	 * @since 0.6
	 * 
	 * @param gradeCandidate	Grade to verify validity
	 * 
	 * @return					Validity
	 * 
	 */
	public boolean isValid(double gradeCandidate) {
		
		if ( (gradeCandidate >= MIN_GRADE) && (gradeCandidate <= MAX_GRADE) ) {
			return true;
		} else {
			return false;
		}
		
	}

	// **************************************** GETTERS ************************************************
	
	/**
	 * Return grade as a double
	 * 
	 * @since 0.6
	 * 
	 * @return		grade
	 * 
	 */
	public double getGrade() {
		
		return gradeVal;
		
	}

	// **************************************** SETTERS ************************************************
	
	/**
	 * Set grade with double as input
	 * 
	 * @since 0.6
	 * 
	 * @return		success / failure
	 * 
	 */
	public boolean setGrade(double newGrade) {
		
		if ( isValid(newGrade) ) {
			gradeVal = newGrade;
			return true;
		} else return false;
		
	}

	// ********************************* Conversions *****************************************
	
	/**
	 * Returns the double value of gradeVal
	 * 
	 * @since 0.6
	 * 
	 * @return	grade as a double value
	 * 
	 */
	public double doubleValue() {
		
		return gradeVal;

	}

	/**
	 * Returns letter representation of grade as a String
	 * 
	 * @since 0.6
	 * 
	 * @return		a String containing the letter representation of gradeVal
	 * 
	 */
	public String toString() {
		
		if (gradeVal >= 4.0) {
			return "A"; 
		} else if (gradeVal >= 3.0) {
			return "B";
		} else if (gradeVal >= 2.0) {
			return "C";
		} else if (gradeVal >= 1.0) {
			return "D";
		} else return "F";
		
	}

}
