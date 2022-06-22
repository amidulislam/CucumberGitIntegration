package com.hackathon;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Base64;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.print.PrintOptions;

import com.utility.ReusableUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintToPdf {
	WebDriver driver=null;
	@BeforeEach
	void launch() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	@Test()
	public void mainTest() throws IOException {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");		
		PrintsPage pg=(PrintsPage)driver;
		PrintOptions printOptions=new PrintOptions();
		Pdf pdf=pg.print(printOptions);
		String pdfBase64 = pdf.getContent();
	    Assertions.assertTrue(pdfBase64.contains("JVBER"));

	    byte[] decodedImg = Base64.getDecoder()
	            .decode(pdfBase64.getBytes(StandardCharsets.UTF_8));
	    Path destinationFile = Paths.get("my-pdf.pdf");
	    Files.write(destinationFile, decodedImg);
		}

}
