package org.demo.instrumentation.commons;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.demo.instrumentation.Instrumentation;

public abstract class ReportWriter {
	
	public abstract void writeOutput(Writer writer, Date date, long threadId) throws IOException ;
	
	private final synchronized void writeSync(Writer writer, Date date, long threadId) throws IOException {
		writeOutput(writer, date, threadId);
	}

	/**
	 * Writes the result in the given file name <br>
	 * The final file name will be the given path + current date + ".txt"
	 * @param fileFullPath file full path without extension ( e.g. "/tmp/myfile" )
	 * @return
	 */
	public final boolean write(String fileFullPath) {
		if ( ! Instrumentation.isActive() ) return false;
		Date dateNow = new Date();
		long threadId = Thread.currentThread().getId();
		String fullFileName = builFileName(fileFullPath, dateNow, threadId);
		try ( BufferedWriter writer = new BufferedWriter(new FileWriter(fullFileName)) ) {
			writeSync(writer, dateNow, threadId);
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	/**
	 * Writes the result in the standard output (console) <br>
	 * @return
	 */
	public final boolean write() {
		if ( ! Instrumentation.isActive() ) return false;
		Date dateNow = new Date();
		long threadId = Thread.currentThread().getId();
		try {
			Writer writer = new OutputStreamWriter(System.out);
			writeSync(writer, dateNow, threadId);
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	private final String builFileName(String fileFullPath, Date date, long threadId) {
	    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS");
	    return fileFullPath + "_" + f.format(date) + "_T" + threadId + ".txt";
	}
	
	protected static final String formatDateHourMilisec(long time) {
		Date date = new Date(time);
	    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	    return f.format(date);
	}

	protected static final String formatTimeMilisec(long time) {
		Date date = new Date(time);
	    SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss.SSS");
	    return f.format(date);
	}
	
	protected static final String formatDateHour(Date date) {
	    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    return f.format(date);
	}

}
