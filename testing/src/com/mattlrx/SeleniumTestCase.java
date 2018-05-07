package com.mattlrx;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTestCase {

	private ChromeDriver driver;
	
	/**
	 * sets up the test to run on Chrome driver
	 * defines if the cookies are stored or not
	 * @param storeCookies
	 */
	public void setup(Boolean storeCookies) {
		//the driver could be placed anywhere on the test machine, the path would need to be set here.
				System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver");

				
				ChromeOptions options = new ChromeOptions();  
				Map<String, Object> prefs = new HashMap<String, Object>(); 
				
				//this is used for the THE SESSION COOKIE missing page, if the browser does not store the cookies, 
				//the redirected page will not know that the login was successful
				if (storeCookies==false) {
					prefs.put("profile.default_content_setting_values.cookies", 2);  
				}else {
					prefs.put("profile.default_content_setting_values.cookies", 1); 
				}
				
				options.setExperimentalOption("prefs", prefs);
				driver = new ChromeDriver(options);
	}
	
	
	/**
	 * executes the test
	 * @param url
	 * @param usr
	 * @param pwd
	 * @param expected
	 * @param storeCookies
	 * @return
	 * @throws InterruptedException
	 */
	public String login (String url, String usr, String pwd, String expected, Boolean storeCookies) throws InterruptedException {
		String ret = "";
		
		//sets up the test
		this.setup(storeCookies);
		
		
		//execute the steps:
		//1- open the page
		driver.get(url);
		Thread.sleep(100);
		//2- enters the user name
		WebElement usrBox = driver.findElement(By.name("usr"));
		usrBox.sendKeys(usr);
		//3- enters the password
		WebElement pwdBox = driver.findElement(By.name("pwd"));
		pwdBox.sendKeys(pwd);
		//4- click the submit button
		pwdBox.submit();

		Thread.sleep(100);

		//5- verify the page contains the expected result and sets the status accordingly
		if(driver.getPageSource().contains(expected)){
			ret = "success";
		}else{
			ret = "failure";
		}

		driver.close();
		return ret;
	}
	

}
