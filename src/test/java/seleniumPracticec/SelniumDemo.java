package seleniumPracticec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.ReusableUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelniumDemo {
	public static void main(String args[]) {		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("slc3000blog");
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();
		ReusableUtility.getInstance().staticWaitForMillis(5000);	
		driver.quit();
	}
}

