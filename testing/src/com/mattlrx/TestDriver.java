package com.mattlrx;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;

public class TestDriver {

	
	
	public static void main(String[] args) throws InterruptedException, ClientProtocolException, IOException, URISyntaxException {
		
		// sets the report
		Report report = new Report("loginTest.txt");
		
		// read the test data and execute all loaded tests
		TestData data = new TestData();
		data.loadData("data.csv");
		System.out.println("starting");
		for (TestCase tc : data.getTestcases()) {
			report.writeTestResult(tc.getTestCaseName(), tc.runTest());
			
		}

	}

}
