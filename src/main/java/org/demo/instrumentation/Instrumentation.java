package org.demo.instrumentation;

public class Instrumentation {
	
	private Instrumentation() {}
	
	/**
	 * Code instrumentation activation
	 * This environment variable that must be defined with value = "true" 
	 * to activate the instrumentation 
	 */
	private static final String  ENVIRONMENT_VAR_NAME = "CODE_INSTRUM" ;

	private static boolean active = false ;
	private static boolean activeChecked = false ;

	public static final String getActivationEnvVarName() {
		return ENVIRONMENT_VAR_NAME ;
	}
	
	public static final boolean isActive() {
		if ( activeChecked ) {
			// Already checked
			return active ;
		}
		else {
			// Not yet checked
			String envValue = System.getenv(ENVIRONMENT_VAR_NAME);
			if ( "true".equalsIgnoreCase(envValue) ) {
				active = true ;
			}
			activeChecked = true ;
		}
		return active;
	}

	/**
	 * Force instrumentation activation
	 * @param v
	 */
	public static final void setActive(boolean v) {
		active = v ;
	}
}
