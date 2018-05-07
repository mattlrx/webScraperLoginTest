package com.mattlrx;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Report {

	
	private String reportName;
	
	/**
	 * instantiates the report class with the name of the report
	 * @param reportName
	 */
	public Report(String reportName) {
		this.reportName = reportName;
	}
	
	public Report() {
		
	}
	
	/**
	 * writes text to the file
	 * @param text
	 */
	private void write(String text) {
		try
		{
		    FileWriter fw = new FileWriter(reportName,true); //the true will append the new data
		    fw.write(text + "\n");//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}
	
	/**
	 * formats the text to be entered in the file
	 * @param testName
	 * @param status
	 */
	public void writeTestResult(String testName, String status) {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		String reportEntry = testName + " - " + status + " - " + timeStamp;
		this.write(reportEntry);
	}
	
}
