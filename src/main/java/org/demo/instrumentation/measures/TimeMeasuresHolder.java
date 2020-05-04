package org.demo.instrumentation.measures;

import java.util.LinkedList;
import java.util.List;

/**
 * Time measures list holder <br>
 * Provides a time measures list for each thread 
 *  
 * @author L. Guerin
 *
 */
public class TimeMeasuresHolder {
	
	private TimeMeasuresHolder() {}
	
	private static final ThreadLocal<List<TimeMeasureRecord>> TIME_MEASURES_LIST = new ThreadLocal<List<TimeMeasureRecord>>() {
		@Override
		protected List<TimeMeasureRecord> initialValue() {
			return new LinkedList<>();
		}
	};
	
	public static final List<TimeMeasureRecord> getList() {
		return TIME_MEASURES_LIST.get();
	}

}
