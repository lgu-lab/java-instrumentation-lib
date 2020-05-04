package org.demo.instrumentation.counters;

public class Counter {

	private final String name ;
	private final long   threadId;
	private long count = 0 ;
	
	/**
	 * Creates a new counter with the given name <br>
	 * The initial value is 0
	 * @param name
	 */
	protected Counter(String name) {
		super();
		this.name = name;
		this.count = 0L;
		this.threadId = 0L;
	}
	
	/**
	 * Creates a new counter with the given name and thread id<br>
	 * The initial value is 0
	 * @param name
	 * @param threadId
	 */
	protected Counter(String name, long threadId) {
		super();
		this.name = name;
		this.count = 0L;
		this.threadId = threadId;
	}

	public String getName() {
		return name;
	}
	
	public long getValue() {
		return count;
	}

	public long getThreadId() {
		return threadId;
	}
	
	public void increment() {
		count++;
	}
	
	public void increment(long n) {
		count = count + n ;
	}
	
	public void setValue(long n) {
		count = n ;
	}
	
	public void reset() {
		count = 0L ;
	}
	
	@Override
	public String toString() {
		return "Counter '" + name + "' (" + threadId + ") = " + count;
	}
	
}
