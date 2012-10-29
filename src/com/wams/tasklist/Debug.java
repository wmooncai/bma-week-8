/**
 * 
 */
package com.wams.tasklist;

/**
 * @author W. Mooncai
 * 
 * @since 0.8
 * 
 * Debugging class to output troubleshooting output to Console
 *
 */
public class Debug implements DebugInterface {

	/** */
	public static boolean toggle = DEBUG_OFF;
	public static int level = DEBUG_LEVEL_DEBUG;
	
	public Debug(boolean toggle, int level) {
		setToggle(toggle);
		setLevel(level);
	}
	
	// ******************************** METHODS *******************************
	
	public void toLog(int lvl, String message) {
		
		if ( (toggle) && (level <= lvl) ) {
			System.out.println("\n\n##########################\n"
					+ message + "\n##########################\n\n");
		}
	}

	// ******************************** GETTERS *******************************

	public boolean getToggle () { return toggle; }
	
	public int getLevel() { return level; }

	// ******************************** SETTERS *******************************

	public void setLevel (int lvl) {
	
		if ( (lvl < DEBUG_LEVEL_DEBUG) && (lvl > DEBUG_LEVEL_EMERGENCY) )
			level = lvl;
	}
	
	public void setToggle (boolean turn) { toggle = turn; }
	
	public void setToggle() { toggle = (toggle) ? DEBUG_OFF : DEBUG_ON; }

}
