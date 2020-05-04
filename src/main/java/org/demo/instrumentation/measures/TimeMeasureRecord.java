package org.demo.instrumentation.measures;

/**
 * Time measure record   
 * 
 * @author L Guerin
 *
 */
public class TimeMeasureRecord {

	private final String name;

	private final long startTime;

	private long endTime ;

	private long timeMeasured ;

	/**
	 * Constructor
	 * @param name
	 * @param startTime
	 */
	public TimeMeasureRecord(String name, long startTime) {
		super();
		this.name = name;
		this.startTime = startTime;
		this.endTime = 0L;
		this.timeMeasured = -1L ;
	}

	public String getName() {
		return name;
	}

	public long getStartTime() {
		return startTime;
	}
	public long getEndTime() {
		return endTime;
	}

	public void endOfMeasure() {
		// Compute elapsed time 
		endTime = System.currentTimeMillis();
		timeMeasured = endTime - startTime;
	}
	
	public long getTimeMeasured() {
		return timeMeasured;
	}

	@Override
	public String toString() {
		return "'" + name + "' : " + timeMeasured + " ms";
	}

}
