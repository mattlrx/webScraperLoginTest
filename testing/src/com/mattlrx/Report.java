package com.mattlrx;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Report {

	private String reportName;
	
	public Report(String reportName) {
		this.reportName = reportName;
	}
	
	public Report() {
		
	}
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
	
	public void writeTestResult(String testName, String status) {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		String reportEntry = testName + " - " + status + " - " + timeStamp;
		this.write(reportEntry);
	}
	
}
