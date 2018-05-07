package com.mattlrx;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;

public class TestCase {
	private String testCaseName;
	private String url;
	private String data1;
	private String data2;
	private String expectedString;
	private String data3;
	private String testType;

	/**
	 * constructor, to be instantiated with the data passed from the csv file.
	 * data1 data2 data3 have such names so this could be extended beyond the login page test.
	 * @param data
	 */
	public TestCase (String[] data) {
		this.testCaseName = data[0];
		this.testType = data[1];
		this.url = data[2].replaceAll("\"", "");

		this.expectedString = data[3].substring(1, data[3].length()-1).replaceAll("\\\\", "");

		if(data.length > 5) {
			this.data1 = data[4].replaceAll("\"", "");
			this.data2 = data[5].replaceAll("\"", "");
		}else {
			this.data1 = "";
			this.data2 = "";
		}

		if (data.length > 6) {
			this.data3 = data[6].replaceAll("\"", "");
		}else {
			this.data3 = "";
		}
	}

	public TestCase() {

	}

	public String getTestCaseName() {
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public String getData2() {
		return data2;
	}

	public void setData2(String data2) {
		this.data2 = data2;
	}

	public String getExpectedString() {
		return expectedString;
	}

	public void setExpectedString(String expectedString) {
		this.expectedString = expectedString;
	}

	public String getData3() {
		return data3;
	}

	public void setData3(String data3) {
		this.data3 = data3;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}





	/**
	 * this method will determine what test to run:
	 * 		S will call the selenium test to login
	 * 		H will call the http client script to login.
	 * @return
	 * @throws InterruptedException
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public String runTest() throws InterruptedException, ClientProtocolException, IOException, URISyntaxException {
		System.out.println(this.testType);
		if (this.testType.contains("S")) {
			SeleniumTestCase tc = new SeleniumTestCase();
			return tc.login(this.url, this.data1, this.data2, this.expectedString, Boolean.valueOf(this.data3));


		}else if(this.testType.contains("H")) {
			HTTPClientTestCase tc = new HTTPClientTestCase();
			return tc.httpPostNoRedirect(this.url, this.data1, this.data2, this.expectedString);
		}
		return "undefined";
	}
}
