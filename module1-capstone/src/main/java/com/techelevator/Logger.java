package com.techelevator;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class Logger {

	public void log(String event, BigDecimal start, BigDecimal finish) throws IOException {

		// Prepare line of output

		StringBuilder logEntry = new StringBuilder();			
		logEntry.append(String.format("%-24s", new SimpleDateFormat("MM/dd/YYYY hh:mm:ss a").format(new java.util.Date())));
		logEntry.append(String.format("%-20s", event));
		logEntry.append(String.format("%1$8s","$"+start.toString()));
		logEntry.append(String.format("%1$8s","$"+finish.toString()));

		// Define log file

		File logFile = new File("Log.txt");

		// If log file does not exist, create it

		if (!logFile.exists()) {
			logFile.createNewFile();
		} else if (logFile.exists() && logFile.isDirectory()) {
			throw new IOException();
		}

		// Open log file for writing in append mode (not overwrite mode)

		FileOutputStream f = new FileOutputStream(logFile,true);

		try (PrintWriter pw = new PrintWriter(f)) {

			// make the log entry

			pw.println(logEntry);
			pw.flush();

		}

	}
}
