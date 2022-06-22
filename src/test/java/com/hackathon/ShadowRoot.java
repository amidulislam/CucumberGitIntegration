package com.hackathon;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.WebDriverListener;

import com.utility.ReusableUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowRoot implements WebDriverListener {
	
	WebDriver driver=null;
	@BeforeEach
	void launch() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	@Test()
	public void mainTest() {
		//driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");
		driver.get("https://books-pwakit.appspot.com");
		WebElement content = driver.findElement(By.xpath("//book-app[@apptitle='BOOKS']"));
		SearchContext shadowRoot = content.getShadowRoot();
		
		WebElement textElement = shadowRoot.findElement(By.tagName("input"));
		ReusableUtility.getInstance().staticWaitForMillis(5000);
		textElement.sendKeys("Hello World");
		//Assertions.assertTrue(textElement.getText().contains("Hello Shadow DOM"));		
		}
	@Disabled("This is disabled for second test")
	@Test
	void testNewTab() {
        ChromeOptions options = new ChromeOptions();
        

	    driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
	    
	    System.out.println("++++++++++++++++++++===="+options.getBrowserVersion());
	    
	    String initHandle = driver.getWindowHandle(); 

	    driver.switchTo().newWindow(WindowType.TAB); 
	    driver.get(
	            "https://bonigarcia.dev/selenium-webdriver-java/web-form.html"); 
	    	    Assertions.assertTrue(driver.getWindowHandles().size()==2);

	    driver.switchTo().window(initHandle); 
	    driver.close(); 
	    Assertions.assertTrue(driver.getWindowHandles().size()==1);
	    ReusableUtility.getInstance().staticWaitForMillis(9000);
	}
	@AfterEach
	void quit() {
		driver.quit();
	}
	
	
}

