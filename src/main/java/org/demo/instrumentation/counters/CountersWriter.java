package org.demo.instrumentation.counters;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.Map;

import org.demo.instrumentation.commons.ReportWriter;

public class CountersWriter extends ReportWriter {

	private final Map<String, Counter> countersMap;

	public CountersWriter(Map<String, Counter> countersMap) {
		super();
		this.countersMap = countersMap;
	}

	@Override
	public void writeOutput(Writer writer, Date date, long threadId) throws IOException {
		writer.write("Counters ( " + formatDateHour(date) + " ) thread id : " + threadId + " \n");
		for (Map.Entry<String, Counter> entry : countersMap.entrySet()) {
			Counter c = entry.getValue();
			String s = " . '" + c.getName() + "' = " + c.getValue() ;
			if ( c.getThreadId() > 0 ) {
				s = s + " ( thread " + c.getThreadId() + " )";
			}
			writer.write(s + "\n");
		}
		writer.flush();
	}

}
