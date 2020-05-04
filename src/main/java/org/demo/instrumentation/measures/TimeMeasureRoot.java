package org.demo.instrumentation.measures;

/**
 * Root time measure
 * 
 * @author L Guerin
 *
 */
public class TimeMeasureRoot extends TimeMeasure {

	private final String filePath ;
	
	/**
	 * Constructor (start root time measure) 
	 * @param name
	 * @param filePath
	 */
	public TimeMeasureRoot(String name, String filePath) {
		super(name, true);
		this.filePath = filePath ;
	}

	/**
	 * Constructor (start root time measure) 
	 * @param name
	 */
	public TimeMeasureRoot(String name) {
		this(name, null);
	}

	@Override
	public void close() { 
		super.close();
		// This is the 'root level' => write report if file name is defined
		if ( filePath != null ) {
			TimeMeasures.write(filePath);
		} else {
			TimeMeasures.write();
		}
		// This is the 'root level' => clear the list 
		TimeMeasures.removeAll();
	}

}
