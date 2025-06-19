package com.learning.helper;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestClass extends STRINGS {
	
	protected WebDriver originalDriver;
	protected WebDriver decorateDriver;
	
	@BeforeEach
	void setup() {
		
//		WebDriverManager.chromedriver().setup();
		originalDriver = new ChromeDriver();
		originalDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		originalDriver.manage().window().maximize();
		MyWebDriverListner listner = new MyWebDriverListner(originalDriver);
		decorateDriver = new EventFiringDecorator<WebDriver>(listner).decorate(originalDriver);
	}
	
	@AfterEach
	void tearDown() {
		if(originalDriver != null)
			originalDriver.quit();
	}
	
}
