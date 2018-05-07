package com.mattlrx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestData {

	private ArrayList<TestCase> testcases = new ArrayList<TestCase>();
	
	public ArrayList<TestCase> getTestcases() {
		return testcases;
	}

	public TestData() {

	}

	/**
	 * loads the csv files into test case objects and stores them in an arrayList.
	 * @param csvFile
	 */
	public void loadData(String csvFile) {


		String line = "";
		String cvsSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {
				
				// if a line in the csv file starts with STOP, then the reading will stop there
				// this was added to avoid running all the tests.
								if(line.startsWith("STOP")) {
					break;
				}
				// use comma as separator
				String[] data = line.split(cvsSplitBy);
				
				TestCase testcase = new TestCase(data);
				System.out.println(testcase.getTestCaseName());
				testcases.add(testcase);
				

			}

		} catch (IOException e) {
			e.printStackTrace();
		}



	}
}
