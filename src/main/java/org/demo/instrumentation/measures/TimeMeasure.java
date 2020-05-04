package org.demo.instrumentation.measures;

/**
 * Time measure system based on AutoCloseable resource 
 * 
 * @author L Guerin
 *
 */
public class TimeMeasure implements AutoCloseable {

	private final TimeMeasureRecord record ;

	/**
	 * Constructor (starts a new time measure) 
	 * @param name
	 * @param isRoot
	 */
	protected TimeMeasure(String name, boolean isRoot) {
		super();
		long startTime = System.currentTimeMillis();

		// This is the 'root level' => clear the list before register 
		if ( isRoot ) {
			TimeMeasures.removeAll();
		}
		// Register this new measure (add a measure record in the list)
		this.record = TimeMeasures.register(name, startTime);
	}

	/**
	 * Constructor (starts a new time measure) 
	 * @param name
	 */
	public TimeMeasure(String name) {
		this(name, false);
	}
	
	
	@Override
	// close (end time measure) 
	// override 'close' without Exception propagation 
	public void close() { 
		this.record.endOfMeasure();
	}

}
