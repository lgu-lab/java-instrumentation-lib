package org.demo.instrumentation.measures;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.List;

import org.demo.instrumentation.commons.ReportWriter;

public class TimeMeasuresWriter extends ReportWriter {

	private final List<TimeMeasureRecord> measuresList ;

	public TimeMeasuresWriter(List<TimeMeasureRecord> list) {
		super();
		this.measuresList = list;
	}

	@Override
	public void writeOutput(Writer writer, Date date, long threadId) throws IOException {
		writer.write("Time measures ( " + formatDateHour(date) + " ) thread id : " + threadId + " \n");
		for (TimeMeasureRecord tm : measuresList) {
			String startTime = "("
			+ "start time " + formatTimeMilisec(tm.getStartTime()) 
			+ " --> " 
			+ "end time " + formatTimeMilisec(tm.getEndTime()) 
			+ ")" ;
			String s = "'" + tm.getName() + "' : " + tm.getTimeMeasured() + " ms " + startTime ;
			writer.write(" . " + s + "\n");
		}
		writer.flush();
	}

}
