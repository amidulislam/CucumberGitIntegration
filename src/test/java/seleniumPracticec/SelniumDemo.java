package seleniumPracticec;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelniumDemo {
	public static void main(String args[]) {		
		
		LocalDate today = LocalDate.now();
	    int currentYear = today.getYear();
	    System.out.println(String.format("//div[text()='%d']", currentYear));
	}
}

