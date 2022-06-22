package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.texio.MyDriver;

public class ReusableUtility {
	private static ReusableUtility obj;
	WebDriver driver;
	private ReusableUtility() {
		driver=new MyDriver().getWebDriver();
	}
	public static ReusableUtility getInstance() {
		if(obj==null) {
			obj=new ReusableUtility();			
		}
		return obj;
	}
	public void staticWaitForMillis(int millis) {
		try {
			Thread.sleep(millis);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public WebElement getWebElementById(String selector) {		
		return driver.findElement(By.id(selector));
	}

}
