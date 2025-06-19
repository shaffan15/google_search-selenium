package com.learning.bookprograms.ch3browserAgnostics;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.learning.helper.BaseTestClass;

public class TestGoogleSearch extends BaseTestClass {

	@Test
	void testGoogleSearch() {
		
		WebDriverWait wait = new WebDriverWait(originalDriver, Duration.ofSeconds(10));
		String initURL = "https://www.google.com/";
		originalDriver.get(initURL);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) originalDriver;
		
		String script = "let input = window.prompt('Enter the search string:');"
				+ "window.localStorage.setItem('searchString', input);";
		jsExecutor.executeAsyncScript(script);
		
		wait.until(ExpectedConditions.alertIsPresent());
		originalDriver.switchTo().alert();
		wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
		
		String searchString = (String) jsExecutor.executeScript("return window.localStorage.getItem('searchString');");
		
		WebElement searchBox = originalDriver.findElement(By.cssSelector("textarea[title='Search']"));
		searchBox.sendKeys(searchString);
		
		By listItemLocator = By.cssSelector(String.format("li[data-entityname='%s']", searchString));
		WebElement listItemElement = wait.until(ExpectedConditions.visibilityOfElementLocated(listItemLocator));
		listItemElement.click();
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(initURL)));
		assertThat(originalDriver.getCurrentUrl()).isNotEqualTo(initURL);
	}
}
