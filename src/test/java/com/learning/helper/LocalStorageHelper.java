package com.learning.helper;

import org.openqa.selenium.WebDriver;

public class LocalStorageHelper extends WebStorageActionsHelper {

	public LocalStorageHelper(WebDriver driver) {
		super(STRINGS.LOCAL_STORAGE, driver);
	}
	
}
