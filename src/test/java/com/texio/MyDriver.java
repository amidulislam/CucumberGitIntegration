package com.texio;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyDriver {
	WebDriver driver = null;

	@BeforeAll
	public void setup() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	void setupTest() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.pizzahut.co.in/order/deals/");
	}

	@AfterEach
	void tearDown() {
		driver.quit();
	}

	public WebDriver getWebDriver() {
		if (driver != null) {
			return driver;
		} else {
			setupTest();
			return driver;
		}
	}
}
