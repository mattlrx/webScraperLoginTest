package com.mattlrx;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;

public class TestDriver {

	
	
	public static void main(String[] args) throws InterruptedException, ClientProtocolException, IOException, URISyntaxException {
		// TODO Auto-generated method stub
		Report report = new Report("loginTest.txt");
		TestData data = new TestData();
		data.loadData("data.csv");
		System.out.println("starting");
		for (TestCase tc : data.testcases) {
			report.writeTestResult(tc.testCaseName, tc.runTest());
			
		}

	}

}
