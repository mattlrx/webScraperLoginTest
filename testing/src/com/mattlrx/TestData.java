package com.mattlrx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestData {

	ArrayList<TestCase> testcases = new ArrayList<TestCase>();
	
	public TestData() {

	}

	public void loadData(String csvFile) {


		String line = "";
		String cvsSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {
				if(line.contains("STOP")) {
					break;
				}
				// use comma as separator
				String[] data = line.split(cvsSplitBy);
				TestCase testcase = new TestCase(data);
				System.out.println(testcase.testCaseName);
				testcases.add(testcase);
				

			}

		} catch (IOException e) {
			e.printStackTrace();
		}



	}
}
