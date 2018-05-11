package fileVisitors.util;

/**
 * MyLogger is a class that is used to help in debugging. It contains
 * a integer debugValue that is used to filter what messages will be 
 * outputted.
 */
public class MyLogger {
    /**
     * DEBUG_VALUE=0 
     * [Nothing should be printed from the application to stdout.]
     * DEBUG_VALUE=1 
     * [Print to stdout everytime a word is deleted and the word tree stats]
     * DEBUG_VALUE=2 
     * [Print to stdout everytime a word is added]
     * DEBUG_VALUE=3 
     * [Print to stdout everytime a thread's run() method is called]
     * DEBUG_VALUE=4 
     * [Print to stdout everytime a constructor is called]
     */
    public static enum DebugLevel {
        RELEASE,
        FROM_RESULTS,
        IN_RESULTS,
        IN_RUN,
        CONSTRUCTOR
    };

    private static DebugLevel debugLevel;

    /**
     * Setter for debugLevel for an integer parameter
     * 
     * @param levelIn       the new debug level
     */
    public static void setDebugValue(int levelIn) {
    	switch(levelIn) {
    	  case 0: 
    	      debugLevel = DebugLevel.RELEASE;
    	      break;
    	  case 1:
    	      debugLevel = DebugLevel.FROM_RESULTS;
    	      break;
    	  case 2:
    	      debugLevel = DebugLevel.IN_RESULTS;
    	      break;
    	  case 3:
    	      debugLevel = DebugLevel.IN_RUN;
    	      break;
    	  case 4: 
    	      debugLevel = DebugLevel.CONSTRUCTOR; 
    	      break;
    	}
    }

    /**
     * Setter for debugLevel for a DebugLevel parameter
     * 
     * @param levelIn       the new debug level
     */
    public static void setDebugValue(DebugLevel levelIn) {
    	debugLevel = levelIn;
    }

    /**
     * Parses the debug level from the arguments in command line
     * Checks to see if it can be an integer 
     * and is between 0 and 4, inclusive
     * 
     * @param levelIn       the new debug level
     */
    public static void parseDebugValue(String levelIn) {
        try {
            int newDebugValue = Integer.parseInt(levelIn);
            if(newDebugValue > 4 || newDebugValue < 0) {
                throw new Exception();
            }
            setDebugValue(newDebugValue);
        } catch (Exception e) {
            System.err.println(
                "Error: Debug value should be an integer between 0 and 4");
            System.exit(0);
        }
    }

    /**
     * Compares the static debug level to determine if message
     * will be outputed to stdout
     * 
     * @param message       the string to be printed to stdout
     * @param levelIn       the static debugValue must be passed in
     */
    public static void writeMessage(String message, DebugLevel levelIn) {
        if (levelIn == debugLevel) {
    	    System.out.println(message);
        }
    }
    
    /**
	 * @return String
	 */
    public String toString() {
    	return "Debug Level is " + debugLevel;
    }
}