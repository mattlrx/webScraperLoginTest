package com.mattlrx;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTestCase {


	public String login (String url, String usr, String pwd, String expected, Boolean storeCookies) throws InterruptedException {
		String ret = "";
		System.setProperty("webdriver.chrome.driver", "/home/matthieulrx/_work/chromedriver/chromedriver");

		ChromeDriver driver;
		ChromeOptions options = new ChromeOptions();  
		Map<String, Object> prefs = new HashMap<String, Object>(); 
		
		if (storeCookies==false) {
			prefs.put("profile.default_content_setting_values.cookies", 2);  
		}else {
			prefs.put("profile.default_content_setting_values.cookies", 1); 
		}
		
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		
		
		
		driver.get(url);
		Thread.sleep(100);
		WebElement usrBox = driver.findElement(By.name("usr"));
		usrBox.sendKeys(usr);
		WebElement pwdBox = driver.findElement(By.name("pwd"));
		pwdBox.sendKeys(pwd);
		pwdBox.submit();
		System.out.println(driver.getCurrentUrl());

		Thread.sleep(100);

		if(driver.getPageSource().contains(expected)){
			System.out.println("Text is present");
			ret = "success";
		}else{
			System.out.println("Text is absent");
			ret = "failure";
		}

		driver.close();
		return ret;
	}
	

}
