package com.mattlrx;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;

public class TestCase {

	public String testCaseName;
	public String url;
	public String user;
	public String password;
	public String expectedString;
	public boolean storeCookies;
	public String testType;
	
	public TestCase (String[] data) {
		this.testCaseName = data[0];
		this.testType = data[1];
		this.url = data[2].replaceAll("\"", "");
		this.user = data[3].replaceAll("\"", "");
		this.password = data[4].replaceAll("\"", "");
		this.expectedString = data[5].substring(1, data[5].length()-1).replaceAll("\\\\", "");
		this.storeCookies = Boolean.parseBoolean(data[6]);
	}
	
	public TestCase() {
		
	}
	
	public String runTest() throws InterruptedException, ClientProtocolException, IOException, URISyntaxException {
		System.out.println(this.testType);
		if (this.testType.contains("S")) {
			SeleniumTestCase tc = new SeleniumTestCase();
			return tc.login(this.url, this.user, this.password, this.expectedString, this.storeCookies);
			

		}else if(this.testType.contains("H")) {
			HTTPClientTestCase tc = new HTTPClientTestCase();
			return tc.httpPostNoRedirect(this.url, this.user, this.password, this.expectedString, this.storeCookies);
		}
		return "undefined";
	}
}
